package pojo;
// Generated Apr 2, 2018 11:25:58 PM by Hibernate Tools 4.3.1

import java.util.*;





public class KhoaHoc  implements java.io.Serializable {


     private String maKhoaHoc;
     private String tenKhoaHoc;
     private Set<SinhVien> sinhviens = new HashSet<SinhVien>(0);

    public Set<SinhVien> getSinhviens() {
        return sinhviens;
    }

    public void setSinhviens(Set<SinhVien> sinhviens) {
        this.sinhviens = sinhviens;
    }
    public KhoaHoc() {
    }

	
    public KhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }
    public KhoaHoc(String maKhoaHoc, String tenKhoaHoc) {
       this.maKhoaHoc = maKhoaHoc;
       this.tenKhoaHoc = tenKhoaHoc;
    }
   
    public String getMaKhoaHoc() {
        return this.maKhoaHoc;
    }
    
    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }
    public String getTenKhoaHoc() {
        return this.tenKhoaHoc;
    }
    
    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }




}


