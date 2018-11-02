package com.clothing.manage.service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品规格服务
 *
 * @author partner
 * @create 2018-10-31 20:40
 */
public interface StandardSizeService {
    /**
     * 获取所有的商品规格大小
     * @return
     */
    List<Map> getStandardSizes();
}
