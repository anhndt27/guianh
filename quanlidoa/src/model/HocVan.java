/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author dell
 */
public class HocVan {
    private String hocVan;
    private Date namTotNghiep;

    public HocVan(String hocVan, Date namTotNghiep) {
        this.hocVan = hocVan;
        this.namTotNghiep = namTotNghiep;
    }

    public String getHocVan() {
        return hocVan;
    }

    public Date getNamTotNghiep() {
        return namTotNghiep;
    }
    
    
}
