/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Damage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vihanga
 */
public class DamageController {

    public static String addDamageItem(Damage damage,String serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("CALL AddDamage(?,?,?,?,?)");
        statement.setObject(4, damage.getQty());
        statement.setObject(2, damage.getReason());
        statement.setObject(5, serial);
        statement.setObject(1, damage.getBatchdId());
        statement.setObject(3, damage.getDate());
        ResultSet executeQuery = statement.executeQuery();
        String  s=null;
        if (executeQuery.next()) {
            s=executeQuery.getString(1);
        }
        return s;
    }

//    public static int deleteDamage(int did) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from damage where id=?");
//        statement.setObject(1, did);
//        int executeUpdate = statement.executeUpdate();
//        return executeUpdate;
//    }
    public static ArrayList<Damage> getAllDamageItem() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Damage order by date desc");
        ArrayList<Damage> damage = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            damage.add(new Damage(Integer.parseInt(executeQuery.getString(1)), executeQuery.getInt(2),
                    executeQuery.getString(3), executeQuery.getInt(4), executeQuery.getString(5)));
        }
        return damage;
    }

    public static boolean updateDamage(Damage damage) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update damage set qty = ?, reason= ?,bid=?,date=? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(5, damage.getDamID());
        prepareStatement.setObject(1, damage.getQty());
        prepareStatement.setObject(2, damage.getReason());
        prepareStatement.setObject(3, damage.getBatchdId());
        prepareStatement.setObject(4, damage.getDate());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
}
