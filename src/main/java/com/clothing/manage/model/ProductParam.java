package com.clothing.manage.model;

import java.util.Date;

public class ProductParam {
    private Integer id;

    private Integer productId;

    private Integer standardColorId;

    private Integer standardSizeId;

    private Date createTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStandardColorId() {
        return standardColorId;
    }

    public void setStandardColorId(Integer standardColorId) {
        this.standardColorId = standardColorId;
    }

    public Integer getStandardSizeId() {
        return standardSizeId;
    }

    public void setStandardSizeId(Integer standardSizeId) {
        this.standardSizeId = standardSizeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}