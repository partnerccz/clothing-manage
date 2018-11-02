package com.clothing.manage.service.impl;

import com.clothing.manage.dao.TypeMapper;
import com.clothing.manage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-10-31 10:12
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Map> getTypes() {
        return typeMapper.getTypes();
    }

}
