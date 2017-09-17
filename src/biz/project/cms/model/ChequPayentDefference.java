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
public class ChequPayentDefference {
    private String chqNo;
    private String bank;
    private double amount;
    private String cusPyID;
    private String oid;

    public ChequPayentDefference() {
    }

    public ChequPayentDefference(String chqNo, String bank, double amount, String cusPyID, String oid) {
        this.chqNo = chqNo;
        this.bank = bank;
        this.amount = amount;
        this.cusPyID = cusPyID;
        this.oid = oid;
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

   

}