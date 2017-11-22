/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actorsortingdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin1
 */
public class ActorSortingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Actor actor1 = new Actor("Mischa", "Barton");
        Actor actor2 = new Actor("Christian", "Bale");
        Actor actor3 = new Actor("Joan", "Collins");
        Actor actor4 = new Actor("Gemma", "Arterton");
        Actor actor5 = new Actor("Daniel", "Craig");
 
        Actor[] actors = new Actor[] { actor1, actor2, actor3, actor4, actor5 };
 
        // Sử dụng một thuật toán để sắp xếp lại mảng trên.
        // Sắp xếp tăng dần các đối tượng Actor.
        for (int i = 0; i < actors.length; i++) {
 
            for (int j = i + 1; j < actors.length; j++) {
                // Nếu actors[j] < actors[i]
                // Thì thực hiện việc tráo đổi vị trí với nhau.
                if (actors[j].compareTo(actors[i]) < 0) {
                    // Sử dụng một biến tạm thời.
                    Actor temp = actors[j];
                    actors[j] = actors[i];
                    actors[i] = temp;
                }
            }
        }
        // On ra các phần tử mảng.
        for (int i = 0; i < actors.length; i++) {
            System.out.println(actors[i].getFirstName() + "  " + actors[i].getLastName());
        }
 
        
        
        ////////-------------list sort --------------------
           // Một danh sách chứa các phần tử có khả năng so sánh với nhau.
        // (Comparable)
        List<Actor> a1 = new ArrayList<Actor>();
 
        a1.add(actor1);
        a1.add(actor2);
        a1.add(actor3);
        a1.add(actor4);
        a1.add(actor5);
 
        // Sử dụng phương thức Collections.sort(List)
        // để sắp xếp một danh sách (List)
        Collections.sort(a1);
 
        for (Actor act : a1) {
            System.out.println(act.getFirstName() + "  " + act.getLastName());
        }
        String a = "hhh";
        
    }
    
}
