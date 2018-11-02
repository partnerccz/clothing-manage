package com.clothing.manage.dao;

import com.clothing.manage.model.StandardColor;
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
}