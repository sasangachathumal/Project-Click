/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

/**
 *
 * @author Vihanga
 */
public class TempOrder {

    private String code;
    private String batch;
    private String desc;
    private String warranty;
    private String qty;
    private String price;
    private String amount;
    private String cost;
    private String sellingPrice;
    private String no;
    private String wholeSale;
    private String period;

    public TempOrder(String code, String desc, String warranty, String qty, String price, String amount, String cost, String sellingPrice, String no) {
        this.code = code;
        this.desc = desc;
        this.warranty = warranty;
        this.qty = qty;
        this.price = price;
        this.amount = amount;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
        this.no = no;
    }

    public TempOrder() {
    }

    public TempOrder(String code, String batch, String desc, String warranty, String qty, String price, String amount, String wholesale, String period,int i) {
        this.code = code;
        this.batch = batch;
        this.desc = desc;
        this.warranty = warranty;
        this.qty = qty;
        this.price = price;
        this.amount = amount;
        this.wholeSale = wholesale;
        this.period = period;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the warranty
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * @param warranty the warranty to set
     */
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * @return the sellingPrice
     */
    public String getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return the no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * @return the wholeSale
     */
    public String getWholeSale() {
        return wholeSale;
    }

    /**
     * @param wholeSale the wholeSale to set
     */
    public void setWholeSale(String wholeSale) {
        this.wholeSale = wholeSale;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
    }

}
