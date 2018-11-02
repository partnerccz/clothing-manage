package com.clothing.manage.dao;

import com.clothing.manage.model.ProductStandard;

public interface ProductStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductStandard record);

    int insertSelective(ProductStandard record);

    ProductStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductStandard record);

    int updateByPrimaryKey(ProductStandard record);
}