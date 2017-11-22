/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstract1;

/**
 *
 * @author admin1
 */

// Class này thừa kế từ class trìu tượng ManualJob 
// BuildHouse không được khai báo là trừu tượng.
// Vì vậy nó cần thực hiện tất cả các phương thức trừu tượng còn lại.
public class BuildHouse extends ManualJob {
 
    public BuildHouse() {
 
    }
 
    // Thực hiện phương thức trừu tượng của lớp cha.
    @Override
    public void doJob() {
        System.out.println("Build a House");
    }
 
}