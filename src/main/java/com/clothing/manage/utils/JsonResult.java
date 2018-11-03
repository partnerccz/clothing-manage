package com.clothing.manage.utils;

import com.clothing.manage.enums.ResultCode;
import lombok.Data;

/**
 * 描述:
 *
 * @author partner
 * @create 2018-10-29 11:44
 */
@Data
public class JsonResult {
    private ResultCode code;
    private String message;
    private Integer httpCode;
    private Object data;

    public JsonResult() {
        this.code = ResultCode.SUCCESS;
        this.message = ResultCode.SUCCESS.getStatusStr();
        this.httpCode = ResultCode.SUCCESS.getStatusCode();
        this.data = null;
    }

    public JsonResult(ResultCode resultCode, String message, Integer httpCode) {
        this.code = resultCode;
        this.message = message;
        this.httpCode = httpCode;
        this.data = null;
    }

    public JsonResult(ResultCode resultCode, String message, Integer httpCode,Object data) {
        this.code = resultCode;
        this.message = message;
        this.httpCode = httpCode;
        this.data = data;
    }
}
