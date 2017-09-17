/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Accounts;
import biz.project.cms.model.JobCheque;
import biz.project.cms.model.JobPayment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * J payment
 *
 * @author Arty
 */
public class JobPaymentController {

    private Connection connection = null;

    public static int addJobPayment(JobPayment jobPayment) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Jpayment(id,date,amount,jid) values(?,?,?,?)");
        statement.setObject(1, jobPayment.getJobPayID());
        statement.setObject(2, jobPayment.getDate());
        statement.setObject(3, jobPayment.getAmount());
        statement.setObject(4, jobPayment.getJobId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteJobPayment(int jobPayid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Jpayment where id=?");
        statement.setObject(1, jobPayid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<JobPayment> getAllJobPayments() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Jpayment");
        ArrayList<JobPayment> jobPayment = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobPayment.add(new JobPayment(executeQuery.getString(1), executeQuery.getString(2),
                    Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4)));
        }
        return jobPayment;
    }

    public static JobPayment searchJobPaymentByID(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Jpayment where id=?");
        statement.setObject(1, id);
        JobPayment jobPayment = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            jobPayment = new JobPayment(executeQuery.getString(1), executeQuery.getString(2),
                    Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4));
        }
        return jobPayment;
    }

    public static boolean updatePayment(JobPayment jobPayment) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Jpayment set date = ?, amount = ?, jid = ?  where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, jobPayment.getDate());
        prepareStatement.setObject(2, jobPayment.getAmount());
        prepareStatement.setObject(3, jobPayment.getJobId());
        prepareStatement.setObject(4, jobPayment.getJobPayID());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    public static ArrayList<JobPayment> getAllJobPaymentByJobID(String text) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Jpayment where jid=?");
        ArrayList<JobPayment> jobPayment = new ArrayList<>();
        statement.setObject(1, text);
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobPayment.add(new JobPayment(executeQuery.getString(1), executeQuery.getString(2),
                    Double.parseDouble(executeQuery.getString(3)), executeQuery.getString(4)));
        }
        return jobPayment;
    }

    public boolean createNewJobPaymentWithTransaction(JobPayment jobPayment, Accounts as, JobCheque jc) throws ClassNotFoundException {
        boolean sendResult = false;
        try {
            if (connection == null) {
                connection = DBConnection.getDBConnection().getConnection();
            }
            connection.setAutoCommit(false);
            if (jobPayment != null) {
                int addJobPayment = addJobPayment(jobPayment);
                if (addJobPayment > 0) {
                    sendResult = true;
                } else {
                    sendResult = false;
                }
            }
            if (as != null) {
                if (jc == null) {
                    int addAccount = AccountsController.addAccount(as);
                    if (addAccount > 0) {
                        sendResult = true;
                    } else {
                        sendResult = false;
                    }
                } else {
                    int addAccount = AccountsController.addAccountChq(as);
                    if (addAccount > 0) {
                        sendResult = true;
                    } else {
                        sendResult = false;
                    }
                }
            }

            if (jc != null) {
                int addCheque = JobChequeController.addJobCheque(jc);
                if (addCheque > 0) {
                    sendResult = true;
                } else {
                    sendResult = false;
                }
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                System.out.println(ex);
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JobController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(JobController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sendResult;
    }
}
