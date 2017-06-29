/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Producer;
import Entity.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class DataProcess {
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user="sa";
            String pass="Duongtran5898";
            String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=Store";
            try {
                con=DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public ArrayList<Product> getProduct(){
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString(1);
                String name= rs.getString(2);
                String producer= rs.getString(3);
                String type= rs.getString(4);
                String memory= rs.getString(5);
                float price= rs.getFloat(6);
                int quanlity= rs.getInt(7);
                int guarantee= rs.getInt(8);
                String money = rs.getString(9);
                Product pr=new Product(id, name, producer, type, memory, price, quanlity, guarantee, money);
                list.add(pr);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    public ArrayList<Producer> getProducer(){
        ArrayList<Producer> list = new ArrayList<>();
        String sql = "SELECT * FROM tblProducer";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String name=rs.getString(1);
                String info= rs.getString(2);
                Producer pr = new Producer(name, info);
                list.add(pr);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
