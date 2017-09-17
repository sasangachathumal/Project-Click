/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.CustomerReturn;
import biz.project.cms.model.LoadOrderItmBachCatDital;
import biz.project.cms.model.ReturnItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Theekshana Buddika
 */
public class CustomerReturnController {

    public static int addCustomerReturn(CustomerReturn customerReturn) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Creturn(id,codId,qty,date) values(?,?,?,?)");
        statement.setObject(1, customerReturn.getRetId());
        statement.setObject(2, customerReturn.getCodId());
        statement.setObject(3, customerReturn.getQty());
        statement.setObject(4, customerReturn.getDate());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int addCustomerReturnProcedure(ReturnItem returnItem) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("CALL AddReturn(?,?,?,?,?,?,?,?,?)");
        statement.setObject(1, returnItem.getBatchid());
        statement.setObject(2, returnItem.getQty());
        statement.setObject(3, returnItem.getOid());
        statement.setObject(4, returnItem.getSerial());
        statement.setObject(5, returnItem.getState());
        statement.setObject(6, returnItem.getReasons());
        statement.setObject(7, returnItem.getCrid());
        statement.setObject(8, returnItem.getMrid());
        statement.setObject(9, returnItem.getUserid());
        int executeUpdate = statement.executeUpdate();
                return executeUpdate;
    }

//    public static int updateCustomerReturn(CustomerReturn customerReturn) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
//                .prepareStatement("UPDATE Creturn SET codid=?,qty=?,date=? WHERE id=?");
//        statement.setObject(1, customerReturn.getCodId());
//        statement.setObject(2, customerReturn.getQty());
//        statement.setObject(3, customerReturn.getDate());
//        statement.setObject(4, customerReturn.getRetId());
//        int executeUpdate = statement.executeUpdate();
//        return executeUpdate;
//    }
    /* ************************************************************************ */
//    public static int deleteCustomerReturn(CustomerReturn customerReturn) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
//                .prepareStatement("DELETE FROM Creturn WHERE id=?");
//        statement.setObject(1, customerReturn.getRetId());
//        int executeUpdate = statement.executeUpdate();
//        return executeUpdate;
//    }
    public static CustomerReturn searchCustomerReturn(CustomerReturn customerReturn) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Creturn where id=?");
        statement.setObject(1, customerReturn.getRetId());
        CustomerReturn customerReturn1 = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerReturn1 = new CustomerReturn(executeQuery.getString(1), executeQuery.getInt(2), executeQuery.getInt(3), executeQuery.getString(4));
        }
        return customerReturn1;
    }

    public static ArrayList<CustomerReturn> getAllCustomerReturns() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Creturn");
        ArrayList<CustomerReturn> customerReturns = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerReturns.add(new CustomerReturn(executeQuery.getString(1), executeQuery.getInt(2), executeQuery.getInt(3), executeQuery.getString(4)));
        }
        return customerReturns;
    }

    public static ArrayList<CustomerReturn> getCustReturnByOrderID() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select r.id,r.codId,r.qty,r.date from Creturn r, Orderdetail od, Orders o where od.oid = ? && r.codid=od.codid && o.id = od.oid");
        ArrayList<CustomerReturn> customerReturns = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerReturns.add(new CustomerReturn(executeQuery.getString(1), executeQuery.getInt(2), executeQuery.getInt(3), executeQuery.getString(4)));
        }
        return customerReturns;
    }
//////////////////

    public static ArrayList<LoadOrderItmBachCatDital> locadIDbyOrders(String id) throws ClassNotFoundException, SQLException {
        ArrayList<LoadOrderItmBachCatDital> dital = new ArrayList<>();

        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT odi.codid, od.date, od.time , od.id , odi.bid , itm.code , itm.description , odi.soldprice , odi.qty ,odi.codid  FROM orders od JOIN orderdetail odi ON od.id=odi.oid JOIN item itm ON itm.code=odi.code JOIN category cat ON cat.id=itm.catid WHERE od.id='" + id + "'");
        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            dital.add(new LoadOrderItmBachCatDital(rst.getString(1), rst.getDate(2), rst.getTime(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getDouble(8), rst.getInt(9), rst.getString(10)));
        }
        return dital;
    }
}
