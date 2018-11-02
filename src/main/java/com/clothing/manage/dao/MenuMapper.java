package com.clothing.manage.dao;

import com.clothing.manage.model.Menu;
import com.clothing.manage.model.MenuKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(MenuKey key);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(MenuKey key);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 获取用户下的菜单集合
     * @param userId
     * @return
     */
    List<Map> getMenuList(Integer userId);
}