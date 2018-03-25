/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import java.awt.event.*; 
import javax.swing.*;
/**
 *
 * @author admin1
 */
public class Bai23 {
     public static void main(final String args[]) {  
        JFrame frame = new JFrame("Jmenu Example");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        JMenuBar menuBar = new JMenuBar();  
        // File Menu, F - Mnemonic  
        JMenu fileMenu = new JMenu("File");  
        fileMenu.setMnemonic(KeyEvent.VK_F);  
        menuBar.add(fileMenu);  
        // File->New, N - Mnemonic  
        JMenuItem menuItem1 = new JMenuItem("Open", KeyEvent.VK_N);  
        fileMenu.add(menuItem1);  
  
        JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Option_1");  
        caseMenuItem.setMnemonic(KeyEvent.VK_O);  
        fileMenu.add(caseMenuItem);  
  
        ActionListener aListener = new ActionListener() {  
            public void actionPerformed(ActionEvent event) {  
                AbstractButton aButton = (AbstractButton) event.getSource();  
                boolean selected = aButton.getModel().isSelected();  
                String newLabel;  
                Icon newIcon;  
                if (selected) {  
                    newLabel = "Value-1";  
                } else {  
                    newLabel = "Value-2";  
                }  
                aButton.setText(newLabel);  
            }  
        };  
  
        caseMenuItem.addActionListener(aListener);  
        frame.setJMenuBar(menuBar);  
        frame.setSize(350, 250);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}
