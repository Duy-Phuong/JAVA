/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.esotericsoftware.kryonet.Client;

public class Client1 extends javax.swing.JFrame {

	public static String RoomMaster = "";
	public static String RoomID = "";
	public static String RoomStatus = "";
	// if player can play game
	public static boolean canPlay = false;
	// if game start by room master
	public static boolean startGame = false;
	public static SnakeClient sc;
	Client client = new Client(8192, 8192);
	public static boolean check = false;
	public String name;
	// may nay connect
	static FormHandler handler = new FormHandler();
	public static String ListPlayer1 = "";
	static ClientHandler ch = new ClientHandler(sc);
	@SuppressWarnings("static-access")
	public Client1(SnakeClient sc) {
		try {
			// LĂ m Ä‘áº¹p giao diá»‡n
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		;
		initComponents();
		this.sc = sc;
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// private SnakeClient snakeClient;
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		btnEnterIP = new javax.swing.JButton();
		btnConnect = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtListPlayer = new javax.swing.JTextArea();
		btnShowList = new javax.swing.JButton();
		btnCreateRoom = new javax.swing.JButton();
		txtRoomID = new javax.swing.JTextField();
		btnJoinRoom = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		btnStartGame = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		btnReady = new javax.swing.JButton();
		txtName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtTime = new javax.swing.JLabel();
		btnLeave = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		jPanel1.setBackground(new java.awt.Color(102, 255, 255));

		jLabel1.setText("IP SERVER");

		btnEnterIP.setText("Enter IP server");
		btnEnterIP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEnterIPActionPerformed(evt);
			}
		});

		btnConnect.setText("Connect Game");
		btnConnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConnectActionPerformed(evt);
			}
		});

		txtListPlayer.setColumns(20);
		txtListPlayer.setRows(5);
		jScrollPane1.setViewportView(txtListPlayer);

		btnShowList.setText("Show list player");
		btnShowList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnShowListActionPerformed(evt);
			}
		});

		btnCreateRoom.setText("Create room");
		btnCreateRoom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCreateRoomActionPerformed(evt);
			}
		});

		btnJoinRoom.setText("Join Room");
		btnJoinRoom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnJoinRoomActionPerformed(evt);
			}
		});

		jLabel2.setText("ROOM ID");

		btnStartGame.setText("Start game");
		btnStartGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStartGameActionPerformed(evt);
			}
		});

		jLabel3.setText("TIME TO PREPARE");

		btnReady.setText("Ready to play");
		btnReady.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReadyActionPerformed(evt);
			}
		});

		jLabel4.setText("Player name");

		txtTime.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 48)); // NOI18N
		txtTime.setText("00");

		btnLeave.setText("Leave game");
		btnLeave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLeaveActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
										.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
														.addGroup(jPanel1Layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jScrollPane1).addComponent(btnShowList,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
												.addGroup(
														jPanel1Layout.createSequentialGroup().addGap(59, 59, 59)
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel4).addComponent(jLabel1))))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27,
												Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtRoomID).addComponent(jLabel2)
														.addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE,
																145, Short.MAX_VALUE)
														.addComponent(btnEnterIP, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(txtTime).addComponent(jLabel3)))
										.addGap(78, 78, 78)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btnReady, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnStartGame, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnJoinRoom, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnCreateRoom, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLeave, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(54, 54, 54)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(btnEnterIP))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnConnect).addComponent(txtName,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnShowList).addComponent(btnCreateRoom).addComponent(jLabel2))
						.addGap(28, 28, 28)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnJoinRoom).addComponent(txtRoomID,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3).addComponent(btnStartGame))
										.addGap(22, 22, 22)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtTime)
												.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnReady)
														.addGap(18, 18, 18).addComponent(btnLeave)))))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConnectActionPerformed

		FormHandler.reset();
		if (txtName.getText().equals("") == false) {
			System.out.print("/* * * * * * * * * * * * * * * * * * * * * * * * * * */\n" + "\t\tE C H O   C L I E N T\n"
					+ "/* * * * * * * * * * * * * * * * * * * * * * * * * * */\n");
			///// =========================== xu li ====================================
			// FormHandler handler = new FormHandler();
//			ClientHandler.name = txtName.getText();
			handler.start("Name;#" + Integer.toHexString(sc.board.myColor.getRGB()).substring(2) + ";" + txtName.getText());
			
//			ch.request("Name;#" +Integer.toHexString(sc.board.myColor.getRGB()).substring(2) + ";" + txtName.getText() );
			System.out.println("Mission Completed");
		} else {
			JOptionPane.showMessageDialog(this, "Cannot connect you must input name");
		}
	}// GEN-LAST:event_btnConnectActionPerformed

	private void btnShowListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnShowListActionPerformed
		System.out.print("/* * * * * * * * * * * * * * * * * * * * * * * * * * */\n" + "\t\tE C H O   C L I E N T\n"
				+ "/* * * * * * * * * * * * * * * * * * * * * * * * * * */\n");
		if (ListPlayer1.equalsIgnoreCase("") == false) {

			txtListPlayer.setText(ListPlayer1);
			System.out.println("list " + ListPlayer1);
		}

	}// GEN-LAST:event_btnShowListActionPerformed

	private void btnCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateRoomActionPerformed
		FormHandler.reset();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		String roomID = "";
		if (randomInt < 10) {
			roomID = "000" + String.valueOf(randomInt);
		} else if (randomInt >= 10 && randomInt < 100) {
			roomID = "00" + String.valueOf(randomInt);
		} else if (randomInt >= 100 && randomInt < 1000) {
			roomID = "0" + String.valueOf(randomInt);
		} else if (randomInt >= 1000 && randomInt < 10000) {
			roomID = "" + String.valueOf(randomInt);
		}
		txtRoomID.setText(roomID);

		// xu li gui ma toi
		RoomStatus = "0";

		if (txtRoomID.getText().equals("") == false) {
			String temp = "CreateRoom;" + txtRoomID.getText() + ";" + txtName.getText();
			handler.start(temp);
		}
		// System.out.println("Mission Completed");
		// tao room xong se join room luon
		// xu li ben Form handler
	}// GEN-LAST:event_btnCreateRoomActionPerformed

	private void btnJoinRoomActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnJoinRoomActionPerformed
		FormHandler.reset();
		if (txtRoomID.getText().equals("") == false && txtName.getText().equals("") == false) {

			int i = 0;

			String temp = "JoinRoom;" + txtRoomID.getText() + ";" + txtName.getText();
			handler.start(temp);

		} else {
			JOptionPane.showMessageDialog(this, "You must input ROOM ID!");
		}
	}// GEN-LAST:event_btnJoinRoomActionPerformed

	private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStartGameActionPerformed
		FormHandler.reset();
		if (txtRoomID.getText().equals("") == false && txtName.getText().equals("") == false) {

			String temp = "startGame;" + txtRoomID.getText() + ";" + txtName.getText();
			handler.start(temp);

		} else {
			JOptionPane.showMessageDialog(this, "You must input Name and ROOM ID");

		}
	}// GEN-LAST:event_btnStartGameActionPerformed

	private void btnReadyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReadyActionPerformed
		FormHandler.reset();
        if((canPlay == true && startGame == true && RoomID.equalsIgnoreCase(txtRoomID.getText()) == true) || (canPlay == true && RoomStatus.startsWith("1")== true) && RoomID.equalsIgnoreCase(txtRoomID.getText()) == true){ 
			// khi connect vao game r va ready khi time = 0
			if (Client1.check == true && txtTime.getText().equals("0") == true) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SnakeClient frame = new SnakeClient();
							frame.setVisible(true);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		} else {
			JOptionPane.showMessageDialog(this, "You cannot play game because game isn't start or you don't join room");
		}
	}// GEN-LAST:event_btnReadyActionPerformed

	private void btnEnterIPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEnterIPActionPerformed
		// TODO add your handling code here
		// handler = new FormHandler();
		FormHandler.reset();
		handler.start("connect");
		check = true;

		// if(Client1.check == true){
		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		// SnakeClient frame = new SnakeClient();
		// frame.setVisible(true);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });
		// }

	}// GEN-LAST:event_btnEnterIPActionPerformed

	private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLeaveActionPerformed
		// TODO add your handling code here:
		FormHandler.reset();
		String temp = "LeaveRoom;" + txtRoomID.getText() + ";" + txtName.getText();
		handler.start(temp);
		canPlay = false;

	}// GEN-LAST:event_btnLeaveActionPerformed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		// TODO add your handling code here:
		// System.out.println("dong");

		handler.start("delete;" + txtName.getText());
	}// GEN-LAST:event_formWindowClosing

	// ham dem nguoc
	public void count() {
		Thread clock = new Thread() {
			public void run() {
				int j;
				for (j = 10; j >= 0; j--) {
					txtTime.setText(String.valueOf(j));
					try {

						sleep(1000);
					} catch (InterruptedException ex) {
						System.out.println("error time");
					}
				}
			}
		};
		clock.start();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Client1(sc).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnConnect;
	private javax.swing.JButton btnCreateRoom;
	private javax.swing.JButton btnEnterIP;
	private javax.swing.JButton btnJoinRoom;
	private javax.swing.JButton btnLeave;
	private javax.swing.JButton btnReady;
	private javax.swing.JButton btnShowList;
	private javax.swing.JButton btnStartGame;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea txtListPlayer;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtRoomID;
	private javax.swing.JLabel txtTime;
	// End of variables declaration//GEN-END:variables
}