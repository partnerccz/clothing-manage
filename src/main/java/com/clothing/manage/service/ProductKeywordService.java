package com.clothing.manage.service;

import com.clothing.manage.model.ProductKeyword;

import java.util.List;

/**
 * 描述:
 * 商品搜索关键词
 *
 * @author partner
 * @create 2018-11-03 14:38
 */
public interface ProductKeywordService {
    /**
     * 根据商品ID获取商品所有的关键词
     * @param productId
     * @return
     */
    List<ProductKeyword> selectProductKeywordByProductId(Integer productId);
}
