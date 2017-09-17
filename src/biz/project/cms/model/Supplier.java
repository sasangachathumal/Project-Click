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
public class Supplier {
    private int supId;
    private String company;
    private String name;
    private int mobile;
    private int office;
    private int fax;
    private String email;
    private double duePayment;

    public Supplier() {
    }

    public Supplier(int supId, String company, String name, int mobile, int office, int fax, String email) {
        this.supId = supId;
        this.company = company;
        this.name = name;
        this.mobile = mobile;
        this.office = office;
        this.fax = fax;
        this.email = email;
    }

    public Supplier(int supId, String company, String name, int mobile, int office, int fax, String email, double duePayment) {
        this.supId = supId;
        this.company = company;
        this.name = name;
        this.mobile = mobile;
        this.office = office;
        this.fax = fax;
        this.email = email;
        this.duePayment = duePayment;
    }
    
    

    /**
     * @return the supId
     */
    public int getSupId() {
        return supId;
    }

    /**
     * @param supId the supId to set
     */
    public void setSupId(int supId) {
        this.supId = supId;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mobile
     */
    public int getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the office
     */
    public int getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(int office) {
        this.office = office;
    }

    /**
     * @return the fax
     */
    public int getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(int fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the duePayment
     */
    public double getDuePayment() {
        return duePayment;
    }

    /**
     * @param duePayment the duePayment to set
     */
    public void setDuePayment(double duePayment) {
        this.duePayment = duePayment;
    }
    
}
