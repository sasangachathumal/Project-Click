/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.CustomerReturn;
import biz.project.cms.model.MyReturns;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Theekshana Buddika
 */
public class MyReturnController {

    public static int addMyReturn(MyReturns myReturns) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Mreturn(id,bid,qty,date) values(?,?,?,?)");
        statement.setObject(1, myReturns.getId());
        statement.setObject(2, myReturns.getBatchId());
        statement.setObject(3, myReturns.getQty());
        statement.setObject(4, myReturns.getDate());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int updateMyReturn(MyReturns myReturns) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("UPDATE Mreturn SET bid=?,qty=?,date=? WHERE id=?");
        statement.setObject(1, myReturns.getBatchId());
        statement.setObject(2, myReturns.getQty());
        statement.setObject(3, myReturns.getDate());
        statement.setObject(4, myReturns.getId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteMyReturn(MyReturns myReturns) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("DELETE FROM Mreturn WHERE id=?");
        statement.setObject(1, myReturns.getId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static CustomerReturn searchCustomerReturn(CustomerReturn customerReturn) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Mreturn where id=?");
        statement.setObject(1, customerReturn.getRetId());
        CustomerReturn customerReturn1 = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerReturn1 = new CustomerReturn(executeQuery.getString(1), executeQuery.getInt(2),
                    executeQuery.getInt(3), executeQuery.getString(4));
        }
        return customerReturn1;
    }

    public static ArrayList<MyReturns> getAllMyReturns() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Mreturn");
        ArrayList<MyReturns> myReturns = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            myReturns.add(new MyReturns(executeQuery.getString(1), executeQuery.getInt(2),
                    executeQuery.getInt(3), executeQuery.getString(4)));
        }
        return myReturns;
    }

}
