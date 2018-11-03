package com.clothing.manage.service.impl;

import com.clothing.manage.dao.ProductKeywordMapper;
import com.clothing.manage.model.ProductKeyword;
import com.clothing.manage.service.ProductKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 商品搜索关键词实现类
 *
 * @author partner
 * @create 2018-11-03 14:38
 */
@Service
public class ProductKeywordServiceImpl implements ProductKeywordService {
    @Autowired
    private ProductKeywordMapper productKeywordMapper;


    @Override
    public List<ProductKeyword> selectProductKeywordByProductId(Integer productId) {
        return productKeywordMapper.selectProductKeywordByProductId(productId);
    }
}
