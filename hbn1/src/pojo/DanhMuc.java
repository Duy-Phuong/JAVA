package pojo;




public class DanhMuc  implements java.io.Serializable {


     private String maDanhMuc;
     private String tenDanhMuc;

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




}


