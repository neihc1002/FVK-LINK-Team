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
public class Function {
    public ArrayList<String>getDayList(ArrayList<InputOrder> ip){
        ArrayList<String> list=new ArrayList<>();
        list.add(ip.get(0).getDate());
        for (int i = 0; i < ip.size(); i++) {
                if(!ip.get(i).getDate().equals(list.get(list.size()-1))){
                    list.add(ip.get(i).getDate());
        }
        }
        if(list.size()>7){
            list.remove(0);
        } 
        return list;
    }
    public ArrayList<String> getDataDay(ArrayList<InputOrder> ip){
        ArrayList<String> list=new ArrayList<>();
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
    public ArrayList<InputOrder> checkDay(ArrayList<InputOrder> ip, String day){
            ArrayList<InputOrder> list=new ArrayList<>();
            for(InputOrder i:ip){
                if(i.getDate().equals(day)){
                    list.add(i);
                }
            }
        return list;
    }
    public ArrayList<String>getDayListOP(ArrayList<OutputOrder> op){
        ArrayList<String> list=new ArrayList<>();
        list.add(op.get(0).getDate());
        for (int i = 0; i < op.size(); i++) {
                if(!op.get(i).getDate().equals(list.get(list.size()-1))){
                    list.add(op.get(i).getDate());
        }
        }
        if(list.size()>7){
            list.remove(0);
        } 
        return list;
    }
    public static void main(String[] args) {
        
        Function f=new Function();
        DataProcess dt=new DataProcess();
        for (int i = 0; i <f.getDayListOP(dt.getOuputOrder()).size(); i++) {
            System.out.println(f.getDayListOP(dt.getOuputOrder()).get(i));
        }
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
}
