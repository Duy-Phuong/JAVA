/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SnakeClient extends JFrame {

    private static final long serialVersionUID = 1L;

    public ClientHandler handler;
    private JPanel contentPane;
    public Board board;
    public static Client1 client;

    public static void main(String[] args) {
    	
    	EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				client = new Client1(new SnakeClient());
		        client.setVisible(true);
			}
		});
        

    }

    /**
     * Create the frame.
     */
    public SnakeClient() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handler.stop();
            }
        });
        setTitle("Snake Client");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        JButton btn = new JButton("play again");
        JButton btnExit = new JButton("EXIT");
        contentPane.setLayout(new BorderLayout(0, 0));
        JPanel jp = new JPanel();
        //jp.setPreferredSize(new Dimension(100,520));
        jp.add(btn);
        //               jp.add(btnExit);
        btn.setFocusable(false);
        btnExit.setFocusable(false);
        // btn.enable(false);// = false;
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Play again!!");
                //viet lai
                Game.PlayAgainst();
                board.repaint();
                handler.ingame = false;
            }
        });
//                btnExit.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                       JOptionPane.showMessageDialog(null, "Exit");
//                       handler.stop();
//                       client.setVisible(true);
//                    }
//                });
        jp.setBackground(Color.CYAN);
//                contentPane.add(btn);
        setContentPane(contentPane);

        board = new Board();
        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(jp, BorderLayout.EAST);

        pack();

        handler = new ClientHandler(this);
        handler.start();

    }

}
