/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author admin1
 */
public class MyWord implements Serializable{
    private  ArrayList<Data> word;
    MyWord(){
        word = new ArrayList<Data>();
    }
    
    public void setWord(MyWord word) {
        if(this.word != null){
            this.word.clear();
        }
        this.word = word.getWord();
    }

    public ArrayList<Data> getWord() {
        return word;
    }
    
     public String toString() {
         //String dulieu = "";
         Data dulieu;
         String c = "";
       for (int i = 0; i < word.size(); i++) {
                 
                  dulieu = word.get(i);
                   c += dulieu.toString();
                }
       return c;
    }
}
