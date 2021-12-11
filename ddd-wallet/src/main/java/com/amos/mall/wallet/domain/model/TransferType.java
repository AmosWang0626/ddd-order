package com.amos.mall.wallet.domain.model;

import java.util.Objects;

/**
 * 交易类型
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
public enum TransferType {

    /**
     * 出账
     */
    DEBIT(1, "出账"),
    /**
     * 入账
     */
    CREDIT(2, "入账"),
    /**
     * 交易
     */
    TRANSFER(3, "交易");

    private final Integer code;

    private final String message;

    TransferType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static TransferType codeOf(Integer transferType) {
        if (Objects.isNull(transferType)) {
            return null;
        }

        for (TransferType type : TransferType.values()) {
            if (type.getCode().equals(transferType)) {
                return type;
            }
        }

        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
