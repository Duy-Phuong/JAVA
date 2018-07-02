/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MessageProcessorRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;
    
    //list player
    public static List<String> listPlayer = new ArrayList<String>();
    //chu phong
    public static String RoomMaster = "";
    public static String RoomID = "";
    
    public static Room room = new Room();

    public MessageProcessorRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            PrintStream printStream = new PrintStream(output);
            InputStreamReader inputStream = new InputStreamReader(input);
            long time = System.currentTimeMillis();
            
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String message = null;
            message = bufferedReader.readLine();
            
            System.out.println("Danh sach: " + message);
            //neu yeu cau showlist   createRoomSuccess
             if(message.startsWith("startGame")){
                 String playerName = "";
                System.out.println(" === ROOM REQUEST: " + message);
                String[] str1 = message.split(" ");
                for (int i = 0; i < str1.length; i++) {
                    System.out.println("\n - str1: " + str1[i]);
                    if(i == (str1.length-1)){
                       playerName = str1[i];
                        
                    }
                     if(i == (str1.length-2)){
                        RoomID = str1[i];
                        
                        
                    }
                }
                //nếu là chủ ms start game
                 if(RoomID.equals(room.getRoomID()) == true && playerName.equals(room.getRoomMaster()) == true){
                    room.setRoomStatus(1); //dang choi
                    message = "startGame " + room.getRoomMaster() + " " + room.getRoomID() + " " + String.valueOf(room.getRoomStatus());

                }else{
                    message = "CannnotStartGame " + room.getRoomMaster() + " " + room.getRoomID() + " " + String.valueOf(room.getRoomStatus());
                 }
            }else if(message.startsWith("JoinRoom")){
                String playerName = "";
                System.out.println(" === ROOM REQUEST: " + message);
                String[] str1 = message.split(" ");
                for (int i = 0; i < str1.length; i++) {
                    System.out.println("\n - str1: " + str1[i]);
                    if(i == (str1.length-1)){
                        playerName = str1[i];
                        
                        
                    }
                     if(i == (str1.length-2)){
                        RoomID = str1[i];
                        
                    }
                }
                //thêm người chơi vào nếu ID đúng và phong đó chưa start va kiem tra so nguoi < 4
                if(RoomID.equals(room.getRoomID()) == true && room.getRoomStatus() == 0 && room.check() == true){
                    room.addPlayer(playerName);
                    message = "joinRoomSuccess " + room.getRoomMaster() + " " + room.getRoomID() + " " + String.valueOf(room.getRoomStatus());

                }else{
                    message = "CannotJoinRoomSuccess " + room.getRoomMaster() + " " + room.getRoomID() + " " + String.valueOf(room.getRoomStatus());
                }
            }else if(message.startsWith("CreateRoom")){
                System.out.println(" === ROOM REQUEST: " + message);
                String[] str1 = message.split(" ");
                for (int i = 0; i < str1.length; i++) {
                    System.out.println("\n - str1: " + str1[i]);
                    if(i == (str1.length-1)){
                        RoomMaster = str1[i];
                        room.setRoomMaster(str1[i]);
                        
                    }
                     if(i == (str1.length-2)){
                        RoomID = str1[i];
                        room.setRoomID(str1[i]);
                        
                    }
                }
                message = "createRoomSuccess " + room.getRoomMaster() + " " + room.getRoomID();
            }else if(message.equalsIgnoreCase("ShowList")==true){
                System.out.println("ADD");
                StringBuffer buf =  new StringBuffer();
                Iterator<String> itr = listPlayer.iterator();
                while (itr.hasNext()) {
                    String temp = itr.next();
                    System.out.print("\n***list: " + temp);
                    buf.append(temp).append("\n");
                 }

                message = buf.toString();
                
            }else{
            //read
                 listPlayer.add(message);
                System.out.println("ADD LIST OK");
                 Iterator<String> itr = listPlayer.iterator();
                 while (itr.hasNext()) {
                System.out.print("\n **** list: " + itr.next());
                
             }
            }
            
            System.out.println("\n-message received from client: \n\t"+message);
            processingDelay(1000);
            System.out.println("Send back the same message "+message);  
            

            output.write(message.getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
    public static void processingDelay(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException ex) {
            
        }
    }
}
