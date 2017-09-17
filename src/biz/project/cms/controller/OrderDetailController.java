/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vihanga
 */
public class OrderDetailController {

    public static boolean addOrderDetails(ArrayList<OrderDetail> orderDetails) throws ClassNotFoundException, SQLException {
        int res = 0;
        for (OrderDetail orderDetail : orderDetails) {
            String query = "insert into Orderdetail(codid,code,oid,qty,soldprice,bid) values(?,?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, orderDetail.getOrderDetaiID());
            prepareStatement.setObject(2, orderDetail.getItemCode());
            prepareStatement.setObject(3, orderDetail.getOrderId());
            prepareStatement.setObject(4, orderDetail.getQty());
            prepareStatement.setObject(5, orderDetail.getSoldPrice());
            prepareStatement.setObject(6, orderDetail.getBid());
            res += prepareStatement.executeUpdate();
        }
        return orderDetails.size() == res;
    }

    public static int addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "insert into Orderdetail(codid,code,oid,qty,soldprice,bid) values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderDetail.getOrderDetaiID());
        prepareStatement.setObject(2, orderDetail.getItemCode());
        prepareStatement.setObject(3, orderDetail.getOrderId());
        prepareStatement.setObject(4, orderDetail.getQty());
        prepareStatement.setObject(5, orderDetail.getSoldPrice());
        prepareStatement.setObject(6, orderDetail.getBid());
        res += prepareStatement.executeUpdate();
        if (res > 0) {
            if (isUpdated(orderDetail)) {
                return getID(orderDetail);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    private static int getID(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        String sql = "select codid from OrderDetail where code = ? && oid=? && qty =? && soldprice =?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, orderDetail.getItemCode());
        prepareStatement.setObject(2, orderDetail.getOrderId());
        prepareStatement.setObject(3, orderDetail.getQty());
        prepareStatement.setObject(4, orderDetail.getSoldPrice());
        ResultSet executeQuery = prepareStatement.executeQuery();
        int detail = 0;
        if (executeQuery.next()) {
            detail = executeQuery.getInt(1);
        }
        return detail;
    }

    public static boolean isUpdated(OrderDetail detail) throws ClassNotFoundException, SQLException {
        String query = "update Batch set qty = qty - ? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, detail.getQty());
        prepareStatement.setObject(2, detail.getBid());
        int res = prepareStatement.executeUpdate();
        return res > 0;
    }

//    public static int deleteOrderDetail(int detailId) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from OrderDetail where codid=?");
//        statement.setObject(1, detailId);
//        int executeUpdate = statement.executeUpdate();
//        return executeUpdate;
//    }
    public static ArrayList<OrderDetail> getAllOrderDetails(String oid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select od.codid, i.description, od.oid, od.qty, od.soldprice, od.code from OrderDetail od, Item i where i.code=od.code && oid = ?");
        ArrayList<OrderDetail> details = new ArrayList<>();
        statement.setObject(1, oid);
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            details.add(new OrderDetail(executeQuery.getInt(1),
                    executeQuery.getString(2),
                    executeQuery.getString(3),
                    executeQuery.getInt(4),
                    executeQuery.getDouble(5), executeQuery.getString(6)));
        }
        return details;
    }
    

//    public static OrderDetail getAllOrderDetailsBySerial(String serial) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
//                .prepareStatement("select o.codid,o.code,o.oid,o.tag1,o.tag2,o.qty,o.soldprice "
//                        + "from OrderDetail o, Cserial S where s.id = ?");
//        statement.setObject(1, serial);
//        OrderDetail details = null;
//        ResultSet executeQuery = statement.executeQuery();
//        if (executeQuery.next()) {
//            details = new OrderDetail(executeQuery.getInt(1),
//                    executeQuery.getString(2),
//                    executeQuery.getString(3),
//                    executeQuery.getInt(4),
//                    executeQuery.getDouble(5),executeQuery.getString(6));
//        }
//        return details;
//    }
    public static OrderDetail searchOrderDetail(String orderID) throws ClassNotFoundException, SQLException {
        String sql = "select * from OrderDetail where oid = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, orderID);
        ResultSet executeQuery = prepareStatement.executeQuery();
        OrderDetail detail = null;
        if (executeQuery.next()) {
            detail = new OrderDetail(executeQuery.getInt(1),
                    executeQuery.getString(2),
                    executeQuery.getString(3),
                    executeQuery.getInt(4),
                    executeQuery.getDouble(5), executeQuery.getString(6));
        }
        return detail;
    }
    public static OrderDetail searchOrderDetailByCODID(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from OrderDetail where codid = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, id);
        ResultSet executeQuery = prepareStatement.executeQuery();
        OrderDetail detail = null;
        if (executeQuery.next()) {
            detail = new OrderDetail(executeQuery.getInt(1),
                    executeQuery.getString(2),
                    executeQuery.getString(3),
                    executeQuery.getInt(4),
                    executeQuery.getDouble(5), executeQuery.getString(6));
        }
        return detail;
    }
}
