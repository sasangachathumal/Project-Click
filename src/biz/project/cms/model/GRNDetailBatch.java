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
public class GRNDetailBatch {
    private int qty;
    private double cost;
    private double unit;
    private double min;
    private String date;
    private String itemCode;
    private String grnID;

    public GRNDetailBatch() {
    }

    public GRNDetailBatch(int qty, double cost, double unit, double min, String date, String itemCode, String grnID) {
        this.qty = qty;
        this.cost = cost;
        this.unit = unit;
        this.min = min;
        this.date = date;
        this.itemCode = itemCode;
        this.grnID = grnID;
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
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the unit
     */
    public double getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(double unit) {
        this.unit = unit;
    }

    /**
     * @return the min
     */
    public double getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(double min) {
        this.min = min;
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

    /**
     * @return the grnID
     */
    public String getGrnID() {
        return grnID;
    }

    /**
     * @param grnID the grnID to set
     */
    public void setGrnID(String grnID) {
        this.grnID = grnID;
    }
    
}
