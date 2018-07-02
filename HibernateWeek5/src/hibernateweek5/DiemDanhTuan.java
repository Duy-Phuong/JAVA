/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateweek5;


import java.io.Serializable;

public class DiemDanhTuan implements Serializable {


    private String tuanThu;
    private String avaliable;

    public DiemDanhTuan(String tuanThu, String avaliable) {
       
        this.tuanThu = tuanThu;
        this.avaliable = avaliable;
    }

    /**
     * @return the tuanThu
     */
    public String getMaTuan() {
        return tuanThu;
    }


 
    public void setMaTuan(String tuanThu) {
        this.tuanThu = tuanThu;
    }

 
    public String isAvaliable() {
        return avaliable;
    }


    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
}


