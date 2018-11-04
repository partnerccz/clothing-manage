package com.clothing.manage.dao;

import com.clothing.manage.model.ProductKeyword;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductKeyword record);

    int insertSelective(ProductKeyword record);

    ProductKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductKeyword record);

    int updateByPrimaryKey(ProductKeyword record);

    /**
     * 根据商品ID获取商品所有的关键词
     * @param productId
     * @return
     */
    List<ProductKeyword> selectProductKeywordByProductId(Integer productId);

    List<ProductKeyword> getProductKeywordByIds(List<Integer> ids);

    /**
     * 根据商品Id删除商品关键词搜索数据
     * @param productId 商品ID
     * @return
     */
    int delProductKeywordByProductId(Integer productId);
}