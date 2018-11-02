package com.clothing.manage.service.impl;

import com.clothing.manage.dao.StandardColorMapper;
import com.clothing.manage.service.StandardColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品颜色归还
 *
 * @author partner
 * @create 2018-10-31 20:29
 */
@Service
public class StandardColorServiceImpl implements StandardColorService {

    @Autowired
    private StandardColorMapper standardColorMapper;

    @Override
    public List<Map> getStandardColors() {
        return standardColorMapper.getStandardColors();
    }
}
