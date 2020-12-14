/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Lop {
    int ID;
    private Khoi khoi;
    private String tenLop;
    private int soLuong;
    private GiaoVien giaoVienChuNhiem;

    public Lop(Khoi khoi, String tenLop, int soLuong, GiaoVien giaoVienChuNhiem) {
        this.khoi = khoi;
        this.tenLop = tenLop;
        this.soLuong = soLuong;
        this.giaoVienChuNhiem = giaoVienChuNhiem;
    }

    public Lop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Khoi getKhoi() {
        return khoi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaoVienChuNhiem(GiaoVien giaoVienChuNhiem) {
        this.giaoVienChuNhiem = giaoVienChuNhiem;
    }
    
    public int getSoLuong() {
        return soLuong;
    }

    public GiaoVien getGiaoVienChuNhiem() {
        return giaoVienChuNhiem;
    }
    
    
}
