package com.clothing.manage.utils;

import java.util.Date;

/**
 * 描述:
 * 编号工具类
 *
 * @author partner
 * @create 2018-10-31 9:50
 */
public class BusinessCodeUtil {

    /**
     * 生成12位的商品编号
     * @return
     */
    public static String generatorProductCode() {
        return "PC" + DateUtil.getStringDate(new Date(), "yyMMdd") + RandomUtil.getRandomInt(4);
    }
}
