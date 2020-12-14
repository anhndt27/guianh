/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.LoiViPham;

/**
 *
 * @author tuan2
 */
public class LoiViPhamDAO {

    public LoiViPhamDAO() {
    }
    
    public ArrayList <LoiViPham>  getByDayAndByID(int ID , Date ngaybatDau, Date ngayKetThuc){
        ArrayList <LoiViPham > ret = new ArrayList<>();
        String url = "SELECT * FROM quanlidoan.tblloivipham where tblNguoiID = ? AND ngayViPham between ? and ?;";
        DAO dao = new DAO();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1, ID);
            prstm.setString(2, formatter.format(ngaybatDau));
            prstm.setString(3, formatter.format(ngayKetThuc));
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                LoiViPham e = new LoiViPham(res.getInt(1),res.getString(2), res.getDate(4));
                ret.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ret;
        
    }
     public ArrayList <LoiViPham>  getByDayAndByID(int ID ){
        ArrayList <LoiViPham > ret = new ArrayList<>();
        String url = "SELECT * FROM quanlidoan.tblloivipham where tblNguoiID = ? ";
        DAO dao = new DAO();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1, ID);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                LoiViPham e = new LoiViPham(res.getInt(1),res.getString(2), res.getDate(4));
                ret.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ret;
        
    }
    public int remove(LoiViPham e){
        String url = "DELETE FROM tblloivipham WHERE (ID = ?);";
        DAO dao = new DAO();
        try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1,e.getID() );
            int res = prstm.executeUpdate();
            return res;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
    public int insert(LoiViPham e ,int ID){
        String url = "INSERT INTO tblloivipham (tenLoi, tblNguoiID, ngayViPham) VALUES (?, ?, ?);";
        DAO dao = new DAO();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         try {
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1,e.getTenLoi() );
            prstm.setInt(2, ID);
            prstm.setString(3, formatter.format(e.getNgayPhamLoi()));
            int res = prstm.executeUpdate();
            return res;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return -1;
    }
}
