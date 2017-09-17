/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.model;

/**
 *
 * @author Dilhan
 */
public class UserLoger {
    private int userlogetId;
    private String userName;
    private String logindate;
    private String logintime;
    private String logoutdate;
    private String logouttime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserLoger() {
    }

    public UserLoger(int userlogetId, String userName, String logindate, String logintime, String logoutdate, String logouttime) {
        this.userlogetId = userlogetId;
        this.userName = userName;
        this.logindate = logindate;
        this.logintime = logintime;
        this.logoutdate = logoutdate;
        this.logouttime = logouttime;
    }
    
    

    /**
     * @return the userlogetId
     */
    public int getUserlogetId() {
        return userlogetId;
    }

    /**
     * @param userlogetId the userlogetId to set
     */
    public void setUserlogetId(int userlogetId) {
        this.userlogetId = userlogetId;
    }

    /**
     * @return the logindate
     */
    public String getLogindate() {
        return logindate;
    }

    /**
     * @param logindate the logindate to set
     */
    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    /**
     * @return the logintime
     */
    public String getLogintime() {
        return logintime;
    }

    /**
     * @param logintime the logintime to set
     */
    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    /**
     * @return the logoutdate
     */
    public String getLogoutdate() {
        return logoutdate;
    }

    /**
     * @param logoutdate the logoutdate to set
     */
    public void setLogoutdate(String logoutdate) {
        this.logoutdate = logoutdate;
    }

    /**
     * @return the logouttime
     */
    public String getLogouttime() {
        return logouttime;
    }

    /**
     * @param logouttime the logouttime to set
     */
    public void setLogouttime(String logouttime) {
        this.logouttime = logouttime;
    }
    
}
