/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Checkbox extends JPanel implements TableModelListener {
    private boolean DEBUG = false;
    JTable table;
    public Checkbox() {
        super(new GridLayout(1,0)); //khi kéo nó k bị giãn
        
        MyTableModel model = new MyTableModel();
       model.insertRow(new Book(1, "heelo", "hehehe", 1, true));
        model.insertRow(new Book(2, "AS", "h2ehe", 23, true));
         model.insertRow(new Book(3, "DD", "chem", 45, false));
          model.insertRow(new Book(4, "heelo", "hehehe", 1, true));
        model.insertRow(new Book(5, "AS", "h2ehe", 23, true));
         model.insertRow(new Book(6, "DD", "chem", 45, false));
        
         table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        //Add the scroll pane to this panel.
        add(scrollPane);
       
    }

    public void tableChanged(TableModelEvent e) {
        System.out.println("Row: ");
        int a = table.getSelectedRow();
        int b = table.getSelectedColumn();
        System.out.println(a);
        System.out.println("Colum: ");
        System.out.println(b);
        System.out.println("Value: ");
        System.out.println(table.getValueAt(a, b));
       // System.out.println(table.getValueAt(2, 2));
    }
    
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"No",
        "BookCode",
        "BookTitle",
        "Price",
        "Avaliable"};
       
        Vector data = new Vector();

        
        /* ADDED MORE */
        public void insertRow(Book c)
        {
            data.add(c);
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            
            return data.size();
        }
        
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
        
        public Object getValueAt(int row, int col) {
            //return data[row][col];
            Book c = (Book)data.get(row);
            
            switch(col) {
                case 0:
                    return c.getNo();
                case 1:
                    return c.getBookCode();
                case 2:
                    return c.getBookTitle();
                case 3:
                    return c.getPrice();
                case 4:
                    return c.isAvaliable();
            }
            
            return null;
        }
        
        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
        
        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        @Override
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }
            
            //data[row][col] = value;
            Book c = (Book)data.get(row);
            switch(col) {
                case 0:
                    c.setNo((Integer)value);
                    break;
                case 1:
                    c.setBookCode((String)value);
                    break;
                case 2:
                    c.setBookTitle((String)value);
                    break;
                case 3:
                    c.setPrice((Integer)value);
                    break;
                case 4:
                    c.setAvaliable((Boolean)value);
                    break;
            }
            
            data.set(row, c);
            
            fireTableCellUpdated(row, col);
            
//            if (DEBUG) {
//                System.out.println("New value of data:");
//                printDebugData();
//            }
        }
        
//        private void printDebugData() {
//            int numRows = getRowCount();
//            int numCols = getColumnCount();
//            
//            for (int i=0; i < numRows; i++) {
//                System.out.print("    row " + i + ":");
//                for (int j=0; j < numCols; j++) {
//                    //System.out.print("  " + data[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("--------------------------");
//        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //Create and set up the content pane.
        Checkbox newContentPane = new Checkbox();
        //newContentPane.setOpaque(true); //content panes must be opaque
        frame.add(newContentPane);
       
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}