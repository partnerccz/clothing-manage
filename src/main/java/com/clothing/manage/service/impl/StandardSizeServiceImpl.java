package com.clothing.manage.service.impl;

import com.clothing.manage.dao.StandardColorMapper;
import com.clothing.manage.dao.StandardSizeMapper;
import com.clothing.manage.model.StandardSize;
import com.clothing.manage.service.StandardSizeService;
import com.clothing.manage.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return standardSizeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StandardSize record) {
        return standardSizeMapper.insert(record);
    }

    @Override
    public int insertSelective(StandardSize record) {
        return standardSizeMapper.insertSelective(record);
    }

    @Override
    public StandardSize selectByPrimaryKey(Integer id) {
        return standardSizeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StandardSize record) {
        return standardSizeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StandardSize record) {
        return standardSizeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<Map> getStandardSizesByPage(String name, Integer id,Integer size, Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (VerifyData.strIsNotNull(name)) {
            sb.append(" and name like #{name}");
            map.put("name", "%"+name+"%");
        }
        if (VerifyData.intIsNotNullOrZero(id)) {
            sb.append(" and id = #{id}");
            map.put("id", id);
        }
        if (VerifyData.intIsNotNullOrZero(size)) {
            sb.append(" and size=#{size}");
            map.put("size", size);
        }
        PageHelper.startPage(pageNum, pageSize);
        map.put("strWhere", sb.toString());
        return standardSizeMapper.getStandardSizesByPage(map);
    }

    @Override
    public int delStandardSize(List<Integer> list) {
        return standardSizeMapper.delStandardSize(list);
    }
}
