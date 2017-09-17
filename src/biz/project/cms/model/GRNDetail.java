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
public class GRNDetail {
    private int grnDetailId;
    private String grnId;
    private String batchId;
    private int qty;

    public GRNDetail() {
    }

    public GRNDetail(int grnDetailId, String grnId, String batchId, int qty) {
        this.grnDetailId = grnDetailId;
        this.grnId = grnId;
        this.batchId = batchId;
        this.qty = qty;
    }

    /**
     * @return the grnDetailId
     */
    public int getGrnDetailId() {
        return grnDetailId;
    }

    /**
     * @param grnDetailId the grnDetailId to set
     */
    public void setGrnDetailId(int grnDetailId) {
        this.grnDetailId = grnDetailId;
    }

    /**
     * @return the grnId
     */
    public String getGrnId() {
        return grnId;
    }

    /**
     * @param grnId the grnId to set
     */
    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
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
    
}
