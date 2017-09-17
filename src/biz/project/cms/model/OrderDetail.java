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
public class OrderDetail {
    private int orderDetaiID;
    private String itemCode;
    private String orderId;
    private int qty;
    private double soldPrice;
    private String bid;

    public OrderDetail(int orderDetaiID, String itemCode, String orderId, int qty, double soldPrice, String bid) {
        this.orderDetaiID = orderDetaiID;
        this.itemCode = itemCode;
        this.orderId = orderId;
        this.qty = qty;
        this.soldPrice = soldPrice;
        this.bid = bid;
    }

    public OrderDetail() {
    }


    /**
     * @return the orderDetaiID
     */
    public int getOrderDetaiID() {
        return orderDetaiID;
    }

    /**
     * @param orderDetaiID the orderDetaiID to set
     */
    public void setOrderDetaiID(int orderDetaiID) {
        this.orderDetaiID = orderDetaiID;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the soldPrice
     */
    public double getSoldPrice() {
        return soldPrice;
    }

    /**
     * @param soldPrice the soldPrice to set
     */
    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    /**
     * @return the bid
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(String bid) {
        this.bid = bid;
    }

    
}