package com.lfx.common.response;

import com.github.pagehelper.Page;
import com.lfx.common.enums.ResponseEnum;

import java.util.List;

/**
 * Created on 2021-11-24 16:55:02
 *
 * @author linfuxin
 */
public class ResponseHelper {
    public static Response<Void> success() {
        return success(null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseEnum.SUCCEED.getCode(), null, data);
    }

    public static <T> PageResponse<T> successPage(Page<?> page, List<T> data) {
        return PageResponse.<T>builder()
                .code(ResponseEnum.SUCCEED.getCode())
                .msg(null)
                .data(data)
                .total(page.getTotal())
                .build();
    }

    public static Response<Void> fail(ResponseEnum errorEnum) {
        return new Response<>(errorEnum.getCode(), errorEnum.getMsg(), null);
    }

    public static Response<Void> fail(int code, String errorMsg) {
        return new Response<>(code, errorMsg, null);
    }
}
