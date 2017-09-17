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
public class JobPayment {
    private String jobPayID;
    private String date;
    private double amount;
    private String jobId;

    public JobPayment() {
    }

    public JobPayment(String jobPayID, String date, double amount, String jobId) {
        this.jobPayID = jobPayID;
        this.date = date;
        this.amount = amount;
        this.jobId = jobId;
    }

    /**
     * @return the jobPayID
     */
    public String getJobPayID() {
        return jobPayID;
    }

    /**
     * @param jobPayID the jobPayID to set
     */
    public void setJobPayID(String jobPayID) {
        this.jobPayID = jobPayID;
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
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    
    
}
