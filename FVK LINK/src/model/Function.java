/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author duong
 */
import Entity.InputOrder;
import Entity.ListProductIO;
import Entity.OutputOrder;
import model.DataProcess;
import java.util.ArrayList;
import Entity.ListProductIO;
import Entity.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Function {
    
    public ArrayList<String>getDayList(ArrayList<InputOrder> ip){
        ArrayList<String> list=new ArrayList<>();
        if(ip.size()>0){
        list.add(ip.get(0).getDate());
        for (int i = 0; i < ip.size(); i++) {
                if(!ip.get(i).getDate().equals(list.get(list.size()-1))){
                    list.add(ip.get(i).getDate());
        }
        }
        }
        return list;
    }
    public ArrayList<String> getDataDay(String day1, String day2) throws ParseException{
        Function f=new Function();
        DataProcess dt=new DataProcess();
        ArrayList<String> list=new ArrayList<>();
        ArrayList<InputOrder> ip=new ArrayList<>();
        for (int i = 0; i <f.checkDayin(f.dayList(day1, day2), f.getDayList(dt.getInputOrder())).size(); i++) {
            for (int j = 0; j < f.getIPPr(dt.getInputOrder(), f.checkDayin(f.dayList(day1, day2), f.getDayList(dt.getInputOrder())).get(i)).size(); j++) {
                ip.add(f.getIPPr(dt.getInputOrder(), f.checkDayin(f.dayList(day1, day2), f.getDayList(dt.getInputOrder())).get(i)).get(j)); 
            }
        }
        int quantity=0;
        int totalorder=ip.size();
        long totalaumont=0;
        for(InputOrder i:ip){
            quantity=quantity+i.getQuantity();
            totalaumont = totalaumont+Long.valueOf(i.getTotalprice());
        }
        list.add(0,String.valueOf(totalorder));
        list.add(1,String.valueOf(totalaumont));
        list.add(2,String.valueOf(quantity));
        return list;
    }
    public ArrayList<String> checkDayin(ArrayList<String> date, ArrayList<String> daylist){
            ArrayList<String> listday=date;
            listday.retainAll(daylist);
        return listday;
    }
    public ArrayList<InputOrder> getIPPr(ArrayList<InputOrder> ip, String day){
        ArrayList<InputOrder> list = new ArrayList<>();
        for(InputOrder l:ip){
            if(l.getDate().equals(day)){
                list.add(l);
            }
        }
        return list;
    }
    public ArrayList<String>getDayListOP(ArrayList<OutputOrder> op){
        ArrayList<String> list=new ArrayList<>();
        if(op.size()>0){
        list.add(op.get(0).getDate());
        for (int i = 0; i < op.size(); i++) {
                if(!op.get(i).getDate().equals(list.get(list.size()-1))){
                    list.add(op.get(i).getDate());
        }
        }
        }
        return list;
    }
    
    public ArrayList<OutputOrder> checkDayOP(ArrayList<OutputOrder> op, String day){
            ArrayList<OutputOrder> list=new ArrayList<>();
            for(OutputOrder i:op){
                if(i.getDate().equals(day)){
                    list.add(i);
                }
            }
        return list;
    }
    public ArrayList<ListProductIO> getProductOP(ArrayList<ListProductIO> lpio,String id){
        ArrayList<ListProductIO> list=new ArrayList<>();
        for(ListProductIO op:lpio){
            if(op.getIdIO().equals(id)){
                list.add(op);
            }
        }
        return list;
    }
    public ArrayList<String> dayList(String day1, String day2) throws ParseException{
        ArrayList<String> list=new ArrayList<>();
        if(!day1.equals(day2)){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        list.add(day1); 
        Date date1=format.parse(day1);
        Date date2=format.parse(day2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        boolean f=true;
        while(f){
                cal.add(Calendar.DATE, 1);
                if(cal.getTime().compareTo(date2)<0){
                    list.add(String.valueOf(format.format(cal.getTime())));
                }else{
                    f=false;
                    list.add(day2);
                }   
        }
        }else
            list.add(day1);
        return list;
    }
       private ArrayList<OutputOrder> getListOpOrder(ArrayList<OutputOrder> op,ArrayList<String> day){
           ArrayList<OutputOrder> list =new ArrayList<>();
           for (int i = 0; i < day.size(); i++) {
               for (int j = 0; j < op.size(); j++) {
                   if(day.get(i).equals(op.get(j).getDate())){
                       list.add(op.get(j));
                   }
               }
           }
        return list;
       }
       public ArrayList<String> getDataOPOrder(String day1, String day2) throws ParseException{
           Function f=new Function();
           DataProcess dt=new DataProcess();
           ArrayList<String> list =new ArrayList<>();
           ArrayList<OutputOrder> op=f.getListOpOrder(dt.getOuputOrder(), checkDayin(dayList(day1, day2), f.getDayListOP(dt.getOuputOrder())));
           int total=0;
           String quantityOrder=String.valueOf(op.size());
           long totalamount=0;
           for(OutputOrder opl:op){
               total=total+opl.getQuan();
               totalamount=totalamount+Long.valueOf(opl.getTotalaumount());
           }
           list.add(quantityOrder);
           list.add(String.valueOf(total));
           list.add(String.valueOf(totalamount));
        return list;   
       }
       public ArrayList<ListProductIO> getPrOP(String day1, String day2) throws ParseException{
           Function f=new Function();
           DataProcess dt=new DataProcess();
           ArrayList<ListProductIO> lpr = new ArrayList<>();
           ArrayList<String> list =new ArrayList<>();
           ArrayList<OutputOrder> op=f.getListOpOrder(dt.getOuputOrder(), checkDayin(dayList(day1, day2), f.getDayListOP(dt.getOuputOrder())));
        for (OutputOrder op1 : op) {
            for(ListProductIO l:dt.getContentOPOrder(op1.getId())){
                lpr.add(l);
            }
        }
        return lpr;
       }
       
}
