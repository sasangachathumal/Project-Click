/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.CustomerSerial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * C serial
 *
 * @author Arty
 */
public class CustomerSerialController {

    public static int addCustomerSerial(CustomerSerial customerSerial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Cserial(id ,serial,tag1,tag2 ,codid ,period ) values(?,?,?,?,?,?)");
        statement.setObject(1, customerSerial.getSerialId());
        statement.setObject(2, customerSerial.getSerialNo());
        statement.setObject(3, customerSerial.getTag1());
        statement.setObject(4, customerSerial.getTag2());
        statement.setObject(5, customerSerial.getCodid());
        statement.setObject(6, customerSerial.getPeriod());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    /*
     public static int deleteCustomerSerial(int cusSerialid) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from Cserial where id=?");
     statement.setObject(1, cusSerialid);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static ArrayList<CustomerSerial> getAllCustomersSerial() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Cserial");
        ArrayList<CustomerSerial> customerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerSerial.add(new CustomerSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getInt(4),
                    executeQuery.getInt(5), executeQuery.getInt(6)));
        }
        return customerSerial;
    }

//    By ID 
    public static CustomerSerial searchCusSerialById(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Cserial where id=?");
        statement.setObject(1, id);
        CustomerSerial customerSerial = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerSerial = new CustomerSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getInt(4),
                    executeQuery.getInt(5), executeQuery.getInt(6));
        }
        return customerSerial;
    }

    public static CustomerSerial searchCusSerialByserial(String serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Cserial where serial=?");
        statement.setObject(1, serial);
        CustomerSerial customerSerial = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customerSerial = new CustomerSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getInt(4),
                    executeQuery.getInt(5), executeQuery.getInt(6));
        }
        return customerSerial;
    }

    public static boolean updateCustomerSerial(CustomerSerial customerSerial) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Cserial set serial = ?, tag1 = ?, tag2 = ?, period = ?  where id  = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, customerSerial.getSerialNo());
        prepareStatement.setObject(2, customerSerial.getTag1());
        prepareStatement.setObject(3, customerSerial.getTag2());
        prepareStatement.setObject(4, customerSerial.getCodid());
        prepareStatement.setObject(5, customerSerial.getPeriod());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
/////////////////////

    public static ArrayList<CustomerSerial> OrderByCSerial(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("SELECT cs.id, cs.serial, cs.tag1, cs.tag2, cs.codid, cs.period FROM orderdetail odi JOIN cserial cs ON odi.codid=cs.codid WHERE odi.oid='" + id + "'");
        ArrayList<CustomerSerial> customerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerSerial.add(new CustomerSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getInt(4),
                    executeQuery.getInt(5), executeQuery.getInt(6)));
        }
        return customerSerial;
    }
    
//searchCusSerialByCodID
    public static ArrayList<CustomerSerial> searchCusSerialByCodID(String serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Cserial where codid=?");
        statement.setObject(1, serial);
       ArrayList<CustomerSerial> customerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customerSerial.add(new CustomerSerial(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getInt(4),
                    executeQuery.getInt(5), executeQuery.getInt(6)));
        }
        return customerSerial;
    }
}
