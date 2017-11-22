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
 
// Animal (Động vật).
// Lớp này mở rộng từ lớp Object (Mặc dù không ghi rõ).
// Và được khai báo thực hiện hiện (hoặc gọi là thừa kế) interface CanMove.
// Interface CanMove có 3 phương thức trừu tượng.
// Lớp này chỉ thực hiện 1 phương thức.
// Vì vậy nó bắt buộc phải khai báo là abstract.
// Các phương thức trừu tượng còn lại sẽ được các lớp con thực hiện.
public abstract class Animal implements CanMove {
 
    // Thực hiện phương thức run() của interface CanMove.
    @Override
    public void run() {
        System.out.println("Animal run...");
    }
 
}
