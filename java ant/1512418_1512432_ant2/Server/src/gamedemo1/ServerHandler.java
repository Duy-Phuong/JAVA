/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.Timer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class ServerHandler implements ActionListener {

	private SnakeServer snakeServer;
	private Server server;
	private Game game;
	private ArrayList<Integer> deadIds = new ArrayList<>();
	private HashMap<Integer, Integer> clients = new HashMap<>();
	private ArrayList<String> banList = new ArrayList<>();
	public Timer timer;

	// Danh sach nguowi choi ket noi vao game
	// list player
	public static List<String> listPlayer = new ArrayList<String>();
	// chu phong
	public static String RoomMaster = "";
	public static String RoomID = "";

	public static Room room = new Room();
	public static boolean isInRoom = false;

	public ServerHandler(SnakeServer snakeServer) {
		this.snakeServer = snakeServer;
	}

	public void start() {

		server = new Server(8192, 8192);
		server.start();
		try {

			server.bind(54000, 54001);
			snakeServer.buttonStart.setEnabled(false);
			snakeServer.buttonStop.setEnabled(true);
			log("Server started");

			Kryo kryo = server.getKryo();
			kryo.register(Request.class);
			kryo.register(Response.class);

			server.addListener(new Listener() {
				public void received(Connection connection, Object object) {
					if (object instanceof Request) {
						Request request = (Request) object;
						handleRequest(request.content, connection);
					}
				}

				@Override
				public void connected(Connection connection) {
					if (banList.contains(connection.getRemoteAddressTCP().getAddress().toString())) {
						log("Banned IP " + connection.getRemoteAddressTCP().getAddress() + " tried to connect");
						respond("ban;You were banned!", connection);
						connection.close();
					} else {
						log("Client " + connection.getID() + " (" + connection.getRemoteAddressTCP().getAddress()
								+ ") connected");
					}
				}

				@Override
				public void disconnected(Connection connection) {
					log("Client " + connection.getID() + " disconnected");

					// remove active players
					if (clients.containsKey(connection.getID())) {
						int playerID = clients.get(connection.getID());
						game.players.set(playerID - 2, null);
						log("Player " + playerID + " removed");
						deadIds.add(playerID);
						clients.remove(connection.getID());
					}

				}
			});

			game = new Game();
			timer = new Timer(Game.TICK, this);
			timer.start();
			log("Game created");

		} catch (Exception e) {
			log(e.toString());
		}

	}

	public void stop() {

		server.stop();
		timer.stop();
		snakeServer.buttonStart.setEnabled(true);
		snakeServer.buttonStop.setEnabled(false);
		log("Server stopped");

	}

	private void log(String message) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		snakeServer.textLog.setText(snakeServer.textLog.getText() + sdf.format(new Date()) + " " + message + "\n");

	}

	public void handleCommand(String command) {

		/**
		 * --- COMMANDS ---
		 *
		 * freeze;[id] slowdown;[id];[steps] kamikaze;[id] ban;[ip] unban;[ip]
		 * score;[id];[score] speed;[tick] gamemode;[mode] 0 normal 1
		 * deadPlayersBecomeSolids addsolid;[x];[y] remsolid;[x];[y] clearsolids
		 *
		 */
		System.out.println("Command: " + command);

		if (command.startsWith("freeze")) {

			Player player = game.players.get(Integer.valueOf(command.substring(7)) - 2);
			if (player == null) {
				return;
			}
			player.freeze = !player.freeze;
			log("Freezed player " + player.id);

		} else if (command.startsWith("slowdown")) {

			String temp[] = command.split(";");
			Player player = game.players.get(Integer.valueOf(temp[1]) - 2);
			if (player == null) {
				return;
			}
			player.steps = Integer.valueOf(temp[2]);
			log("Slowed player " + player.id + " down to " + player.steps + " steps");

		} else if (command.startsWith("kamikaze")) {

			Player player = game.players.get(Integer.valueOf(command.substring(9)) - 2);
			if (player == null) {
				return;
			}
			player.kamikaze = player.direction;
			log("Locked direction of player " + player.id);

		} else if (command.startsWith("ban")) {

			String ip = command.substring(4);
			banList.add(ip);
			for (Connection c : server.getConnections()) {
				if (c.getRemoteAddressTCP().getAddress().toString().equals(ip)) {
					respond("ban;You were banned!", c);
					c.close();
				}
			}
			log("Banned IP " + ip);

		} else if (command.startsWith("unban")) {

			String ip = command.substring(6);
			if (banList.contains(ip)) {
				banList.remove(ip);
			}
			log("Unbanned IP " + ip);

		} else if (command.startsWith("score")) {

			String temp[] = command.split(";");
			Player player = game.players.get(Integer.valueOf(temp[1]) - 2);
			if (player == null) {
				return;
			}
			player.score = Integer.valueOf(temp[2]);
			log("Set score of player " + player.id + " to " + player.score);

		} else if (command.startsWith("speed")) {

			int tick = Integer.valueOf(command.substring(6));
			timer.setDelay(tick);
			log("Changed game tick to " + tick);

		} else if (command.startsWith("gamemode")) {

			int mode = Integer.valueOf(command.substring(9));
			switch (mode) {

			case 1:
				game.deadPlayersBecomeSolids = true;
				break;

			default: // 0
				game.deadPlayersBecomeSolids = false;
				mode = 0;
				break;

			}
			log("Switched gamemode to " + mode);

		} else if (command.startsWith("addsolid")) {

			String temp[] = command.split(";");
			game.solidsX.add(Integer.valueOf(temp[1]));
			game.solidsY.add(Integer.valueOf(temp[2]));
			log("Added solid at X:" + temp[1] + " Y:" + temp[2]);

		} else if (command.startsWith("remsolid")) {

			String temp[] = command.split(";");
			for (int i = 0; i < game.solidsX.size(); i++) {
				if (game.solidsX.get(i) == Integer.valueOf(temp[1])
						&& game.solidsY.get(i) == Integer.valueOf(temp[2])) {
					game.solidsX.remove(i);
					game.solidsY.remove(i);
					log("Removed solid at X:" + temp[1] + " Y:" + temp[2]);
				}
			}

		} else if (command.startsWith("clearsolids")) {

			game.solidsX.clear();
			game.solidsY.clear();
			log("Removed all solids");

		}

	}
	///////////////////////// bat event

	private void handleRequest(String content, Connection connection) {

		System.out.println("Request: " + content);

		/**
		 * --- COMMANDS ---
		 *
		 * getID;[color] setID;[id]
		 *
		 * direction;[id];[direction]
		 *
		 * update;[field] score;[id];[score] dead;[id] highscore;[highscore]
		 * colors;[id]:[color];[id2]...
		 *
		 * getHighscore getColors
		 *
		 * dead;[id]
		 *
		 */
		if (content.startsWith("Name;#")) {
			/// JOptionPane.showMessageDialog(null, "Nhan : +++++ " + content);
			String infor[] = content.split(";");

			String playerName = "";
			try {
				playerName = infor[2];
			} catch (Exception e) {
				playerName = "";
			}

			// Player newPlayer = new Player(game.players.size() + 2, infor[1], infor[2]);
			// game.players.add(newPlayer);
			// respond("setID;" + newPlayer.id, connection);
			// clients.put(connection.getID(), newPlayer.id);

			// update colors
			// Response response = new Response();
			// response.content = "colors;" + newPlayer.id + ":" + newPlayer.color;
			// server.sendToAllTCP(response);

			// log("Player " + newPlayer.id + " joined the game (Client " +
			// connection.getID() + ")");

			listPlayer.add(playerName);// cat tu vt 5 toi cuoi
			// JOptionPane.showMessageDialog(null, "Nhan : +++++ " + listPlayer.get(0));
			// respond("aaaa", connection); 1 nguoi

			// tra ve tat ca cac may ds nguoi choi
			StringBuffer buf = new StringBuffer();
			Iterator<String> itr = listPlayer.iterator();
			while (itr.hasNext()) {
				String temp = itr.next();
				System.out.println("***list: " + temp);
				buf.append(temp.trim()).append("\n");
			}

			String message = buf.toString();
			Response res = new Response();
			res.content = "playerName:;" + message;
			// gui toi all may client ds cap nhat
			server.sendToAllTCP(res);

		} else if (content.startsWith("connect")) {

			System.out.println("==== Client1 send: " + content);
			respond("success", connection); // 1 nguoi

		} else if (content.startsWith("delete")) {
			String playerName = content.split(";")[1];
			int i = 0;
			System.out.println("XOA DS=========== ");
			if (ServerHandler.listPlayer.isEmpty()) {
				System.out.println("empty");
			} else {
				for (String f : ServerHandler.listPlayer) {
					System.out.println("f: " + f);
					if (f.equalsIgnoreCase(playerName) == true) {
						ServerHandler.listPlayer.remove(i);
						i--;
						System.out.println("xoa ok");
					}
					i++;
				}
			}
			// tra ve tat ca cac may ds nguoi choi
			StringBuffer buf = new StringBuffer();
			Iterator<String> itr = listPlayer.iterator();
			while (itr.hasNext()) {
				String temp = itr.next();
				System.out.println("***list: " + temp);
				buf.append(temp.trim()).append("\n");
			}

			String message = buf.toString();
			Response res = new Response();
			res.content = "playerName:;" + message;
			// gui toi all may client ds cap nhat
			server.sendToAllTCP(res);

		} else if (content.startsWith("CreateRoom")) {
			// System.out.println(" === ROOM REQUEST: " + message);
			String[] str1 = content.split(";");
			for (int i = 0; i < str1.length; i++) {
				System.out.println(" - str1: " + str1[i]);
				if (i == (str1.length - 1)) {
					RoomMaster = str1[i];
					room.setRoomMaster(str1[i]);

				}
				if (i == (str1.length - 2)) {
					RoomID = str1[i];
					room.setRoomID(str1[i]);

				}
			}
			// khi tao rĂ´m thanh cong reset lai room status
			room.setRoomStatus(0);
			// room.clean();
			// tra ve cho client
			String message = "createRoomSuccess;" + room.getRoomMaster() + ";" + room.getRoomID();
			respond(message, connection);
		} else if (content.startsWith("JoinRoom")) {
			String playerName = "";
			System.out.println(" === ROOM REQUEST: " + content);
			String[] str1 = content.split(";");
			for (int i = 0; i < str1.length; i++) {
				System.out.println(" - str1: " + str1[i]);
				if (i == (str1.length - 1)) {
					playerName = str1[i];

				}
				if (i == (str1.length - 2)) {
					RoomID = str1[i];

				}
			}
			// kiem tra nguoi do co trong room chua
			System.out.println("---- Player are in room! ---- " + room.getPlayer().size());
			Iterator<String> itr = room.getPlayer().iterator();
			while (itr.hasNext()) {
				String temp = itr.next();
				if (temp.equalsIgnoreCase(playerName)) {
					// JOptionPane.showMessageDialog(null, "You are in room!");
					isInRoom = true;
					System.out.println("---- player ---- : " + temp);
					System.out.println("---- You are in room! ---- ");
					break;
				}
			}

			String message = "";
			System.out.println("isInRoom " + isInRoom);
			System.out.println("< 4 " + room.check());
			System.out.println("roomID: " + room.getRoomID());
			System.out.println("tinh trang: " + room.getRoomStatus());
			// thĂªm ngÆ°á»�i chÆ¡i vĂ o náº¿u ID Ä‘Ăºng vĂ  phong Ä‘Ă³ chÆ°a start va kiem
			// tra so nguoi < 4
			if (RoomID.equals(room.getRoomID()) == true && room.getRoomStatus() == 0 && room.check() == true
					&& isInRoom == false) {
				room.addPlayer(playerName);
				message = "joinRoomSuccess;" + room.getRoomMaster() + ";" + room.getRoomID() + ";"
						+ String.valueOf(room.getRoomStatus());
				respond(message, connection);

			} else {
				message = "CannotJoinRoomSuccess;" + room.getRoomMaster() + ";" + room.getRoomID() + ";"
						+ String.valueOf(room.getRoomStatus());
				respond(message, connection);
			}
			isInRoom = false;
		} else if (content.startsWith("startGame")) {
			String playerName = "";
			System.out.println(" === ROOM REQUEST: " + content);
			String[] str1 = content.split(";");
			for (int i = 0; i < str1.length; i++) {
				System.out.println(" - str1: " + str1[i]);
				if (i == (str1.length - 1)) {
					playerName = str1[i];

				}
				if (i == (str1.length - 2)) {
					RoomID = str1[i];

				}
			}
			// náº¿u lĂ  chá»§ ms start game
			String message = "";
			if (RoomID.equals(room.getRoomID()) == true && playerName.equals(room.getRoomMaster()) == true) {
				room.setRoomStatus(1); // dang choi
				message = "startGame;" + room.getRoomMaster() + ";" + room.getRoomID() + ";"
						+ String.valueOf(room.getRoomStatus());
				respond(message, connection);

				// dem ngÆ°á»£c
				Response res = new Response();
				res.content = "count";
				// gui toi all may client
				server.sendToAllTCP(res);
			} else {
				message = "CannnotStartGame;" + room.getRoomMaster() + ";" + room.getRoomID() + ";"
						+ String.valueOf(room.getRoomStatus());
				respond(message, connection);
			}
		} else if (content.startsWith("LeaveRoom")) {
			String playerName = "";
			System.out.println(" === ROOM REQUEST: " + content);
			String[] str1 = content.split(";");
			for (int i = 0; i < str1.length; i++) {
				System.out.println(" - str1: " + str1[i]);
				if (i == (str1.length - 1)) {
					playerName = str1[i];

				}
				if (i == (str1.length - 2)) {
					RoomID = str1[i];

				}
			}

			//
			if (RoomID.equals(room.getRoomID()) == true && room.getRoomStatus() == 0 && isInRoom == false) {
				Iterator<String> itr = room.getPlayer().iterator();
				int i = 0;
				System.out.println(" + danh sach trk khi xoa: ");
				while (itr.hasNext()) {
					String temp = itr.next();
					if (temp.equalsIgnoreCase(playerName)) {
						break;
					}
					i++;
				}
				System.out.println("i: " + i);
				System.out.println("player remove: " + room.getPlayer().get(i));
				room.removePlayer(i);
				// update room master
				if (room.getPlayer().size() >= 1) {
					RoomMaster = room.getPlayer().get(0);
					room.setRoomMaster(RoomMaster);
					System.out.println("Room master: " + RoomMaster);
					System.out.println(" + danh sach sau khi xoa: ");
					Iterator<String> itr1 = room.getPlayer().iterator();

					while (itr1.hasNext()) {
						String temp = itr1.next();
						System.out.println("player: " + temp);

					}
					String message = "leaveRoomSuccess;" + room.getRoomMaster() + ";" + room.getRoomID();
					respond(message, connection);
				}
				// neu con 1 nguoi leave
				if (room.getPlayer().size() == 0) {
					room.clean();
					RoomID = "";
					RoomMaster = "";
					respond("clearRoom", connection);
				}

			}
		}
		 else if (content.startsWith("getID")) {
		String[] infor = content.split(";");
		 // begin with 2 ( -> 0 nothing 1 fruit -1 border)
		 Player newPlayer = new Player(game.players.size() + 2, infor[1], infor[2]);
		 game.players.add(newPlayer);
		 respond("setID;" + newPlayer.id, connection);
		 clients.put(connection.getID(), newPlayer.id);
		
		 // update colors
		 Response response = new Response();
		 response.content = "colors;" + newPlayer.id + ":" + newPlayer.color;
		 server.sendToAllTCP(response);
		
		 log("Player " + newPlayer.id + " joined the game (Client " +
		 connection.getID() + ")");
		
		 }
		else if (content.startsWith("direction")) {

			String temp[] = content.split(";");
			Player player = game.players.get(Integer.valueOf(temp[1]) - 2);
			if (player == null) {
				return;
			}
			player.direction = Integer.valueOf(temp[2]);

		} else if (content.startsWith("getHighscore")) {

			respond("highscore;" + game.highscore, connection);

		} else if (content.startsWith("getColors")) {

			String colors = "";
			for (Player p : game.players) {
				if (p == null) {
					continue;
				}
				colors += p.id + ":" + p.color + ";";
			}
			if (colors.length() == 0) {
				return;
			}
			colors = colors.substring(0, colors.length() - 1);
			respond("colors;" + colors, connection);

		}

	}

	private void respond(String content, Connection connection) {
		Response response = new Response();
		response.content = content;
		connection.sendTCP(response);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// update
		game.update();

		// send to clients
		String raw = "";
		for (int y = 0; y < Game.HEIGHT; y++) {
			for (int x = 0; x < Game.WIDTH; x++) {
				raw += String.valueOf(game.field[x][y]) + ":";
			}
			raw = raw.substring(0, raw.length() - 1);
			raw += ";";
		}
		raw = raw.substring(0, raw.length() - 1);

		Response response = new Response();
		response.content = "update;" + raw;
		server.sendToAllTCP(response);

		// scores and dead updates
		for (int i = 0; i < game.players.size(); i++) {
			Player p = game.players.get(i);

			if (p != null && p.updateScore) {
				response = new Response();
				response.content = "score;" + p.id + ";" + p.score;
				server.sendToAllTCP(response);
				p.updateScore = false;

				if (p.score > game.highscore) {
					game.highscore = p.score;
					response = new Response();
					response.content = "highscore;" + game.highscore + ";" + p.name;
					server.sendToAllTCP(response);
					log("New highscore by player " + p.id + ": " + game.highscore);
				}

			} else if (p == null && !deadIds.contains(i + 2)) {
				deadIds.add(i + 2);
				response = new Response();
				response.content = "dead;" + (i + 2);
				// JOptionPane.showMessageDialog(null,"Nguoi cuoi cung chet");
				server.sendToAllTCP(response);
				log("Player " + (i + 2) + " died");
			}

		}

	}

}
