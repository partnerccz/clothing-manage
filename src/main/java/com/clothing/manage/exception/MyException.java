package com.clothing.manage.exception;

import lombok.Data;

/**
 * 描述:
 * 我的异常类
 *
 * @author partner
 * @create 2018-09-13 23:14
 */
@Data
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
