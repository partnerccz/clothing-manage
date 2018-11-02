package com.clothing.manage.dao;

import com.clothing.manage.model.ProductStandardParam;

public interface ProductStandardParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductStandardParam record);

    int insertSelective(ProductStandardParam record);

    ProductStandardParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductStandardParam record);

    int updateByPrimaryKey(ProductStandardParam record);
}