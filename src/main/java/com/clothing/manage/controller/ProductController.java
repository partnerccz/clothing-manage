package com.clothing.manage.controller;

import com.clothing.manage.enums.ResultCode;
import com.clothing.manage.exception.DMLException;
import com.clothing.manage.model.Product;
import com.clothing.manage.model.ProductKeyword;
import com.clothing.manage.model.ProductParam;
import com.clothing.manage.model.extension.ColorSize;
import com.clothing.manage.model.extension.ProductExtension;
import com.clothing.manage.service.ProductKeywordService;
import com.clothing.manage.service.ProductService;
import com.clothing.manage.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品API
 *
 * @author partner
 * @create 2018-10-30 19:15
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;



    /**
     * 查询商品分页集合
     * @param productExtension
     * @return
     */
    @PostMapping("/getProductsByPage")
    public PageInfo<Map> getProductsByPage(ProductExtension productExtension) {
        try {
            log.info("【商品】 分页查询商品校核，参数productExtension={}", productExtension);
            Page<Map> productsByPage = productService.getProductsByPage(productExtension);
            PageInfo<Map> pageInfo = new PageInfo<>(productsByPage);
            return pageInfo;
        } catch (Exception e) {
            log.error("【商品】 分页查询商品集合，异常信息={}", e.getMessage());
            return new PageInfo<>();
        }
    }

    @GetMapping("/getProductById")
    public Map getProductById(Integer productId) {
        try {
            log.info("【获取商品】 参数productId={}", productId);
            Map product = productService.selectByPrimaryKey(productId);
            return product;
        } catch (Exception e) {
            log.error("【获取商品】 异常信息={}", e.getMessage());
            return new HashMap();
        }
    }

    @PostMapping("/saveProduct")
    public JsonResult saveProduct(Product product, String[] keywords, String [] colorSize, String [] imgs) {
        try {
            // 如果商品为空
            if (product == null) {
                return new JsonResult(ResultCode.PARAMS_ERROR, "商品不能为空！", ResultCode.PARAMS_ERROR.getStatusCode());
            }
            if (product.getId() == null) {
                Integer insert  = productService.saveProduct(product, keywords, colorSize, imgs);
                if(insert>0){
                    return new JsonResult();
                }else{
                    return new JsonResult(ResultCode.FAIL, "添加商品失败！", ResultCode.FAIL.getStatusCode());
                }
            }else{

            }
            return new JsonResult();
        } catch (DMLException e){
            log.error("【添加商品】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.FAIL, e.getMessage(), ResultCode.FAIL.getStatusCode());
        }catch (Exception e) {
            log.error("【添加商品】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION, "添加商品异常!", ResultCode.EXCEPTION.getStatusCode(), e.getMessage());
        }
    }
}
