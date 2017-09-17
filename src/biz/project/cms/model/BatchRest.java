/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

/**
 *
 * @author SMSC
 */
public class BatchRest {
    private int batchId;
    private int currQTY;
    private double costPrice;
    private double unitPrice;
    private String itemCode;

    public BatchRest(int batchId, int currQTY, double costPrice, double unitPrice, String itemCode) {
        this.batchId = batchId;
        this.currQTY = currQTY;
        this.costPrice = costPrice;
        this.unitPrice = unitPrice;
        this.itemCode = itemCode;
    }

    public BatchRest() {
    }

    /**
     * @return the batchId
     */
    public int getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the currQTY
     */
    public int getCurrQTY() {
        return currQTY;
    }

    /**
     * @param currQTY the currQTY to set
     */
    public void setCurrQTY(int currQTY) {
        this.currQTY = currQTY;
    }

    /**
     * @return the costPrice
     */
    public double getCostPrice() {
        return costPrice;
    }

    /**
     * @param costPrice the costPrice to set
     */
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    
    
}
