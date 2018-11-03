package com.clothing.manage.dao;

import com.clothing.manage.model.ProductImg;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);
}