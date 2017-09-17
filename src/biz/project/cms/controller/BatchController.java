/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.Batch;
import biz.project.cms.model.ItemBatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amila(Polta)
 */
public class BatchController {

    public static int addBatch(Batch batch) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("insert into Batch(qty, date, unitprice, listprice, costprice, code) values(?,?,?,?,?,?)");
        statement.setObject(1, batch.getQty());
        statement.setObject(2, batch.getDate());
        statement.setObject(3, batch.getUnitPrice());
        statement.setObject(4, batch.getListPrice());
        statement.setObject(5, batch.getCostPrice());
        statement.setObject(6, batch.getItemCode());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }
    /*
     public static int deleteBatch(int batchId) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from Batch where id=?");
     statement.setObject(1, batchId);
     int executeUpdate = statement.executeUpdate();
     return executeUpdate;
     }
     */

    public static ArrayList<Batch> getAllBatches() throws ClassNotFoundException, SQLException {
        ResultSet executeQuery = null;
        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Batch where qty > 0 order by 7");
            ArrayList<Batch> batchs = new ArrayList<>();
            executeQuery = statement.executeQuery();
            while (executeQuery.next()) {
                batchs.add(new Batch(executeQuery.getInt(1), executeQuery.getInt(2),
                        executeQuery.getString(3), executeQuery.getDouble(4), executeQuery.getDouble(5),
                        executeQuery.getDouble(6), executeQuery.getString(7)));
            }
            return batchs;
        } finally {
            if (executeQuery != null) {
                executeQuery.close();
            }
        }
    }

    public static ArrayList<ItemBatch> getItemBatches(String itemCode) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection()
                .getConnection().prepareStatement("select * from ItemBatch where code = ?");
        statement.setObject(1, itemCode);
        ArrayList<ItemBatch> batches = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            batches.add(new ItemBatch(executeQuery.getInt(1), executeQuery.getString(2),
                    executeQuery.getDouble(3), executeQuery.getDouble(4), executeQuery.getDouble(5),
                    executeQuery.getInt(6)));
        }
        return batches;
    }

    public static ArrayList<Batch> searchBatchByItemCode(String itemCode) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select * from Batch where code=? && qty>0");
        statement.setObject(1, itemCode);
        ArrayList<Batch> batches = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            batches.add(new Batch(executeQuery.getInt(1), executeQuery.getInt(2), executeQuery.getString(3), executeQuery.getDouble(4), executeQuery.getDouble(5), executeQuery.getDouble(6), executeQuery.getString(7)));
        }
        return batches;
    }

    public static Batch searchBatchBy_CodeZeroItems(String itemCode) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Batch where code=? && qty=0 limit 1");
        statement.setObject(1, itemCode);
        Batch batches = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            batches = new Batch(executeQuery.getInt(1), executeQuery.getInt(2), executeQuery.getString(3), executeQuery.getDouble(4), executeQuery.getDouble(5), executeQuery.getDouble(6), executeQuery.getString(7));
        }
        return batches;
    }

    public static Batch getAllBatchesByBatchId(String batchID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Batch where id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, batchID);
        ResultSet rst = stm.executeQuery();
        Batch batch = null;
        if (rst.next()) {
            batch = new Batch(rst.getInt(1), rst.getInt(2),
                    rst.getString(3), rst.getDouble(4), rst.getDouble(5),
                    rst.getDouble(6), rst.getString(7));
        }
        return batch;
    }

    public static String getQOH(String code) throws ClassNotFoundException, SQLException {
        String sql = "Select sum(qty) as QOH from batch where qty>0 && code = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, code);
        ResultSet rst = stm.executeQuery();
        String tot = null;
        if (rst.next()) {
            tot = rst.getString(1);
        }
        return tot;
    }

    public static boolean updateBatchDetail(Batch batch) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("update Batch set qty = ?, date = ?, unitprice = ?, "
                        + "listprice = ?, costprice = ?, code = ?  where id = ?");
        statement.setObject(1, batch.getQty());
        statement.setObject(2, batch.getDate());
        statement.setObject(3, batch.getUnitPrice());
        statement.setObject(4, batch.getListPrice());
        statement.setObject(5, batch.getCostPrice());
        statement.setObject(6, batch.getItemCode());
        statement.setObject(7, batch.getBatchId());
        int executeUpdate = statement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean updateBatchItemQty(ArrayList<Batch> batchList) throws ClassNotFoundException, SQLException {
        int res = 0;
        for (Batch batch : batchList) {
            String query = "update Batch set qty = qty - ? where id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, batch.getQty());
            prepareStatement.setObject(2, batch.getBatchId());
            res += prepareStatement.executeUpdate();
        }
        return (res == batchList.size());
    }

    public static boolean updateSingleBatchItemQty(Batch batch) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Batch set qty = qty - ? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, batch.getQty());
        prepareStatement.setObject(2, batch.getBatchId());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    public static Batch searchBatch(String batchID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Batch where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, batchID);
        ResultSet rst = prepareStatement.executeQuery();
        Batch batch = null;
        if (rst.next()) {
            batch = new Batch(rst.getInt(1), rst.getInt(2),
                    rst.getString(3), rst.getDouble(4), rst.getDouble(5),
                    rst.getDouble(6), rst.getString(7));
        }
        return batch;
    }
}
