package com.clothing.manage.exception;

import lombok.Data;

/**
 * 描述:
 * 我的异常类,设备异常类
 *
 * @author partner
 * @create 2018-09-13 23:11
 */
@Data
public class EquipException extends RuntimeException {

    public EquipException(String message) {
        super(message);
    }
}
