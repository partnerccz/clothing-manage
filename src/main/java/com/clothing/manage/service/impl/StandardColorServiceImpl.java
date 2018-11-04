package com.clothing.manage.service.impl;

import com.clothing.manage.dao.StandardColorMapper;
import com.clothing.manage.model.StandardColor;
import com.clothing.manage.service.StandardColorService;
import com.clothing.manage.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public int deleteByPrimaryKey(Integer id) {
        return standardColorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StandardColor record) {
        return standardColorMapper.insert(record);
    }

    @Override
    public int insertSelective(StandardColor record) {
        return standardColorMapper.insertSelective(record);
    }

    @Override
    public StandardColor selectByPrimaryKey(Integer id) {
        return standardColorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StandardColor record) {
        return standardColorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StandardColor record) {
        return standardColorMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> getStandardColors() {
        return standardColorMapper.getStandardColors();
    }

    @Override
    public Page<Map> getStandardColorsByPage(String name,Integer id,Integer pageNum, Integer pageSize) {
        Map map = new HashMap();
        StringBuilder sb = new StringBuilder();
        if (VerifyData.intIsNotNullOrZero(id)) {
            sb.append(" and id = #{id}");
            map.put("id", id);
        }
        if (VerifyData.strIsNotNull(name)) {
            sb.append(" and name like #{name}");
            map.put("name", "%"+name+"%");
        }
        map.put("strWhere", sb.toString());

        PageHelper.startPage(pageNum, pageSize);
        return standardColorMapper.getStandardColorsByPage(map);
    }

    @Override
    public int delStandardColor(List<Integer> list) {
        return standardColorMapper.delStandardColor(list);
    }

    @Override
    public int addStandardColor(StandardColor standardColor) {
        return standardColorMapper.insert(standardColor);
    }
}
