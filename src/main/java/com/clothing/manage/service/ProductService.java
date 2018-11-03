package com.clothing.manage.service;

import com.clothing.manage.model.Product;
import com.clothing.manage.model.extension.ProductExtension;
import com.github.pagehelper.Page;

import java.util.Map;

/**
 * 描述:
 * 商品服务
 *
 * @author partner
 * @create 2018-10-30 13:25
 */
public interface ProductService {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Map selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 带条件的分页查询
     * @param productExtension
     * @return
     */
    Page<Map> getProductsByPage(ProductExtension productExtension);

    /**
     * 添加商品
     * @param product
     * @param keywords
     * @param colorSize
     * @param imgs
     * @return
     */
    Integer saveProduct(Product product, String[] keywords, String[] colorSize, String[] imgs);
}
