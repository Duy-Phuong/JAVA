package pojo;
// Generated Apr 2, 2018 9:51:35 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;





public class DanhMuc  implements java.io.Serializable {


     private String maDanhMuc;
     private String tenDanhMuc;
     //
     private Set<Sach> sachs = new HashSet<Sach>(0);
     
    public DanhMuc() {
    }

	
    public DanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
    public DanhMuc(String maDanhMuc, String tenDanhMuc) {
       this.maDanhMuc = maDanhMuc;
       this.tenDanhMuc = tenDanhMuc;
    }
   
    public String getMaDanhMuc() {
        return this.maDanhMuc;
    }
    
    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
    public String getTenDanhMuc() {
        return this.tenDanhMuc;
    }
    
    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<Sach> getSachs() {
       
        return sachs;
    }
    
    public void setSachs(Set<Sach> s) {
       
        sachs = s;
    }




}


