/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class GiaoVien extends Nguoi{
    
    private String maGiaoVien;
    private ArrayList<HocVan> hocVan;
    private ToChuyenMon toChuyenMon;
    private String monGiangDay;
    private ChucVu chucVu; 

    public GiaoVien() {
    }
   
    public GiaoVien(String maGiaoVien, ArrayList<HocVan> hocVan, ToChuyenMon toChuyenMon, String monGiangDay, ChucVu chucVu, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(hoTen, diaChi, ngaySinh);
        this.maGiaoVien = maGiaoVien;
        this.hocVan = hocVan;
        this.toChuyenMon = toChuyenMon;
        this.monGiangDay = monGiangDay;
        this.chucVu = chucVu;
    }

    public GiaoVien(String maGiaoVien, ToChuyenMon toChuyenMon, String monGiangDay, int ID, HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email, String gioiTinh) {
        super(ID, hoTen, diaChi, ngaySinh, email, gioiTinh);
        this.maGiaoVien = maGiaoVien;
        this.toChuyenMon = toChuyenMon;
        this.monGiangDay = monGiangDay;
    }
    

    public GiaoVien(String maGiaoVien, ToChuyenMon toChuyenMon, String monGiangDay, ChucVu chucVu, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(hoTen, diaChi, ngaySinh);
        this.maGiaoVien = maGiaoVien;
        this.toChuyenMon = toChuyenMon;
        this.monGiangDay = monGiangDay;
        this.chucVu = chucVu;
        this.hocVan = new ArrayList<>();
    }

    public GiaoVien(String maGiaoVien, ToChuyenMon toChuyenMon, String monGiangDay, ChucVu chucVu, HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email) {
        super(hoTen, diaChi, ngaySinh, email);
        this.maGiaoVien = maGiaoVien;
        this.hocVan = hocVan;
        this.toChuyenMon = toChuyenMon;
        this.monGiangDay = monGiangDay;
        this.chucVu = chucVu;
    }
    
    public void addHocVan(HocVan e){
        this.hocVan.add(e);
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public void setHocVan(ArrayList<HocVan> hocVan) {
        this.hocVan = hocVan;
    }

    public void setToChuyenMon(ToChuyenMon toChuyenMon) {
        this.toChuyenMon = toChuyenMon;
    }

    public void setMonGiangDay(String monGiangDay) {
        this.monGiangDay = monGiangDay;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }
    

    public ArrayList<HocVan> getHocVan() {
        return hocVan;
    }

    public ToChuyenMon getToChuyenMon() {
        return toChuyenMon;
    }

    public String getMonGiangDay() {
        return monGiangDay;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }
    
    
}
