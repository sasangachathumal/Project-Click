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
public class CustomerCheque {
    private String chqNo;
    private String chqDate;
    private String bank;
    private String custPayId;

    public CustomerCheque() {
    }

    public CustomerCheque(String chqNo, String chqDate, String bank, String custPayId) {
        this.chqNo = chqNo;
        this.chqDate = chqDate;
        this.bank = bank;
        this.custPayId = custPayId;
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
     * @return the custPayId
     */
    public String getCustPayId() {
        return custPayId;
    }

    /**
     * @param custPayId the custPayId to set
     */
    public void setCustPayId(String custPayId) {
        this.custPayId = custPayId;
    }

}  