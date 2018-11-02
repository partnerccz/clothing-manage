package com.clothing.manage.service.impl;

import com.clothing.manage.dao.MenuMapper;
import com.clothing.manage.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 菜单实现类
 *
 * @author partner
 * @create 2018-10-29 21:16
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Map> getMenuList(Integer userId) {
        // m.id as id,m.parent_id as parentId,m.`name`,m.icon,m.url,m.create_time as createTime,m.update_time as updateTime
        List<Map> menuList = menuMapper.getMenuList(userId);

        List<Map> newMenuList = new ArrayList<>();

        for (int i = 0; i < menuList.size(); i++) {
            Map menu = menuList.get(i);
            Integer parentId = Integer.parseInt(menu.get("parentId") + "");
            if (parentId == 0) {
                newMenuList.add(menu);
            }
        }

        List<Map> finalMap = new ArrayList<>();
        for (int i = 0; i < newMenuList.size(); i++) {
            Map menu = newMenuList.get(i);
            int id = Integer.parseInt(menu.get("id") + "");
            List<Map> sonMenu = new ArrayList<>();
            for (int j = 0; j < menuList.size(); j++) {
                Map map = menuList.get(j);
                int parentId = Integer.parseInt(map.get("parentId") + "");
                if (id == parentId && parentId!=0) {
                    sonMenu.add(map);
                    menu.put("sonMenu", sonMenu);
                }
            }
            finalMap.add(menu);
        }
//        List<Map> newMenuList = new ArrayList<>();
//        List<Map>[] menuListGroup = new ArrayList[12];
//        for (int i = 0; i < menuList.size(); i++) {
//            Map menu = menuList.get(i);
//            Integer parentId = Integer.parseInt(menu.get("parentId") + "");
//            List<Map> maps = menuListGroup[parentId];
//            if (maps != null) {
//                maps.add(menu);
//                menuListGroup[parentId] = maps;
//            }else{
//                maps = new ArrayList<>();
//                maps.add(menu);
//                menuListGroup[parentId] = maps;
//            }
//        }
//
//        // 根据 'parent_id = 0为根节点' 开始组装
//        List<Map> parentGroup = menuListGroup[0];
//        for (Map parentMenu : parentGroup) {
//            Integer parentId = Integer.parseInt(parentMenu.get("parentId") + "");
//            List<Map> sonMenu = menuListGroup[parentId];
//            parentMenu.put("sonMenu",sonMenu);
//            newMenuList.add(parentMenu);
//        }
        return newMenuList;
    }
}
