/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import java.util.Random;

/**
 *
 * @author admin1
 */
public class Inheritance {

    
     // Phương thức này trả về ngẫu nhiên một con vật.
    public static Animal getRandomAnimal() {
        // Trả về giá trị ngẫu nhiên 0 hoặc 1.
        int random = new Random().nextInt(2);
 
        Animal animal = null;
        if (random == 0) {
            animal = new Cat("Tom", 3, 20);
        } else {
            animal = new Mouse("Jerry", 5);
        }
        return animal;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Khởi tạo một đối tượng động vật.
        // Animal là một lớp trừu tượng,
        // bạn không thể tạo ra một đối tượng từ Constructor của Animal.
        Animal tom = new Cat("Tom", 3, 20);
 
        System.out.println("name: " + tom.getName());
        System.out.println("animalName: " + tom.getAnimalName());
 
        // Sử dụng toán tử 'instanceof' để kiểm tra xem
        // một đối tượng có phải là một kiểu nào đó hay không.
        boolean isMouse = tom instanceof Mouse;
        System.out.println("Tom is mouse? " + isMouse);
 
        boolean isCat = tom instanceof Cat;
        System.out.println("Tom is cat? " + isCat);
 
        boolean isAnimal = tom instanceof Animal;
        System.out.println("Tom is animal? " + isAnimal);
        
         System.out.println("-----------------");
 
       // Tạo một đối tượng Cat.
        Cat tom1 = new Cat("Tom1", 3, 20);
 
        // Gọi các phương thức thừa kế được từ lớp cha (Animal).
        System.out.println("name: " + tom1.getName());
        System.out.println("animalName: " + tom1.getAnimalName());
 
        System.out.println("-----------------");
 
        // Gọi các phương thức được khai báo trên lớp Cat.
        System.out.println("Age: " + tom1.getAge());
        System.out.println("Height: " + tom1.getHeight());
        
        
        //////--------------------cast----------------------------
         Animal animal = getRandomAnimal();
 
         
         System.out.println("---------- cast --------------");
        if (animal instanceof Cat) {
            // Ép kiểu (cast) thành kiểu Cat.
            Cat cat = (Cat) animal;
 
            // Và gọi một phương thức của lớp Cat.
            System.out.println("Cat height: " + cat.getHeight());
        } else if (animal instanceof Mouse) {
            // Ép kiểu (cast) thành kiểu Mouse.
            Mouse mouse = (Mouse) animal;
 
            // Và gọi một phương thức của lớp Mouse.
            System.out.println("Mouse weight: " + mouse.getWeight());
        }
        
        //----------- da hinh ------------
       System.out.println("---------- da hinh --------------");

       Cat cat12 = new Cat("Tom", 3, 20);
 
      Cat cat2 = new AsianCat("ATom", 2, 19);
 
      System.out.println("Animal Name of cat1: " + cat12.getAnimalName());
 
      System.out.println("Animal Name of cat2: " + cat2.getAnimalName());
      
    }
    
}
