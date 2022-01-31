package com.lfx.common.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lfx.common.controller.valid.UpdateSelective;
import com.lfx.common.convert.BaseConvert;
import com.lfx.common.manager.BaseManager;
import com.lfx.common.request.PageRequest;
import com.lfx.common.response.PageResponse;
import com.lfx.common.response.Response;
import com.lfx.common.response.ResponseHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2021-12-01 16:16:51
 *
 * @author linfuxin
 */
public abstract class BaseController<Manager extends BaseManager<T>, Convert extends BaseConvert<T, V, Q>, T, V, Q> {
    
    protected final Manager manager;
    protected final Convert convert;
    
    public BaseController(Manager manager, Convert convert) {
        this.manager = manager;
        this.convert = convert;
    }

    @ApiOperation("查询单条记录")
    @GetMapping("/get")
    public Response<V> get(@Validated @NotNull @RequestParam Integer id) {
        return ResponseHelper.success(convert.entityToVo(manager.get(id)));
    }

    @ApiOperation("根据id批量查询记录")
    @GetMapping("/get/ids")
    public Response<List<V>> getIds(@Validated @NotNull @Size(min = 1, max = 100) @RequestParam Integer[] idList) {
        return ResponseHelper.success(convert.entityListToVoList(manager.getByIds(Arrays.asList(idList))));
    }

    @ApiOperation("查询所有记录")
    @GetMapping("/list")
    public Response<List<V>> list(@Validated Q query) {
        throw new UnsupportedOperationException();
        // T entityParam = convert.queryToEntity(query);
        // return ResponseHelper.success(convert.entityListToVoList(manager.list(entityParam)));
    }

    @ApiOperation("查询分页记录")
    @GetMapping("/page")
    public PageResponse<V> page(@Validated PageRequest request, @Validated Q query) {
        T entityParam = convert.queryToEntity(query);
        Page<T> page = PageHelper.startPage(request.getPageNum(), request.getPageSize(), request.isSearchCount())
                .doSelectPage(() -> manager.list(entityParam));
        List<V> data = convert.entityListToVoList(page.getResult());
        return ResponseHelper.successPage(page, data);
    }

    @ApiOperation("添加一条记录")
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> insert(@Validated @RequestBody V v) {
        T dataToInsert = convert.voToEntityIgnoreId(v);
        manager.insert(dataToInsert);
        return ResponseHelper.success();
    }

    @ApiOperation("更新一条记录(所有字段更新)")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> update(@Validated @RequestBody V v) {
        T dataToInsert = convert.voToEntity(v);
        manager.updateById(dataToInsert);
        return ResponseHelper.success();
    }

    @ApiOperation("更新一条记录(只更新不为null的字段)")
    @PostMapping(value = "/updateSelective", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> updateSelective(@Validated(UpdateSelective.class) @RequestBody V v) {
        T dataToInsert = convert.voToEntity(v);
        manager.updateSelectiveById(dataToInsert);
        return ResponseHelper.success();
    }

    @ApiOperation("删除一条记录")
    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> delete(@Validated @NotNull @RequestParam Integer id) {
        manager.remove(id);
        return ResponseHelper.success();
    }
}
