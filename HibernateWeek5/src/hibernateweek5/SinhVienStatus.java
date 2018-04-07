/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateweek5;


import java.io.Serializable;

public class SinhVienStatus implements Serializable {


    private String maSinhVien;
    private String HoTen;

    private boolean avaliable;

    public SinhVienStatus(String maSinhVien, String HoTen, boolean avaliable) {
       
        this.maSinhVien = maSinhVien;
        this.HoTen = HoTen;

        this.avaliable = avaliable;
    }

    /**
     * @return the maSinhVien
     */
    public String getMaSinhVien() {
        return maSinhVien;
    }


 
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

   
    public String getTenSinhVien() {
        return HoTen;
    }

 
    public void setTenSinhVien(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isAvaliable() {
        return avaliable;
    }


    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
}


