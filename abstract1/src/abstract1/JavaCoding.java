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

// Lớp này thực hiện hết các phương thức trừu tượng của lớp cha.
public class JavaCoding extends AbstractJob {
 
    public JavaCoding() {
    }
 
    // Thực hiện phương thức trừu tượng khai báo tại lớp cha.
    @Override
    public void doJob() {
        System.out.println("Coding Java...");
    }
 
    // Thực hiện phương thức trừu tượng khai báo tại lớp cha.
    // Phương thức này sẽ có thân (body).
    // Và trả về tên của công việc.
    @Override
    public String getJobName() {
        return "Coding Java";
    }
 
}