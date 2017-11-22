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
public class Abstract1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Khởi tạo một đối tượng AbstractJob
        // từ Constructor của lớp JavaCoding.
        AbstractJob job1 = new JavaCoding();
 
        // Gọi phương thức doJob()
        job1.doJob();
 
        // Phương thức getJobName là trừu tượng trong lớp AbstractJob.
        // Nhưng nó đã được thực hiện tại một lớp con nào đó.
        // Vì vậy bạn có thể gọi nó.
        String jobName = job1.getJobName();
 
        System.out.println("Job Name 1= " + jobName);
 
        // Khởi tạo một đối tượng AbstractJob
        // từ Constructor của lớp BuildHouse.
        AbstractJob job2 = new BuildHouse();
 
        job2.doJob();
 
        String jobName2 = job2.getJobName();
 
        System.out.println("Job Name 2= " + jobName2);
 
    }
    
}
