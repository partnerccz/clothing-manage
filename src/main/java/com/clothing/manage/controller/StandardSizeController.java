package com.clothing.manage.controller;

import com.clothing.manage.service.StandardSizeService;
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
 * 商品大小规格API
 *
 * @author partner
 * @create 2018-10-31 20:42
 */
@RestController
@RequestMapping("/standardSize")
@Slf4j
public class StandardSizeController {
    @Autowired
    private StandardSizeService standardSizeService;

    @GetMapping("/getStandardSizes")
    public List<Map> getStandardSizes() {
        try {
            List<Map> standardSizes = standardSizeService.getStandardSizes();
            return standardSizes;
        } catch (Exception e) {
            log.error("【商品大小规格】 异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
