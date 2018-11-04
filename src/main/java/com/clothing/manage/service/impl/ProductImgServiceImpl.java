package com.clothing.manage.service.impl;

import com.clothing.manage.dao.ProductImgMapper;
import com.clothing.manage.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品实现类
 *
 * @author partner
 * @create 2018-11-04 12:47
 */
@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    private ProductImgMapper productImgMapper;

    @Override
    public List<Map> getProductImgByProductId(Integer productId) {
        return productImgMapper.getProductImgByProductId(productId);
    }
}
