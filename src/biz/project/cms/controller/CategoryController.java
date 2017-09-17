/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arty
 */
public class CategoryController {

    public static int addCategory(Category category) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection()
                .getConnection().prepareStatement("insert into category(id,name) values(?,?)");
        statement.setObject(1, category.getCatID());
        statement.setObject(2, category.getName());
        return statement.executeUpdate();
    }
    /*
     public static int deleteCategory(int Catid) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from category where id=?");
     statement.setObject(1, Catid);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static ArrayList<Category> getAllCategory() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Category order by name");
        ArrayList<Category> category = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            category.add(new Category(executeQuery.getInt(1), executeQuery.getString(2)));
        }
        return category;
    }
    
    public static ArrayList<Category> getAllCategorySearch(String key) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from category where name like ?");
        statement.setObject(1, key);
        ArrayList<Category> category = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            category.add(new Category(executeQuery.getInt(1), executeQuery.getString(2)));
        }
        return category;
    }

    public static Category searchCategoryByName(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Category where name=?");
        statement.setObject(1, name);
        Category category = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            category = new Category(executeQuery.getInt(1), executeQuery.getString(2));
        }
        return category;
    }

    public static Category searchCategoryByID(String categoryID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Category where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, categoryID);
        ResultSet rst = prepareStatement.executeQuery();
        Category category = null;
        if (rst.next()) {
            category = new Category(rst.getInt(1), rst.getString(2));
        }
        return category;
    }

    public static boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update category set name = ? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, category.getName());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
}
