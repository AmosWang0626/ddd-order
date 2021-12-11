package com.amos.mall.wallet.domain.model;

import com.amos.mall.wallet.infrastructure.exception.InvalidBalanceException;
import com.amos.mall.wallet.infrastructure.exception.NoSufficientBalanceException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 钱包实体
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Getter
@Setter
public class WalletEntity {

    /**
     * 钱包ID
     */
    private Long walletId;

    /**
     * 钱包余额
     */
    private BigDecimal balance;

    /**
     * 钱包状态
     */
    private WalletStatus status;

    /**
     * 是否可透支使用
     */
    private boolean isAllowOverDraft = true;

    /**
     * 可透支金额
     */
    private BigDecimal overdraftAmount = BigDecimal.ZERO;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    /**
     * 钱包创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 钱包修改时间
     */
    private LocalDateTime gmtModify;

    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException();
        }
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new InvalidBalanceException();
        }
        this.balance = this.balance.add(amount);
    }

    /**
     * 计算可用的余额
     *
     * @return 可用的余额
     */
    public BigDecimal getAvailableBalance() {
        BigDecimal totalAvailableBalance = this.balance.subtract(this.frozenAmount);
        if (isAllowOverDraft) {
            totalAvailableBalance = totalAvailableBalance.add(this.overdraftAmount);
        }
        return totalAvailableBalance;
    }

    /**
     * 冻结余额
     *
     * @param amount 金额
     */
    public void freeze(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException();
        }
        this.balance = this.balance.subtract(amount);
        this.frozenAmount = this.frozenAmount.add(amount);
    }

    /**
     * 解冻余额
     *
     * @param amount 金额
     */
    public void unfreeze(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new InvalidBalanceException();
        }
        if (this.frozenAmount.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException();
        }
        this.balance = this.balance.add(amount);
        this.frozenAmount = this.frozenAmount.subtract(amount);
    }

    public void increaseOverdraftAmount(BigDecimal amount) {
        this.overdraftAmount = this.overdraftAmount.add(amount);
    }

    public void decreaseOverdraftAmount(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new InvalidBalanceException();
        }
        if (overdraftAmount.compareTo(amount) < 0) {
            throw new InvalidBalanceException();
        }

        this.overdraftAmount = this.overdraftAmount.subtract(amount);
    }

    public void closeOverdraft() {
        this.isAllowOverDraft = false;
    }

    public void openOverdraft() {
        this.isAllowOverDraft = false;
    }
}
