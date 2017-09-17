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
public class Damage {
    private int damID;
    private int qty;
    private String reason;
    private int batchdId;
    private String date;

    public Damage(int damID, int qty, String reason, int batchdId, String date) {
        this.damID = damID;
        this.qty = qty;
        this.reason = reason;
        this.batchdId = batchdId;
        this.date = date;
    }

    public Damage() {
    }

    /**
     * @return the damID
     */
    public int getDamID() {
        return damID;
    }

    /**
     * @param damID the damID to set
     */
    public void setDamID(int damID) {
        this.damID = damID;
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
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the batchdId
     */
    public int getBatchdId() {
        return batchdId;
    }

    /**
     * @param batchdId the batchdId to set
     */
    public void setBatchdId(int batchdId) {
        this.batchdId = batchdId;
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

}