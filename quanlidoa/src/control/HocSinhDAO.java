/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.DoanVien;
import model.HoTen;
import model.HocSinh;
import model.KhoaHoc;
import model.Khoi;
import model.Lop;
import model.TheGiaoVien;
import model.TheHocSinh;
import model.ToChuyenMon;

/**
 *
 * @author tuan2
 */
public class HocSinhDAO {

    public HocSinhDAO() {
    }
    public int updateDoanVien(DoanVien e){
        try {
            //UPDATE `quanlidoan`.`tblhocsinh` SET `ngayVaoDoan` = '2019-06-12', `maDoanVien` = '134' WHERE (`ID` = '47');
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String url = "UPDATE tblhocsinh SET ngayVaoDoan = ?, maDoanVien = ? WHERE (tblNguoiID = ?)";
            DAO dao = new DAO();
           
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1,formatter.format(e.getNgayVaoDoan()));
            prstm.setInt(2, e.getMaDoanVien());
            prstm.setInt(3, e.getID());
            int res = prstm.executeUpdate();
           
            return res;
            
            
          
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int removeHocSinh(HocSinh e){
        //DELETE FROM `quanlidoan`.`tblhocsinh` WHERE (`ID` = '43');
        try {
            //UPDATE `quanlidoan`.`tblhocsinh` SET `ngayVaoDoan` = '2019-06-12', `maDoanVien` = '134' WHERE (`ID` = '47');

            String url = "UPDATE tblhocsinh SET daxoa = ? WHERE (tblNguoiID = ?);";
            DAO dao = new DAO();
            System.out.println(e.getID());
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1,1);
            prstm.setInt(2,e.getID());
            int res = prstm.executeUpdate();
           
            return res;
            
            
          
        } catch (SQLException ex) {
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return -1;
    }
    public int getMaxMaDoanVien(){
        String url = "SELECT MAX( maDoanVien )  FROM tblhocsinh ;";
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public ArrayList<DoanVien> getDoanVien(String ten, String tenDem, String ho,String add){
        ArrayList<DoanVien> ret =  new ArrayList();
        String url = "SELECT tblnguoi.ID,tblhocsinh.maHocSinh,tblhoten.ho,tblhoten.tenDem,tblhoten.ten,\n" +
        "tbldiachi.soNha,tbldiachi.duong,tbldiachi.thon,tbldiachi.xa_Phuong,\n" +
        "tbldiachi.huyen_Quan,tbldiachi.tinh_ThanhPho,tblkhoi.tenKhoi,tbllop.tenLop,\n" +
        "tblhocsinh.hinhAnh,\n" +
        "tblnguoi.ngaySinh,tblnguoi.gioitinh,tblnguoi.email,tblHocSinh.sdtPhuHuynh,\n" +
        "tblhocsinh.maDoanVien \n" +
        "FROM	tblhocsinh,tblnguoi,tblhoten,tbldiachi,tblkhoi,tbllop\n" +
        "WHERE	tblhocsinh.tblnguoiID = tblnguoi.ID\n" +
        "AND		tblhoten.ID = tblnguoi.tblHoTenID\n" +
        "AND		tbldiachi.ID = tblnguoi.tblDiaChiID\n" +
        "AND		tblhocsinh.tblLopID = tbllop.ID\n" +
        "AND		tbllop.tblKhoiID = tblkhoi.ID\n" +
        "AND		tblhocsinh.daxoa = 0\n" +
        "AND		tblhocsinh.maDoanVien is not null\n" +
        "AND 	tblhoten.ho LIKE '%"+ho+"%'\n" +
        "AND 	tblhoten.tenDem LIKE '%"+tenDem+"%'\n" +
        "AND 	tblhoten.ten LIKE '%"+ten+"%' "+add;
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                DoanVien e = new DoanVien();
                e.setID(res.getInt(1));
                e.setMaHocSinh(res.getString(2));
                HoTen hoten = new HoTen(res.getString(3), res.getString(4),res.getString(5));
                e.setHoTen(hoten);
                DiaChi diaChi = new DiaChi(res.getString(11), res.getString(10), res.getString(9), res.getString(8), res.getString(7), res.getString(6));
                e.setDiaChi(diaChi);
                e.setKhoi( new Khoi( res.getString(12), 0));
                e.setLop(new Lop(res.getString(13)));
                Blob blob = res.getBlob("hinhAnh");
                if(blob != null){
                    int len = (int) blob.length();
                    byte[] buf = blob.getBytes(1, len);
                    e.sethinhAnh(buf);
                }
                e.setNgaySinh((java.util.Date)res.getDate(15));
                e.setGioiTinh(res.getString(16));
                e.setEmail(res.getString(17));
                e.setSdtPhuHuynh(res.getString(18));
                e.setMaDoanVien(res.getInt(19));
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
    public int seachID(String e){
         try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String url = "SELECT ID FROM tblhocsinh  where maHocSinh = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1, e);
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
                int ret = res.getInt(1);
                return ret;
            }
           
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return -1;
    
    }
    //INSERT INTO `quanlidoan`.`tblhocsinh` (`maHocSinh`, `sdtPhuHuynh`, `maDoanVien`, `tblLopID`, `tblKhoaHocID`, `tblNguoiID`) VALUES ('?', '?', '', '?', '?', '?');
    public int insertHocSinh(HocSinh hs){
        if(seachID(hs.getMaHocSinh()) > 0) return -2;
        try{
            DAO dao = new DAO();
            NguoiDao nguoiDAO = new NguoiDao();
            int tblNguoiID = nguoiDAO.upDateNguoi(hs);
            KhoaHocDAO khoahocDAO = new KhoaHocDAO();
            int tblKhoaHoc = khoahocDAO.insertKhoaHoc(hs.getKhoahoc());
            LopDAO lopDAO = new LopDAO();
            int tblLop = lopDAO.seachID(hs.getLop());
            String url = "INSERT INTO tblhocsinh (maHocSinh, sdtPhuHuynh, tblLopID, tblKhoaHocID, tblNguoiID) VALUES (?, ?, ?, ?, ?)";
        
            PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
            prstm.setString(1, hs.getMaHocSinh());
            prstm.setString(2, hs.getSdtPhuHuynh());
            prstm.setInt(3, tblLop);
            prstm.setInt(4, tblKhoaHoc);
            prstm.setInt(5, tblNguoiID);
            int res = prstm.executeUpdate();        
            if(res >0){
               ResultSet  result = prstm.getGeneratedKeys();
               while(result.next()){
                   return result.getInt(1);
               }
            }
            return res;
            
        }
        catch(Exception e){
            
        }
        return -1;
        
    }
    public int insertHocSinh(HocSinh hs,String pathAnh){
        if(seachID(hs.getMaHocSinh()) > 0) return -2;
        try{
            DAO dao = new DAO();
            NguoiDao nguoiDAO = new NguoiDao();
            int tblNguoiID = nguoiDAO.upDateNguoi(hs);
            KhoaHocDAO khoahocDAO = new KhoaHocDAO();
            int tblKhoaHoc = khoahocDAO.insertKhoaHoc(hs.getKhoahoc());
            LopDAO lopDAO = new LopDAO();
            int tblLop = lopDAO.seachID(hs.getLop());
            String url = "INSERT INTO tblhocsinh (maHocSinh, sdtPhuHuynh, hinhAnh ,tblLopID, tblKhoaHocID, tblNguoiID) VALUES (?, ?, ?, ?, ?, ?)";
            InputStream in = new FileInputStream(pathAnh);
            PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
            prstm.setString(1, hs.getMaHocSinh());
            prstm.setString(2, hs.getSdtPhuHuynh());
            prstm.setBlob(3, in);
            prstm.setInt(4, tblLop);
            prstm.setInt(5, tblKhoaHoc);
            prstm.setInt(6, tblNguoiID);
            int res = prstm.executeUpdate();        
            if(res >0){
               ResultSet  result = prstm.getGeneratedKeys();
               while(result.next()){
                   return result.getInt(1);
               }
            }
            return res;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return -1;
        
    }
    
    public ArrayList<TheHocSinh> getbyName(String ten, String tenDem, String ho,String add ){
        ArrayList<TheHocSinh> ret =  new ArrayList();
        String url = "SELECT tblnguoi.ID,tblhocsinh.maHocSinh,tblhoten.ho,tblhoten.tenDem,tblhoten.ten,\n" +
        "tbldiachi.soNha,tbldiachi.duong,tbldiachi.thon,tbldiachi.xa_Phuong,\n" +
        "tbldiachi.huyen_Quan,tbldiachi.tinh_ThanhPho,tblkhoi.tenKhoi,tbllop.tenLop,\n" +
        "tblhocsinh.hinhAnh,\n" +
        "tblnguoi.ngaySinh,tblnguoi.gioitinh,tblnguoi.email,tblHocSinh.sdtPhuHuynh\n" +
        "\n" +
        "FROM	tblhocsinh,tblnguoi,tblhoten,tbldiachi,tblkhoi,tbllop\n" +
        "WHERE	tblhocsinh.tblnguoiID = tblnguoi.ID\n" +
        "AND		tblhoten.ID = tblnguoi.tblHoTenID\n" +
        "AND		tbldiachi.ID = tblnguoi.tblDiaChiID\n" +
        "AND		tblhocsinh.tblLopID = tbllop.ID\n" +
        "AND		tblhocsinh.daxoa = 0\n" +
        "AND		tbllop.tblKhoiID = tblkhoi.ID\n" +
        "AND 	tblhoten.ho LIKE '%"+ho+"%'\n" +
        "AND 	tblhoten.tenDem LIKE '%"+tenDem+"%'\n" +
        "AND 	tblhoten.ten LIKE '%"+ten+"%' "+add;
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                TheHocSinh e = new TheHocSinh();
                e.setID(res.getInt(1));
                e.setMaHocSinh(res.getString(2));
                HoTen hoten = new HoTen(res.getString(3), res.getString(4),res.getString(5));
                e.setHoTen(hoten);
                DiaChi diaChi = new DiaChi(res.getString(11), res.getString(10), res.getString(9), res.getString(8), res.getString(7), res.getString(6));
                e.setDiaChi(diaChi);
                e.setKhoi( new Khoi( res.getString(12), 0));
                e.setLop(new Lop(res.getString(13)));
                Blob blob = res.getBlob("hinhAnh");
                if(blob != null){
                    int len = (int) blob.length();
                    byte[] buf = blob.getBytes(1, len);
                    e.sethinhAnh(buf);
                }
                e.setNgaySinh((java.util.Date)res.getDate(15));
                e.setGioiTinh(res.getString(16));
                e.setEmail(res.getString(17));
                e.setSdtPhuHuynh(res.getString(18));
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
