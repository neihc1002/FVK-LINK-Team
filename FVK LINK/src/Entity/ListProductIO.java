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
public class ListProductIO {
    private String idIO;
    private String idPr;
    private int Quantity;
    private String price;
    private String producer;
    private String memory;

    public ListProductIO(String idIO, String idPr, int Quantity, String price) {
        this.idIO = idIO;
        this.idPr = idPr;
        this.Quantity = Quantity;
        this.price = price;
    }

    public ListProductIO(String idIO, String idPr, int Quantity, String price, String producer, String memory) {
        this.idIO = idIO;
        this.idPr = idPr;
        this.Quantity = Quantity;
        this.price = price;
        this.producer = producer;
        this.memory = memory;
    }

    public String getIdIO() {
        return idIO;
    }

    public void setIdIO(String idIO) {
        this.idIO = idIO;
    }

    public String getIdPr() {
        return idPr;
    }

    public void setIdPr(String idPr) {
        this.idPr = idPr;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public ListProductIO() {
    }
    
}
