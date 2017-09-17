/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

/**
 *
 * @author Amila(Polta)
 */
public class AllOrders {
    
    private int cusId;
    private String cusName;
    private String usrName;
    private String date;
    private String ordrId;
    private int status;
    private double amount;

    public AllOrders() {
    }

    public AllOrders(int cusId, String cusName, String usrName, String date, String ordrId, int status, double amount) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.usrName = usrName;
        this.date = date;
        this.ordrId = ordrId;
        this.status = status;
        this.amount = amount;
    }

    /**
     * @return the cusId
     */
    public int getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the cusName
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * @param cusName the cusName to set
     */
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    /**
     * @return the usrName
     */
    public String getUsrName() {
        return usrName;
    }

    /**
     * @param usrName the usrName to set
     */
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the ordrId
     */
    public String getOrdrId() {
        return ordrId;
    }

    /**
     * @param ordrId the ordrId to set
     */
    public void setOrdrId(String ordrId) {
        this.ordrId = ordrId;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    
}
