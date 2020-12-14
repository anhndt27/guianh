/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

/**
 *
 * @author dell
 */
public class KhoaHoc {
    private int ID;
    private String tenKhoaHoc;
    private Date batDau;
    private Date ketThuc;

    public KhoaHoc(Date batDau, Date ketThuc) {
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }

    public KhoaHoc(int ID, String tenKhoaHoc, Date batDau, Date ketThuc) {
        this.ID = ID;
        this.tenKhoaHoc = tenKhoaHoc;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }
    
    public KhoaHoc(String s) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String[] mang = s.split("-");
            Date batDau = formatter.parse("01/8/"+mang[0]);
            Date ketThuc = formatter.parse("01/8/"+mang[1]);
            this.batDau = batDau;
            this.ketThuc = ketThuc;
        } catch (ParseException ex) {
            Logger.getLogger(KhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Date getBatDau() {
        return batDau;
    }

    public Date getKetThuc() {
        return ketThuc;
    }
    
    
}
