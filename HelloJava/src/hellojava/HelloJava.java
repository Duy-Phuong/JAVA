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

public class HelloJava {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
        // TODO code application logic here
        // Khai báo một biến, có kiểu int (Số tự nguyên 32 bit).
        int firstNumber;
 
        // Gán giá trị cho firstNumber
        firstNumber = 10;
        
        System.out.println("First Number =" + firstNumber);
                
 
        // Khai báo một biến kiểu float (Số thực 32 bit)
        // Số này được gán giá trị 10.2
        // Ký tự 'f' ở cuối giúp java hiểu đây là kiểu float.
        float secondNumber = 10.2f;
 
        System.out.println("Second Number =" + secondNumber);
 
        // Khai báo một số kiểu double (Số thực 64 bit)
        // Số này được gán giá trị 10.2
        // Ký tự 'd' ở cuối giúp java hiểu đây là kiểu double.
        // Phân biệt với kiểu float 'f'.
        double thirdNumber = 10.2d;
 
        System.out.println("Third Number =" + thirdNumber);
 
        // Khai báo một biến kiểu ký tự.
        char ch = 'a';
 
        System.out.println("Char ch= " + ch);
        
         // Khai báo 3 số kiểu long (Số nguyên 64 bit).
        long firstNumber1, secondNumber1, thirdNumber1;
 
        // Gán giá trị cho firstNumber
        // Ký tự 'L' ở cuối để nói với java đây là kiểu long, 
        // phân biệt với kiểu int.
        firstNumber1 = 100L;
 
        // Gán giá trị cho secondNumber
        secondNumber1 = 200L;
 
        // Gán giá trị cho thirdNumber.
        thirdNumber1 = firstNumber1 + secondNumber1;
 
        System.out.println("First Number = " + firstNumber1);
        System.out.println("Second Number = " + secondNumber1);
        System.out.println("Third Number = " + thirdNumber1);
        
        if (firstNumber1 >= 100)
        {
            System.out.println(">= 100");
        }
        
        // Khai báo một biến kiểu boolean
        boolean value = true;
 
        // Nếu value là true
        if (value) {
            System.out.println("It's true");
        }
        // Ngược lại
        else {
            System.out.println("It's false");
        }
        
        //vong lap
        int[] arr = new int[5];
        for(int i=0; i<5; i++)
        {
            arr[i] = i;
            System.out.println("gia tri i = " + i);
        }
        
        System.out.println("SD foreach: ");
        int value1 = 0;
        //khi muon in het cac phan tu trong mang ra
        for(int a: arr)
        {
            System.out.println("arr[" + value1 + "] = " + a );
            value1++;
        }
        
        System.out.println("Chieu dai cua mang la: " + arr.length);
        
        
        //class
        // Tạo một đối tượng từ lớp Person
        // Khởi tạo đối tượng này từ Constructor của lớp Person 
        Person edison = new Person("Edison");
 
        // Lớp Person có phương thức getName()
        // Sử dụng đối tượng để gọi phương thức getName():
        String name = edison.getName();
        System.out.println("Person 1: " + name);
 
        // Tạo một đối tượng từ class Person.
        // Khởi tạo đối tượng này tử cấu tử của class Person 
        Person billGate = new Person("Bill Gates");
 
        // Lớp Person có trường name là công khai (public)
        // Sử dụng đối tượng để tham chiếu tới nó.
        String name2 = billGate.name;
        System.out.println("Person 2: " + name2);
        
        
        //----------------------------field--------------
        System.out.println("----------------------------------------");
        // Tạo đối tượng thứ nhất.
        FieldSample obj1 = new FieldSample("Value1");
 
        System.out.println("obj1.myValue= " + obj1.myValue);
 
        // In ra giá trị của trường tĩnh MY_STATIC_FIELD.
        // Tham chiếu thông qua đối tượng (Không được khuyến khích).
      //  System.out.println("obj1.MY_STATIC_FIELD= " + obj1.MY_STATIC_FIELD);
 
        // In ra giá trị của trường tĩnh - MY_STATIC_FIELD.
        // Với các trường tĩnh, có thể truy cập tới nó thông qua lớp.
        // (Cách này được khuyến khích).
        System.out.println("FieldSample.MY_STATIC_FIELD= " + FieldSample.MY_STATIC_FIELD);
 
        // Tạo đối tượng thứ 2:
        FieldSample obj2 = new FieldSample("Value2");
 
        System.out.println("obj2.myValue= " + obj2.myValue);
 
       // System.out.println("obj2.MY_STATIC_FIELD= " + obj2.MY_STATIC_FIELD);
 
        System.out.println(" ------------- ");
 
        // Trường tĩnh được sử dụng chung cho mọi đối tượng của cùng một lớp.
        // Gán giá trị mới cho trường tĩnh MY_STATIC_FIELD.
        // (Có thể dùng cách: FieldSample.MY_STATIC_FIELD = 200)
     //   obj1.MY_STATIC_FIELD = 200;
 
        // Tại đây sẽ in ra giá trị 200.
      //  System.out.println("obj2.MY_STATIC_FIELD= " + obj2.MY_STATIC_FIELD);
      
      
      
      //-----------------------------METHOD-------------------------------------
       // Tạo đối tượng MethodSample
        MethodSample obj = new MethodSample();
 
        // Gọi phương thức getText()
        String text = obj.getText();
 
        System.out.println("Text = " + text);
 
        // Gọi phương thức setText(String)
        obj.setText("New Text");
 
        System.out.println("Text = " + obj.getText());
 
        // Phương thức tĩnh có thể được gọi thông qua lớp.
        // Cách này được khuyến khích dùng. (**)
        int sum = MethodSample.sum(10, 20, 30);
 
        System.out.println("Sum  10,20,30= " + sum);
 
        // Hoặc gọi thông qua đối tượng.
        // Cách này không được khuyến khích. (**)
//        int sum2 = obj.sum(20, 30, 40);
// 
//        System.out.println("Sum  20,30,40= " + sum2);
    }
 
    
    
}
