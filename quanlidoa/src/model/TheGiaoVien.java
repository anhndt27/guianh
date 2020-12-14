/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class TheGiaoVien extends GiaoVien{
    private ImageIcon hinhAnh;

    public TheGiaoVien() {
        super(null, null, null, null, null, null, null);
    }
    
    public TheGiaoVien(ImageIcon hinhAnh, String maGiaoVien, ArrayList<HocVan> hocVan, ToChuyenMon toChuyenMon, String monGiangDay, ChucVu chucVu, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(maGiaoVien, hocVan, toChuyenMon, monGiangDay, chucVu, hoTen, diaChi, ngaySinh);
        this.hinhAnh = hinhAnh;
    }

    public TheGiaoVien(ImageIcon hinhAnh, String maGiaoVien, ToChuyenMon toChuyenMon, String monGiangDay, ChucVu chucVu, HoTen hoTen, DiaChi diaChi, Date ngaySinh) {
        super(maGiaoVien, toChuyenMon, monGiangDay, chucVu, hoTen, diaChi, ngaySinh);
        this.hinhAnh = hinhAnh;
    }

    public TheGiaoVien( String maGiaoVien, ToChuyenMon toChuyenMon, String monGiangDay, int ID, HoTen hoTen, DiaChi diaChi, Date ngaySinh, String email, String gioiTinh) {
        super(maGiaoVien, toChuyenMon, monGiangDay, ID, hoTen, diaChi, ngaySinh, email, gioiTinh);
    }

   

    
    public void sethinhAnh(FileInputStream in){
        try {
            byte[] e = new byte[10240];
            int read = in.read(e);
            System.out.println("da doc duoc anh");
            this.hinhAnh = new ImageIcon(e);
        } catch (IOException ex) {
            Logger.getLogger(TheGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sethinhAnh(byte[] e){
        try {
            this.hinhAnh = new ImageIcon(e);
        } catch (Exception ex) {
            Logger.getLogger(TheGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sethinhAnh(InputStream in){
        try {
            byte[] e = new byte[10240];
            int read = in.read(e);
            this.hinhAnh = new ImageIcon(e);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(TheGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ImageIcon getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(ImageIcon hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    
    
}
