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
public abstract class AbstractJob {
    public AbstractJob()
    {
        
    }
 // Đây là một phương thức trừu tượng.
    // Method này trả về tên của công việc.
    public abstract String getJobName();
 
    // Đây là một phương thức trừu tượng.
    public abstract void doJob();    
}
