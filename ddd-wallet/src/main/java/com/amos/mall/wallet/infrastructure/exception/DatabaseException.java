package com.amos.mall.wallet.infrastructure.exception;

/**
 * DB Exception
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException() {
        this("数据变更失败");
    }

    public DatabaseException(String message) {
        super("[db] " + message);
    }

}
