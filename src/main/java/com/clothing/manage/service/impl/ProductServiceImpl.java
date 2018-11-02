package com.clothing.manage.service.impl;

import com.clothing.manage.dao.ProductMapper;
import com.clothing.manage.model.Product;
import com.clothing.manage.model.extension.ProductExtension;
import com.clothing.manage.service.ProductService;
import com.clothing.manage.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 商品服务实现类
 *
 * @author partner
 * @create 2018-10-30 13:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Product record) {
        return 0;
    }

    @Override
    public int insertSelective(Product record) {
        return 0;
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }

    @Override
    public Page<Map> getProductsByPage(ProductExtension productExtension) {
        Map params = getParams(productExtension);
        PageHelper.startPage(productExtension.getPageNum(), productExtension.getPageSize());
        return productMapper.getProductsByPage(params);
    }

    private Map getParams(ProductExtension productExtension) {
        Map map = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        if (VerifyData.strIsNotNull(productExtension.getProductName())) {
            stringBuilder.append(" AND b.`name` LIKE  #{productName} ");
            map.put("productName", "%"+productExtension.getProductName() + "%");
        }
        if (VerifyData.intIsNotNullOrZero(productExtension.getProductId())) {
            stringBuilder.append(" AND b.id = #{productId}");
            map.put("productId", productExtension.getProductId());
        }
        if (VerifyData.intIsNotNullOrZero(productExtension.getTypeId())) {
            stringBuilder.append(" AND b.type = #{typeId}");
            map.put("typeId", productExtension.getTypeId());
        }
        if (VerifyData.strIsNotNull(productExtension.getStartTime())) {
            stringBuilder.append(" AND create_time > #{startTime}");
            map.put("startTime", productExtension.getStartTime());
        }
        if (VerifyData.strIsNotNull(productExtension.getEndTime())) {
            stringBuilder.append(" AND create_time < #{endTime}");
            map.put("endTime", productExtension.getEndTime());
        }
        if (VerifyData.strIsNotNull(productExtension.getProductCode())) {
            stringBuilder.append(" AND code = #{code} ");
            map.put("code", productExtension.getProductCode());
        }
        if (VerifyData.intIsNotNullOrZero(productExtension.getIsPutAway())) {
            stringBuilder.append(" AND is_putaway = #{isPutAway}");
            map.put("isPutAway", productExtension.getIsPutAway());
        }
        map.put("strWhere", stringBuilder.toString());
        return map;
    }
}
