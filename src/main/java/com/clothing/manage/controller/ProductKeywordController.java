package com.clothing.manage.controller;

import com.clothing.manage.dao.ProductKeywordMapper;
import com.clothing.manage.model.ProductKeyword;
import com.clothing.manage.service.ProductKeywordService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.First;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 商品关键词API
 *
 * @author partner
 * @create 2018-11-03 14:40
 */
@RestController
@RequestMapping("/productKeyword")
@Slf4j
public class ProductKeywordController {

    @Autowired
    private ProductKeywordService productKeywordService;

    @Autowired
    private ProductKeywordMapper productKeywordMapper;

    /**
     * 获取关键词
     * @param productId
     * @return
     */
    @GetMapping("/getProductKeywordsByProductId")
    public List<ProductKeyword> getProductKeywordsByProductId(Integer productId) {
        try {
            log.info("【获取商品关键词】 参数productId={}", productId);
            List<ProductKeyword> productKeywords = productKeywordService.selectProductKeywordByProductId(productId);
            return productKeywords;
        } catch (Exception e) {
            log.error("【获取商品关键词】 异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 获取关键词,String集合
     * @param productId
     * @return
     */
    @GetMapping("/getKeywordByProductId")
    public List<String> getKeywordByProductId(Integer productId) {
        try {
            log.info("【获取商品关键词】 参数productId={}", productId);
            List<ProductKeyword> productKeywords = productKeywordService.selectProductKeywordByProductId(productId);
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < productKeywords.size(); i++) {
                ProductKeyword productKeyword = productKeywords.get(i);
                stringList.add(productKeyword.getKeyword());
            }
            return stringList;
        } catch (Exception e) {
            log.error("【获取商品关键词】 异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/getTest")
    public List<ProductKeyword> getTest(Integer id1, Integer id2, Integer id3) {
        List<Integer> list = new ArrayList<>();
        list.add(id1);
        list.add(id2);
        list.add(id3);
        List<ProductKeyword> productKeywordByIds = productKeywordMapper.getProductKeywordByIds(list);
        return productKeywordByIds;
    }
}
