package com.lfx.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2021-11-24 16:55:49
 *
 * @author linfuxin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    /**
     * 响应码
     */
    private int code;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

}
