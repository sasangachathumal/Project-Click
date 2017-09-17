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
public class TempSerial {
    private String serial;
    private int period;
    private String tag1;
    private String tag2;

    public TempSerial() {
    }

    public TempSerial(String serial, int period, String tag1, String tag2) {
        this.serial = serial;
        this.period = period;
        this.tag1 = tag1;
        this.tag2 = tag2;
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
     * @return the tag1
     */
    public String getTag1() {
        return tag1;
    }

    /**
     * @param tag1 the tag1 to set
     */
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    /**
     * @return the tag2
     */
    public String getTag2() {
        return tag2;
    }

    /**
     * @param tag2 the tag2 to set
     */
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }
    
}
