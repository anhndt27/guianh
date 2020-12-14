/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ToChuyenMon;

/**
 *
 * @author tuan2
 */
public class ToChuyenMonDAO {
    public int insertToChuyenMon(ToChuyenMon e){
        
        return -1;
    }
    public ArrayList<ToChuyenMon> getALLToChuyenMon(){
        ArrayList<ToChuyenMon> ret = new ArrayList();
        try {
      
            String url = "SELECT * FROM quanlidoan.tbltochuyenmon;";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while(res.next()){
                int ID =  res.getInt(1);
                String ten = res.getString(2);
                String diachi = res.getString(3);
                ret.add(new ToChuyenMon(ID, ten, diachi));
            }
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(ToChuyenMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
