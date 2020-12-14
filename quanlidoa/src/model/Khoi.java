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
public class Khoi {
    private String tenKhoi;
    private int soLuongHocSinh;

    public Khoi(String tenKhoi, int soLuongHocSinh) {
        this.tenKhoi = tenKhoi;
        this.soLuongHocSinh = soLuongHocSinh;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public int getSoLuongHocSinh() {
        return soLuongHocSinh;
    }
    
}
