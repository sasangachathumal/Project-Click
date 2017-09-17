/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.ChequPayentDefference;
import biz.project.cms.model.JobCheque;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arty
 */
public class JobChequeController {

    public static int addJobCheque(JobCheque cheque) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Jcheque(chqno ,chqdate ,bank ,jpid) values(?,?,?,?)");
        statement.setObject(1, cheque.getChqNo());
        statement.setObject(2, cheque.getChqDate());
        statement.setObject(3, cheque.getBank());
        statement.setObject(4, cheque.getJobPayID());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    /**
     *
     * @param option 
     * 0 - order by chqno 
     * 1 - order by bank 
     * 2 - order by chqdate
     * @return Array list
     */
    public static ArrayList<JobCheque> getAllJobChqs(int option) throws ClassNotFoundException, SQLException {
        String sql = null;
        if (option == 0) {
            sql = "select * from Jcheque order by chqno";
        } else if (option == 1) {
            sql = "select * from Jcheque order by bank";
        } else if (option == 2) {
            sql = "select * from Jcheque order by chqdate";
        }
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement(sql);
        ArrayList<JobCheque> jobCheques = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobCheques.add(new JobCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4)));
        }
        return jobCheques;
    }

    /**
     *
     * @param option 0 - order by chqno desc 1 - order by bank desc 2 - order by
     * chqdate desc
     * @return Array list
     */
    public static ArrayList<JobCheque> getAllJobChqsDecending(int option) throws ClassNotFoundException, SQLException {
        String sql = null;
        if (option == 0) {
            sql = "select * from Jcheque order by chqno desc";
        } else if (option == 1) {
            sql = "select * from Jcheque order by bank desc";
        } else if (option == 2) {
            sql = "select * from Jcheque order by chqdate desc";
        }
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement(sql);
        ArrayList<JobCheque> jobCheques = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobCheques.add(new JobCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4)));
        }
        return jobCheques;
    }

    public static ArrayList<JobCheque> getChqByDate(String date, int option) throws ClassNotFoundException, SQLException {
        String sql = null;
        if (option == 0) {
            sql = "select * from Jcheque where chqdate = ? order by chqno";
        } else if (option == 1) {
            sql = "select * from Jcheque where chqdate = ? order by bank";
        }
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, date);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<JobCheque> chques = new ArrayList<>();
        while (rst.next()) {
            chques.add(new JobCheque(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return chques;
    }

    public static JobCheque searchJobCheqByNumber(String chqno) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Jcheque where chqno=?");
        statement.setObject(1, chqno);
        JobCheque jobCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            jobCheque = new JobCheque(executeQuery.getString(1),
                    executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return jobCheque;
    }

    public static JobCheque searchJobCheqByPaymentId(String custPayId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Jcheque where jpid=?");
        statement.setObject(1, custPayId);
        JobCheque jobCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            jobCheque = new JobCheque(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4));
        }
        return jobCheque;
    }

    public static String getPaymentID(String chqNo) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select jpid from Jcheque where chqno=?");
        statement.setObject(1, chqNo);
        String pid = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            pid = executeQuery.getString(1);
        }
        return pid;
    }

    public static boolean updateCustomerCheque(JobCheque jobCheque) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Jcheque set chqdate = ? , bank = ?, jpid  = ? where chqno = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, jobCheque.getChqDate());
        prepareStatement.setObject(2, jobCheque.getBank());
        prepareStatement.setObject(3, jobCheque.getJobPayID());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
/*
    public static ArrayList<ChequPayentDefference> getDateDeffirence(Date from, Date to) {

        ArrayList<ChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, cpid, amount FROM Ccheque ch JOIN cpayment cp ON ch.cpid=cp.id WHERE `chqdate`>='" + from + "' AND `chqdate`<='" + to + "';");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new ChequPayentDefference(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4))));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JobChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // list.trimToSize();
        return list;

    }*/

    public static ArrayList<ChequPayentDefference> getDateDeffirence(Date from, Date to) {
       ArrayList<ChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, amount, id, jid FROM jcheque jch JOIN jpayment jp ON jch.jpid=jp.id WHERE `chqdate`>='" + from + "' AND `chqdate`<='" + to + "';");

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
        public static ArrayList<ChequPayentDefference> getAllJobData() {
       ArrayList<ChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, amount, id, jid FROM jcheque jch JOIN jpayment jp ON jch.jpid=jp.id ");

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
