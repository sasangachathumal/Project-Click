/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.CustomerPayment;
import biz.project.cms.model.MyPayment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amila(Polta)
 */
public class MyPaymentController {

    public static int addMyPayment(MyPayment myPayment) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Mpayment values(?,?,?,?)");
        statement.setObject(1, myPayment.getPaymentId());
        statement.setObject(2, myPayment.getDate());
        statement.setObject(3, myPayment.getAmount());
        statement.setObject(4, myPayment.getGrnId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteMyPayment(String myPayid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Mpayment where id=?");
        statement.setObject(1, myPayid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<MyPayment> getAllMyPayment() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Mpayment");
        ArrayList<MyPayment> mypayments = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            mypayments.add(new MyPayment(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getDouble(3), executeQuery.getString(4)));
        }
        return mypayments;
    }

    //BY ID
    public static MyPayment searchMyPaymentByID(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Mpayment where id=?");
        statement.setObject(1, id);
        MyPayment myPayment = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            myPayment = new MyPayment(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getDouble(3), executeQuery.getString(4));
        }
        return myPayment;
    }

    public static ArrayList<MyPayment> searchMyPaymentByGRNId(String grnid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Mpayment where grnid=?");
        statement.setObject(1, grnid);
        ArrayList<MyPayment> myPayments = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            myPayments.add(new MyPayment(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getDouble(3), executeQuery.getString(4)));
        }
        return myPayments;
    }

    public static boolean updateCustomer(CustomerPayment cuspayment) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        int res = 0;
        try {
            String query = "update Mpayment set date = ?, amount = ?, oid = ?  where id = ?";
            connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, cuspayment.getId());
            prepareStatement.setObject(2, cuspayment.getDate());
            prepareStatement.setObject(3, cuspayment.getAmount());
            prepareStatement.setObject(4, cuspayment.getOrderId());
            res += prepareStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return res > 0;
    }
}
