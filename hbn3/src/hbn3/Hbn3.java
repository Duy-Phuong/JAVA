/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbn3;
import java.util.Iterator;
import pojo.*;
import dao.*;
import org.hibernate.Session;
import util.HibernateUtil;
/**
 *
 * @author admin1
 */
public class Hbn3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Sach sach = SachDAO.layThongTinSach("1");
        DanhMuc dm = DanhMucDAO.layThongTinDanhmuc("1");
        System.out.println("Mã danh mục: "+dm.getMaDanhMuc());
        System.out.println("Tên danh mục: "+dm.getTenDanhMuc());
        Iterator<Sach> sachs = dm.getSachs().iterator();
        while(sachs.hasNext()){
            Sach s = sachs.next();
            System.out.println("==== book =====");
            System.out.println("Mã sách:"+ s.getMaSach());
            System.out.println("Tên sách: "+s.getTenSach());
            System.out.println("Tác giả: "+s.getTacGia());
            System.out.println("Giá bán: "+s.getGiaBan());
            System.out.println("Số lượng: "+s.getSoLuong());
            System.out.println("Hình ảnh: "+s.getHinhAnh());
        }
        System.exit(1);
    }
    
}
