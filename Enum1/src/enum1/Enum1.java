/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enum1;

/**
 *
 * @author admin1
 */
public class Enum1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Gender marryGender = Gender.FEMALE;
 
      System.out.println("Code: " + marryGender.getCode());
      System.out.println("Text: " + marryGender.getText());
 
      // Gender[].
      for (Gender gender : Gender.values()) {
          System.out.println(gender.getText());
      }
      
      
      String code ="M";
      Gender gender= Gender.getGenderByCode(code);
      
      System.out.println("Gender by code: "+ gender);
    }
    
}
