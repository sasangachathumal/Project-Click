/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.controller;

import biz.project.cms.controller.dbConnection.DBConnection;
import biz.project.cms.model.BatchRest;
import biz.project.cms.model.Item;
import biz.project.cms.model.Items;
import biz.project.cms.model.ViewDamageNReturn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amila(Polta)
 */
public class ItemController {

    public static int addItem(Item item) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("insert into Item values(?,?,?,?,?)");
        statement.setObject(1, item.getCode());
        statement.setObject(2, item.getSerial());
        statement.setObject(3, item.getDesciption());
        statement.setObject(4, item.getCatId());
        statement.setObject(5, item.getRol());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<Item> searchCodeLike(String key, int index) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        if (index == 1) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where code like concat(?) order by code");
        } else if (index == 2) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where code like concat(?) order by description");
        } else if (index == 3) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where code like concat(?) order by catid");
        }
        statement.setObject(1, key);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static ArrayList<Item> searchDescLike(String key, int index) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        if (index == 1) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where description like concat(?) order by code");
        } else if (index == 2) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where description like concat(?) order by description");
        } else if (index == 3) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("select * from Item where description like concat(?) order by catid");
        }
        statement.setObject(1, key);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static ArrayList<Item> searchItemBySup(String key, int index) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        if (index == 1) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("Select i.code,i.serial,i.description,i.catid,i.rol from supplier s, grn g, grndetail gd, batch b, Item i where s.id=g.sid && g.id=gd.grnid && gd.bid=b.id && b.code=i.code && s.company like concat(?) order by i.code");
        } else if (index == 2) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("Select i.code,i.serial,i.description,i.catid,i.rol from supplier s, grn g, grndetail gd, batch b, Item i where s.id=g.sid && g.id=gd.grnid && gd.bid=b.id && b.code=i.code && s.company like concat(?) order by i.description");
        } else if (index == 3) {
            statement = DBConnection.getDBConnection().getConnection()
                    .prepareStatement("Select i.code,i.serial,i.description,i.catid,i.rol from supplier s, grn g, grndetail gd, batch b, Item i where s.id=g.sid && g.id=gd.grnid && gd.bid=b.id && b.code=i.code && s.company like concat(?) ");
        } 
        statement.setObject(1, key);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static ArrayList<Item> searchDescStartWith(String key) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Item where description like concat(?) order by description");
        statement.setObject(1, key);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static int deleteItem(String code) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("delete from Item where code=?");
        statement.setObject(1, code);
        int executeUpdate = statement.executeUpdate();
        return executeUpdate;
    }

    public static ArrayList<Item> getItemsByCategory(String catID) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Item where catid=?");
        statement.setObject(1, catID);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }
    
    public static ArrayList<Item> getItemsByCategoryOrderDes(String catID) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Item where catid=? order by description");
        statement.setObject(1, catID);
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static ArrayList<Item> getAllItem() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select * from Item");
        ArrayList<Item> items = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            items.add(new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5)));
        }
        return items;
    }

    public static Item searchItemByDesc(String desc) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Item where description=?");
        statement.setObject(1, desc);
        Item item = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            item = new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5));
        }
        return item;
    }

    public static Item searchIstemByCode(String code) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Item where code=?");
        statement.setObject(1, code);
        Item item = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            item = new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5));
        }
        return item;
    }

    public static Item searchItemBySerial(String serial) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select * from Item where serial=?");
        statement.setObject(1, serial);
        Item item = null;
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            item = new Item(executeQuery.getString(1), executeQuery.getString(2),
                    executeQuery.getString(3), executeQuery.getInt(4),
                    executeQuery.getInt(5));
        }
        return item;
    }

    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("update Item set serial = ?, description = ?, catid = ?, rol = ?  where code = ?");
        statement.setObject(1, item.getSerial());
        statement.setObject(2, item.getDesciption());
        statement.setObject(3, item.getCatId());
        statement.setObject(4, item.getRol());
        statement.setObject(5, item.getCode());
        int executeUpdate = statement.executeUpdate();
        return executeUpdate > 0;
    }

    public static ArrayList<BatchRest> getBatchRest(String itemCode) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection()
                .getConnection().prepareStatement("select * from BatchRest where code = ?");
        statement.setObject(1, itemCode);
        ArrayList<BatchRest> batches = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            batches.add(new BatchRest(executeQuery.getInt(1), executeQuery.getInt(2),
                    executeQuery.getDouble(3), executeQuery.getDouble(4), executeQuery.getString(5)));
        }
        return batches;
    }

    public static ArrayList<ViewDamageNReturn> getAllDamageToView() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select i.code, i.description, d.date, b.costprice from Item i, Damage d, Batch b where d.bid=b.id && b.code=i.code ");
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }

    public static ArrayList<ViewDamageNReturn> getAllDamageByDate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select i.code, i.description, d.date, b.costprice from Item i, Damage d, Batch b where d.bid=b.id && b.code=i.code && d.date=?");
        statement.setObject(1, date);
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }

    public static ArrayList<ViewDamageNReturn> getAllMyReturn() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select i.code, i.description, d.date, b.costprice from Item i, Mreturn d, Batch b where d.bid=b.id && b.code=i.code ");
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }

    public static ArrayList<ViewDamageNReturn> getAllMyReturnByDate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select i.code, i.description, d.date, b.costprice from Item i, Mreturn d, Batch b where d.bid=b.id && b.code=i.code && d.date=?");
        statement.setObject(1, date);
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }

    public static ArrayList<ViewDamageNReturn> getCustomerReturn() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection().prepareStatement("Select i.code, i.description, c.date, b.costprice from Item i, Creturn c, Batch b, OrderDetail od where b.code=i.code && od.codid=c.codid && od.bid=b.id");
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }

    public static ArrayList<ViewDamageNReturn> getCustomerReturnByDate(String date) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("Select i.code, i.description, c.date, b.costprice from Item i, Creturn c, Batch b, OrderDetail od where b.code=i.code && od.codid=c.codid && od.bid=b.id c.date=?");
        statement.setObject(1, date);
        ArrayList<ViewDamageNReturn> al = new ArrayList<>();
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            al.add(new ViewDamageNReturn(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getDouble(4)));
        }
        return al;
    }
    
    public static ArrayList<Items> getItemLikeByCategory(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select i.code, i.description, i.serial, c.name, i.rol from Item i, Category c where i.catid=c.id && c.name like concat(?) order by description");
        statement.setString(1, name+"%");
        ArrayList<Items> list = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            list.add(new Items(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        return list;
    }

    public static ArrayList<Items> getItemLikeByDes(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select i.code, i.description, i.serial, c.name, i.rol from Item i, Category c where i.catid=c.id && i.description like concat(?) order by description");
        statement.setString(1, name+"%");
        ArrayList<Items> list = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            list.add(new Items(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        return list;
    }

    public static ArrayList<Items> getItemLikeByCategoryBoth(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select i.code, i.description, i.serial, c.name, i.rol from Item i, Category c where i.catid=c.id && c.name like concat(?) order by description");
        statement.setString(1, "%"+name+"%");
        ArrayList<Items> list = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            list.add(new Items(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        return list;
    }

    public static ArrayList<Items> getItemLikeByDesBoth(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select i.code, i.description, i.serial, c.name, i.rol from Item i, Category c where i.catid=c.id && i.description like concat(?) order by description");
        statement.setString(1, "%"+name+"%");
        ArrayList<Items> list = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            list.add(new Items(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        return list;
    }

    public static ArrayList<Items> getItemLikeCode(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getDBConnection().getConnection()
                .prepareStatement("select i.code, i.description, i.serial, c.name, i.rol from Item i, Category c where i.catid=c.id && i.code like concat(?) order by description");
        statement.setString(1, "%"+name+"%");
        ArrayList<Items> list = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            list.add(new Items(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        return list;
    }

}
