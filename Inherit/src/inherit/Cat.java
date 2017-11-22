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
public class Cat extends Animal {
 
    // Ghi đè (override) phương thúc của lớp Animal.

    public void say() {
        System.out.println("Meo");
    }
 
}
