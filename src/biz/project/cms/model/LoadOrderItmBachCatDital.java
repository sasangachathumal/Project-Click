/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Arty
 */
public class LoadOrderItmBachCatDital {
    private String orderDitailID;
    private Date date;
    private Time time;
    private String orderID;
    private String bachID;
    private String itmCode;
    private String description;
    private double soldPrice;
    private int qty;
    private String codid;

    public LoadOrderItmBachCatDital() {
    }

    public LoadOrderItmBachCatDital(String orderDitailID,Date date, Time time, String orderID, String bachID, String itmCode, String description, double soldPrice, int qty,String codid) {
        this.orderDitailID= orderDitailID;
        this.date = date;
        this.time = time;
        this.orderID = orderID;
        this.bachID = bachID;
        this.itmCode = itmCode;
        this.description = description;
        this.soldPrice = soldPrice;
        this.qty = qty;
        this.codid = codid;
    }

    /**
     * @return the orderDitailID
     */
    public String getOrderDitailID() {
        return orderDitailID;
    }

    /**
     * @param orderDitailID the date to set
     */
    public void setOrderDitailID(String orderDitailID) {
        this.orderDitailID = orderDitailID;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the bachID
     */
    public String getBachID() {
        return bachID;
    }

    /**
     * @param bachID the bachID to set
     */
    public void setBachID(String bachID) {
        this.bachID = bachID;
    }

    /**
     * @return the itmCode
     */
    public String getItmCode() {
        return itmCode;
    }

    /**
     * @param itmCode the itmCode to set
     */
    public void setItmCode(String itmCode) {
        this.itmCode = itmCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the codid
     */
    public String getCodid() {
        return codid;
    }

    /**
     * @param codid the codid to set
     */
    public void setCodid(String codid) {
        this.codid = codid;
    }
    
}
