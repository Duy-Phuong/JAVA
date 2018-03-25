/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.Serializable;

/**
 *
 * @author admin1
 */
public class Data implements Serializable {
/**
     * @param args the command line arguments
     */
    private String text,dec;
    private int freq = 0; 
    private long time = 0L;

    
    public Data(String text, String dec, int freq, long time) {
        this.text = text;
        this.dec = dec;
        this.freq = freq;
        this.time = time;
    }

    

   Data(){
       text = "";
       dec = "";
       freq = 0;
       time = 0L;
   }
   Data(String text, String dec){
       this.text = text;
       this.dec = dec;
   }
   public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
    
    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getFreq() {
        return freq;
    }
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the dec
     */
    public String getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(String dec) {
        this.dec = dec;
    }
    
     public String toString() {
        return "-word: " + text + "\n-meaning:" + dec + "-frequence: " + freq + "\n-time: " + time + "\n----------------\n";
    }

}
