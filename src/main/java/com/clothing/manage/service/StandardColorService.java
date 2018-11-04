package com.clothing.manage.service;


import com.clothing.manage.model.StandardColor;
import com.github.pagehelper.Page;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品颜色归还
 *
 * @author partner
 * @create 2018-10-31 20:27
 */
public interface StandardColorService {

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
     * @param name
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Map> getStandardColorsByPage(String name, Integer id, Integer pageNum, Integer pageSize);

    /**
     * 根据Id删除颜色规格
     * @param list
     * @return
     */
    int delStandardColor(List<Integer> list);

    /**
     * 添加商品颜色规格
     * @param standardColor
     * @return
     */
    int addStandardColor(StandardColor standardColor);
}
