/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inherit;

/**
 *
 * @author admin1
 */
public class Inherit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
           // Khai báo một đối tượng Cat.
        Cat cat = new Cat();
 
        // Kiểm tra xem 'cat' có phải là đối tượng của Animal hay không.
        // Kết quả rõ ràng là true.
        boolean isAnimal = cat instanceof Animal;
        System.out.println("cat instanceof Animal?" + isAnimal);
 
        // ==> Meo
        // Gọi tới phương thức say() của Cat.
        cat.say();
 
        // Khai báo một đối tượng Animal.
        // Khởi tạo đối tượng thông qua Constructor của Cat.
        Animal cat2 = new Cat();
 
        // ==> Meo
        // Phương thức say() của Cat được gọi (Chứ không phải của Animal).
        cat2.say();
 
        // Tạo đối tượng Animal.
        // Thông qua constructor của lớp con, Ant.
        Animal ant = new Ant();
 
        // Ant không có phương thức say()
        // ==> Nó gọi vào phương thức say(), thừa kế từ lớp cha (Animal).
        ant.say();
        
        Animal dog = new Dog();
        dog.say();
        
    }
    
}
