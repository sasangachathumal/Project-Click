/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;


import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amila(Polta)
 */
public class CustomerController {

    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Customer(name,contact,nic) values(?,?,?)");
        statement.setObject(1, customer.getName());
        statement.setObject(2, customer.getContact());
        statement.setObject(3, customer.getNic());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    
    public static int addCustomerSpecialForOrders(Customer customer) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Customer(name,contact,nic) values(?,?,?)");
        statement.setObject(1, customer.getName());
        statement.setObject(2, customer.getContact());
        statement.setObject(3, customer.getNic());
        int executeUpdate = statement.executeUpdate();
        if (executeUpdate > 0) {
            executeUpdate = getAddedID(customer);
        } else {
        }
        return executeUpdate;
    }

    private static int getAddedID(Customer customer) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select id from Customer where name=? && contact=?");
        statement.setObject(1, customer.getName());
        statement.setObject(2, customer.getContact());
        ResultSet executeQuery = statement.executeQuery();
        int id = 1;
        if (executeQuery.next()) {
            id = executeQuery.getInt(1);
        }
        return id;
    }

    public static int deleteCustomer(int sid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from customer where id=?");
        statement.setObject(1, sid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    
    public static int deleteCustomerbyName(String name,String nic) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from customer where name=? and contact=?");
        statement.setObject(1, name);
        statement.setObject(2, nic);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<Customer> allCustomers() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Customer");
        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customers.add(new Customer(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4)));
        }
        return customers;
    }

    public static ArrayList<Customer> allCustomersWithDebits() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("select * from CustomerTable");
        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            customers.add(new Customer(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4),executeQuery.getDouble(5)));
        }
        return customers;
    }
    
    public static Customer searchCustomerByNIC(String nic) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from Customer where nic=?");
        statement.setObject(1, nic);
        Customer customer = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customer = new Customer(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4));
        }
        return customer;
    }

    public static Customer searchCustomerByContact(int contact) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from Customer where contact=?");
        statement.setObject(1, contact);
        Customer customer = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customer = new Customer(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4));
        }
        return customer;
    }

    public static Customer searchCustomerByID(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Customer where id=?");
        statement.setObject(1, id);
        Customer customer = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            customer = new Customer(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getInt(3), executeQuery.getString(4));
        }
        return customer;
    }
    
    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Customer set contact = ?, name = ?, nic = ?  where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, customer.getContact());
        prepareStatement.setObject(2, customer.getName());
        prepareStatement.setObject(3, customer.getNic());
        prepareStatement.setObject(4, customer.getCid());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
    
}
