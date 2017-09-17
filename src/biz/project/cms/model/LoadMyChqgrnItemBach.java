/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

/**
 *
 * @author Arty
 */
public class LoadMyChqgrnItemBach {
    private String bachID;
    private String description;
    private int qty;
    private double cost;

    public LoadMyChqgrnItemBach() {
    }

    public LoadMyChqgrnItemBach(String bachID, String description, int qty, double cost) {
        this.bachID = bachID;
        this.description = description;
        this.qty = qty;
        this.cost = cost;
    }

    /**
     * @return the bachID
     */
    public String getBachID() {
        return bachID;
    }

    /**
     * @param bachID the bachID to set
     */
    public void setBachID(String bachID) {
        this.bachID = bachID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
    
    
}




