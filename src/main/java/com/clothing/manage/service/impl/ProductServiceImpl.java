package com.clothing.manage.service.impl;

import com.clothing.manage.dao.ProductImgMapper;
import com.clothing.manage.dao.ProductKeywordMapper;
import com.clothing.manage.dao.ProductMapper;
import com.clothing.manage.dao.ProductParamMapper;
import com.clothing.manage.exception.DMLException;
import com.clothing.manage.model.Product;
import com.clothing.manage.model.ProductImg;
import com.clothing.manage.model.ProductKeyword;
import com.clothing.manage.model.ProductParam;
import com.clothing.manage.model.extension.ProductExtension;
import com.clothing.manage.service.ProductService;
import com.clothing.manage.utils.BusinessCodeUtil;
import com.clothing.manage.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.deploy.panel.ITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private ProductKeywordMapper productKeywordMapper;

    @Autowired
    private ProductImgMapper productImgMapper;

    @Autowired
    private ProductParamMapper productParamMapper;

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
    public Map selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
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

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public Integer saveProduct(Product product, String[] keywords, String[] colorSize, String[] imgs) {
        Date date = new Date();

        Integer insertProductCount = 0;
        try {
            //1. 添加商品
            product.setCode(BusinessCodeUtil.generatorProductCode());
            product.setCreateTime(date);
            product.setImg(imgs!=null && imgs.length > 0 ? imgs[0] : null);
            insertProductCount = productMapper.insert(product);
        } catch (Exception e) {
            throw new DMLException("添加商品失败！");
        }
        //2. 添加商品关键词搜索
        Integer pkInsertCount=addProductKeyword(keywords, date, product.getId());
//        if (keywords != null && keywords.length>0) {
//            ProductKeyword productKeyword = null;
//            for (int i = 0; i < keywords.length; i++) {
//                productKeyword = new ProductKeyword();
//                productKeyword.setCreateTime(date);
//                productKeyword.setKeyword(keywords[i]);
//                productKeyword.setProductId(product.getId());
//                pkInsertCount = productKeywordMapper.insert(productKeyword);
//                if (pkInsertCount == 0) {
//                    throw new DMLException("添加商品搜索关键字失败！");
//                }
//            }
//        }
        // 3.执行添加商品规格参数
        Integer ppInsertCount = addProductParam(colorSize, date, product.getId());
//        if (colorSize != null && colorSize.length > 0) {
//            ProductParam productParam = null;
//            for (int i = 0; i < colorSize.length; i++) {
//                productParam = new ProductParam();
//                String colorSizeStr = colorSize[i];
//                // colorSizeStr 类似于这 “1*1” ，第一个数字是sizeId，第二个是colorId
//                String[] split = colorSizeStr.split("\\*");
//                productParam.setCreateTime(date);
//                productParam.setProductId(product.getId());
//                productParam.setStandardColorId(Integer.parseInt(split[1]));
//                productParam.setStandardSizeId(Integer.parseInt(split[0]));
//                ppInsertCount = productParamMapper.insert(productParam);
//                if (ppInsertCount == 0) {
//                    throw new DMLException("添加商品规格参数失败！");
//                }
//            }
//        }
        Integer piInsertCount = addProductImg(imgs, date, product.getId());
        //4. 执行添加商品图片
//        if (imgs != null && imgs.length > 0) {
//            ProductImg productImg = null;
//            for (int i = 0; i < imgs.length; i++) {
//                productImg = new ProductImg();
//                productImg.setCreateTime(date);
//                productImg.setImgUrl(imgs[i]);
//                productImg.setProductId(product.getId());
//                piInsertCount = productImgMapper.insert(productImg);
//                if (piInsertCount == 0) {
//                    throw new DMLException("添加商品图片失败！");
//                }
//            }
//        }
        if (insertProductCount > 0 && pkInsertCount > -1 && piInsertCount > -1 && ppInsertCount > -1) {
            return 1;
        }
        return 0;
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public Integer updateProduct(Product product, String[] keywords, String[] colorSize, String[] imgs) {
        Date date = new Date();
        product.setUpdateTime(date);
        // 1.修改商品数据
        int updateProductCount = productMapper.updateByPrimaryKeySelective(product);
        // 2.修改关键词
        // 2.1 先删除对应的商品关键词
        int delProductKeyword = productKeywordMapper.delProductKeywordByProductId(product.getId());
        // 2.2 执行添加商品搜索关键词
        int pkInsertCount = addProductKeyword(keywords, date, product.getId());
        // 3.修改商品规格参数
        // 3.1 先删除对应的商品规格参数
        int delProductParam = productParamMapper.delProductParamByProductId(product.getId());
        // 3.2 执行添加商品规格参数
        Integer ppInsertCount = addProductParam(colorSize, date, product.getId());
        // 4.修改商品图片
        // 4.1 先删除对应的商品图片
        int delProductImg = productImgMapper.delProductImgByProductId(product.getId());
        // 4.2 执行添加商品图片
        Integer piInsertCount = addProductImg(imgs, date, product.getId());

        if (updateProductCount > 0 && delProductKeyword > -1 && pkInsertCount > -1 && delProductParam > -1 && ppInsertCount > -1 && delProductImg > -1 && piInsertCount > -1) {
            return 1;
        }
        return 0;
    }

    /**
     * 添加商品图片
     * @param imgs
     * @param date
     * @param productId
     * @return
     */
    private Integer addProductImg(String[] imgs, Date date, Integer productId) {
        Integer piInsertCount=0;
        if (imgs != null && imgs.length > 0) {
            ProductImg productImg = null;
            for (int i = 0; i < imgs.length; i++) {
                productImg = new ProductImg();
                productImg.setCreateTime(date);
                productImg.setImgUrl(imgs[i]);
                productImg.setProductId(productId);
                piInsertCount = productImgMapper.insert(productImg);
                if (piInsertCount == 0) {
                    throw new DMLException("添加商品图片失败！");
                }
            }
        }
        return  piInsertCount;
    }

    /**
     * 执行添加商品规格参数
     * @param colorSize
     * @param date
     * @param productId
     * @return
     */
    private Integer addProductParam(String[] colorSize, Date date, Integer productId) {
        Integer ppInsertCount = 0;
        if (colorSize != null && colorSize.length > 0) {
            ProductParam productParam = null;
            for (int i = 0; i < colorSize.length; i++) {
                productParam = new ProductParam();
                String colorSizeStr = colorSize[i];
                // colorSizeStr 类似于这 “1*1” ，第一个数字是sizeId，第二个是colorId
                String[] split = colorSizeStr.split("\\*");
                productParam.setCreateTime(date);
                productParam.setProductId(productId);
                productParam.setStandardColorId(Integer.parseInt(split[1]));
                productParam.setStandardSizeId(Integer.parseInt(split[0]));
                ppInsertCount = productParamMapper.insert(productParam);
                if (ppInsertCount == 0) {
                    throw new DMLException("添加商品规格参数失败！");
                }
            }
        }
        return ppInsertCount;
    }

    /**
     *  执行添加商品关键字搜索
     * @param keywords
     * @param date
     * @param productId
     * @return
     */
    private Integer addProductKeyword(String[] keywords, Date date, Integer productId) {
        Integer pkInsertCount = 0;
        //2. 添加商品关键词搜索
        if (keywords != null && keywords.length>0) {
            ProductKeyword productKeyword = null;
            for (int i = 0; i < keywords.length; i++) {
                productKeyword = new ProductKeyword();
                productKeyword.setCreateTime(date);
                productKeyword.setKeyword(keywords[i]);
                productKeyword.setProductId(productId);
                pkInsertCount = productKeywordMapper.insert(productKeyword);
                if (pkInsertCount == 0) {
                    throw new DMLException("添加商品搜索关键字失败！");
                }
            }
        }
        return pkInsertCount;
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
