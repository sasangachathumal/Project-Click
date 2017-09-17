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
public class MyCheque {
    
    private String chqNo;
    private String chqDate;
    private String bank;
    private String payId;

    public MyCheque() {
    }

    public MyCheque(String chqNo, String chqDate, String bank, String payId) {
        this.chqNo = chqNo;
        this.chqDate = chqDate;
        this.bank = bank;
        this.payId = payId;
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
     * @return the chqDate
     */
    public String getChqDate() {
        return chqDate;
    }

    /**
     * @param chqDate the chqDate to set
     */
    public void setChqDate(String chqDate) {
        this.chqDate = chqDate;
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
     * @return the payId
     */
    public String getPayId() {
        return payId;
    }

    /**
     * @param payId the payId to set
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }
    
}
