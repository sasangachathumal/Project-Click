/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.AllOrders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amila(Polta)
 */
public class ViewOrderControoller {
    
    public static ArrayList<AllOrders> getAllOrders() throws ClassNotFoundException, SQLException{
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from AllOrders");
        ArrayList<AllOrders> allOrders = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {            
            allOrders.add(new AllOrders(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getString(4), executeQuery.getString(5), executeQuery.getInt(6), executeQuery.getDouble(7)));
        }
        return allOrders;
    }

    public static ArrayList<AllOrders> getAllOrdersByUser(String userName) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from AllOrders where username = ?");
        statement.setObject(1, userName);
        ArrayList<AllOrders> allOrders = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {            
            allOrders.add(new AllOrders(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4), executeQuery.getString(5), executeQuery.getInt(6), executeQuery.getDouble(7)));
        }
        return allOrders;
    }

    public static ArrayList<AllOrders> getAllOrdersByDate(Date date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from AllOrders where date = ?");
        statement.setObject(1, date);
        ArrayList<AllOrders> allOrders = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {            
            allOrders.add(new AllOrders(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4), executeQuery.getString(5), executeQuery.getInt(6), executeQuery.getDouble(7)));
        }
        return allOrders;
    }

    public static ArrayList<AllOrders> getAllOrdersByDate(String userName, Date date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from AllOrders where date = ? && username = ?");
        statement.setObject(1, date);
        statement.setObject(2, userName);
        ArrayList<AllOrders> allOrders = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {            
            allOrders.add(new AllOrders(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4), executeQuery.getString(5), executeQuery.getInt(6), executeQuery.getDouble(7)));
        }
        return allOrders;
    }
}
