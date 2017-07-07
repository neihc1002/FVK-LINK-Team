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
    private String pricein;
    private int number;
    private String memory;
    private String producer;

    public inputList() {
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

    public String getPricein() {
        return pricein;
    }

    public void setPricein(String pricein) {
        this.pricein = pricein;
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

    public inputList(String id, String name, String pricein, int number, String memory, String producer) {
        this.id = id;
        this.name = name;
        this.pricein = pricein;
        this.number = number;
        this.memory = memory;
        this.producer = producer;
    }

   
}
