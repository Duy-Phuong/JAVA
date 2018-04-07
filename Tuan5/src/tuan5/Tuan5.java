/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuan5;
import pojo.SinhVien;
import dao.SinhVienDAO;
import java.util.List;

public class Tuan5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<SinhVien> ds=SinhVienDAO.layDanhSachSinhVien();
        if(ds != null){
            System.out.println("ok");
        }else{
            System.out.println("err");
        }
    }
    
}
