package com.clothing.manage.dao;

import com.clothing.manage.model.StandardColor;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StandardColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardColor record);

    int insertSelective(StandardColor record);

    StandardColor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardColor record);

    int updateByPrimaryKey(StandardColor record);

    /**
     * 获取商品颜色规格
     * @return
     */
    List<Map> getStandardColors();

    /**
     * 分页获取颜色规格
     *
     * @param map
     * @return
     */
    Page<Map> getStandardColorsByPage(Map map);

    /**
     * 根据Id删除颜色规格
     * @param list
     * @return
     */
    int delStandardColor(List<Integer> list);
}