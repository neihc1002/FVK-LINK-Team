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
public class OutputOrder {
    private String id;
    private String idcus;
    private String date;
    private int quan;
    private String sale;
    private String totalaumount;
    private String note;
    private String cuspay;

    public OutputOrder(String id, String idcus, String date, int quan, String sale, String totalaumount, String note, String cuspay) {
        this.id = id;
        this.idcus = idcus;
        this.date = date;
        this.quan = quan;
        this.sale = sale;
        this.totalaumount = totalaumount;
        this.note = note;
        this.cuspay = cuspay;
    }

    public String getCuspay() {
        return cuspay;
    }

    public void setCuspay(String cuspay) {
        this.cuspay = cuspay;
    }

    public OutputOrder(String id, String idcus, String date, int quan, String sale, String totalaumount, String note) {
        this.id = id;
        this.idcus = idcus;
        this.date = date;
        this.quan = quan;
        this.sale = sale;
        this.totalaumount = totalaumount;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcus() {
        return idcus;
    }

    public void setIdcus(String idcus) {
        this.idcus = idcus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getTotalaumount() {
        return totalaumount;
    }

    public void setTotalaumount(String totalaumount) {
        this.totalaumount = totalaumount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OutputOrder() {
    }
}
