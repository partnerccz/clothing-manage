package com.clothing.manage.service.impl;

import com.clothing.manage.dao.ProductParamMapper;
import com.clothing.manage.model.ProductParam;
import com.clothing.manage.service.ProductParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-11-03 17:17
 */
@Service
public class ProductParamServiceImpl implements ProductParamService {
    @Autowired
    private ProductParamMapper productParamMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productParamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductParam record) {
        return productParamMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductParam record) {
        return productParamMapper.insertSelective(record);
    }

    @Override
    public ProductParam selectByPrimaryKey(Integer id) {
        return productParamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductParam record) {
        return productParamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductParam record) {
        return productParamMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> selectProductParamByProductId(Integer productId) {
        return productParamMapper.selectProductParamByProductId(productId);
    }
}
