package pojo;
// Generated Apr 5, 2018 8:19:09 PM by Hibernate Tools 4.3.1



/**
 * SvAccount generated by hbm2java
 */
public class SvAccount  implements java.io.Serializable {


     private String idsvaccount;
     private String username;
     private String password;
     private SinhVien sinhVien;

    public SvAccount() {
    }

	
    public SvAccount(String idsvaccount) {
        this.idsvaccount = idsvaccount;
    }
    public SvAccount(String idsvaccount, String username, String password, SinhVien sinhVien) {
       this.idsvaccount = idsvaccount;
       this.username = username;
       this.password = password;
       this.sinhVien = sinhVien;
    }
   
    public String getIdsvaccount() {
        return this.idsvaccount;
    }
    
    public void setIdsvaccount(String idsvaccount) {
        this.idsvaccount = idsvaccount;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public SinhVien getSinhVien() {
        return this.sinhVien;
    }
    
    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }




}

