package org.common.consul.api.enums;

import lombok.Getter;

/**
 * TTL type check status
 * @author liaoyushao
 */
@Getter
public enum TtlCheckStatus {

    PASS("pass"),
    WARN("warn"),
    FAIL("fail"),
    UPDATE("update");

    private final String code;

    TtlCheckStatus(String code) {
        this.code = code;
    }
}
