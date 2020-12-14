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
public class LoiViPham {
    int ID;
    private String TenLoi;
    private Date ngayPhamLoi;
    
    public LoiViPham() {
    }

    public LoiViPham(int ID, String TenLoi, Date ngayPhamLoi) {
        this.ID = ID;
        this.TenLoi = TenLoi;
        this.ngayPhamLoi = ngayPhamLoi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public LoiViPham(String TenLoi, Date ngayPhamLoi) {
        this.TenLoi = TenLoi;
        this.ngayPhamLoi = ngayPhamLoi;
    }

    public String getTenLoi() {
        return TenLoi;
    }

    public void setTenLoi(String TenLoi) {
        this.TenLoi = TenLoi;
    }

    public Date getNgayPhamLoi() {
        return ngayPhamLoi;
    }

    public void setNgayPhamLoi(Date ngayPhamLoi) {
        this.ngayPhamLoi = ngayPhamLoi;
    }
    
}
