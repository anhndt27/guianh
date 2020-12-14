/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class HocSinh extends  Nguoi{
    
    private String maHocSinh;
    private String sdtPhuHuynh;
    private Lop lop;
    private Khoi khoi;
    private KhoaHoc khoahoc;
    ArrayList<LoiViPham> listLoi; 
    public HocSinh(String maHocSinh, String sdtPhuHuynh, Lop lop, KhoaHoc khoahoc, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(hoTen, diaChi, ngaySinh);
        this.maHocSinh = maHocSinh;
        this.sdtPhuHuynh = sdtPhuHuynh;
        this.lop = lop;
        this.khoahoc = khoahoc;
        listLoi = new ArrayList();
    }
    public HocSinh(HocSinh e){
        super(e);
        this.maHocSinh = e.maHocSinh;
        this.sdtPhuHuynh = e.sdtPhuHuynh;
        this.lop = e.lop;
        this.khoi = e.khoi;
        this.khoahoc = e.khoahoc;
    }
    
    public HocSinh(HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(hoTen, diaChi, ngaySinh);
        listLoi = new ArrayList();
    }

    public HocSinh() {
        listLoi = new ArrayList();
    }
    
    public Khoi getKhoi() {
        return khoi;
    }

    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }
    
    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public void setSdtPhuHuynh(String sdtPhuHuynh) {
        this.sdtPhuHuynh = sdtPhuHuynh;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public void setKhoahoc(KhoaHoc khoahoc) {
        this.khoahoc = khoahoc;
    }

    public ArrayList<LoiViPham> getListLoi() {
        return listLoi;
    }

    public void setListLoi(ArrayList<LoiViPham> listLoi) {
        this.listLoi = listLoi;
    }
    public void addLoi(LoiViPham e){
        this.listLoi.add(e);
    }
    
    

     

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public Lop getLop() {
        return lop;
    }

    public String getSdtPhuHuynh() {
        return sdtPhuHuynh;
    }


    public KhoaHoc getKhoahoc() {
        return khoahoc;
    }
    
    
}
