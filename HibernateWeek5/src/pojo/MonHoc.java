package pojo;
// Generated Apr 4, 2018 9:25:36 AM by Hibernate Tools 4.3.1




public class MonHoc  implements java.io.Serializable {


     private String maMonHoc;
     private String tenMonHoc;
     private ThoiKhoaBieu thoiKhoaBieu;
     private String maSinhVien;

    public MonHoc() {
    }

	
    public MonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    public MonHoc(String maMonHoc, String tenMonHoc, ThoiKhoaBieu thoiKhoaBieu, String maSinhVien) {
       this.maMonHoc = maMonHoc;
       this.tenMonHoc = tenMonHoc;
       this.thoiKhoaBieu = thoiKhoaBieu;
       this.maSinhVien = maSinhVien;
    }
   
    public String getMaMonHoc() {
        return this.maMonHoc;
    }
    
    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    public String getTenMonHoc() {
        return this.tenMonHoc;
    }
    
    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    public ThoiKhoaBieu getThoiKhoaBieu() {
        return this.thoiKhoaBieu;
    }
    
    public void setThoiKhoaBieu(ThoiKhoaBieu thoiKhoaBieu) {
        this.thoiKhoaBieu = thoiKhoaBieu;
    }
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }




}


