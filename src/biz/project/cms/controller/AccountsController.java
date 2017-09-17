/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Accounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amila(Polta)
 */
public class AccountsController {

    public static int addAccount(Accounts accounts) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into Account(uid, date, time, type, description, amount) values(?,CurDate(),CurTime(),?,?,?)");
        statement.setObject(1, accounts.getUid());
//        statement.setObject(2, accounts.getDate());
//        statement.setObject(3, accounts.getTime());
        statement.setObject(2, accounts.getType());
        statement.setObject(3, accounts.getDescription());
        statement.setObject(4, accounts.getAmount());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int addAccountChq(Accounts accounts) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into Account(uid, date, time, type, description, amount) values(?,?,CurTime(),?,?,?)");
        statement.setObject(1, accounts.getUid());
        statement.setObject(2, accounts.getDate());
//        statement.setObject(3, accounts.getTime());
        statement.setObject(3, accounts.getType());
        statement.setObject(4, accounts.getDescription());
        statement.setObject(5, accounts.getAmount());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    /**
     *
     * @return @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Accounts> getAllAccount() throws ClassNotFoundException, SQLException {
        ArrayList<Accounts> accountses = new ArrayList<>();
        PreparedStatement prepareStatement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT * FROM Account ORDER BY date");
        ResultSet result = prepareStatement.executeQuery();
        while (result.next()) {
            accountses.add(new Accounts(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getDouble(7)));
        }
        return accountses;
    }

    public static ArrayList<Accounts> getAllAccountDateRangeAdd(String year, String month1, String month2) throws ClassNotFoundException, SQLException {
        ArrayList<Accounts> accountses = new ArrayList<>();
        PreparedStatement prepareStatement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT * FROM Account WHERE month(date) BETWEEN ? AND ? && description LIKE 'Add%' && year(date) LIKE ? ORDER BY date");
        prepareStatement.setObject(3, year);
        prepareStatement.setObject(1, month1);
        prepareStatement.setObject(2, month2);
        ResultSet result = prepareStatement.executeQuery();
        while (result.next()) {
            accountses.add(new Accounts(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getDouble(7)));
        }
        return accountses;
    }

    public static ArrayList<Accounts> getAllAccountDateRangeWith(String year, String month1, String month2) throws ClassNotFoundException, SQLException {
        ArrayList<Accounts> accountses = new ArrayList<>();
        PreparedStatement prepareStatement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT * FROM Account WHERE month(date) BETWEEN ? AND ? && description LIKE 'WITH%' && year(date) LIKE ? ORDER BY date;");
        prepareStatement.setObject(3, year);
        prepareStatement.setObject(1, month1);
        prepareStatement.setObject(2, month2);
        ResultSet result = prepareStatement.executeQuery();
        while (result.next()) {
            accountses.add(new Accounts(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getDouble(7)));
        }
        return accountses;
    }

    public static ArrayList<Accounts> getAllAccountAtDate(String date) throws ClassNotFoundException, SQLException {
        ArrayList<Accounts> accountses = new ArrayList<>();
        PreparedStatement prepareStatement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT * FROM Account WHERE date=?");
        prepareStatement.setObject(1, date);
        ResultSet result = prepareStatement.executeQuery();
        while (result.next()) {
            accountses.add(new Accounts(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getDouble(7)));
        }
        return accountses;
    }

    public static double getDayIncome(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount > 0 &&  date =?");
        statement.setObject(1, date);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }

    public static double getDayExpences(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount < 0 && type ^ 3 &&  date =?");
        statement.setObject(1, date);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }

    public static double getFromToIncome(String date1, String date2) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount > 0 &&  date>=? && date<=?");
        statement.setObject(1, date1);
        statement.setObject(2, date2);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }

    public static double getFromToExpences(String date1, String date2) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount < 0 && type^3 && date>=? && date<=?");
        statement.setObject(1, date1);
        statement.setObject(2, date2);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }

    public static double getDamageItemValue(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount < 0 && type ^ 2 && type ^ 1 &&  date =?");
        statement.setObject(1, date);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }

    public static double getDamegeFromTo(String date1, String date2) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select sum(amount) as income from Account where amount < 0 && type^1 && type^2 && date>=? && date<=?");
        statement.setObject(1, date1);
        statement.setObject(2, date2);
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        } else {
            return 0;
        }
    }
}
