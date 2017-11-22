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
public enum Color {
     RED("red") {
      @Override
      public String getHexCode() {
          return "#ff0000";
      }
  },
  GREEN("green") {
      @Override
      public String getHexCode() {
          return "#00ff00";
      }
  },
  BLUE("blue") {
      @Override
      public String getHexCode() {
          return "#0000ff";
      }
  };
 
  private String name;
 
  Color(String name) {
      this.name = name;
  }
 
  public String getName() {
      return name;
  }
 
 
  public abstract String getHexCode();
}
