package com.lfx.common.mapper;

import com.lfx.common.constant.BaseConstant;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:idler41@163.com">linfuxin</a>
 * @date 2021-11-26 20:50:27
 */
public interface BaseMapper<T> {

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(T entity);

    /**
     * 删除一条记录
     *
     * @param id 主键id
     * @return 影响行数
     */
    int deleteById(Serializable id);

    /**
     * 批量删除记录
     *
     * @param idList 主键id集合
     * @return 影响行数
     */
    int deleteByIdList(@Param(BaseConstant.MYBATIS_PARAM_IDS) Collection<? extends Serializable> idList);

    /**
     * 更新单条记录
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int updateById(T entity);

    /**
     * 更新单条记录(只更新不为null的字段)
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int updateSelectiveById(T entity);

    /**
     * 查询单条记录
     *
     * @param id 主键id
     * @return 实体对象
     */
    T selectById(Serializable id);

    /**
     * 查询多条记录
     *
     * @param idList 主键id集合
     * @return 实体对象集合
     */
    List<T> selectByIdList(@Param(BaseConstant.MYBATIS_PARAM_IDS) Collection<? extends Serializable> idList);

    /**
     * 条件查询所有记录
     * @param entity 实体对象
     * @return 实体对象集合
     */
    List<T> selectByEntity(T entity);
}
