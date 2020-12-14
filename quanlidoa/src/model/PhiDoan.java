/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author dell
 */
public class PhiDoan {
    private KiHoc kiHoc;
    private int mucPhi;
    private String loai;
    private Date ngayThu;

    public PhiDoan(KiHoc kiHoc, int mucPhi, String loai, Date ngayThu) {
        this.kiHoc = kiHoc;
        this.mucPhi = mucPhi;
        this.loai = loai;
        this.ngayThu = ngayThu;
    }
    
}
