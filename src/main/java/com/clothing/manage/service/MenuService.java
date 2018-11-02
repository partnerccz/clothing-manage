package com.clothing.manage.service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 菜单
 *
 * @author partner
 * @create 2018-10-29 21:15
 */
public interface MenuService {
    /**
     * 获取用户下的菜单集合
     * @param userId
     * @return
     */
    List<Map> getMenuList(Integer userId);

}
