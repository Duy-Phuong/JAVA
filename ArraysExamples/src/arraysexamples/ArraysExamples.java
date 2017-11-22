/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysexamples;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author admin1
 */
public class ArraysExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          int[] years = new int[] { 2001, 1994, 1995, 2000, 2017 };
 
        // Sắp xếp
        Arrays.sort(years);
 
        for (int year : years) {
            System.out.println("Year: " + year);
        }
 
        // Chuyển một mảng thành chuỗi
        String yearsString = Arrays.toString(years);
 
        System.out.println("Years: " + yearsString);
 
        // Tạo danh sách (List) từ một vài giá trị.
        List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
 
        for (String name : names) {
            System.out.println("Name: " + name);
        }
        
        ////------------------------Mang 2 chieu--------------------------------
           // Khai báo một mảng 2 chiều, chỉ rõ các phần tử của mảng.
        String[][] teamAndPlayers = new String[][] { 
                { "Sam", "Smith", "Robert" }, // US Players
                { "Tran", "Nguyen" }          // Vietnam Players
        };
 
        String[] usPlayers = teamAndPlayers[0];
        String[] vnPlayers = teamAndPlayers[1];
         
        System.out.println("Team count: " + teamAndPlayers.length); // ==> 2
 
        System.out.println("Us Players count:" + usPlayers.length); // ==> 3
        System.out.println("Vn Players count:" + vnPlayers.length); // ==> 2
 
        for (int row = 0; row < teamAndPlayers.length; row++) { 
 //de lay chieu dai moi mang con
            String[] players = teamAndPlayers[row];
 
            for (int col = 0; col < players.length; col++) {
                System.out.print("Player at[" + row + "][" + col + "]=" + teamAndPlayers[row][col] + "  ");
            }
            System.out.println("");
            

        }
        
                    
            
            ///////
             // Khai báo một mảng 2 chiều (Mảng của mảng)
        // Có 2 dòng.
            System.out.println("----------------------");
        String[][] teamAndPlayers1 = new String[2][];
         
        // US Players
        teamAndPlayers1[0] = new String[]{ "A", "B", "C" };
         
        // Vietnam Players
        teamAndPlayers1[1] = new String[]{ "D", "E" };
      
   
        for (int row1 = 0; row1 < teamAndPlayers1.length; row1++) { 
 
            String[] players1 = teamAndPlayers1[row1];
 
            for (int col = 0; col < players1.length; col++) {
                System.out.println("Player at[" + row1 + "][" + col + "]=" + teamAndPlayers1[row1][col]);
            }
 
        }
        
        
        
        ///////////////end
        
        
        
    }
    
}
