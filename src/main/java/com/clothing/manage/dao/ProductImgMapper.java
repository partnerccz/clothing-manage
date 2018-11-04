package com.clothing.manage.dao;

import com.clothing.manage.model.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);

    /**
     * 根据商品ID获取商品集合
     * @param productId
     * @return
     */
    List<Map> getProductImgByProductId(Integer productId);

    /**
     * 根据商品ID删除对应的商品图片
     * @param productId
     * @return
     */
    int delProductImgByProductId(Integer productId);
}