package com.lfx.common.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author <a href="mailto:idler41@163.com">linfuxin</a>
 * @date 2020-05-22 11:37:09
 */
@Data
@ToString(callSuper = true)
public class ScrollPageRequest<T extends Serializable & Comparable<? super T>, P> implements Serializable {

    /**
     * 起始数据
     */
    @NotNull
    private T preValue;

    /**
     * 分页大小
     */
    @NotNull
    @Min(1)
    private Integer pageSize;

    /**
     * 具体的业务参数
     */
    private P param;
}
