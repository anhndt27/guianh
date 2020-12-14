/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class TheHocSinh extends HocSinh{
    private ImageIcon hinhAnh;

    public TheHocSinh(ImageIcon hinhAnh, String maHocSinh, String sdtPhuHuynh, Lop lop, KhoaHoc khoahoc, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(maHocSinh, sdtPhuHuynh, lop, khoahoc, hoTen, diaChi, ngaySinh);
        this.hinhAnh = hinhAnh;
    }
    public TheHocSinh(TheHocSinh e){
        super(e);
        this.hinhAnh = e.hinhAnh;
       
    }
    public ImageIcon getHinhAnh() {
        return hinhAnh;
    }
    

    public TheHocSinh(String maHocSinh, String sdtPhuHuynh, Lop lop, KhoaHoc khoahoc, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(maHocSinh, sdtPhuHuynh, lop, khoahoc, hoTen, diaChi, ngaySinh);
    }

    public TheHocSinh() {
    }
     public void sethinhAnh(byte[] e){
        try {
            this.hinhAnh = new ImageIcon(e);
        } catch (Exception ex) {
            Logger.getLogger(TheGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

   
    
    
}
