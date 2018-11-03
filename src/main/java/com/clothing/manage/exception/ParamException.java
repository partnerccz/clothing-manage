package com.clothing.manage.exception;


import com.clothing.manage.utils.VerifyData;

/**
 * 描述:
 * 参数异常
 *
 * @author partner
 * @create 2018-10-23 15:08
 */
public class ParamException extends RuntimeException {
    public ParamException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        if (VerifyData.doubleIsNotNullOrZero(null)) {

            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
