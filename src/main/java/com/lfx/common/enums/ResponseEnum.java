package com.lfx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 2021-11-24 16:58:10
 *
 * @author linfuxin
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    /**
     * 正常响应
     */
    SUCCEED(0, "成功"),

    /**
     * 服务级别错误码10XX
     */
    SERVICE_ERROR(5000, "服务异常"),

    /**
     * 数据不存在
     */
    DATA_NOT_FOUND_ERROR(1001, "数据不存在"),
    ;

    private final int code;
    private final String msg;
}
