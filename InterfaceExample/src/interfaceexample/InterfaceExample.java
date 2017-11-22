/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceexample;

/**
 *
 * @author admin1
 */
public class InterfaceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         // Thừa kế trường tĩnh từ interface CanDrink.
        System.out.println("Drink " + Cat.SEVENUP);
 
        // Khởi tạo một đối tượng CanEat.
        // Một đối tượng khai báo là CanEat.
        // Nhưng thực tế là Cat.
        CanEat canEat1 = new Cat("Tom");
 
        // Một đối tượng khai báo là CanEat.
        // Nhưng thực tế là Mouse.
        CanEat canEat2 = new Mouse();
 
        // Tính đa hình (Polymorphism) thể hiện rõ tại đây.
        // Java luôn biết một đối tượng là kiểu gì
        // ==> Tom cat eat ...
        canEat1.eat();
        // ==> Mouse eat ...
        canEat2.eat();
 
        boolean isCat = canEat1 instanceof Cat;
 
        System.out.println("catEat1 is Cat? " + isCat);
 
        // Ép kiểu (Cast).
        if (canEat2 instanceof Mouse) {
            Mouse mouse = (Mouse) canEat2;
 
            // Gọi phương thức drink (Thừa kế từ CanDrink).
            mouse.drink();
        }
    }
    
}
