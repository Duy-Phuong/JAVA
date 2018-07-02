/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class FormHandler {

	private SnakeClient snakeClient;
	Client client = new Client(8192, 8192);
	public int id = 0;
	public int score = 0;
	public int highscore = 0;
	public boolean ingame = false;
	public Timer reconnectionTimer;

	// address cua may khi connect lan dau tien
	private static String AddressIP = "";

	public FormHandler() {

	}

	public void start(String contentForm) {

		client.start();
		try {

			Kryo kryo = client.getKryo();
			kryo.register(Request.class);
			kryo.register(Response.class);

			// InetAddress address = client.discoverHost(54001, 5000);
			// neu chua co
			if (AddressIP.equalsIgnoreCase("") == true || AddressIP == null) {
				AddressIP = JOptionPane.showInputDialog("Enter server IP");

				InetAddress address = InetAddress.getByName(AddressIP); // yeah, worldwide is possible ;)
				client.connect(5000, address, 54000, 54001);
			}
			// request("connect");
			request(contentForm);
			// ben snake client se lay IP nay
			ClientHandler.AddressIP = AddressIP;

			client.addListener(new Listener() {
				public void received(Connection connection, Object object) {
					if (object instanceof Response) {
						Response response = (Response) object;
						handleResponse(response.content, connection);
					}
				}

				@Override
				public void disconnected(Connection connection) {
					System.out.println("Connection lost!");

					// try to reconnect
					snakeClient.board.text = "Connection lost! Trying to reconnect...";
					snakeClient.board.repaint();
					ingame = false;
					reconnectionTimer = new Timer(3000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								client.reconnect(5000);
								reconnectionTimer.stop();

								snakeClient.board.id = 9999;
								request("getHighscore");
								request("getColors");

							} catch (IOException e1) {
								System.out.println(e1.toString());
							}
						}
					});
					reconnectionTimer.setRepeats(true);
					reconnectionTimer.start();

				}
			});

			// snakeClient.addKeyListener(this);

			request("getHighscore");
			request("getColors");

		} catch (Exception e) {
			System.out.println("exception: " + e.toString());
			// k connect dk xuat thong bao
			JOptionPane.showMessageDialog(null, "exception: " + e.toString());
			// resset lai addressIP
			AddressIP = "";

			if (e.toString().contains("host cannot be null.")) {

				int result = JOptionPane.showOptionDialog(null,
						"No server found! Start server first, then click 'Retry'.", "Error",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null,
						new String[] { "Retry", "Cancel" }, "Retry");

				if (result == 0) {
					start(contentForm);
				} else {
					System.exit(1);
				}

			}

		}

	}

	public void stop() {

		client.close();
		client.stop();

	}

	////////////////////////////
	// Tranh TH gui nhiu reponse no thong bao mess nhiu lan
	public static boolean kt = false;
	public static int i = 0;
	public static boolean kt0 = false;
	public static int i0 = 0;
	public static boolean kt1 = false;
	public static int i1 = 0;
	public static boolean kt2 = false;
	public static int i2 = 0;
	public static boolean kt3 = false;
	public static int i3 = 0;
	public static boolean kt4 = false;
	public static int i4 = 0;
	public static boolean kt5 = false;
	public static int i5 = 0;
	public static boolean kt6 = false;
	public static int i6 = 0;
	public static boolean kt7 = false;
	public static int i7 = 0;

	public static void reset() {
		FormHandler.kt = false;
		FormHandler.i = 0;
		FormHandler.kt0 = false;
		FormHandler.i0 = 0;
		FormHandler.kt1 = false;
		FormHandler.i1 = 0;
		FormHandler.kt2 = false;
		FormHandler.i2 = 0;
		FormHandler.kt3 = false;
		FormHandler.i3 = 0;
		FormHandler.kt4 = false;
		FormHandler.i4 = 0;
		FormHandler.kt5 = false;
		FormHandler.i5 = 0;
		FormHandler.kt6 = false;
		FormHandler.i6 = 0;
		FormHandler.kt7 = false;
		FormHandler.i7 = 0;
	}

	private void handleResponse(String content, Connection connection) {

		if (!content.startsWith("update"))
			System.out.println("Response: " + content);

		if (content.startsWith("setID")) {

			id = Integer.valueOf(content.substring(6));
			snakeClient.board.id = id;
			score = 0;
			snakeClient.board.text = "Score: " + score + " | Highscore: " + highscore;
			ingame = true;
			JOptionPane.showMessageDialog(null,"set true");
			System.out.println("Mission complete");

		}
		else if (content.startsWith("createRoomSuccess") == true) {
			String[] str1 = content.split(";");
			for (int j = 0; j < str1.length; j++) {
				System.out.println(" - receive : " + str1[j]);
				if (j == (str1.length - 1)) {
					Client1.RoomID = str1[j];

				}
				if (j == (str1.length - 2)) {
					Client1.RoomMaster = str1[j];

				}

			}
			// System.out.println("==== " + RoomID + " " + RoomMaster);
			if (kt0 == false && i0 == 0) {
				JOptionPane.showMessageDialog(null, "Create room with ROOM ID: " + Client1.RoomID + " - Room master: "
						+ Client1.RoomMaster + " successfully!");
				// chu se join room luon
				String temp = "JoinRoom;" + Client1.RoomID + ";" + Client1.RoomMaster;
				request(temp); // gui yeu cau join room toi server
				kt0 = true;
				i0++;
			}
		} else if (content.startsWith("playerName:;")) {
			String cut = content.substring(12);
			// JOptionPane.showMessageDialog(null, "Form Nhan: " + cut );
			// String[] s = cut.split("-");
			// System.out.println("=== list player ===");
			// for (int i = 0; i < s.length; i++) {
			// String string = s[i];
			// System.out.println("== " + string);
			// }
			Client1.ListPlayer1 = cut;

			if (kt == false && i == 0) {
				JOptionPane.showMessageDialog(null,
						"New player connect game successfully, You can click button show list to update list! ");
				kt = true;
				i++;
			}
		} else if (content.startsWith("success")) {
			if (kt5 == false && i5 == 0) {
				JOptionPane.showMessageDialog(null, "Connect to server successfully");
				kt5 = true;
				i5++;
			}

		} else if (content.startsWith("joinRoomSuccess") == true) {
			String[] str1 = content.split(";");
			for (int j = 0; j < str1.length; j++) {
				System.out.println(" - receive : " + str1[j]);
				if (j == (str1.length - 2)) {
					Client1.RoomID = str1[j];

				}
				if (j == (str1.length - 1)) {
					Client1.RoomStatus = str1[j];

				}

			}
			// System.out.println("==== " + RoomID + " " + RoomMaster);
			Client1.canPlay = true;
			if (kt1 == false && i1 == 0) {
				JOptionPane.showMessageDialog(null, "Join room with ROOM ID: " + Client1.RoomID + " successfully!");
				kt1 = true;
				i1++;
			}

		} else if (content.startsWith("CannotJoinRoomSuccess") == true) {
			String error = "";
			String roomIDrec = "";
			String RoomStt = "";
			String[] str1 = content.split(";");
			for (int j = 0; j < str1.length; j++) {
				System.out.println(" - receive : " + str1[j]);
				if (j == (str1.length - 2)) {
					Client1.RoomID = str1[j];

				}
				if (j == (str1.length - 1)) {
					Client1.RoomStatus = str1[j];

				}

			}
			if (Client1.RoomStatus.equalsIgnoreCase("1")) {
				error = "Room is start...";
			}
			if (kt2 == false && i2 == 0) {
				JOptionPane.showMessageDialog(null, "Cannot Join room with ROOM ID: " + Client1.RoomID + " " + error);
				kt2 = true;
				i2++;
			}
		} else if (content.startsWith("leaveRoomSuccess") == true) {
			String roomID = "";
			String chuRoom = "";
			String[] str1 = content.split(";");
			for (int j = 0; j < str1.length; j++) {
				System.out.println(" - receive : " + str1[j]);
				if (j == (str1.length - 2)) {
					chuRoom = str1[j];

				}
				if (j == (str1.length - 1)) {
					roomID = str1[j];

				}
			}
			System.out.println("leave: " + roomID + " successfully; RoomMaster: " + chuRoom);
			if (kt6 == false && i6 == 0) {
				JOptionPane.showMessageDialog(null, "leave room ROOMID: " + roomID + " successfully");
				kt6 = true;
				i6++;
			}

		} else if (content.startsWith("clearRoom") == true) {
			if (kt7 == false && i7 == 0) {
				JOptionPane.showMessageDialog(null, "leave room successfully and room is deleted");
				kt7 = true;
				i7++;
			}

			Client1.canPlay = false; // k chÆ¡i dk

		} else if (content.startsWith("startGame") == true) { // thĂ´ng bĂ¡o náº¿u táº¡o success
			String[] str1 = content.split(";");
			for (int j = 0; j < str1.length; j++) {
				System.out.println(" - receive : " + str1[j]);
				if (j == (str1.length - 1)) {
					Client1.RoomStatus = str1[j];
					System.out.println(" === Room STTT: " + Client1.RoomStatus);
				}
				if (j == (str1.length - 2)) {
					Client1.RoomID = str1[j];

				}
				if (j == (str1.length - 3)) {
					Client1.RoomMaster = str1[j];

				}

			}

			// System.out.println("==== " + RoomID + " " + RoomMaster);
			// báº­t cá»� hiá»‡u khi game dk chá»§ room start
			Client1.startGame = true;
			if (kt3 == false && i3 == 0) {
				JOptionPane.showMessageDialog(null, "Game start with ROOM ID: " + Client1.RoomID + " - Room master: "
						+ Client1.RoomMaster + " successfully!");
				kt3 = true;
				i3++;

			}

			// snakeClient.client.count();

			// JOptionPane.showMessageDialog(null, "Game start with ROOM ID: " +
			// Client1.RoomID + " - Room master: " + Client1.RoomMaster + " successfully!");

			/*
			 * Thread clock = new Thread(){ public void run(){ int j; for (j= 10; j >= 0;
			 * j--) { txtTime.setText(String.valueOf(j)); try {
			 * 
			 * sleep(1000); } catch (InterruptedException ex) {
			 * System.out.println("error time"); } } } }; clock.start();
			 */
		} else if (content.startsWith("CannnotStartGame") == true) {
			String messageTemp = content;
			// neu k start Ä‘k game ma da join room va game do dk chu start
			if (messageTemp.startsWith("CannnotStartGame") == true) {
				String[] str12 = messageTemp.split(";");
				for (int j = 0; j < str12.length; j++) {
					System.out.println(" - receive : " + str12[j]);
					if (j == (str12.length - 1)) {
						Client1.RoomStatus = str12[j];
						System.out.println(" === Room STTT: " + Client1.RoomStatus);
					}
					if (j == (str12.length - 2)) {
						Client1.RoomID = str12[j];

					}
					if (j == (str12.length - 3)) {
						Client1.RoomMaster = str12[j];

					}

				}
			}

			// neu join room va room va game start
			System.out.println("== canPlay " + Client1.canPlay + " ;roomStatus: " + Client1.RoomStatus);
			if (Client1.canPlay == true && Client1.RoomStatus.startsWith("1") == true) {

			} else {
				if (kt4 == false && i4 == 0) {
					JOptionPane.showMessageDialog(null, "You cannot start game with ROOM ID: " + Client1.RoomID
							+ " - Room master: " + Client1.RoomMaster + " !");
					kt4 = true;
					i4++;

				}
			}
		} else if (content.startsWith("count")) {
			SnakeClient.client.count();
			Client1.RoomStatus = "1"; // TH cho client k nháº¥n nt start
		}

	}

	private void request(String content) {
		Request request = new Request();
		request.content = content;
		client.sendTCP(request);
	}

}