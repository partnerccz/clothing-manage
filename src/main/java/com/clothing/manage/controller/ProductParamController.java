package com.clothing.manage.controller;

import com.clothing.manage.model.ProductParam;
import com.clothing.manage.service.ProductParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品规格参数API
 *
 * @author partner
 * @create 2018-11-03 17:19
 */
@RestController
@RequestMapping("/productParam")
@Slf4j
public class ProductParamController {
    @Autowired
    private ProductParamService productParamService;

    @GetMapping("/getProductParamsByProductId")
    public List<Map> getProductParamsByProductId(Integer productId) {
        try {
            log.info("【获取商品规格参数】 商品ID={}", productId);
            List<Map> productParams = productParamService.selectProductParamByProductId(productId);
            return productParams;
        } catch (Exception e) {
            log.error("【获取商品规格参数】 异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
