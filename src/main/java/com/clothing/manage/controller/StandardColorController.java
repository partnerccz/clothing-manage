package com.clothing.manage.controller;

import com.clothing.manage.enums.ResultCode;
import com.clothing.manage.model.StandardColor;
import com.clothing.manage.service.StandardColorService;
import com.clothing.manage.utils.JsonResult;
import com.clothing.manage.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @GetMapping("/getStandardColorById")
    public StandardColor getStandardColorById(Integer id) {
        try {
            log.info("【获取商品颜色规格】 参数id={}", id);
            StandardColor standardColor = standardColorService.selectByPrimaryKey(id);
            return standardColor;
        } catch (Exception e) {
            log.error("【获取商品颜色规格】异常信息={}", e.getMessage());
            return new StandardColor();
        }
    }

    @PostMapping("/getStandardColorsByPage")
    public PageInfo<Map> getStandardColorsByPage(Integer pageNum, Integer pageSize, Integer id, String name) {
        try {
            log.info("【获取商品颜色规格分页】 参数pageNum={},pageSize={},id={},name={}");
            Page<Map> standardColorsByPage = standardColorService.getStandardColorsByPage(name, id, pageNum, pageSize);
            PageInfo<Map> pageInfo = new PageInfo<>(standardColorsByPage);
            return pageInfo;
        } catch (Exception e) {
            log.error("【获取商品颜色规格分页】 异常信息={}", e.getMessage());
            return new PageInfo<>();
        }
    }

    @PostMapping("/delColors")
    public JsonResult delColors(Integer[] ids, Integer status) {
        try {
            if (ids == null || ids.length == 0 || status ==null) {
                return new JsonResult(ResultCode.PARAMS_ERROR, "参数不能为空！", ResultCode.PARAMS_ERROR.getStatusCode());
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                list.add(ids[i]);
            }
            int i = standardColorService.delStandardColor(list);
            if (i > 0) {
                return new JsonResult();
            }
            return new JsonResult(ResultCode.FAIL, "删除失败！", ResultCode.FAIL.getStatusCode());
        } catch (Exception e) {
            log.error("【批量删除商品颜色规格】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION, "删除异常！", ResultCode.EXCEPTION.getStatusCode());
        }
    }

    @PostMapping("/addStandardColor")
    public JsonResult addStandardColor(StandardColor standardColor) {
        try {
            if (standardColor == null) {
                return new JsonResult(ResultCode.PARAMS_ERROR, "参数不能为空！", ResultCode.PARAMS_ERROR.getStatusCode());
            }
            if (standardColor.getId() == null) {
                standardColor.setCreateTime(new Date());
                int i = standardColorService.addStandardColor(standardColor);
                if (i > 0) {
                    return new JsonResult();
                }
            }else {
                int i = standardColorService.updateByPrimaryKeySelective(standardColor);
                if (i > 0) {
                    return new JsonResult();
                }
            }
            return new JsonResult(ResultCode.FAIL, "添加失败！", ResultCode.FAIL.getStatusCode());
        } catch (Exception e) {
            log.error("【添加商品颜色规格】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION, "添加异常！", ResultCode.EXCEPTION.getStatusCode());
        }
    }
}
