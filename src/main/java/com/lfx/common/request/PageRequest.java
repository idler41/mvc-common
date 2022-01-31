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
public class PageRequest implements Serializable {

    /**
     * 当前页
     */
    @NotNull
    @Min(1)
    private Integer pageNum;

    /**
     * 分页大小
     */
    @NotNull
    @Min(1)
    private Integer pageSize;

    /**
     * 查询总记录数（默认 true）
     */
    private boolean searchCount = true;
}
