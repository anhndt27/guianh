/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.GiaoVien;
import model.KhoaHoc;
import model.Lop;

/**
 *
 * @author tuan2
 */
public class LopDAO {
    public int seachID(Lop e){
         try {
            String url = "SELECT ID FROM tbllop  where tenLop = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1,e.getTenLop());
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
    public int seachSoLuong(Lop e){
         try {
            String url = "SELECT soLuong FROM tbllop  where ten = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1,e.getTenLop());
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
    public int addSoLuong(Lop e){
         try {
            int ID = seachID(e);
            String url = "UPDATE tbllop SET soLuong = ? WHERE ( ID = ?);";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setInt(1,seachSoLuong(e) +1);
            prstm.setInt(1,ID);
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
    public ArrayList <Lop> getNameLop(){
        ArrayList <Lop> ret = new ArrayList<>();
         try {
            
            String url = "SELECT * FROM tblLop;";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
                Lop e = new Lop("");
                e.setID(res.getInt(1));
                e.setTenLop(res.getString(2));
                GiaoVien gv = new GiaoVien();
                gv.setID(res.getInt(5));
                e.setGiaoVienChuNhiem(gv);
                ret.add(e);
            }
           
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
         return ret;
    }
 
}
