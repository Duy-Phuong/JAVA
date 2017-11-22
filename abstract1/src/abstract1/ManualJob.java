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
// ManualJob - (Mô phỏng một công việc phổ thông)
// Lớp cha (AbstractJob) có 2 phương thức trừu tượng.
// Lớp này mới chỉ thực hiện 1 phương thức trừu tượng của lớp cha.
// Vì vậy nó bắt buộc phải khai báo là abstract.
public abstract class ManualJob extends AbstractJob {
 
    public ManualJob() {
 
    }
 
    // Thực hiện phương thức trừu tượng của lớp cha.
    @Override
    public String getJobName() {
        return "Manual Job";
    }
 
}
