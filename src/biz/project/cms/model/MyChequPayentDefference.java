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
public class MyChequPayentDefference {
    private String chqNo;
    private String bank;
    private String cusPyID;
    private double amount;

    public MyChequPayentDefference() {
    }

    public MyChequPayentDefference(String chqNo, String bank, String cusPyID, double amount) {
        this.chqNo = chqNo;
        this.bank = bank;
        this.cusPyID = cusPyID;
        this.amount = amount;
    }

    /**
     * @return the chqNo
     */
    public String getChqNo() {
        return chqNo;
    }

    /**
     * @param chqNo the chqNo to set
     */
    public void setChqNo(String chqNo) {
        this.chqNo = chqNo;
    }

    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * @return the cusPyID
     */
    public String getCusPyID() {
        return cusPyID;
    }

    /**
     * @param cusPyID the cusPyID to set
     */
    public void setCusPyID(String cusPyID) {
        this.cusPyID = cusPyID;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
