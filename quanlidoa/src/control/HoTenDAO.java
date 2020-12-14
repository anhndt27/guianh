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
import model.HoTen;
/**
 *
 * @author tuan2
 */
public class HoTenDAO {

    public HoTenDAO() {
    }
    public int seachID(HoTen e){
         try {
            String url = "SELECT ID FROM tblhoten  where ho = ? and tenDem = ? and ten = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1, e.getHo());
            prstm.setString(2, e.getTenDem());
            prstm.setString(3, e.getTen());
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
    public int updateHoTen(HoTen e){
        int ret = seachID(e);
        if(ret != -1) return ret;
        else{
            try {
                String url = "INSERT INTO `tblhoten` (`ho`, `tenDem`, `ten`) VALUES (?, ?, ?);";
                DAO dao = new DAO();
                PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
                prstm.setString(1, e.getHo());
                prstm.setString(2, e.getTenDem());
                prstm.setString(3, e.getTen());
                int res = prstm.executeUpdate   ();
                if(res >0){
                   ResultSet  result = prstm.getGeneratedKeys();
                   while(result.next()){
                       return result.getInt(1);
                   }
                }
                return res;
            } catch (SQLException ex) {
                Logger.getLogger(HoTenDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return -1;
    }
 
}
