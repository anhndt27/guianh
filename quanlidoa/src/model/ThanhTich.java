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
public class ThanhTich {
    private String loaiThanhTich;
    private String cap;
    private String moTaChiTiet;

    public ThanhTich(String loaiThanhTich, String cap, String moTaChiTiet) {
        this.loaiThanhTich = loaiThanhTich;
        this.cap = cap;
        this.moTaChiTiet = moTaChiTiet;
    }

    public String getLoaiThanhTich() {
        return loaiThanhTich;
    }

    public String getCap() {
        return cap;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }
    
    
}
