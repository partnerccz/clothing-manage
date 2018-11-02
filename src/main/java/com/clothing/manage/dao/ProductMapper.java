package com.clothing.manage.dao;

import com.clothing.manage.model.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 获取商品分页
     * @param map
     * @return
     */
    Page<Map> getProductsByPage(Map map);
}