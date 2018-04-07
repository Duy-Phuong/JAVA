package pojo;
// Generated Apr 3, 2018 7:08:59 PM by Hibernate Tools 4.3.1


import java.util.Date;


public class Cmnd  implements java.io.Serializable {


     private String soCmnd;
     private String hoTen;
     private Date ngaySinh;
     private SinhVien sinhVien;

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Cmnd() {
    }

	
    public Cmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }
    public Cmnd(String soCmnd, String hoTen, Date ngaySinh) {
       this.soCmnd = soCmnd;
       this.hoTen = hoTen;
       this.ngaySinh = ngaySinh;
    }
   
    public String getSoCmnd() {
        return this.soCmnd;
    }
    
    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }




}


