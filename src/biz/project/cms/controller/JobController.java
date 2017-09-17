/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Job;
import biz.project.cms.model.JobCheque;
import biz.project.cms.model.JobPayment;
import biz.project.cms.model.JobSerial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amila(Polta)
 */
public class JobController {

    private Connection connection = null;

    public static int addJob(Job job) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Job values(?,?,?,?,?,?,?,?)");
        statement.setObject(1, job.getJobId());
        statement.setObject(2, job.getDescription());
        statement.setObject(3, job.getTime());
        statement.setObject(4, job.getDate());
        statement.setObject(5, job.getStatus());
        statement.setObject(6, job.getTotalAmount());
        statement.setObject(7, job.getCustId());
        statement.setObject(8, job.getJobCatId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    /*
     public static int deleteJob(String jobId) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection()
     .prepareStatement("delete from Job where id=?");
     statement.setObject(1, jobId);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */
    public static ArrayList<Job> getAllJobs() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job");
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6),
                    executeQuery.getInt(7), executeQuery.getInt(8)));
        }
        return jobs;
    }

    public static Job searchJobById(String jobId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Job where id=?");
        statement.setObject(1, jobId);
        Job job = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            job = new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6),
                    executeQuery.getInt(7), executeQuery.getInt(8));
        }
        return job;
    }

    public static boolean updateJob(Job job) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("update Job set description = ?, status = ?, totAmount = ?, jcid = ?  "
                        + "where id = ?");
        statement.setObject(1, job.getDescription());
        statement.setObject(2, job.getStatus());
        statement.setObject(3, job.getTotalAmount());
        statement.setObject(4, job.getJobCatId());
        statement.setObject(5, job.getJobId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate > 0;
    }

    public static boolean updateJobStatus(String state, String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("update Job set status = ? where id = ?");
        statement.setObject(1, state);
        statement.setObject(2, id);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate > 0;
    }

    public static ArrayList<Job> searchJobByDate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job where date=?");
        statement.setObject(1, date);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6),
                    executeQuery.getInt(7), executeQuery.getInt(8)));
        }
        return jobs;
    }

    public static ArrayList<Job> searchJobByStatus(String status) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job where status=?");
        statement.setObject(1, status);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6),
                    executeQuery.getInt(7), executeQuery.getInt(8)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsWithCategoryName() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, JobCategory jc where jc.id=j.jcid");
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsByCategoryTitle(String title) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc where j.jcid=jc.id && jc.title=?");
        statement.setObject(1, title);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static Job searchJobByIdWithCategory(String jobId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc where j.jcid=jc.id && j.id=?");
        statement.setObject(1, jobId);
        Job job = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            job = new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10));
        }
        return job;
    }

    public static ArrayList<Job> getAllJobsBydate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc where j.jcid=jc.id && j.date=?");
        statement.setObject(1, date);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsByStatus(String status) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc where j.jcid=jc.id && j.status=?");
        statement.setObject(1, status);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsByCustomerNic(String nic) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc, Customer c where j.jcid=jc.id && j.cid = c.id && c.nic=?");
        statement.setObject(1, nic);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsByCustomerContact(int contact) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc, Customer c where j.jcid=jc.id && j.cid = c.id && c.contact=?");
        statement.setObject(1, contact);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public static ArrayList<Job> getAllJobsByItemSerial(String serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Job j, jobCategory jc, JobSerial js where j.id = js.jid && jc.id = j.jcid && js.serial=?");
        statement.setObject(1, serial);
        ArrayList<Job> jobs = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobs.add(new Job(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4),
                    executeQuery.getString(5), executeQuery.getDouble(6), executeQuery.getInt(7),
                    executeQuery.getInt(8), executeQuery.getString(10)));
        }
        return jobs;
    }

    public boolean createNewJobWithTransaction(Job j, JobPayment jobPayment, ArrayList<JobSerial> js, JobCheque jc) throws ClassNotFoundException {
        boolean sendResult = false;
        try {
            if (connection == null) {
                connection = DBConnection.getDBConnection().getConnection();
            }
            connection.setAutoCommit(false);
            if (j != null) {
                int addJob = addJob(j);
                if (addJob > 0) {
                    sendResult = true;
                }
            }
            if (jobPayment != null) {
                int addJobPayment = JobPaymentController.addJobPayment(jobPayment);
                if (addJobPayment > 0) {
                    sendResult = true;
                }
            }
            if (js.size() > 0) {
                int count = 0;
                for (JobSerial j1 : js) {
                    JobSerialController.addJobSerial(j1);
                    count++;
                }
                if (count == js.size()) {
                    sendResult = true;
                } else {
                    sendResult = false;
                }
            }
            if (jc != null) {
                int addJobCheque = JobChequeController.addJobCheque(jc);
                if (addJobCheque > 0) {
                    sendResult = true;
                } else {
                    sendResult = false;
                }
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                Logger.getLogger(JobController.class.getName()).log(Level.SEVERE, null, ex);
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
