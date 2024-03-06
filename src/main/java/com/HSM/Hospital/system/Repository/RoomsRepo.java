package com.HSM.Hospital.system.Repository;

import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Room;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoomsRepo {
    HashMap<UUID, Room> roomsRepo;

    public RoomsRepo() {
        roomsRepo = new HashMap<>();
    }
    public void addRoom(Room room){
        UUID roomID = room.getRoomID();
        roomsRepo.put(roomID,room);
    }
    public List<Room> getAllUnOccupiedRoomsByHID(UUID hosp){
        List<Room> rooms = new ArrayList<>();
        for(UUID roomID : roomsRepo.keySet()){
            Room room = roomsRepo.get(roomID);
            if(!roomsRepo.get(roomID).isOccupied() && Objects.equals(room.getHospitalID(), hosp)){
                rooms.add(roomsRepo.get(roomID));
            }
        }
        return rooms;
    }
    public List<Room> getAllUnOccupiedRooms(){
        List<Room> rooms = new ArrayList<>();
        for(UUID roomID : roomsRepo.keySet()){
            if(!roomsRepo.get(roomID).isOccupied()) rooms.add(roomsRepo.get(roomID));
        }
        return rooms;
    }
    public List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<>();
        for(UUID roomID : roomsRepo.keySet()){
            rooms.add(roomsRepo.get(roomID));
        }
        return rooms;
    }
    public void occupy(UUID docID,UUID pID,UUID roomNo){
        roomsRepo.get(roomNo).setOccupied(true);
        roomsRepo.get(roomNo).setDoctor(docID);
        roomsRepo.get(roomNo).setPatient(pID);
    }
    public Room getRoom(UUID room){
        return roomsRepo.get(room);
    }
}
