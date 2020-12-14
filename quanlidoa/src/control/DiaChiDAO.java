/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;

/**
 *
 * @author tuan2
 */
public class DiaChiDAO {

    public DiaChiDAO() {
    }
    public int seachID(DiaChi e){
         try {
            String url = "SELECT * FROM tbldiachi  where tinh_ThanhPho = ? and huyen_Quan = ? and xa_Phuong = ?"+
                    " and thon = ? and duong = ? and soNha = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1, e.getTinh_ThanhPho());
            prstm.setString(2, e.getHuyen_Quan());
            prstm.setString(3, e.getXa_Phuong());
            prstm.setString(4, e.getThon());
            prstm.setString(5, e.getDuong());
            prstm.setString(6, e.getSoNha());
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
                int ret = res.getInt(7);
                return ret;
            }
           
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return -1;
    
    }
    public int upDateDiaChi(DiaChi e){
        int ret = seachID(e);
        if(ret != -1) return ret;
        else{
            try {
                String url = "INSERT INTO tbldiachi (tinh_ThanhPho, huyen_Quan, xa_Phuong, thon, duong, soNha) VALUES (?, ?, ?, ?, ?, ?)";
                DAO dao = new DAO();
                PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
                prstm.setString(1, e.getTinh_ThanhPho());
                prstm.setString(2, e.getHuyen_Quan());
                prstm.setString(3, e.getXa_Phuong());
                prstm.setString(4, e.getThon());
                prstm.setString(5, e.getDuong());
                prstm.setString(6, e.getSoNha());
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

}
