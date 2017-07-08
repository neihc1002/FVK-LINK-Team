/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author duong
 */
public class inputList {
    private String id;
    private String name;
    private String price;
    private int number;
    private String memory;
    private String producer;
    private String amount;

    public inputList() {
    }

    public inputList(String id, String name, String price, int number, String memory, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.memory = memory;
        this.producer = producer;
    }

    public inputList(String id, String name, String price, int number, String memory, String producer, String amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.memory = memory;
        this.producer = producer;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    
}
