package com.clothing.manage.controller;

import com.alibaba.fastjson.JSON;
import com.clothing.manage.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 菜单api
 *
 * @author partner
 * @create 2018-10-29 22:05
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/getMenuListByUserId")
    @ResponseBody
    public ResponseEntity<List> getMenuListByUserId() {
        Integer userId = 1;
        List<Map> menuList = menuService.getMenuList(userId);
        return ResponseEntity.ok(menuList);
    }
}
