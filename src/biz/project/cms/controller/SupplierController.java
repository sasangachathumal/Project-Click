/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vihanga
 */
public class SupplierController {

    public static int addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Supplier(id,company,name,mobile,office,fax,email)"
                        + " values(?,?,?,?,?,?,?)");
        statement.setObject(1, supplier.getSupId());
        statement.setObject(2, supplier.getCompany());
        statement.setObject(3, supplier.getName());
        statement.setObject(4, supplier.getMobile());
        statement.setObject(5, supplier.getOffice());
        statement.setObject(6, supplier.getFax());
        statement.setObject(7, supplier.getEmail());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteSupplier(int sid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from supplier where id=?");
        statement.setObject(1, sid);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<Supplier> allSuppliers() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Supplier order by company");
        ArrayList<Supplier> suppliers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            suppliers.add(new Supplier(executeQuery.getInt(1),
                    executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getInt(5),
                    executeQuery.getInt(6), executeQuery.getString(7)));
        }
        return suppliers;
    }
    
    public static ArrayList<Supplier> allSuppliersWithDuePayment() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from SupplierTable");
        ArrayList<Supplier> suppliers = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            suppliers.add(new Supplier(executeQuery.getInt(1),
                    executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getInt(5),
                    executeQuery.getInt(6), executeQuery.getString(7), executeQuery.getDouble(8)));
        }
        return suppliers;
    }

    public static Supplier searchSupplier(String company) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Supplier where company=?");
        statement.setObject(1, company);
        Supplier supplier = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            supplier = new Supplier(executeQuery.getInt(1),
                    executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getInt(5),
                    executeQuery.getInt(6), executeQuery.getString(7));
        }
        return supplier;
    }
    
    public static String searchSupplierItemCode(String code) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select s.company, s.name from supplier s, grn g, grndetail gd, batch b, Item i where s.id=g.sid && g.id=gd.grnid && gd.bid=b.id && b.code=i.code && i.code=? limit 1;");
        statement.setObject(1, code);
        String supplier = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            supplier = executeQuery.getString(1);
        }
        return supplier;
    }

    public static boolean updateSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Supplier set company = ?, name = ?, mobile = ?,office=?, fax=?,email=?  where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, supplier.getCompany());
        prepareStatement.setObject(2, supplier.getName());
        prepareStatement.setObject(3, supplier.getMobile());
        prepareStatement.setObject(4, supplier.getOffice());
        prepareStatement.setObject(5, supplier.getFax());
        prepareStatement.setObject(6, supplier.getEmail());
        prepareStatement.setObject(7, supplier.getSupId());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
    
    
    public static Supplier searchSupplierBYID(String supid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Supplier where id=?");
        statement.setObject(1, supid);
        Supplier supplier = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            supplier = new Supplier(executeQuery.getInt(1),
                    executeQuery.getString(2), executeQuery.getString(3),
                    executeQuery.getInt(4), executeQuery.getInt(5),
                    executeQuery.getInt(6), executeQuery.getString(7));
        }
        return supplier;
    }

}
