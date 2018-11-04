package com.clothing.manage.service;

import com.clothing.manage.model.StandardSize;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品规格服务
 *
 * @author partner
 * @create 2018-10-31 20:40
 */
public interface StandardSizeService {
    /**
     * 获取所有的商品规格大小
     * @return
     */
    List<Map> getStandardSizes();

    int deleteByPrimaryKey(Integer id);

    int insert(StandardSize record);

    int insertSelective(StandardSize record);

    StandardSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardSize record);

    int updateByPrimaryKey(StandardSize record);

    /**
     * 分页查询商品规格大小
     * @param name
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Map> getStandardSizesByPage(String name,Integer id,Integer size,Integer pageNum,Integer pageSize);

    /**
     * 批量删除商品规格大小
     * @param list
     * @return
     */
    int delStandardSize(List<Integer> list);
}
