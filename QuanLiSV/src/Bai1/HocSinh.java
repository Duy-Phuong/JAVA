/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author admin1
 */
public class HocSinh {
    private int id;
    private String name;
    private float score;
    private String image;


    private String address;
    private String note;
    
    public HocSinh() {
        this.id = 0;
        this.name = "";
        this.score = 0f;
        this.address = "";
        this.note = "";
    }
    public HocSinh(int id, String name, float score,String image, String address, String note) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.image = image;
        this.address = address;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public void show(){
        System.out.println("===================");
        System.out.println("- MHS: " + this.id);
        System.out.println("- Name: " + this.name);
        System.out.println("- Điểm: " + this.score );
        System.out.println("- Hình ảnh: " + this.image);
        System.out.println("- Địa chỉ: " + this.address);
        System.out.println("- Ghi chú: " + this.note);
    }

    @Override
    public String toString() {
        String result = "==================="
                + "\n- MHS: " + this.id
                + "\n- Name: " + this.name
                + "\n- Điểm: " + this.score
                + "\n- Hình ảnh: " + this.image
                + "\n- Địa chỉ: " + this.address
                + "\n- Ghi chú: " + this.note;
        return result;
    }
    ///tao dinh dang chuoi in ra file csv
    public String print(){
         String result =  this.id
                + "," + this.name
                + "," + this.score
                 + "," + this.image
                + "," + this.address
                + "," + this.note;
        return result;
    }
}
