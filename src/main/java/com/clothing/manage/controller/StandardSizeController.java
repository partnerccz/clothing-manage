package com.clothing.manage.controller;

import com.clothing.manage.enums.ResultCode;
import com.clothing.manage.model.StandardColor;
import com.clothing.manage.model.StandardSize;
import com.clothing.manage.service.StandardSizeService;
import com.clothing.manage.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/getStandardSizeById")
    public StandardSize getStandardSizeById(Integer id) {
        try {
            return standardSizeService.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("【商品大小规格】 根据ID={},获取规格大小异常信息={}", e.getMessage());
            return new StandardSize();
        }
    }

    @PostMapping("/getStandardSizeByPage")
    public PageInfo<Map> getStandardSizeByPage(String name, Integer id, Integer pageNum, Integer pageSize,Integer size) {
        try {
            log.info("【商品大小规格分页】 参数name={},id={},pageNum={},pageSize={}", name, id, pageNum, pageSize);
            Page<Map> standardSizesByPage = standardSizeService.getStandardSizesByPage(name, id,size, pageNum, pageSize);
            PageInfo<Map> pageInfo = new PageInfo<>(standardSizesByPage);
            return pageInfo;
        } catch (Exception e) {
            log.error("【商品大小规格分页】 异常信息={}", e.getMessage());
            return new PageInfo<>();
        }
    }

    @PostMapping("/delSizes")
    public JsonResult delSizes(Integer[] ids, Integer status) {
        try {
            if (ids == null || ids.length == 0 || status ==null) {
                return new JsonResult(ResultCode.PARAMS_ERROR, "参数不能为空！", ResultCode.PARAMS_ERROR.getStatusCode());
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                list.add(ids[i]);
            }
            int i = standardSizeService.delStandardSize(list);
            if (i > 0) {
                return new JsonResult();
            }
            return new JsonResult(ResultCode.FAIL, "删除失败！", ResultCode.FAIL.getStatusCode());
        } catch (Exception e) {
            log.error("【批量删除商品大小规格】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION, "删除异常！", ResultCode.EXCEPTION.getStatusCode());
        }
    }

    @PostMapping("/addStandardSize")
    public JsonResult addStandardSize(StandardSize standardSize) {
        try {
            if (standardSize == null) {
                return new JsonResult(ResultCode.PARAMS_ERROR, "参数不能为空！", ResultCode.PARAMS_ERROR.getStatusCode());
            }
            if (standardSize.getId() == null) {
                standardSize.setCreateTime(new Date());
                int i = standardSizeService.insert(standardSize);
                if (i > 0) {
                    return new JsonResult();
                }
            }else {
                int i = standardSizeService.updateByPrimaryKeySelective(standardSize);
                if (i > 0) {
                    return new JsonResult();
                }
            }
            return new JsonResult(ResultCode.FAIL, "添加失败！", ResultCode.FAIL.getStatusCode());
        } catch (Exception e) {
            log.error("【添加商品大小规格】 异常信息={}", e.getMessage());
            return new JsonResult(ResultCode.EXCEPTION, "添加异常！", ResultCode.EXCEPTION.getStatusCode());
        }
    }

}
