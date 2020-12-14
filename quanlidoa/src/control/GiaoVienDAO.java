/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.GiaoVien;
import model.HoTen;
import model.Nguoi;
import model.TheGiaoVien;
import model.ToChuyenMon;

/**
 *
 * @author tuan2
 */

public class GiaoVienDAO {
    public int updateGiaoVien(GiaoVien e,String pathAnh){
        try {
            System.out.println(pathAnh);
            NguoiDao nguoiDAO = new NguoiDao();
            int tblNguoi = nguoiDAO.upDateNguoi(e);
            InputStream in = new FileInputStream(pathAnh);
            String url = "INSERT INTO tblgiaovien (maGiaoVien, monGiangDay, hinhAnh, tblToChuyenMonID, tblNguoiID) VALUES (?, ?, ?, ?, ?);";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
            prstm.setString(1, e.getMaGiaoVien());
            prstm.setString(2, e.getMonGiangDay());
            prstm.setBlob(3, in);
            prstm.setInt(4, e.getToChuyenMon().getID());
            prstm.setInt(5, tblNguoi);
            int res = prstm.executeUpdate();
            if(res >0){
               ResultSet  result = prstm.getGeneratedKeys();
               while(result.next()){
                   return result.getInt(1);
               }
            }
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public GiaoVien getGiaoVienbyID(int ID){
        String url = "SELECT tblnguoi.ID,tblgiaovien.maGiaoVien,tblhoten.ho,tblhoten.tenDem,tblhoten.ten,\n" +
        "tbldiachi.soNha,tbldiachi.duong,tbldiachi.thon,tbldiachi.xa_Phuong,\n" +
        "tbldiachi.huyen_Quan,tbldiachi.tinh_ThanhPho,\n" +
        "tblgiaovien.monGiangDay,tblgiaovien.hinhAnh,\n" +
        "tblnguoi.ngaySinh,tblnguoi.gioitinh,tblnguoi.email,tbltochuyenmon.ten\n" +
        "FROM	tblgiaovien,tblnguoi,tblhoten,tbldiachi,tbltochuyenmon  \n" +
        "WHERE	tblgiaovien.tblnguoiID = tblnguoi.ID\n" +
        "AND		tblhoten.ID = tblnguoi.tblHoTenID\n" +
        "AND		tbldiachi.ID = tblnguoi.tblDiaChiID\n" +
        "AND 	tblgiaovien.tblToChuyenMonID = tbltochuyenmon.ID\n"+
        "AND 	tblgiaovien.ID = ?";
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1, ID);
            ResultSet res = prstm.executeQuery();
            
            while(res.next()){
                TheGiaoVien e = new TheGiaoVien();
                e.setID(res.getInt(1));
                e.setMaGiaoVien(res.getString(2));
                HoTen hoten = new HoTen(res.getString(3), res.getString(4),res.getString(5));
                e.setHoTen(hoten);
                DiaChi diaChi = new DiaChi(res.getString(11), res.getString(10), res.getString(9), res.getString(8), res.getString(7), res.getString(6));
                e.setDiaChi(diaChi);
                e.setMonGiangDay(res.getString(12));
                Blob blob = res.getBlob("hinhAnh");
                int len = (int) blob.length();
                byte[] buf = blob.getBytes(1, len);
                e.sethinhAnh(buf);
                e.setNgaySinh((java.util.Date)res.getDate(14));
                e.setGioiTinh(res.getString(15));
                e.setEmail(res.getString(16));
                ToChuyenMon to = new ToChuyenMon(res.getString(17), "");
                e.setToChuyenMon(to);
                return e;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new TheGiaoVien();
        
    }
    public ArrayList<TheGiaoVien> getGiaoVien(String ten, String tenDem, String ho ){
        ArrayList<TheGiaoVien> ret =  new ArrayList();
        String url = "SELECT tblnguoi.ID,tblgiaovien.maGiaoVien,tblhoten.ho,tblhoten.tenDem,tblhoten.ten,\n" +
        "tbldiachi.soNha,tbldiachi.duong,tbldiachi.thon,tbldiachi.xa_Phuong,\n" +
        "tbldiachi.huyen_Quan,tbldiachi.tinh_ThanhPho,\n" +
        "tblgiaovien.monGiangDay,tblgiaovien.hinhAnh,\n" +
        "tblnguoi.ngaySinh,tblnguoi.gioitinh,tblnguoi.email,tbltochuyenmon.ten\n" +
        "FROM	tblgiaovien,tblnguoi,tblhoten,tbldiachi,tbltochuyenmon  \n" +
        "WHERE	tblgiaovien.tblnguoiID = tblnguoi.ID\n" +
        "AND		tblhoten.ID = tblnguoi.tblHoTenID\n" +
        "AND		tbldiachi.ID = tblnguoi.tblDiaChiID\n" +
        "AND 	tblgiaovien.tblToChuyenMonID = tbltochuyenmon.ID\n"+
        "AND 	tblhoten.ho LIKE '%"+ho+"%'\n" +
        "AND 	tblhoten.tenDem LIKE '%"+tenDem+"%'\n" +
        "AND 	tblhoten.ten LIKE '%"+ten+"%' ";
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                TheGiaoVien e = new TheGiaoVien();
                e.setID(res.getInt(1));
                e.setMaGiaoVien(res.getString(2));
                HoTen hoten = new HoTen(res.getString(3), res.getString(4),res.getString(5));
                e.setHoTen(hoten);
                DiaChi diaChi = new DiaChi(res.getString(11), res.getString(10), res.getString(9), res.getString(8), res.getString(7), res.getString(6));
                e.setDiaChi(diaChi);
                e.setMonGiangDay(res.getString(12));
                Blob blob = res.getBlob("hinhAnh");
                int len = (int) blob.length();
                byte[] buf = blob.getBytes(1, len);
                e.sethinhAnh(buf);
                e.setNgaySinh((java.util.Date)res.getDate(14));
                e.setGioiTinh(res.getString(15));
                e.setEmail(res.getString(16));
                ToChuyenMon to = new ToChuyenMon(res.getString(17), "");
                e.setToChuyenMon(to);
                ret.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(ret,(o1,o2)->{
            return o1.getHoTen().toString().compareTo( o2.getHoTen().toString());
        }); 
        return ret;
    }
    
}
