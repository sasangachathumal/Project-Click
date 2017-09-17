/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.DealerSerial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arty
 */
public class DealerSerialController {

    public static int addDealerSerial(DealerSerial dealerSerial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Dserial(id ,serial ,grndid ,period ) values(?,?,?,?)");
        statement.setObject(1, dealerSerial.getdId());
        statement.setObject(2, dealerSerial.getSerial());
        statement.setObject(3, dealerSerial.getGrnId());
        statement.setObject(4, dealerSerial.getPeriod());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteDealerSerial(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Dserial where id=?");
        statement.setObject(1, id);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<DealerSerial> getAllDealerSerial() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Dserial");
        ArrayList<DealerSerial> dealerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            dealerSerial.add(new DealerSerial(executeQuery.getInt(1), executeQuery.getString(2),
                    executeQuery.getInt(3), executeQuery.getInt(4)));
        }
        return dealerSerial;
    }

    public static ArrayList<DealerSerial> getAllDealerSerialByBatch(String bid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select d.serial as Serial, period, d.id "
                        + "from Grndetail g, Batch b, Dserial d "
                        + "where b.id=? && b.id=g.bid && d.grndid=g.grndid");
        statement.setObject(1, bid);
        ArrayList<DealerSerial> dealerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            dealerSerial.add(new DealerSerial(executeQuery.getInt(3), executeQuery.getString(1),
                    0, executeQuery.getInt(2)));
        }
        return dealerSerial;
    }

//    By NO
    public static DealerSerial searchDserialBySerial(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Dserial where serial=?");
        statement.setObject(1, id);
        DealerSerial dealerSerial = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            dealerSerial = new DealerSerial(executeQuery.getInt(1), executeQuery.getString(2),
                    executeQuery.getInt(3), executeQuery.getInt(4));
        }
        return dealerSerial;
    }

//    By grndid
    public static ArrayList<DealerSerial> searchDserialGRNDID(String grndid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Dserial where grndid=?");
        statement.setObject(1, grndid);
       ArrayList<DealerSerial> dealerSerial = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
       while (executeQuery.next()) {
            dealerSerial.add(new DealerSerial(executeQuery.getInt(1), executeQuery.getString(2),
                    executeQuery.getInt(3), executeQuery.getInt(4)));
        }
        return dealerSerial;
    }

    public static boolean updateDealerSerial(DealerSerial dealerSerial) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Dserial set serial = ? , grndid = ?, period = ? where id = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, dealerSerial.getSerial());
        prepareStatement.setObject(2, dealerSerial.getGrnId());
        prepareStatement.setObject(3, dealerSerial.getPeriod());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }
}
