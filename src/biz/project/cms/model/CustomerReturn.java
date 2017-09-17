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
public class CustomerReturn {
    private String retId;
    private int codId;
    private int qty;
    private String date;

    public CustomerReturn() {
    }

    public CustomerReturn(String retId, int codId, int qty, String date) {
        this.retId = retId;
        this.codId = codId;
        this.qty = qty;
        this.date = date;
    }

    /**
     * @return the retId
     */
    public String getRetId() {
        return retId;
    }

    /**
     * @param retId the retId to set
     */
    public void setRetId(String retId) {
        this.retId = retId;
    }

    /**
     * @return the codId
     */
    public int getCodId() {
        return codId;
    }

    /**
     * @param codId the codId to set
     */
    public void setCodId(int codId) {
        this.codId = codId;
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
