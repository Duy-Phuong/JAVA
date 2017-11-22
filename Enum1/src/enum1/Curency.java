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
public enum Curency {
    VND, USD, EURO ;
 
  @Override
  public String toString() {
      if (this == VND) {
          return "Dong";
      } else if (this == USD) {
          return "Dola";
      }
      return super.toString();
  }
// 
//  public static void main(String[] args) {
//      Currency money = Currency.USD;
// 
//      System.out.println("Money " + money);
//      System.out.println("Money " + money.toString());
//      System.out.println("VND " + Currency.VND);
//      System.out.println("EURO " + Currency.EURO);
  //}
}
