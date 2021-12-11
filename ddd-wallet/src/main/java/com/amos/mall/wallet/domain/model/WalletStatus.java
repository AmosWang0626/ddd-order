package com.amos.mall.wallet.domain.model;

import java.util.Objects;

/**
 * 钱包状态
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
public enum WalletStatus {

    /**
     * 正常
     */
    NORMAL(1, "正常"),

    /**
     * 冻结
     */
    FROZEN(2, "冻结"),

    /**
     * 关闭
     */
    CLOSE(3, "关闭");

    private final Integer code;

    private final String message;

    WalletStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static WalletStatus codeOf(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (WalletStatus status : WalletStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
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
