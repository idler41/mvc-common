package com.lfx.common.manager;

import com.lfx.common.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:idler41@163.com">linfuxin</a>
 * @date 2021-11-28 15:16:55
 */
@Slf4j
public abstract class AbstractManager<Mapper extends BaseMapper<T>, T> implements BaseManager<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(T entity) {
        return retBoolean(mapper.insert(entity));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Serializable id) {
        return retBoolean(mapper.deleteById(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeBatch(Collection<? extends Serializable> idList) {
        return retBoolean(mapper.deleteByIdList(idList));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        return retBoolean(mapper.updateById(entity));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelectiveById(T entity) {
        return retBoolean(mapper.updateSelectiveById(entity));
    }

    @Override
    public T get(Serializable id) {
        return mapper.selectById(id);
    }

    @Override
    public List<T> getByIds(Collection<? extends Serializable> idList) {
        return mapper.selectByIdList(idList);
    }

    @Override
    public List<T> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> list(T entity) {
        return mapper.selectByEntity(entity);
    }
}
