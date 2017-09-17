/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.JobCategory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Theekshana Buddika
 */
public class JobCategoryController {

    public static int addJobCategory(JobCategory jobCategory) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("INSERT INTO JobCategory(id,title) VALUES(?,?)");
        statement.setObject(1, jobCategory.getCatID());
        statement.setObject(2, jobCategory.getTitle());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int updateJobCategory(JobCategory jobCategory) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("UPDATE JobCategory SET title=? WHERE id=?");
        statement.setObject(2, jobCategory.getCatID());
        statement.setObject(1, jobCategory.getTitle());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    /*
     public static int delete_JobCategory(JobCategory jobCategory) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("DELETE FROM jobCategory WHERE id=?");
     statement.setObject(1, jobCategory.getCatID());
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static JobCategory searchJobCategory(String title) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM jobCategory WHERE title=?");
        statement.setObject(1, title);
        ResultSet resultSet = statement.executeQuery();
        JobCategory jobCategory = null;
        if (resultSet.next()) {
            jobCategory = new JobCategory();
            jobCategory.setCatID(resultSet.getInt(1));
            jobCategory.setTitle(resultSet.getString(2));
        }
        return jobCategory;
    }
 public static JobCategory searchJobCategorybyID(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM jobCategory WHERE id=?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        JobCategory jobCategory = null;
        if (resultSet.next()) {
            jobCategory = new JobCategory();
            jobCategory.setCatID(resultSet.getInt(1));
            jobCategory.setTitle(resultSet.getString(2));
        }
        return jobCategory;
    }
    public static ArrayList<JobCategory> getAllJobCategorys() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from jobCategory");
        ArrayList<JobCategory> jobCategorys = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            jobCategorys.add(new JobCategory(executeQuery.getInt(1), executeQuery.getString(2)));
        }
        return jobCategorys;
    }

}
