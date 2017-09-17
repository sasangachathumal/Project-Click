/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.ChequPayentDefference;
import biz.project.cms.model.CustomerCheque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arty
 */
public class CustomerChequeController {
     public static int addCustomerCheque(CustomerCheque customerCheque) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Ccheque(chqno,chqdate,bank,cpid) values(?,?,?,?)");
        statement.setObject(1, customerCheque.getChqNo());
        statement.setObject(2, customerCheque.getChqDate());
        statement.setObject(3, customerCheque.getBank());
        statement.setObject(4, customerCheque.getCustPayId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteCustomerCheque(int chqno) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Ccheque where chqno=?");
        statement.setObject(1, chqno);
        return statement.executeUpdate();
    }
    
    /**
     * 
     * @param option
     * 0 - order by chqno
     * 1 - order by bank
     * 2 - order by chqdate 
     * @return
     * Array list
     */
    public static ArrayList<CustomerCheque> getAllCustomerChqs(int option) throws ClassNotFoundException, SQLException {
        String sql = null;
        if(option == 0){
            sql = "select * from Ccheque order by chqno";
        }else if(option == 1){
            sql = "select * from Ccheque order by bank";
        }else if(option == 2){
            sql = "select * from Ccheque order by chqdate";
        }
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement(sql);
        ArrayList<CustomerCheque> customerCheque = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerCheque.add(new CustomerCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4)));
        }
        return customerCheque;
    }
    
    /**
     * 
     * @param option
     * 0 - order by chqno desc
     * 1 - order by bank desc
     * 2 - order by chqdate desc
     * @return
     * Array list
     */
    public static ArrayList<CustomerCheque> getAllCustomerChqs_Decending(int option) throws ClassNotFoundException, SQLException {
        String sql = null;
        if(option == 0){
            sql = "select * from Ccheque order by chqno desc";
        }else if(option == 1){
            sql = "select * from Ccheque order by bank desc";
        }else if(option == 2){
            sql = "select * from Ccheque order by chqdate desc";
        }
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement(sql);
        ArrayList<CustomerCheque> customerCheque = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerCheque.add(new CustomerCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4)));
        }
        return customerCheque;
    }
    
    public static ArrayList<CustomerCheque> getChqByDate(String date, int option) throws ClassNotFoundException, SQLException{
        String sql = null;
        if(option == 0){
            sql = "select * from Ccheque where chqdate = ? order by chqno";
        }else if(option == 1){
            sql = "select * from Ccheque where chqdate = ? order by bank";
        }
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, date);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<CustomerCheque> chques = new ArrayList<>();
        while (rst.next()) {            
            chques.add(new CustomerCheque(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return chques;
    }
    
    public static CustomerCheque searchCustCheqByNumber(String chqno) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Ccheque where chqno=?");
        statement.setObject(1, chqno);
        CustomerCheque customerCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerCheque = new CustomerCheque(executeQuery.getString(1), 
                    executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return customerCheque;
    }

    
    public static CustomerCheque searchCustCheqBy_PaymentId(String custPayId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Ccheque where cpid=?");
        statement.setObject(1, custPayId);
        CustomerCheque customerCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerCheque = new CustomerCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return customerCheque;
    }
    
    public static String getPaymentID(String chqNo) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select cpid from Ccheque where chqno=?");
        statement.setObject(1, chqNo);
        String pid = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            pid = executeQuery.getString(1);
        }
        return pid;
    }

    public static boolean updateCustomerCheque(CustomerCheque customerCheque) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Ccheque set chqdate = ? , bank = ?, cpid  = ? where chqno = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, customerCheque.getChqDate());
        prepareStatement.setObject(2, customerCheque.getBank());
        prepareStatement.setObject(3, customerCheque.getCustPayId());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
    
    
    public static ArrayList<ChequPayentDefference> getDateDeffirence(Date from, Date to) {

        ArrayList<ChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, amount, cpid, oid FROM Ccheque ch JOIN cpayment cp ON ch.cpid=cp.id WHERE `chqdate`>='" + from + "' AND `chqdate`<='" + to + "';");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new ChequPayentDefference(resultSet.getString(1), resultSet.getString(2), Double.parseDouble(resultSet.getString(3)), resultSet.getString(4), resultSet.getString(5)));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // list.trimToSize();
        return list;

    }
        public static ArrayList<ChequPayentDefference> getAllCusCheqData() {

        ArrayList<ChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, amount, cpid, oid FROM Ccheque ch JOIN cpayment cp ON ch.cpid=cp.id");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new ChequPayentDefference(resultSet.getString(1), resultSet.getString(2), Double.parseDouble(resultSet.getString(3)), resultSet.getString(4), resultSet.getString(5)));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // list.trimToSize();
        return list;

    }
}
