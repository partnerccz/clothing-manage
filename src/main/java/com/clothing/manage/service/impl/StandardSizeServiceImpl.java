package com.clothing.manage.service.impl;

import com.clothing.manage.dao.StandardColorMapper;
import com.clothing.manage.dao.StandardSizeMapper;
import com.clothing.manage.model.StandardSize;
import com.clothing.manage.service.StandardSizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-10-31 20:41
 */
@Service
@Slf4j
public class StandardSizeServiceImpl implements StandardSizeService {
    @Autowired
    private StandardSizeMapper standardSizeMapper;

    @Override
    public List<Map> getStandardSizes() {
        return standardSizeMapper.getStandardSizes();
    }
}
