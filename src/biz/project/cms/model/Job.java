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
public class Job {

    private String jobId;
    private String description;
    private String time;
    private String date;
    private String status;
    private double totalAmount;
    private int custId;
    private int jobCatId;
    private String categoryName;

    public Job() {
    }

    public Job(String jobId, String description, String time, String date, String status, double totalAmount, int custId, int jobCatId) {
        this.jobId = jobId;
        this.description = description;
        this.time = time;
        this.date = date;
        this.status = status;
        this.totalAmount = totalAmount;
        this.custId = custId;
        this.jobCatId = jobCatId;
    }

    public Job(String jobId, String description, String time, String date, String status, double totalAmount, int custId, int jobCatId, String categoryName) {
        this.jobId = jobId;
        this.description = description;
        this.time = time;
        this.date = date;
        this.status = status;
        this.totalAmount = totalAmount;
        this.custId = custId;
        this.jobCatId = jobCatId;
        this.categoryName = categoryName;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the custId
     */
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * @return the jobCatId
     */
    public int getJobCatId() {
        return jobCatId;
    }

    /**
     * @param jobCatId the jobCatId to set
     */
    public void setJobCatId(int jobCatId) {
        this.jobCatId = jobCatId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    

    

}
