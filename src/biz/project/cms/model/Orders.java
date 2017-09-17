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
public class Orders {
    private String id;
    private String date;
    private String time;
    private int usrId;
    private int cusId;
    private int status;
    private double amount;

    public Orders() {
    }

    public Orders(String id, String date, String time, int usrId, int cusId, int status, double amount) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.usrId = usrId;
        this.cusId = cusId;
        this.status = status;
        this.amount = amount;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the usrId
     */
    public int getUsrId() {
        return usrId;
    }

    /**
     * @param usrId the usrId to set
     */
    public void setUsrId(int usrId) {
        this.usrId = usrId;
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