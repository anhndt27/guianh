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
public class Truong {
    private String ten;
    private DiaChi diaChi;
    private String soDienThoai;

    public Truong(String ten, DiaChi diaChi, String soDienThoai) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    
}
