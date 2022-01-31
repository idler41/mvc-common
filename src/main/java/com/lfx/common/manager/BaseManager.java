package com.lfx.common.manager;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created on 2021-12-01 15:10:52
 *
 * @author linfuxin
 */
public interface BaseManager<T> {

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     * @return 操作是否成功
     */
    boolean insert(T entity);

    /**
     * 删除一条记录
     *
     * @param id 主键id
     * @return 操作是否成功
     */
    boolean remove(Serializable id);

    /**
     * 批量删除记录
     *
     * @param idList 主键id集合
     * @return 操作是否成功
     */
    boolean removeBatch(Collection<? extends Serializable> idList);

    /**
     * 更新单条记录
     *
     * @param entity 实体对象
     * @return 操作是否成功
     */
    boolean updateById(T entity);

    /**
     * 更新单条记录(只更新不为null的字段)
     *
     * @param entity 实体对象
     * @return 操作是否成功
     */
    boolean updateSelectiveById(T entity);

    /**
     * 查询单条记录
     *
     * @param id 主键id
     * @return 实体对象
     */
    T get(Serializable id);

    /**
     * 查询多条记录
     *
     * @param idList 主键id集合
     * @return 实体对象集合
     */
    List<T> getByIds(Collection<? extends Serializable> idList);

    /**
     * 查询所有记录
     *
     * @return 实体对象集合
     */
    List<T> list();

    /**
     * 条件查询所有记录
     *
     * @return 实体对象集合
     */
    List<T> list(T entity);

    /**
     * 操作是否成功
     * @param rowAffected 影响行数
     * @return 操作成功返回true,否则返回false
     */
    default boolean retBoolean(int rowAffected) {
        return rowAffected > 0;
    }
}
