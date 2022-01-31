package com.lfx.common.convert;

import com.lfx.common.constant.BaseConstant;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Created on 2021-12-01 17:10:15
 *
 * @author linfuxin
 */
public interface BaseConvert<T, V, Q> {
    /**
     * 数据对象转换
     *
     * @param q 前端参数
     * @return 业务封装对象
     */
    T queryToEntity(Q q);

    /**
     * 数据对象转换
     *
     * @param t db查询对象
     * @return 前端展示对象
     */
    V entityToVo(T t);

    /**
     * 数据对象转换
     *
     * @param v 前端参数对象
     * @return 数据对象
     */
    @Mapping(target = BaseConstant.CONVERT_ID, ignore = true)
    T voToEntityIgnoreId(V v);

    /**
     * 数据对象转换
     *
     * @param v 前端参数
     * @return 业务封装对象
     */
    T voToEntity(V v);

    /**
     * 数据对象转换
     *
     * @param t db查询对象
     * @return 前端展示对象
     */
    List<V> entityListToVoList(List<T> t);
}
