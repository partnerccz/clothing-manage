package com.clothing.manage.controller;

import com.clothing.manage.model.extension.ProductExtension;
import com.clothing.manage.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
