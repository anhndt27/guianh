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
import model.DanToc;
import model.Lop;

/**
 *
 * @author tuan2
 */
public class DanTocDAO {
    public  ArrayList <DanToc> getAllDanToc(){
        ArrayList <DanToc> ret = new ArrayList();
         try {
            
            String url = "SELECT * FROM tblDanToc;";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
               DanToc e = new DanToc(res.getInt(1), res.getString(2));
                ret.add(e);
            }
           
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
         return ret;
    }
    public DanToc getDanToc(String s){
        DanToc ret = new DanToc(56, "Không xác định");
         try {
            
            String url = "SELECT * FROM tblDanToc;";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
               DanToc e = new DanToc(res.getInt(1), res.getString(2));
                return e;
            }
           
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
         return ret;
    }
 
}
