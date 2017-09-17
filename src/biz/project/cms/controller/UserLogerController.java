/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.UserLoger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dilhan
 */
public class UserLogerController {

    public static int addLogerDetail(UserLoger loger) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into userloger(username,logindate,logintime) values(?,CurDate(),CurTime())");
        statement.setObject(1, loger.getUserName());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int updateLogerDetail(UserLoger loger) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("update userloger set logoutdate=CurDate(), logouttime=CurTime() where userlogerId=?");
        statement.setObject(1, loger.getUserlogetId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<UserLoger> getAllUserlogets(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from userloger where username=? order by userlogerId desc");
        statement.setObject(1, name);
        ArrayList<UserLoger> userlogers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            userlogers.add(new UserLoger(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getString(4), executeQuery.getString(6), executeQuery.getString(5)));
        }
        return userlogers;
    }

    public static ArrayList<UserLoger> getAllUserlog() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from userloger order by userlogerId desc");
        ArrayList<UserLoger> userlogers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            userlogers.add(new UserLoger(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getString(4), executeQuery.getString(6), executeQuery.getString(5)));
        }
        return userlogers;
    }

    public static int getLoggerID() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select userlogerId from userloger order by userlogerId desc limit 1");
        int i = 0;
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            i = executeQuery.getInt(1);
        }
        return i;
    }

    public static UserLoger getLastEntry() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from userloger order by userlogerId desc limit 1");
        UserLoger userlogers = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            userlogers = new UserLoger(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getString(4), executeQuery.getString(6), executeQuery.getString(5));
        }
        return userlogers;
    }
    
    public static int deleteAllItem() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from userloger");
        return statement.executeUpdate();
    }
}
