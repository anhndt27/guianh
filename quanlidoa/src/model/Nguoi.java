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

/**
 *
 * @author dell
 */
public class Nguoi {
    private int ID;
    private HoTen hoTen;
    private DiaChi diaChi;
    private Date ngaySinh;
    private String email;
    private String gioiTinh;
    private DanToc danToc;
    
    public Nguoi(int ID, HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email, String gioiTinh) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }
    public Nguoi(Nguoi e){
        this.ID = e.ID;
        this.danToc = e.danToc;
        this.diaChi = e.diaChi;
        this.email = e.email;
        this.gioiTinh = e.gioiTinh;
        this.hoTen = e.hoTen;
        this.ngaySinh = e.ngaySinh;
        this.danToc = e.danToc;
    }

    public Nguoi(int ID, HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public Nguoi(HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }
    public Nguoi(HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
    }

    public Nguoi() {
    }

    public DanToc getDanToc() {
        return danToc;
    }

    public void setDanToc(DanToc danToc) {
        this.danToc = danToc;
    }
    
   
    
    public HoTen getHoTen() {
        return hoTen;
    }

    public void setHoTen(HoTen hoTen) {
        this.hoTen = hoTen;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public void setNgaySinh(String ngaySinh) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            this.ngaySinh = formatter.parse(ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(Nguoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
}
