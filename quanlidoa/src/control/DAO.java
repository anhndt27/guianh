/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan2
 */
public class DAO {
    private static Connection cnn;

    public DAO() {
    }

    public static Connection getCnn() {
        if(cnn == null){
            String url="jdbc:mysql://localhost:3306/quanlidoan?autoReconnect=true&useSSL=false";
            try {
                cnn = DriverManager.getConnection(url, "root","quanlidoan");
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return cnn;
        }
        return cnn;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        Connection cnn = dao.getCnn();
        System.out.println("done");
    }
    
}
