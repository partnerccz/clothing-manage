package com.clothing.manage.utils;

import java.util.UUID;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-11-03 10:28
 */
public class FileNameUtil {
    public static String generatorUUIDName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 截取文件类型
     * @param fileName
     * @return
     */
    public static String splitFileType(String fileName) {
        try {
            String fileType = fileName.split("\\.")[1];
            return fileType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(generatorUUIDName());
    }
}
