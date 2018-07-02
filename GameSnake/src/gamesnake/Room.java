/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesnake;

import java.util.*;

/**
 *
 * @author admin1
 */
public class Room {
    private String RoomID = "";
    private String RoomMaster = "";
    private int RoomStatus = 0;
    private List<String> player = new ArrayList<>();

    public Room() {
       
    }
    public Room(String RoomID, String RoomMaster, int RoomStatus, List<String> player) {
        this.RoomID = RoomID;
        this.RoomMaster = RoomMaster;
        this.RoomStatus = RoomStatus;
        this.player = player;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getRoomMaster() {
        return RoomMaster;
    }

    public void setRoomMaster(String RoomMaster) {
        this.RoomMaster = RoomMaster;
    }

    public int getRoomStatus() {
        return RoomStatus;
    }

    public void setRoomStatus(int RoomStatus) {
        this.RoomStatus = RoomStatus;
    }

    public List<String> getPlayer() {
        return player;
    }

    public void setPlayer(List<String> player) {
        this.player = player;
    }
    public void addPlayer(String player) {
        this.player.add(player);
    }
    
    
    
    
}
