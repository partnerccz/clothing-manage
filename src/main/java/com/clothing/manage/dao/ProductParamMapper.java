package com.clothing.manage.dao;

import com.clothing.manage.model.ProductParam;

public interface ProductParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductParam record);

    int insertSelective(ProductParam record);

    ProductParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductParam record);

    int updateByPrimaryKey(ProductParam record);
}