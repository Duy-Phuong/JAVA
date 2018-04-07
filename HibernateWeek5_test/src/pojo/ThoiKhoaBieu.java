package pojo;
// Generated Apr 4, 2018 9:25:36 AM by Hibernate Tools 4.3.1


import java.util.Date;


public class ThoiKhoaBieu implements java.io.Serializable {


     private String maTkb;
     private Date ngayBatDau;
     private Date ngayKetThuc;
     private Integer khoangThoiGian;
     private Integer thu;
     private Date gioBatDau;
     private Date gioKetThuc;
     private String tenPhongHoc;
     private MonHoc monHoc;

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public ThoiKhoaBieu() {
    }

	
    public  ThoiKhoaBieu(String maTkb) {
        this.maTkb = maTkb;
    }
    public  ThoiKhoaBieu(String maTkb, Date ngayBatDau, Date ngayKetThuc, Integer khoangThoiGian, Integer thu, Date gioBatDau, Date gioKetThuc, String tenPhongHoc) {
       this.maTkb = maTkb;
       this.ngayBatDau = ngayBatDau;
       this.ngayKetThuc = ngayKetThuc;
       this.khoangThoiGian = khoangThoiGian;
       this.thu = thu;
       this.gioBatDau = gioBatDau;
       this.gioKetThuc = gioKetThuc;
       this.tenPhongHoc = tenPhongHoc;
    }
   
    public String getMaTkb() {
        return this.maTkb;
    }
    
    public void setMaTkb(String maTkb) {
        this.maTkb = maTkb;
    }
    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }
    
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public Integer getKhoangThoiGian() {
        return this.khoangThoiGian;
    }
    
    public void setKhoangThoiGian(Integer khoangThoiGian) {
        this.khoangThoiGian = khoangThoiGian;
    }
    public Integer getThu() {
        return this.thu;
    }
    
    public void setThu(Integer thu) {
        this.thu = thu;
    }
    public Date getGioBatDau() {
        return this.gioBatDau;
    }
    
    public void setGioBatDau(Date gioBatDau) {
        this.gioBatDau = gioBatDau;
    }
    public Date getGioKetThuc() {
        return this.gioKetThuc;
    }
    
    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
    public String getTenPhongHoc() {
        return this.tenPhongHoc;
    }
    
    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }




}


