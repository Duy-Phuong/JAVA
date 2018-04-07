package pojo;
// Generated Apr 5, 2018 8:19:09 PM by Hibernate Tools 4.3.1




public class DiemDanh  implements java.io.Serializable {


     private Integer id;
     private String maSinhVien;
     private MonHoc maMonHoc;
     private String tuan;

    public DiemDanh() {
    }

    public DiemDanh(String maSinhVien, MonHoc maMonHoc, String tuan) {
       this.maSinhVien = maSinhVien;
       this.maMonHoc = maMonHoc;
       this.tuan = tuan;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public MonHoc getMaMonHoc() {
        return this.maMonHoc;
    }
    
    public void setMaMonHoc(MonHoc maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    public String getTuan() {
        return this.tuan;
    }
    
    public void setTuan(String tuan) {
        this.tuan = tuan;
    }




}


