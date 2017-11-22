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
// Interface này định nghĩa một tiêu chuẩn 
// về những thứ có khả năng di chuyển. 
public interface CanMove {
 
    // Các phương thức trong Interface đều là trừu tượng và public.
    public abstract void run();
 
    // Cho dù bạn không viết rõ 'public abstract' thì java luôn hiểu là vậy.
    void back();
 
    // Tốc độ.
    public int getVelocity();
 
}