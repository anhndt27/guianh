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
public class DiaChi {
    private int ID;
    String tinh_ThanhPho;
    String huyen_Quan;
    String xa_Phuong;
    String thon;
    String duong;
    String soNha;

    public DiaChi() {
    }
    
    public DiaChi(int ID, String tinh_ThanhPho, String huyen_Quan, String xa_Phuong, String thon, String duong, String soNha) {
        this.ID = ID;
        this.tinh_ThanhPho = tinh_ThanhPho;
        this.huyen_Quan = huyen_Quan;
        this.xa_Phuong = xa_Phuong;
        this.thon = thon;
        this.duong = duong;
        this.soNha = soNha;
    }
    
    public DiaChi(String tinh_ThanhPho, String huyen_Quan, String xa_Phuong, String thon, String duong, String soNha) {
        this.tinh_ThanhPho = tinh_ThanhPho;
        this.huyen_Quan = huyen_Quan;
        this.xa_Phuong = xa_Phuong;
        this.thon = thon;
        this.duong = duong;
        this.soNha = soNha;
    }

    public DiaChi(String tinh_ThanhPho, String huyen_Quan, String xa_Phuong, String thon) {
        this.tinh_ThanhPho = tinh_ThanhPho;
        this.huyen_Quan = huyen_Quan;
        this.xa_Phuong = xa_Phuong;
        this.thon = thon;
    }
    public DiaChi(DiaChi e){
        this.tinh_ThanhPho = e.tinh_ThanhPho;
        this.huyen_Quan = e.huyen_Quan;
        this.xa_Phuong = e.xa_Phuong;
        this.thon = e.thon;
    }

    public void setTinh_ThanhPho(String tinh_ThanhPho) {
        this.tinh_ThanhPho = tinh_ThanhPho;
    }

    public void setHuyen_Quan(String huyen_Quan) {
        this.huyen_Quan = huyen_Quan;
    }

    public void setXa_Phuong(String xa_Phuong) {
        this.xa_Phuong = xa_Phuong;
    }

    public void setThon(String thon) {
        this.thon = thon;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    
    public String getTinh_ThanhPho() {
        return tinh_ThanhPho;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    

    public String getHuyen_Quan() {
        return huyen_Quan;
    }

    public String getXa_Phuong() {
        return xa_Phuong;
    }

    public String getThon() {
        return thon;
    }

    public String getDuong() {
        return duong;
    }

    public String getSoNha() {
        return soNha;
    }

    @Override
    public String toString() {
        String ret ="";
        boolean oki = false;
        if(  soNha != null && !soNha.equals("") ){
             ret += soNha;
             oki = true;
        }
        if( duong != null && !duong.equals("")){
            if(oki) ret+= ", ";
            ret+= duong;
            oki = true;
        }
        if( thon != null && !thon.equals("") ){
            if(oki) ret+= ", ";
            ret+= thon;
            oki = true;
        } 
        if( xa_Phuong != null && !xa_Phuong.equals("") ){
            if(oki) ret+= ", ";
            ret+= xa_Phuong;
            oki = true;
        } 
        if(  huyen_Quan != null && !huyen_Quan.equals("") ){
            if(oki) ret+= ", ";
            ret+= huyen_Quan;
            oki = true;
        } 
        if( tinh_ThanhPho != null && !tinh_ThanhPho.equals("")){
            if(oki) ret+= ", ";
            ret+= tinh_ThanhPho;
            oki = true;
        } 
        return ret;
    }
    
    
}
