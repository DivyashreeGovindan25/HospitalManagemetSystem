package com.HSM.Hospital.system.Controller;

import com.HSM.Hospital.system.Models.Hospital;
import com.HSM.Hospital.system.Models.Room;
import com.HSM.Hospital.system.Service.HospitalService;
import com.HSM.Hospital.system.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/Rooms")
public class RoomController {
    @Autowired
    RoomService rs;
    @Autowired
    HospitalService hs;
    @PostMapping("/AddRooms")
    public String addRoomsToHospital(@RequestBody Room room){
        rs.addRoomToHospital(room);
        return "Room added in hospital";
    }
    @GetMapping("/GetAllUnOccupiedRooms")
    public List<Room> getAllUnOccupiedRooms(){
        return rs.getAllUnOccupiedRooms();
    }
    @GetMapping("/GetAllRooms")
    public List<Room> getAllRooms(){
        return rs.getAllRooms();
    }

    @GetMapping("/{h}/getAllUnOccupiedRoomsByHID")
    public List<Room> getAllUnOccupiedRoomsByHID(@PathVariable UUID h){
//        List<Room> list= rs.getAllUnOccupiedRoomsByHID(h);
//        for(Room room : list){
//            System.out.println(room.getRoomID());
//            System.out.println(room.isOccupied());
//            System.out.println(room.getHospitalID());
//            System.out.println(room.getDoctor());
//            System.out.println(room.getPatient());
//        }
        return rs.getAllUnOccupiedRoomsByHID(h);
    }
}
