/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellojava;

import java.util.StringTokenizer;

/**
 *
 * @author admin1
 */
public class test {
    void fact(int n) {
        int giaithua = 1;
        for (int i = 1; i <= n; i++) {
            giaithua = giaithua * i;
        }
        System.out.println("Giai thừa của " + n + "  là: " + giaithua);
    }

    
    public static void main(String[] args) {
//        System.out.println("hello");
//        int so1 = 10;
//        System.out.println("so1: " + so1);
//        float so12 = 10.2f;
//        System.out.println("so12: " + so12);
//        double so13 = 10.3d;
//        System.out.println("so13: " + so13);
//        long so4, so5, so6;
//        so4 = 10L;
//        so5 = 20L;
//        so6 = so4 + so5;
//        System.out.println("so4: " + so4);
//        System.out.println("so5: "+ so5 );
//        System.out.println("so6: " + so6);
//        boolean a = true;
//        System.out.println("boolean: " + a);
//        
//        int arr[] =  new int[3];
//        System.out.println("array in java: ");
//        for(int i=0; i< 3; i++)
//        {
//            arr[i] = i;
//            System.out.println(arr[i]);
//        }

//          StringBuffer sb = new StringBuffer("Hello");
//          for(int i = 0;i < 5; i++){
//                       System.out.println(sb.charAt(i));//in -> HJavalo  
//             }
//        sb.replace(1, 3, "Java");
//        System.out.println(sb);//in -> HJavalo  
           StringTokenizer st = new StringTokenizer("Toi-ten-,la-VietTut", "-,", false);
 
        // in next token dựa trên dấu phân cách
        while(st.hasMoreTokens() == true)
        System.out.println("Next token là : " + st.nextToken());  

        
          // gọi phương thức của đối tượng annonymous
         new test().fact(5);

    }
}
