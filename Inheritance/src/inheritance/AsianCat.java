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
public class AsianCat extends Cat {
 
    public AsianCat(String name, int age, int height) {
        super(name, age, height);
    }
 
    // Ghi đè (override) phương thức của lớp cha (Cat)
    @Override
    public String getAnimalName() {
        return "Asian Cat";
    }
    
    
    void print11()
    {
        System.out.println("mememem ");
    }
}
