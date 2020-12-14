/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class VanBan {
    private String loaiVanBan;
    private String path;

    public VanBan(String loaiVanBan, String path) {
        this.loaiVanBan = loaiVanBan;
        this.path = path;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public String getPath() {
        return path;
    }
    
    
}
