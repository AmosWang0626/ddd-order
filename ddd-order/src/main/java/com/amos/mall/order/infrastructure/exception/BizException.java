package com.amos.mall.order.infrastructure.exception;

/**
 * 业务异常
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
public class BizException extends RuntimeException {

    public BizException() {
        this("业务异常");
    }

    public BizException(String message) {
        super("[biz] " + message);
    }

}
