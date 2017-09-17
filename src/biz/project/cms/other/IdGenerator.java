/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.other;

import biz.project.cms.controller.dbConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Dilhan
 */
public class IdGenerator {

    /*
     * param i - For get a methode calling Gui
     * i = 1 (New Customer Order Id)
     * i = 2 (New Job Id)
     * i = 3 (new Job payment Id
     * i = 4 (New customer payment id)
     */
    public static String getNewId(int i) throws SQLException, ClassNotFoundException {
        String charCode = null;
        String sql = null;
        String code = null;
        System.out.println(i);
        switch (i) {
            case 1:
                System.out.println("asds");
                charCode = "CO";
                sql = "select id from Orders order by id desc limit 1";
                break;
            case 2:
                charCode = "JB";
                sql = "select id from Job order by id desc limit 1";
                break;
            case 3:
                charCode = "JP";
                sql = "select id from Jpayment order by id desc limit 1";
                break;
            case 4:
                charCode = "CP";
                sql = "select id from Cpayment order by id desc limit 1";
                break;
            case 5:
                charCode = "CP";
                sql = "select id from Mpayment order by id desc limit 1";
                break;
            default:
                break;
        }

        PreparedStatement preparedStatement = DBConnection.getDBConnection().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yy");
        String year = dateFormat.format(Calendar.getInstance().getTime());
        dateFormat = new SimpleDateFormat("MM");
        String month = dateFormat.format(Calendar.getInstance().getTime());
        dateFormat = new SimpleDateFormat("dd");
        String date = dateFormat.format(Calendar.getInstance().getTime());

        code = charCode + year + month + date;
        if (resultSet.next()) {
            String lastCode = resultSet.getString(1);
            String prefLastCode = lastCode.substring(0, 8);
            if (prefLastCode.equals(code)) {
                String newCode = lastCode.substring(8, 12);
                int x = Integer.parseInt(newCode);

                x++;
                DecimalFormat df = new DecimalFormat("0000");
                String n = df.format(x);
                return code + n;
            } else {
                return code + "0001";
            }
        } else {
            return code + "0001";
        }
    }

    public static String getNewItemId() throws SQLException, ClassNotFoundException {
        String sql = "select code from Item order by code desc limit 1";
        PreparedStatement preparedStatement = DBConnection.getDBConnection().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String s = resultSet.getString(1);
            int i = Integer.parseInt(s.substring(2, 10));
            i = i + 1;
            DecimalFormat df = new DecimalFormat("00000000");
            String n = df.format(i);
            return "IT" + n;
        } else {
            return "IT00000001";
        }
    }

    public static String getNewMyReturmID() throws SQLException, ClassNotFoundException {
        String sql = "select id from Mreturn order by id desc limit 1";
        PreparedStatement preparedStatement = DBConnection.getDBConnection().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String s = resultSet.getString(1);
            int i = Integer.parseInt(s.substring(2, 8));
            i = i + 1;
            DecimalFormat df = new DecimalFormat("000000");
            String n = df.format(i);
            return "MR" + n;
        } else {
            return "MR000001";
        }
    }

    public static String getNewCutReturmID() throws SQLException, ClassNotFoundException {
        String sql = "select id from creturn order by id desc limit 1";
        PreparedStatement preparedStatement = DBConnection.getDBConnection().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String s = resultSet.getString(1);
            int i = Integer.parseInt(s.substring(2, 8));
            i = i + 1;
            DecimalFormat df = new DecimalFormat("000000");
            String n = df.format(i);
            return "CR" + n;
        } else {
            return "CR000001";
        }
    }

    public static String getNewGRNID() throws SQLException, ClassNotFoundException {
        String sql = "select id from GRN order by id desc limit 1";
        PreparedStatement preparedStatement = DBConnection.getDBConnection().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String s = resultSet.getString(1);
            int i = Integer.parseInt(s.substring(2, 8));
            i = i + 1;
            DecimalFormat df = new DecimalFormat("000000");
            String n = df.format(i);
            return "GR" + n;
        } else {
            return "GR000001";
        }
    }
}
