/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readxml;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

/**
 *
 * @author admin1
 */
public class ReadXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            File f = new File("Anh_Viet.xml");
            Document document = builder.parse(f);
            
            Element root = document.getDocumentElement();
//            System.out.println("ROOT: " + root.getNodeName());
            
            NodeList list =  root.getElementsByTagName("record");
            
            for (int i = 0; i < list.getLength(); i++) {
               Node word = list.item(i);
                Element element = (Element) word; 
                String w = element.getElementsByTagName("word").item(0).getTextContent();
                System.out.println("word: " + w);
                String w1 = element.getElementsByTagName("meaning").item(0).getTextContent();
                System.out.println("meaning: " + w1);
                
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
        
    }
    
}
