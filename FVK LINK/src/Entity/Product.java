/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author duong
 */
public class Product implements Serializable{
    private String id;
    private String name;
    private String producer;
    private String type;
    private String memory;
    private String pricein;  
    private String priceout;
    private int quantity;
    private String guarantee;
    private String coin;
    private String info;
    private byte[] image;

    public Product() {
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPricein() {
        return pricein;
    }

    public void setPricein(String pricein) {
        this.pricein = pricein;
    }

    public String getPriceout() {
        return priceout;
    }

    public void setPriceout(String priceout) {
        this.priceout = priceout;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product(String id, String name, String producer, String type, String memory, String pricein, String priceout, int quantity, String guarantee, String coin, String info, byte[] image) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.type = type;
        this.memory = memory;
        this.pricein = pricein;
        this.priceout = priceout;
        this.quantity = quantity;
        this.guarantee = guarantee;
        this.coin = coin;
        this.info = info;
        this.image = image;
    }

}
