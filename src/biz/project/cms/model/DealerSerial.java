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
public class DealerSerial {
    private int dId;
    private String serial;
    private int grnId;
    private int period;
    private String itemcode;

    public DealerSerial(int dId, String serial, int grnId, int period, String itemcode) {
        this.dId = dId;
        this.serial = serial;
        this.grnId = grnId;
        this.period = period;
        this.itemcode = itemcode;
    }
    public DealerSerial(String serial, int grnId, int period) {
        this.serial = serial;
        this.grnId = grnId;
        this.period = period;
    }

    public DealerSerial() {
    }

    public DealerSerial(int dId, String serial, int grnId, int period) {
        this.dId = dId;
        this.serial = serial;
        this.grnId = grnId;
        this.period = period;
    }

    /**
     * @return the dId
     */
    public int getdId() {
        return dId;
    }

    /**
     * @param dId the dId to set
     */
    public void setdId(int dId) {
        this.dId = dId;
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
     * @return the grnId
     */
    public int getGrnId() {
        return grnId;
    }

    /**
     * @param grnId the grnId to set
     */
    public void setGrnId(int grnId) {
        this.grnId = grnId;
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

    /**
     * @return the itemcode
     */
    public String getItemcode() {
        return itemcode;
    }

    /**
     * @param itemcode the itemcode to set
     */
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }
    
}
