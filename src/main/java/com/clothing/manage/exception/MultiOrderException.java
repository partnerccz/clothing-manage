package com.clothing.manage.exception;

/**
 * 描述:
 * 同个用户多个订单异常
 *
 * @author partner
 * @create 2018-10-23 14:09
 */
public class MultiOrderException extends RuntimeException {
    public MultiOrderException(String message) {
        super(message);
    }
}
