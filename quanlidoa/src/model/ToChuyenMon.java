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
public class ToChuyenMon {
    private int ID;
    private String tenTo;
    private String diaChiPhong;

    public ToChuyenMon(String tenTo, String diaChiPhong) {
        this.tenTo = tenTo;
        this.diaChiPhong = diaChiPhong;
    }

    public String getTenTo() {
        return tenTo;
    }



    public String getDiaChiPhong() {
        return diaChiPhong;
    }

    public ToChuyenMon(int ID, String tenTo, String diaChiPhong) {
        this.ID = ID;
        this.tenTo = tenTo;
        this.diaChiPhong = diaChiPhong;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}
