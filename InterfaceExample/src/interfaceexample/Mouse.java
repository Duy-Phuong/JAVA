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
public class Mouse extends Animal  implements CanEat, CanDrink {
 
  @Override
  public void back() {
      System.out.println("Mouse back ...");
  }
 
  @Override
  public int getVelocity() {
      return 85;
  }
 
  @Override
  public void drink() {
      System.out.println("Mouse drink ...");
  }
 
  @Override
  public void eat() {
      System.out.println("Mouse eat ...");
  }
 
}