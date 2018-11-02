package com.clothing.manage.dao;

import com.clothing.manage.model.ProductRecommend;

public interface ProductRecommendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}