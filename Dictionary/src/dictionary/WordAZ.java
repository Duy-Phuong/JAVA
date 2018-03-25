/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;


import java.util.Comparator;

/**
 *
 * @author admin1
 */
public class WordAZ implements Comparator<Data>{

    @Override
    public int compare(Data o1, Data o2) {
        if (o1.getText().compareTo(o2.getText()) < 0) {
            return -1;
        }else if(o1.getText().compareTo(o2.getText()) > 0){
            return 1;
        }else{
            return 0;
        }
        
    }
}