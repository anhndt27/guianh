/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class ThongKePhiDoan extends PhiDoan{
    Date batDau;
    Date ketThuc;

    public ThongKePhiDoan(Date batDau, Date ketThuc, KiHoc kiHoc, int mucPhi, String loai, Date ngayThu) {
        super(kiHoc, mucPhi, loai, ngayThu);
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }
    
    
    
}
