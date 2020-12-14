/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class DoanVien extends TheHocSinh{
    private int maDoanVien;
    private ArrayList<PhiDoan> phiDoan;
    private ArrayList<ThanhTich> thanhTich;
    private  Date ngayVaoDoan;

    public DoanVien() {
    }
    
  
    public int getMaDoanVien() {
        return maDoanVien;
    }
    
    public ArrayList<PhiDoan> getPhiDoan() {
        return phiDoan;
    }

    public ArrayList<ThanhTich> getThanhTich() {
        return thanhTich;
    }

    public Date getNgayVaoDoan() {
        return ngayVaoDoan;
    }

    public void setNgayVaoDoan(Date ngayVaoDoan) {
        this.ngayVaoDoan = ngayVaoDoan;
    }
    
    public DoanVien(TheHocSinh e,int maDoanVien){
        super(e);
        this.maDoanVien = maDoanVien;
    }
    
    public void addPhiDoan(PhiDoan e){
        this.phiDoan.add(e);
    }
    
    public void addThanhTich(ThanhTich e){
        this.thanhTich.add(e);
    }

    public void setMaDoanVien(int maDoanVien) {
        this.maDoanVien = maDoanVien;
    }

    public void setPhiDoan(ArrayList<PhiDoan> phiDoan) {
        this.phiDoan = phiDoan;
    }

    public void setThanhTich(ArrayList<ThanhTich> thanhTich) {
        this.thanhTich = thanhTich;
    }
    
            
}
