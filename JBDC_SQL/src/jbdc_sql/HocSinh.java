
package jbdc_sql;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HocSinh {

    
    public static SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
    private int MaHS;
    private String TenHS;
    private Date NgaySinh;
    private String GhiChu;
    private byte[] ExtInfo;
    
    

    public int getMaHS() {
        return MaHS;
    }

    public void setMaHS(int MaHS) {
        this.MaHS = MaHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public byte[] getExtInfo() {
        return ExtInfo;
    }

    public void setExtInfo(byte[] ExtInfo) {
        this.ExtInfo = ExtInfo;
    }

    public HocSinh(int MaHS, String TenHS, Date NgaySinh, String GhiChu, byte[] ExtInfo) {
        this.MaHS = MaHS;
        this.TenHS = TenHS;
        this.NgaySinh = NgaySinh;
        this.GhiChu = GhiChu;
        this.ExtInfo = ExtInfo;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
