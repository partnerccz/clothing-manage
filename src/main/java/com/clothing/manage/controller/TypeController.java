package com.clothing.manage.controller;

import com.clothing.manage.service.TypeService;
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
 * @create 2018-10-31 10:12
 */
@RestController
@RequestMapping("/type")
@Slf4j
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 获取所有的类型
     * @return
     */
    @GetMapping("/getTypes")
    public List<Map> getTypes() {
        try {
            List<Map> types = typeService.getTypes();
            return types;
        } catch (Exception e) {
            log.error("【分类】 获取所有的分类异常，异常信息={}", e.getMessage());
            return new ArrayList<>();
        }
    }
}
