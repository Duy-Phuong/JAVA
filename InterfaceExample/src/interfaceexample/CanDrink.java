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
 
// Interface này định nghĩa ra một tiêu chuẩn 
// về những thứ có khả năng biết uống.
public interface CanDrink {
 
    // Các trường (field) trong Interface đều là 'public static final'.
    // Cho dù bạn có khai báo rõ hay không java luôn hiểu ngầm vậy.
    public static final String PEPSI = "PEPSI";
    final String NUMBER_ONE = "NUMBER ONE";
    String SEVENUP = "SEVEN UP";
 
    public void drink();
 
}
