package com.clothing.manage.dao;

import com.clothing.manage.model.ProductKeyword;

public interface ProductKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductKeyword record);

    int insertSelective(ProductKeyword record);

    ProductKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductKeyword record);

    int updateByPrimaryKey(ProductKeyword record);
}