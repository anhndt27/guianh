/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.VNCharacterUtils;

/**
 *
 * @author dell
 */
public class HoTen {
    private String ho;
    private String tenDem;
    private String ten;

    public HoTen(String ho, String tenDem, String ten) {
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
    }
    public HoTen(HoTen e){
        this.ho = e.ho;
        this.tenDem = e.tenDem;
        this.ten = e.ten;
    }
    public String getHo() {
        return ho;
    }

    public String getTenDem() {
        return tenDem;
    }
    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        VNCharacterUtils d = new VNCharacterUtils();
        return d.removeAccent(ten) +" "+d.removeAccent(ho) +" "+d.removeAccent(tenDem);
    }

    public String ToString() {
        return ho +" " + tenDem + " " +ten;
    }
    

    
}
