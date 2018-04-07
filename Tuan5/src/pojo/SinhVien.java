package pojo;
// Generated Apr 3, 2018 7:08:59 PM by Hibernate Tools 4.3.1




public class SinhVien  implements java.io.Serializable {


     private String maSinhVien;
     private Cmnd soCmnd;

    public SinhVien() {
    }

	
    public SinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public SinhVien(String maSinhVien, Cmnd soCmnd) {
       this.maSinhVien = maSinhVien;
       this.soCmnd = soCmnd;
    }
   
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public Cmnd getSoCmnd() {
        return this.soCmnd;
    }
    
    public void setSoCmnd(Cmnd soCmnd) {
        this.soCmnd = soCmnd;
    }




}


