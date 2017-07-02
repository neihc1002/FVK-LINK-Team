/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Producer;
import Entity.Product;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author duong
 */
public class DataProcess implements Serializable{
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user="sa";
            String pass="123456";
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
                String pricein= rs.getString(6);
                String priceout= rs.getString(7);
                int quantity= rs.getInt(8);
                String guarantee= rs.getString(9);
                String coin = rs.getString(10);
                String info=rs.getString(11);
                byte[] image=rs.getBytes(12);
                Product pr=new Product(id, name, producer, type, memory, pricein, priceout, quantity, guarantee, coin, info, image);
                list.add(pr);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    public boolean save(String id,String name, String producer, String pricein, String priceout, String memory, String guarantee,String money, String image, String info) throws FileNotFoundException, IOException{
        int result=0;
        File file =new File(image);
        FileInputStream fis=new FileInputStream(file);
        int len=(int) file.length(); 
        String sql = "UPDATE tblProduct SET _image=?,_producer=?,_pricein=?, _priceout=?, _memory=?, _guarantee=?, _money=?, _info=?, _name=?  WHERE _id=?";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setBinaryStream(1, fis,len);
            prst.setString(2, producer);
            prst.setString(3, pricein);
            prst.setString(4, priceout);
            prst.setString(5, memory);
            prst.setString(6, guarantee);
            prst.setString(7, money);
            prst.setString(8, info);
            prst.setString(9, name);
            prst.setString(10, id);
            result=prst.executeUpdate();
            fis.close();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
        
        
        
    }
    
    
    public boolean deleteIteam(String id)
    {
        int result=0;
        String sql="DELETE FROM tblProduct WHERE _id=?";
        try {
            PreparedStatement prst = getConnection(
            ).prepareStatement(sql);
            prst.setString(1, id);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result>0;
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
    public boolean addProduct(String id, String name, String producer, int quantity, float price, String memory, int guarantee, String type, String money){
        int result = 0;
        String sql="INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, name);
            prst.setString(3, producer);
            prst.setString(4, type);
            prst.setString(5, memory);
            prst.setFloat(6, price);
            prst.setInt(7, quantity);
            prst.setInt(8, guarantee);
            prst.setString(9, money);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
}
