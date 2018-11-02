package com.clothing.manage.dao;

import com.clothing.manage.model.CartProduct;

public interface CartProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartProduct record);

    int insertSelective(CartProduct record);

    CartProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartProduct record);

    int updateByPrimaryKey(CartProduct record);
}