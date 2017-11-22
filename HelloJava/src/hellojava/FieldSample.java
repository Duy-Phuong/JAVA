/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellojava;

/**
 *
 * @author admin1
 */
public class FieldSample {
     // Đây là một trường tĩnh (static field).
    public static int MY_STATIC_FIELD = 100;
 
    // Đây là một trường thông thường.
    public String myValue;
 
    // Constructor để khởi tạo đối tượng FieldSample.
    public FieldSample(String myValue) {
        this.myValue = myValue;
    }
    
}
