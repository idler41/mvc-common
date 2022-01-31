package com.lfx.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:idler41@163.com">linfuxin</a>
 * @date 2020-05-22 10:14:26
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> implements Serializable {

    /**
     * 响应数据
     */
    private List<T> data;

    /**
     * 响应码
     */
    private int code;

    /**
     * 信息提示
     */
    private String msg;

    /**
     * 总记录数
     */
    private long total;
}
