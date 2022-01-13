package com.naufal.testadprieds.model;

public class CartList {

    String name;
    String sku;
    String date;
    String qty;
    String uom;
    String price;
    String total_price;
    String remark;
    boolean expanded;

    public CartList(String name, String sku, String date, String qty, String uom, String price,
                    String total_price, String remark, boolean expanded) {
        this.name = name;
        this.sku = sku;
        this.date = date;
        this.qty = qty;
        this.uom = uom;
        this.price = price;
        this.total_price = total_price;
        this.remark = remark;
        this.expanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
