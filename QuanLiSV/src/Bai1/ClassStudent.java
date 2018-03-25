/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author admin1
 */
public class ClassStudent {
    //private static int total = 0 ;
    private final int MAX = 50;
    private List<HocSinh> list = null;
    
    public ClassStudent(){
        list = new LinkedList<HocSinh>();//cấp phát
    }
    public void add(HocSinh h) {
        if (isFull()) {
            System.out.println("Danh sách lớp đầy");
        } else {
          //this.list[total] = h;
          //ClassStudent.total++;
          if(!isEmpty())
          {
            int vt = this.getPosition(h.getId());//neu id trung k them hs có id do
            if(vt == -1){
               list.add(h);
              System.out.println("thêm thành công!");
            }
          }else{
              list.add(h);
              System.out.println("thêm thành công!");
          }

                      
        }

    }

    public void delete(int id) {
        int vt = this.getPosition(id);
        if(vt != -1){
           list.remove(vt);
            System.out.println("Xóa thành công!");
        }else{
            System.out.println("Không có hoc sinh có ID đó");
        }

    }
    public void list() {
        if(isEmpty()){
            System.out.println("Danh sách rỗng!");
        }else{
            Iterator<HocSinh> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
//            for (int i = 0; i < list.size(); i++) {
//                   
//                //this.list[i].show();
//                System.out.println(list.get(i));
//                
//            }
        }
    }
    
    //ham kiem tra xem no co hs chua ms in
    public boolean isEmpty(){
        //return total == 0;
        return list.isEmpty();
    }
    public boolean isFull(){
        //return total == this.MAX;
        return (list.size() == MAX);
    }
    //tim vt 1 hs
    public int getPosition(int id){
//        for (int i = 0; i < list.size(); i++) {
//            HocSinh h = (HocSinh)list.get(i);//vi no tra ve Obj
//            if(h.getId() == id)
//                return i;
//        }
        Iterator<HocSinh> it = list.iterator();
        int i = 0;
        while(it.hasNext()){
            if(it.next().getId() == id)
                return i;
        i++;
        }
        return -1;
    }
    //in ra hs khi tìm ra
    public void find(int id){
        int vt = this.getPosition(id);
        if(vt != -1){
            //list[vt].show();
            System.out.println(list.get(vt));
        }else{
            System.out.println("Không có hoc sinh có ID đó");
        }
        
    }
    
    //ham edit khi co id hoc sinh ta vao sua thong tin cua hs đó
    public void edit(int id, String name, float score, String image, String address, String note){
        int vt = this.getPosition(id);
        if(vt != -1){
            HocSinh h = (HocSinh)list.get(vt);
            h.setName(name);
            h.setScore(score);
            h.setImage(image);
            h.setAddress(address);
            h.getNote();
            System.out.println("Cập nhật thành công!");
        }else{
            System.out.println("Không có hoc sinh có ID đó");
        }
    }

    void sortIdAZ() {
        Collections.sort(list, new MHSAZ());
    }

    void sortIdZA() {
        Collections.sort(list, new MHSAZ());
        Collections.reverse(list);
    }

    void sortDiemAZ() {
        Collections.sort(list, new DiemAZ());
    }

    void sortDIemZA() {
        Collections.sort(list, new DiemAZ());  
        Collections.reverse(list);
    }
    //export ra DSHS
     public void writeFile(String FILENAME, boolean kt) {
         boolean type;
         int number = 0;
        if(!isEmpty()){
            Iterator<HocSinh> it = list.iterator();
        while(it.hasNext()){
           // System.out.println(it.next());
           String content;
            try {
                type = true;//ghi tiep vao file(true)
                //boolean de check xem co import vo hay k
                //chua import do thi ghi tiep vao file co san
                // number = 0 de khi export lan dau la ghi lai file moi cac lan sau ghi tiep tuc
                if(kt == true && number == 0){
                    type = false;
                    number++;
                }
                    
            try (FileWriter f = new FileWriter(FILENAME, type) //F là k ghi tiếp (import dô là false)
            ) {
                try (PrintWriter p = new PrintWriter(f)) {
                    content = it.next().print();
                    p.println(content);//ghi xong xuong dong
                } //ghi xong xuong dong
                f.close();
                
                //ghi ra file dat
                String content1 = content + "-"; // dau "-" la dau phan cach du lieu 2 sv
                System.out.println(" --- " + content1);
                writeDat(content1, true);
            }
            
        } catch (FileNotFoundException ex) {
           System.out.println("write file error");
        } catch (IOException ex) {
            System.out.println("write file error");
        }
        }
        }
    }
    //export ra file dat
     public void writeDat(String data, boolean type) {
        try {
            try (FileOutputStream f = new FileOutputStream("DSHS.dat", type) //F là k ghi tiếp
            ) {
                f.write(data.getBytes());
                f.close();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("write file error");
        } catch (IOException ex) {
            System.out.println("write file error");
        }
        
    }
     
}
