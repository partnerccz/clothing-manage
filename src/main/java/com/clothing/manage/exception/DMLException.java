package com.clothing.manage.exception;

/**
 * 描述:
 * 执行数据的查询、新增、删除、更新异常
 *
 * @author partner
 * @create 2018-10-23 15:15
 */
public class DMLException extends RuntimeException {
    public DMLException(String message) {
        super(message);
    }
}
