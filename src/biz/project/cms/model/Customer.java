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
public class Customer {
    private int cusid;
    private String name;
    private int contact;
    private String nic;
    private double debit;

    public Customer() {
    }

    public Customer(int cid, String name, int contact, String nic) {
        this.cusid = cid;
        this.name = name;
        this.contact = contact;
        this.nic = nic;
    }

    public Customer(int cusid, String name, int contact, String nic, double debit) {
        this.cusid = cusid;
        this.name = name;
        this.contact = contact;
        this.nic = nic;
        this.debit = debit;
    }
    
    

    /**
     * @return the sid
     */
    public int getCid() {
        return cusid;
    }

    /**
     * @param sid the sid to set
     */
    public void setCid(int sid) {
        this.cusid = sid;
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
     * @return the contact
     */
    public int getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the Debit
     */
    public double getDebit() {
        return debit;
    }

    /**
     * @param debit
     */
    public void setDebit(double debit) {
        this.debit = debit;
    }
    
}
