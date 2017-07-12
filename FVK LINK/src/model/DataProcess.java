/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.CodeSale;
import Entity.Customer;
import Entity.InputOrder;
import Entity.ListProductIO;
import Entity.OutputOrder;
import Entity.Producer;
import Entity.Product;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
import javafx.scene.chart.PieChart;

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
//    public boolean addProduct(String id, String name, String producer, int quantity, float price, String memory, int guarantee, String type, String money){
//        int result = 0;
//        String sql="INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement prst=getConnection().prepareStatement(sql);
//            prst.setString(1, id);
//            prst.setString(2, name);
//            prst.setString(3, producer);
//            prst.setString(4, type);
//            prst.setString(5, memory);
//            prst.setFloat(6, price);
//            prst.setInt(7, quantity);
//            prst.setInt(8, guarantee);
//            prst.setString(9, money);
//            result=prst.executeUpdate();
//            prst.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return result>0;
//    }
    public boolean addProduct(String id,String name, String producer, String type, String memory, String priceIn, String priceOut, String quantity, String guarantee,String coin, String info, String image) throws IOException{
        int result = 0;
        File file=new File(image);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql="INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, name);
            prst.setString(3, producer);
            prst.setString(4, type);
            prst.setString(5, memory);
            prst.setString(6, priceIn);
            prst.setString(7, priceOut);
            prst.setString(8, quantity);
            prst.setString(9, guarantee);
            prst.setString(10, coin);
            prst.setString(11, info);
            prst.setBinaryStream(12, fis, (int) file.length());
            result=prst.executeUpdate();
            fis.close();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public boolean addInputList(String idOrder, String id, int quantity, String price, String producer, String memory ){
        int result = 0;
        String sql="INSERT INTO tblInputList VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, idOrder);
            prst.setString(2, id);
            prst.setInt(3, quantity);
            prst.setString(4, price);
            prst.setString(5, producer);
            prst.setString(6, memory);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public boolean addInputOrder(String idOrder, String importer, String date, String totalprice, int quantity ){
        int result = 0;
        String sql="INSERT INTO tblInputOrder VALUES (?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, idOrder);
            prst.setString(2, importer);
            prst.setString(3, date);
            prst.setString(4, totalprice);
            prst.setInt(5, quantity);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public ArrayList<InputOrder> getInputOrder(){
        ArrayList<InputOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM tblInputOrder";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString(1);
                String importer= rs.getString(2);
                String date=rs.getString(3);
                String totalprice = rs.getString(4);
                int quantity = rs.getInt(5);
                InputOrder io = new InputOrder(id, importer, totalprice, date, quantity);
                list.add(io);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    public boolean updateQuan(int num, String id) throws SQLException{
        int result=0;
        String sql = "UPDATE tblProduct SET _quantity=?  WHERE _id=?";
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setInt(1,num);
            prst.setString(2, id);
            result=prst.executeUpdate();
            prst.close();
        return result>0;
            
    }
    public ArrayList<ListProductIO> getContentOrder(String idOrder){
        ArrayList<ListProductIO> list = new ArrayList<>();
        String sql = "SELECT * FROM tblInputList WHERE _idOrder=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, idOrder);
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                String idO=rs.getString(1);
                String id=rs.getString(2);
                int quantity = rs.getInt(3);
                String price = rs.getString(4);
                String producer=rs.getString(5);
                String memory = rs.getString(6);
                ListProductIO lpio= new ListProductIO(idO, id, quantity, price, producer, memory);
                list.add(lpio);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    public ArrayList<OutputOrder> getOuputOrder(){
        ArrayList<OutputOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM tblOutputOrder";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString(1);
                String idcus= rs.getString(2);
                String date=rs.getString(3);
                int quantity = rs.getInt(4);
                String sale = rs.getString(5);
                String totalprice = rs.getString(6);
                String note = rs.getString(7);
                String cuspay=rs.getString(8);
                OutputOrder oo = new OutputOrder(id, idcus, date, quantity, sale, totalprice, note,cuspay);
                list.add(oo);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    public static void main(String[] args) {
        DataProcess dt=new DataProcess();
        dt.getCustomer();
    }
    public ArrayList<Customer> getCustomer(){
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM tblCustomer";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString(1);
                String name= rs.getString(2);
                String phone=rs.getString(3);
                String total = rs.getString(4);
                String rank = rs.getString(5);
                Customer cus = new Customer(id, name, phone, total, rank);
                list.add(cus);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    public ArrayList<CodeSale> getCodeSale(){
        ArrayList<CodeSale> list=new ArrayList<>();
        String sql="SELECT * FROM tblcodesale";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String code=rs.getString(1);
                String price=rs.getString(2);
                String status=rs.getString(3);
                CodeSale cs=new CodeSale(code, price, status);
                list.add(cs);  
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    public boolean addCustomer(String id, String name, String phone, String money, String rank){
        int result = 0;
        String sql="INSERT INTO tblCustomer VALUES (?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, name);
            prst.setString(3, phone);
            prst.setString(4, money);
            prst.setString(5, rank);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public boolean saveCus(String id, String money, String rank){
        int result=0;
        String sql = "UPDATE tblCustomer SET _total=?,_rank=?  WHERE _id=?";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, money);
            prst.setString(2, rank);
            prst.setString(3, id);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }
    public boolean addOPOrder(String id,String idcus, String date, int quantity, String sale, String totalamount,String note, String cuspay){
        int result = 0;
        String sql="INSERT INTO tblOutputOrder VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, idcus);
            prst.setString(3, date);
            prst.setInt(4, quantity);
            prst.setString(5, sale);
            prst.setString(6, totalamount);
            prst.setString(7, note);
            prst.setString(8, cuspay);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public boolean addOutputList(String idOrder, String idPr, int quantity, String amount){
        int result = 0;
        String sql="INSERT INTO tblOutputList VALUES (?,?,?,?)";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, idOrder);
            prst.setString(2, idPr);
            prst.setInt(3, quantity);
            prst.setString(4, amount);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result>0;
    }
    public boolean updateStatusCS(String code, String status){
        int result=0;
        String sql = "UPDATE tblcodesale SET _status=? WHERE _code=?";
        try {
            PreparedStatement prst=getConnection().prepareStatement(sql);
            prst.setString(1, status);
            prst.setString(2, code);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }
    public ArrayList<ListProductIO> getContentOPOrder(String idOP){
        ArrayList<ListProductIO> list = new ArrayList<>();
        String sql = "SELECT * FROM tblOutputList WHERE _idOP=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, idOP);
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                String idO=rs.getString(1);
                String id=rs.getString(2);
                int quantity = rs.getInt(3);
                String price = rs.getString(4);
                ListProductIO lpio= new ListProductIO(idO, id, quantity, price);
                list.add(lpio);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    public boolean deleteOutputOrder(String id)
    {
        int result=0;
        String sql="DELETE FROM tblOutputOrder WHERE _id=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, id);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result>0;
    }
    public boolean deleteOutputOrderPr(String id)
    {
        int result=0;
        String sql="DELETE FROM tblOutputList WHERE _idOP=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, id);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result>0;
    }
    public boolean addNewProducer(String pr, String info){
        int result=0;
        String sql="INSERT INTO tblProducer VALUES (?,?)";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareStatement(sql);
            prst.setString(1, pr);
            prst.setString(2, info);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return result>0;
    }
    public boolean addgiftcode(String code, String price, String status){
        int result=0;
        String sql="INSERT INTO tblcodesale VALUES (?,?,?)";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareStatement(sql);
            prst.setString(1, code);
            prst.setString(2, price);
            prst.setString(3, status);
            result=prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return result>0;
    }
}
