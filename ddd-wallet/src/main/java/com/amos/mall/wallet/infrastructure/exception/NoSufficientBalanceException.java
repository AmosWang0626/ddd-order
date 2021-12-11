package com.amos.mall.wallet.infrastructure.exception;

/**
 * 交易-余额不足
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
public class NoSufficientBalanceException extends RuntimeException {

    public NoSufficientBalanceException() {
        this("余额不足");
    }

    public NoSufficientBalanceException(String message) {
        super("[biz] " + message);
    }

}
