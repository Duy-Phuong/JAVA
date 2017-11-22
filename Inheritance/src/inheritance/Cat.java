/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author admin1
 */


public class Cat extends Animal {
 
    private int age;
    private int height;
 
    public Cat(int age, int height) {
        // Gọi tới Constructor mặc định của lớp cha (Animal).
        // Nhằm mục đích gán tạo giá trị cho các trường (field) của lớp cha.
        super();
        // Sau đó mới gán giá trị cho các trường (field) của nó.
        this.age = age;
        this.height = height;
    }
 
    public Cat(String name, int age, int height) {
        // Gọi tới Constructor của lớp cha (Animal)
        // Nhằm mục đích gán tạo giá trị cho các trường (field) của lớp cha.
        super(name);
        // Sau đó mới gán giá trị cho các trường (field) của nó.
        this.age = age;
        this.height = height;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public int getHeight() {
        return height;
    }
 
    public void setHeight(int height) {
        this.height = height;
    }
 
    // Thực hiện (implement) phương thức trừu tượng được khai báo tại lớp cha.
    @Override
    public String getAnimalName() {
        return "Cat";
    }
}