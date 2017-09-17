/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.CustomerPayment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arty
 */
public class CustomerPaymentController {
    public static int addPayment(CustomerPayment cuspayment) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Cpayment(id,date,amount,oid) values(?,?,?,?)");
        statement.setObject(1, cuspayment.getId());
        statement.setObject(2, cuspayment.getDate());
        statement.setObject(3, cuspayment.getAmount());
        statement.setObject(4, cuspayment.getOrderId());
        return statement.executeUpdate();
    }

    public static int deleteCustomerPayment(int cusPayid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Cpayment where id=?");
        statement.setObject(1, cusPayid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<CustomerPayment> getAllCustomerPayment() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Cpayment");
        ArrayList<CustomerPayment> cuspayment = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            cuspayment.add(new CustomerPayment(executeQuery.getString(1), executeQuery.getDate(2)+"", Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4)));
        }
        return cuspayment;
    }
    
    public static ArrayList<CustomerPayment> getAllCustomerPaymentOfOrder(String oid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Cpayment where oid =?");
        statement.setObject(1, oid);
        ArrayList<CustomerPayment> cuspayment = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            cuspayment.add(new CustomerPayment(executeQuery.getString(1), executeQuery.getDate(2)+"", Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4)));
        }
        return cuspayment;
    }
    
    //BY ID
    public static CustomerPayment searchCusPaymentByID(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Cpayment where id=?");
        statement.setObject(1, id);
        CustomerPayment cuspayment = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            cuspayment = new CustomerPayment(executeQuery.getString(1), executeQuery.getDate(2)+"", Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4));
        }
        return cuspayment;
    }
            

    public static CustomerPayment searchCusPaymentByOID(String oid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Cpayment where oid=?");
        statement.setObject(1, oid);
        CustomerPayment cuspayment = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            cuspayment = new CustomerPayment(executeQuery.getString(1), executeQuery.getDate(2)+"", Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4));
        }
        return cuspayment;
    }

    public static boolean updateCustomer(CustomerPayment cuspayment) throws ClassNotFoundException, SQLException {
        String query = "update Cpayment set date = ?, amount = ?, oid = ?  where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1, cuspayment.getId());
        statement.setObject(2, cuspayment.getDate());
        statement.setObject(3, cuspayment.getAmount());
        statement.setObject(4, cuspayment.getOrderId());
        return statement.executeUpdate() > 0;
    }
}
