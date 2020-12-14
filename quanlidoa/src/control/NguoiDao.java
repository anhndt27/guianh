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
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.HoTen;
import model.Nguoi;

/**
 *
 * @author tuan2
 */
public class NguoiDao {
    public int upDateNguoi(Nguoi e){
       if(e.getID() == 0 ){
           DiaChiDAO diachiDAO = new DiaChiDAO();
           int tblDiaChi = diachiDAO.upDateDiaChi(e.getDiaChi());
           HoTenDAO hotenDAO = new HoTenDAO();
           int tblHoTen = hotenDAO.updateHoTen(e.getHoTen());
           System.out.println(tblDiaChi +" ; "  +tblHoTen);
           if(tblDiaChi != -1 && tblHoTen != -1){
                try {
                    String url = "INSERT INTO tblnguoi (ngaySinh,gioitinh,email, tblDiaChiID, tblHoTenID) VALUES (?,?, ?, ?, ?);";
                    DAO dao = new DAO();
                    PreparedStatement prstm = dao.getCnn().prepareStatement(url,Statement.RETURN_GENERATED_KEYS);
                    SimpleDateFormat formartdate = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(e.getNgaySinh());
                    prstm.setString(1,formartdate.format(e.getNgaySinh()));
                    prstm.setString(2, e.getGioiTinh());
                    prstm.setString(3, e.getEmail());
                    prstm.setInt(4, tblDiaChi);
                    prstm.setInt(5, tblHoTen);
                    int res = prstm.executeUpdate();
                    if(res >0){
                       ResultSet  result = prstm.getGeneratedKeys();
                       while(result.next()){
                           return result.getInt(1);
                       }
                    }
                    return res;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(NguoiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }
        
        return -1;
    }
   
    
}
