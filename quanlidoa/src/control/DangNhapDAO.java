/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan2
 */
public class DangNhapDAO {
    public String  checkDangNhap(String user, String pass){
        System.out.println(user +" " + pass);
        try {
            String url = "SELECT * FROM tblcanbodoan  where tblcanbodoan.username = ? and tblcanbodoan.password = ?";
            DAO dao = new DAO();
            PreparedStatement prstm = dao.getCnn().prepareStatement(url);
            prstm.setString(1, user);
            prstm.setString(2, pass);
            ResultSet res = prstm.executeQuery();
            while (res.next()) {
                String userInSql = res.getString(6);
                System.out.println(userInSql);
                return userInSql;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "-1";
    }
    public static void main(String[] args) {
        DangNhapDAO d = new DangNhapDAO();
        d.checkDangNhap("dungdz", "123");
    }
}
