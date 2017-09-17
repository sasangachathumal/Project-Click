/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.JobSerial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arty
 */
public class JobSerialController {

    public static int addJobSerial(JobSerial serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection()
                .getConnection().prepareStatement("insert into JobSerial(id,serial,jid) values(?,?,?)");
        statement.setObject(1, serial.getId());
        statement.setObject(2, serial.getSerialNo());
        statement.setObject(3, serial.getJobId());
        return statement.executeUpdate();
    }

    /*
     public static int deleteCategory(int Catid) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from category where id=?");
     statement.setObject(1, Catid);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static ArrayList<JobSerial> getAllJobSerials() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from JobSerial");
        ArrayList<JobSerial> serials = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            serials.add(new JobSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3)));
        }
        return serials;
    }

    public static ArrayList<JobSerial> getAllJobSerialsByJobId(String jobId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from JobSerial where jid=?");
        statement.setObject(1, jobId);
        ArrayList<JobSerial> serials = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            serials.add(new JobSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3)));
        }
        return serials;
    }
    
    
    public static JobSerial searchSerialById(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from JobSerial where id=?");
        statement.setObject(1, id);
        JobSerial serial = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            serial = new JobSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3));
        }
        return serial;
    }

    public static boolean updateJobSerials(JobSerial serial) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update JobSerial set serial = ? where jid = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, serial.getSerialNo());
        prepareStatement.setObject(1, serial.getJobId());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    public static boolean deleteJobSerials(int jsId) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "delete from jobSerial where id=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, jsId);
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    
}
 