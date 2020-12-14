/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tuan2
 */
public class Tuan {
    private String tenTuan;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Lop lop;
    private float diem;
    private float soDiemA;
    private float soDiemB;
    private float soDiemC;
    private float soDiemD;
    private float diemVeSinh;
    private float diemNeNep;
    private String moTa;
    public Tuan() {
    }
    public Tuan(Tuan e){
        this.diem = e.diem;
        this.diemNeNep = e.diemNeNep;
        this.diemVeSinh = e.diemVeSinh;
        this.lop = e.lop;
        this.ngayBatDau = e.ngayBatDau;
        this.ngayKetThuc = e.ngayKetThuc;
        this.soDiemA = e.soDiemA;
        this.soDiemB = e.soDiemB;
        this.soDiemC = e.soDiemC;
        this.soDiemD = e.soDiemD;
        this.moTa = e.moTa;
        this.tenTuan = e.tenTuan;
    }
    public Tuan(String tenTuan, Lop lop, float diem, float soDiemA, float soDiemB, float soDiemC, float soDiemD, float diemVeSinh, float diemNeNep) {
        this.tenTuan = tenTuan;
        this.lop = lop;
        this.diem = diem;
        this.soDiemA = soDiemA;
        this.soDiemB = soDiemB;
        this.soDiemC = soDiemC;
        this.soDiemD = soDiemD;
        this.diemVeSinh = diemVeSinh;
        this.diemNeNep = diemNeNep;
        this.moTa = "";
    }

    public Tuan(String tenTuan, Date ngayBatDau, Date ngayKetThuc, Lop lop, float diem, float soDiemA, float soDiemB, float soDiemC, float soDiemD, float diemVeSinh, float diemNeNep) {
        this.tenTuan = tenTuan;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lop = lop;
        this.diem = diem;
        this.soDiemA = soDiemA;
        this.soDiemB = soDiemB;
        this.soDiemC = soDiemC;
        this.soDiemD = soDiemD;
        this.diemVeSinh = diemVeSinh;
        this.diemNeNep = diemNeNep;
        this.moTa = "";
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
   
    
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public String getTenTuan() {
        return tenTuan;
    }

    public void setTenTuan(String tenTuan) {
        this.tenTuan = tenTuan;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public float getSoDiemA() {
        return soDiemA;
    }

    public void setSoDiemA(float soDiemA) {
        this.soDiemA = soDiemA;
    }

    public float getSoDiemB() {
        return soDiemB;
    }

    public void setSoDiemB(float soDiemB) {
        this.soDiemB = soDiemB;
    }

    public float getSoDiemC() {
        return soDiemC;
    }

    public void setSoDiemC(float soDiemC) {
        this.soDiemC = soDiemC;
    }

    public float getSoDiemD() {
        return soDiemD;
    }

    public void setSoDiemD(float soDiemD) {
        this.soDiemD = soDiemD;
    }

    public float getDiemVeSinh() {
        return diemVeSinh;
    }

    public void setDiemVeSinh(float diemVeSinh) {
        this.diemVeSinh = diemVeSinh;
    }

    public float getDiemNeNep() {
        return diemNeNep;
    }

    public void setDiemNeNep(float diemNeNep) {
        this.diemNeNep = diemNeNep;
    }
    
    
}
