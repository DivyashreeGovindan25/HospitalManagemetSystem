package com.HSM.Hospital.system.Service;

import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Patient;
import com.HSM.Hospital.system.Models.Room;
import com.HSM.Hospital.system.Repository.RoomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    RoomsRepo roomsRepo;
    @Autowired
    HospitalService hs;
    public void addRoomToHospital(Room room){
        UUID hospID = room.getHospitalID();
        hs.getHospital(hospID).addRoom(room);
        roomsRepo.addRoom(room);
    }
    public List<Room> getAllUnOccupiedRooms(){
        return roomsRepo.getAllUnOccupiedRooms();
    }
    public List<Room> getAllUnOccupiedRoomsByHID(UUID hID){
//        List<Room> list= roomsRepo.getAllUnOccupiedRoomsByHID(hID);
//        for(Room room : list){
//            System.out.println(room.getRoomID());
//            System.out.println(room.isOccupied());
//            System.out.println(room.getHospitalID());
//            System.out.println(room.getDoctor());
//            System.out.println(room.getPatient());
//        }
        return roomsRepo.getAllUnOccupiedRoomsByHID(hID);
    }

    public void occupy(UUID docID,UUID pID,UUID roomNO){
        roomsRepo.occupy(docID,pID,roomNO);
    }
    public void unOccupyRoom(UUID roomNO){
        Room room = roomsRepo.getRoom(roomNO);
        room.setDoctor(null);
        room.setOccupied(false);
        room.setPatient(null);
    }
    public List<Room> getAllRooms(){
        return roomsRepo.getAllRooms();
    }
}
