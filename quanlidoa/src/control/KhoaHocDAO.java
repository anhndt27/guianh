/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.KhoaHoc;

/**
 *
 * @author tuan2
 */
public class KhoaHocDAO {

    public KhoaHocDAO() {
    }
    public int seachID(KhoaHoc e){
         try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String url = "SELECT ID FROM tblkhoahoc  where batDau = ? and ketThuc = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            
            prstm.setString(1, formatter.format(e.getBatDau()));
            prstm.setString(2, formatter.format(e.getKetThuc()));
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
       
     public int insertKhoaHoc(KhoaHoc e){
        int ret = seachID(e);
        if(ret != -1) return ret;
        else{
            try {
                String url = "INSERT INTO tblkhoahoc (batDau, ketThuc) VALUES (?, ?);";
                DAO dao = new DAO();
                PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                prstm.setString(1, formatter.format(e.getBatDau()));
                prstm.setString(2, formatter.format(e.getKetThuc()));
                int res = prstm.executeUpdate   ();
                if(res >0){
                   ResultSet  result = prstm.getGeneratedKeys();
                   while(result.next()){
                       return result.getInt(1);
                   }
                }
                return res;
            } catch (SQLException ex) {
                Logger.getLogger(DiaChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return -1;
    }
    public ArrayList<KhoaHoc> getALL(){
        ArrayList<KhoaHoc> ret = new ArrayList();
        try {
            String url = "SELECT * FROM tblKhoaHoc ORDER BY tenKhoa";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            
            
            ResultSet  result = prstm.executeQuery();
            while(result.next()){
                ret.add( new KhoaHoc(result.getInt(1),result.getString(2),result.getDate(3),result.getDate(4) ));
            }

            return ret;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }
       
//    public static void main(String[] args) {
//        KhoaHocDAO kh = new KhoaHocDAO();
//        KhoaHoc k1 = new KhoaHoc("2018-2021");
//        System.out.println(kh.getALL().size());
//    }
    //INSERT INTO `quanlidoan`.`tblkhoahoc` (`batDau`, `ketThuc`) VALUES ('1', '1');
    
    
    
}
