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
public class JobCategory {
    
    private int catID;
    private String title;

    public JobCategory() {
    }

    public JobCategory(int catID, String title) {
        this.catID = catID;
        this.title = title;
    }

    /**
     * @return the catID
     */
    public int getCatID() {
        return catID;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(int catID) {
        this.catID = catID;
    }

    /**
     * @return the name
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param name the name to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
