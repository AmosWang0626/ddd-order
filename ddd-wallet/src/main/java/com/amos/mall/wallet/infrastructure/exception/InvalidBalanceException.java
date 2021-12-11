package com.amos.mall.wallet.infrastructure.exception;

/**
 * 交易-非法的金额
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
public class InvalidBalanceException extends RuntimeException {

    public InvalidBalanceException() {
        this("非法的金额");
    }

    public InvalidBalanceException(String message) {
        super("[biz] " + message);
    }

}
