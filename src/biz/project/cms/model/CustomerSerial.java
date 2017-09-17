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
public class CustomerSerial {
    private int serialId;
    private String serialNo;
    private int tag1;
    private int tag2;
    private int codid;
    private int period;

    public CustomerSerial() {
    }

    public CustomerSerial(int serialId, String serialNo, int tag1, int tag2, int codid, int period) {
        this.serialId = serialId;
        this.serialNo = serialNo;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.codid = codid;
        this.period = period;
    }

    /**
     * @return the serialId
     */
    public int getSerialId() {
        return serialId;
    }

    /**
     * @param serialId the serialId to set
     */
    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    /**
     * @return the serialNo
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * @return the tag1
     */
    public int getTag1() {
        return tag1;
    }

    /**
     * @param tag1 the tag1 to set
     */
    public void setTag1(int tag1) {
        this.tag1 = tag1;
    }

    /**
     * @return the tag2
     */
    public int getTag2() {
        return tag2;
    }

    /**
     * @param tag2 the tag2 to set
     */
    public void setTag2(int tag2) {
        this.tag2 = tag2;
    }

    /**
     * @return the codid
     */
    public int getCodid() {
        return codid;
    }

    /**
     * @param codid the codid to set
     */
    public void setCodid(int codid) {
        this.codid = codid;
    }

    /**
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(int period) {
        this.period = period;
    }
    
}