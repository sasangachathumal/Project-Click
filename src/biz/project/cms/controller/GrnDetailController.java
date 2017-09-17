/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.GRNDetail;
import biz.project.cms.model.GRNDetailBatch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Theekshana Buddika
 */
public class GrnDetailController {

//    public static boolean addGrnDetail(ArrayList<GRNDetail> grnDetails) throws ClassNotFoundException, SQLException {
//        int res = 0;
//        for (GRNDetail grnDetail : grnDetails) {
//            String query = "insert into Grndetail(grndid,grnid,bid,qty) values(?,?,?,?)";
//            Connection connection = DBConnection.getDBConnection().getConnection();
//            PreparedStatement prepareStatement = connection.prepareStatement(query);
//            prepareStatement.setObject(1, grnDetail.getGrnDetailId());
//            prepareStatement.setObject(2, grnDetail.getGrnId());
//            prepareStatement.setObject(3, grnDetail.getBatchId());
//            prepareStatement.setObject(4, grnDetail.getQty());
//            res += prepareStatement.executeUpdate();
//        }
//        return grnDetails.size() == res;
//    }
    public static int[] addGRNDetailBatch(GRNDetailBatch detailBatch) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("CALL AddGRNDetail(?,?,?,?,?,?,?)");
        statement.setObject(1, detailBatch.getQty());
        statement.setObject(2, detailBatch.getCost());
        statement.setObject(3, detailBatch.getUnit());
        statement.setObject(4, detailBatch.getMin());
        statement.setObject(5, detailBatch.getDate());
        statement.setObject(6, detailBatch.getItemCode());
        statement.setObject(7, detailBatch.getGrnID());
        ResultSet executeQuery = statement.executeQuery();
        int i[] = null;
        if (executeQuery.next()) {
            i = new int[]{executeQuery.getInt(1), executeQuery.getInt(2)};
        }
        return i;
    }
    
    public static String updateGRNDetailBatch(GRNDetailBatch detailBatch) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("CALL UpdateGRN(?,?,?,?,?,?,?)");
        statement.setObject(1, detailBatch.getItemCode());//bid
        statement.setObject(2, detailBatch.getQty());
        statement.setObject(3, detailBatch.getGrnID());
        statement.setObject(4, detailBatch.getCost());
        statement.setObject(5, detailBatch.getUnit());
        statement.setObject(6, detailBatch.getMin());
        statement.setObject(7, detailBatch.getDate());////warranty case
        ResultSet executeQuery = statement.executeQuery();
        String i = null;
        if (executeQuery.next()) {
            i = executeQuery.getString(1);
        }
        return i;
    }

//    public static int deleteOrderDetail(int detailId) throws ClassNotFoundException, SQLException {
//        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from OrderDetail where codid=?");
//        statement.setObject(1, detailId);
//        int executeUpdate = statement.executeUpdate();
//        return executeUpdate;
//    }
    public static ArrayList<GRNDetail> getAllOrderDetails(String grnid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Grndetail where grnid = ?");
        ArrayList<GRNDetail> grnDetails = new ArrayList<>();
        statement.setObject(1, grnid);
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            grnDetails.add(new GRNDetail(executeQuery.getInt(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4)));
        }
        return grnDetails;
    }
 public static GRNDetail searchGRNDetail(String grndid) throws ClassNotFoundException, SQLException {
        String sql = "select * from Grndetail where grndid = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setObject(1, grndid);
        ResultSet rst = prepareStatement.executeQuery();
        GRNDetail detail = null;
        if (rst.next()) {
            detail = new GRNDetail(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
        }
        return detail;
    }
}
