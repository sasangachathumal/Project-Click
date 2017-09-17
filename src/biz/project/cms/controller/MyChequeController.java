/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.ChequPayentDefference;
import biz.project.cms.model.LoadMyChqgrnItemBach;
import biz.project.cms.model.MyChequPayentDefference;
import biz.project.cms.model.MyCheque;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arty
 */
public class MyChequeController {

    public static int addMyCheque(MyCheque myCheque) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Mcheque(chqno ,chqdate ,pid ,bank ) values(?,?,?,?)");
        statement.setObject(1, myCheque.getChqNo());
        statement.setObject(2, myCheque.getChqDate());
        statement.setObject(3, myCheque.getPayId());
        statement.setObject(4, myCheque.getBank());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static int deleteMyCheque(int chqno) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("delete from Mcheque where chqno=?");
        statement.setObject(1, chqno);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<MyCheque> getAllMyCheque() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Mcheque");
        ArrayList<MyCheque> myCheque = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            myCheque.add(new MyCheque(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4)));
        }
        return myCheque;
    }

//    By NO
    public static MyCheque searchGRNchqno(String chqno) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Mcheque where chqno=?");
        statement.setObject(1, chqno);
        MyCheque myCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            myCheque = new MyCheque(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4));
        }
        return myCheque;
    }

//    By grndid
    public static MyCheque searchGRNBySupID(String pid) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Mcheque where pid=?");
        statement.setObject(1, pid);
        MyCheque myCheque = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            myCheque = new MyCheque(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getString(4));
        }
        return myCheque;
    }

    public static boolean updateMyCheque(MyCheque myCheque) throws ClassNotFoundException, SQLException {
        int res = 0;
        String query = "update Mcheque set chqdate = ? , pid = ?, bank = ? where chqno = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, myCheque.getChqDate());
        prepareStatement.setObject(2, myCheque.getPayId());
        prepareStatement.setObject(3, myCheque.getBank());
        res += prepareStatement.executeUpdate();
        return res > 0;
    }

    public static ArrayList<MyChequPayentDefference> getDateDeffirence(Date from, Date to) {

        ArrayList<MyChequPayentDefference> list = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT chqno, bank, pid, amount FROM mcheque mh JOIN mpayment mp ON mh.pid=mp.id WHERE `chqdate`>='" + from + "' AND `chqdate`<='" + to + "';");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new MyChequPayentDefference(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4))));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // list.trimToSize();
        return list;

    }

    public static LoadMyChqgrnItemBach LoadMyChqgrnItemBach(String id) {
            LoadMyChqgrnItemBach chqgrnItemBach = null;
        try {
            PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("SELECT bch.id, itm.description, grd.qty, bch.costprice FROM grn gr JOIN grndetail grd ON gr.id=grd.grnid JOIN batch bch ON grd.bid=bch.id JOIN item itm ON bch.code=itm.code WHERE gr.id='"+id+"'");
            ResultSet executeQuery = statement.executeQuery();
            
            if (executeQuery.next()) {
                chqgrnItemBach = new LoadMyChqgrnItemBach(executeQuery.getString(1),
                        executeQuery.getString(2), Integer.parseInt(executeQuery.getInt(3)+""),
                        Double.parseDouble(executeQuery.getDouble(4)+""));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyChequeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chqgrnItemBach;
    }
}
 