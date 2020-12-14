/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tuan2
 */
public class DanToc {
    private int ID;
    private String tenDanToc;

    public DanToc(int ID, String tenDanToc) {
        this.ID = ID;
        this.tenDanToc = tenDanToc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDanToc() {
        return tenDanToc;
    }

    public void setTenDanToc(String tenDanToc) {
        this.tenDanToc = tenDanToc;
    }
    
    
}
