/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vihanga
 */
public class CalcTotController {

    public static double getTotalSales(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select sum(amount) as total from orders where  date like ?");
        statement.setObject(1, date);
        
        double tot = 0.0;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            tot = executeQuery.getDouble(1);
            if (Double.toString(tot) == null) {
                tot = 0.0;
            }
        }
        
        return tot;
    }
    
    public static double getTotalServices(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement1 = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select sum(totamount) as total from job where  date like ?");
        statement1.setObject(1, date);
        double tot1 = 0.0;
        ResultSet executeQuery1 = statement1.executeQuery();
        if (executeQuery1.next()) {
            tot1 = executeQuery1.getDouble(1);
            if (Double.toString(tot1) == null) {
                tot1 = 0.0;
            }
        }
        return tot1;
    }
    
    public static int getTotalServiceCount(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement1 = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select count(id) as count1 from job where  date like ?");
        statement1.setObject(1, date);
        int tot1 = 0;
        ResultSet executeQuery1 = statement1.executeQuery();
        if (executeQuery1.next()) {
            tot1 = executeQuery1.getInt(1);
            if (Double.toString(tot1) == null) {
                tot1 = 0;
            }
        }
        return tot1;
    }
    
    public static int getTotalSaleCount(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement1 = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select count(id) as count1 from Orders where date like ?");
        statement1.setObject(1, date);
        int tot1 = 0;
        ResultSet executeQuery1 = statement1.executeQuery();
        if (executeQuery1.next()) {
            tot1 = executeQuery1.getInt(1);
            if (Double.toString(tot1) == null) {
                tot1 = 0;
            }
        }
        return tot1;
    }
}
