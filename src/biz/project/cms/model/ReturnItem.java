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
public class ReturnItem {
    private int batchid;
    private int qty;
    private String oid;
    private String serial;
    private int state;
    private String reasons;
    private String crid;
    private String mrid;
    private int userid;

    public ReturnItem() {
    }

    public ReturnItem(int batchid, int qty, String oid, String serial, int state, String reasons, String crid, String mrid, int userid) {
        this.batchid = batchid;
        this.qty = qty;
        this.oid = oid;
        this.serial = serial;
        this.state = state;
        this.reasons = reasons;
        this.crid = crid;
        this.mrid = mrid;
        this.userid = userid;
    }

    /**
     * @return the batchid
     */
    public int getBatchid() {
        return batchid;
    }

    /**
     * @param batchid the batchid to set
     */
    public void setBatchid(int batchid) {
        this.batchid = batchid;
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
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the reasons
     */
    public String getReasons() {
        return reasons;
    }

    /**
     * @param reasons the reasons to set
     */
    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    /**
     * @return the crid
     */
    public String getCrid() {
        return crid;
    }

    /**
     * @param crid the crid to set
     */
    public void setCrid(String crid) {
        this.crid = crid;
    }

    /**
     * @return the mrid
     */
    public String getMrid() {
        return mrid;
    }

    /**
     * @param mrid the mrid to set
     */
    public void setMrid(String mrid) {
        this.mrid = mrid;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
}
