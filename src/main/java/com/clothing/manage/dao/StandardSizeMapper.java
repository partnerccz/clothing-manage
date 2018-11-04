package com.clothing.manage.dao;

import com.clothing.manage.model.StandardSize;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StandardSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardSize record);

    int insertSelective(StandardSize record);

    StandardSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardSize record);

    int updateByPrimaryKey(StandardSize record);

    /**
     * 获取所有的商品规格大小
     * @return
     */
    List<Map> getStandardSizes();

    /**
     * 分页查询商品规格大小
     * @param map
     * @return
     */
    Page<Map> getStandardSizesByPage(Map map);

    /**
     * 批量删除商品规格大小
     * @param list
     * @return
     */
    int delStandardSize(List<Integer> list);
}