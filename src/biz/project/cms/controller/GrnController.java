/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.GRN;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arty
 */
public class GrnController {

    public static int addGRN(GRN grn) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Grn(id ,date ,sid,amount) values(?,?,?,?)");
        statement.setObject(1, grn.getGrnId());
        statement.setObject(2, grn.getDate());
        statement.setObject(3, grn.getSupId());
        statement.setObject(4, grn.getAmount());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteGRN(int gid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Grn where id=?");
        statement.setObject(1, gid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<GRN> getAllGRN() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Grn order by id desc");
        ArrayList<GRN> grn = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            grn.add(new GRN(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return grn;
    }

    public static ArrayList<GRN> getAllGRNBySID(String sid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Grn where sid=? order by id desc");
        statement.setObject(1, sid);
        ArrayList<GRN> grn = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            grn.add(new GRN(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return grn;
    }

    public static ArrayList<GRN> getAllGRNBySID(String sid, String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Grn where sid=? && date like ? order by id desc");
        statement.setObject(1, sid);
        statement.setObject(2, date);
        ArrayList<GRN> grn = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            grn.add(new GRN(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return grn;
    }

//    By NO
    public static GRN searchGRNById(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Grn where id=?");
        statement.setObject(1, id);
        GRN grn = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            grn = new GRN(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4));
        }
        return grn;
    }

    public static Date getGrnDateByBatch(String batch) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select date from Grndetail gd, Grn g where gd.bid=? && g.id=gd.grnid");
        statement.setObject(1, batch);
        Date date = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            date = executeQuery.getDate(1);
        }
        return date;
    }

//    By SupID
    public static GRN searchGRNBySupID(String supId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Grn where sid=?");
        statement.setObject(1, supId);
        GRN grn = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            grn = new GRN(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4));
        }
        return grn;
    }
    
    public static String getDiscount(String grnid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("CALL GetDiscount(?) ");
        statement.setObject(1, grnid);
        String dis = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            dis = executeQuery.getString(1);
        }
        return dis;
    }

//    public static boolean updateGRN(GRN grn) throws ClassNotFoundException, SQLException {
//        int res = 0;
//        String query = "update Grn set date = ?, sid  = ?,amount=?  where id = ?";
//        Connection connection = DBConnection.getDBConnection().getConnection();
//        PreparedStatement prepareStatement = connection.prepareStatement(query);
//        prepareStatement.setObject(1, grn.getDate());
//        prepareStatement.setObject(2, grn.getSupId());
//        res += prepareStatement.executeUpdate();
//        return res > 0;
//    }
    
    public static boolean updateGRNAmount(GRN grn) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Grn set amount=?  where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, grn.getAmount());
        prepareStatement.setObject(2, grn.getGrnId());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
}
