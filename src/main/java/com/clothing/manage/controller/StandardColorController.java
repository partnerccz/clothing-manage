package com.clothing.manage.controller;

import com.clothing.manage.model.StandardColor;
import com.clothing.manage.service.StandardColorService;
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
 *
 * @author partner
 * @create 2018-10-31 20:31
 */
@RestController
@Slf4j
@RequestMapping("/standardColor")
public class StandardColorController {

    @Autowired
    private StandardColorService standardColorService;

    @GetMapping("/getStandardColors")
    public List<Map> getStandardColors() {
        try {
            List<Map> standardColors = standardColorService.getStandardColors();
            return standardColors;
        } catch (Exception e) {
            log.error("【获取商品颜色规格】异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }

}
