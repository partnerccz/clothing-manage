package com.clothing.manage.model.extension;

import lombok.Data;

/**
 * 描述: 订单查询扩张类
 *
 * @author partner
 * @create 2018-10-30 13:20
 */
@Data
public class ProductExtension {
    private String productName;
    private Integer productId;
    private String productCode;
    private Integer isPutAway;
    private Integer typeId;
    private Integer pageNum;
    private Integer pageSize;
    private String startTime;
    private String endTime;
    private String orderBy;
}
