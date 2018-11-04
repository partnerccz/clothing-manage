package com.clothing.manage.dao;

import com.clothing.manage.model.ProductParam;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductParam record);

    int insertSelective(ProductParam record);

    ProductParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductParam record);

    int updateByPrimaryKey(ProductParam record);

    /**
     * 根据商品Id获取商品规格参数
     * @param productId
     * @return
     */
    List<Map> selectProductParamByProductId(Integer productId);

    /**
     * 根据商品ID商户商品规格参数
     * @param productId
     * @return
     */
    int delProductParamByProductId(Integer productId);
}