/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;


import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vihanga
 */
public class UserController {

    public static int addUser(User user) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into User(username,password,type) values(?,?,?)");
        statement.setObject(1, user.getUsername());
        statement.setObject(2, user.getPassword());
        statement.setObject(3, user.getType());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    /*
     public static int deleteUser(int userId) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from user where id=?");
     statement.setObject(1, userId);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from User");
        ArrayList<User> users = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            users.add(new User(Integer.parseInt(executeQuery.getString(1)), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4)));
        }
        return users;
    }

    public static String getPassword(String userName) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select password from User where username=?");
        statement.setObject(1, userName);
        String pw = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            pw = executeQuery.getString(1);
        }
        return pw;
    }

    public static boolean updateUser(User user) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update User set username = ?, password = ?, type = ? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, user.getUsername());
        prepareStatement.setObject(2, user.getPassword());
        prepareStatement.setObject(3, user.getType());
        prepareStatement.setObject(4, user.getUid());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    public static User searchUserByUserName(String nic) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from User where username=?");
        statement.setObject(1, nic);
        User user = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            user = new User(Integer.parseInt(executeQuery.getString(1)), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return user;
    }
    
    // edit by Sasanga
    public static User searchUserByUserid(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from User where id=?");
        statement.setObject(1, id);
        User user = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            user = new User(Integer.parseInt(executeQuery.getString(1)), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return user;
    }

    public static int getUserCount() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select Count(username) as count from User");
        ResultSet executeQuery = statement.executeQuery();
        int count = 0;
        if (executeQuery.next()) {
            count = executeQuery.getInt(1);
        }
        return count;
    }

}
