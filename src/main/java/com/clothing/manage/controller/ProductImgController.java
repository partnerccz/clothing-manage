package com.clothing.manage.controller;

import com.clothing.manage.enums.ResultCode;
import com.clothing.manage.service.ProductImgService;
import com.clothing.manage.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品图片API
 *
 * @author partner
 * @create 2018-11-04 12:48
 */
@RestController
@RequestMapping("/productImg")
@Slf4j
public class ProductImgController {
    @Autowired
    private ProductImgService productImgService;

    @GetMapping("/getProductImg")
    public List<Map> getProductImg(Integer productId) {
        try {
            log.info("【获取商品图片】 参数productId={}", productId);
            List<Map> productImgs = productImgService.getProductImgByProductId(productId);
            return productImgs;
        } catch (Exception e) {
            log.error("【获取商品图片】 异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
