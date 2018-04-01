package pojo;
// Generated Mar 31, 2018 8:35:08 PM by Hibernate Tools 4.3.1


import java.util.Date;


public class SinhVien  implements java.io.Serializable {


     private String maSinhVien;
     private String hoVaTen;
     private Date ngaySinh;
     private String diaChi;

    public SinhVien() {
    }

	
    public SinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public SinhVien(String maSinhVien, String hoVaTen, Date ngaySinh, String diaChi) {
       this.maSinhVien = maSinhVien;
       this.hoVaTen = hoVaTen;
       this.ngaySinh = ngaySinh;
       this.diaChi = diaChi;
    }
   
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public String getHoVaTen() {
        return this.hoVaTen;
    }
    
    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }




}


