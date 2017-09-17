/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Theekshana Buddika
 */
public class OrderController {

    public static int addOrder(Orders orders) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("INSERT INTO Orders(id,date,time,uid,cid,status,amount) VALUES(?,?,?,?,?,?,?)");
        statement.setObject(1, orders.getId());
        statement.setObject(2, orders.getDate());
        statement.setObject(3, orders.getTime());
        statement.setObject(4, orders.getUsrId());
        statement.setObject(5, orders.getCusId());
        statement.setObject(6, orders.getStatus());
        statement.setObject(7, orders.getAmount());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int updateOrder(Orders orders) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("UPDATE Orders SET date=?,time=?,uid=?,cid=?,status=?,amount=? WHERE id=?");
        statement.setObject(1, orders.getDate());
        statement.setObject(2, orders.getTime());
        statement.setObject(3, orders.getUsrId());
        statement.setObject(4, orders.getCusId());
        statement.setObject(5, orders.getStatus());
        statement.setObject(6, orders.getAmount());
        statement.setObject(7, orders.getId());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    /*public static int delete_order(Orders orders) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("DELETE FROM Orders WHERE id=?");
     statement.setObject(1, orders.getId());
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */
    public static Orders searchOrderByOrderid(Orders orders) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM Orders WHERE id=?");
        statement.setObject(1, orders.getId());
        ResultSet resultSet = statement.executeQuery();
        Orders orders1 = null;
        if (resultSet.next()) {
            orders1 = new Orders();
            orders1.setId(resultSet.getString(1));
            orders1.setDate(resultSet.getString(2));
            orders1.setTime(resultSet.getString(3));
            orders1.setUsrId(resultSet.getInt(4));
            orders1.setCusId(resultSet.getInt(5));
            orders1.setAmount(resultSet.getDouble(7));
            orders1.setStatus(resultSet.getInt(6));
        }
        return orders1;
    }
    
    public static Orders searchOrderByOrderid(String orderId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM Orders WHERE id=?");
        statement.setObject(1, orderId);
        ResultSet resultSet = statement.executeQuery();
        Orders orders1 = null;
        if (resultSet.next()) {
            orders1 = new Orders();
            orders1.setId(resultSet.getString(1));
            orders1.setDate(resultSet.getString(2));
            orders1.setTime(resultSet.getString(3));
            orders1.setUsrId(resultSet.getInt(4));
            orders1.setCusId(resultSet.getInt(5));
            orders1.setAmount(resultSet.getDouble(7));
            orders1.setStatus(resultSet.getInt(6));
        }
        return orders1;
    }

    public static ArrayList<Orders> searchOrderByDate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM Orders WHERE date like ?");
        statement.setObject(1, date);
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

    public static ArrayList<Orders> searchOrderByCstomerNic(String customerNic) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM Orders as od , Customer cu WHERE cu.nic=?");
        statement.setObject(1, customerNic);
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

    public static ArrayList<Orders> searchOrderByCustomerContact(String customerContact) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT * FROM Orders as od , Customer cu WHERE cu.contact=?");
        statement.setObject(1, customerContact);
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

    public static ArrayList<Orders> searchOrderByUserId(int userId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Orders where uid=?");
        statement.setObject(1, userId);
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

    public static ArrayList<Orders> getAllOrders() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Orders");
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

    public static ArrayList<Orders> searchOrderByStatus(int status) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Orders where status=?");
        statement.setObject(1, status);
        ArrayList<Orders> orders = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            orders.add(new Orders(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6), resultSet.getDouble(7)));
        }
        return orders;
    }

}
