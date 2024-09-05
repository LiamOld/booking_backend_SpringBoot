package com.example.demo.api;

import com.example.demo.DAO.DaoMySQL;
import com.example.demo.model.Room;
import com.example.demo.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RequestMapping("/test")
@RestController
public class Controller {

    private DaoMySQL doaMySQL;

    @Autowired
    public Controller(DaoMySQL doaMySQL) {
        this.doaMySQL = doaMySQL;
    }

    @GetMapping
    public String test(){
        return "test ok!";
    }

    @PostMapping("/room")
    public void addRoom(@RequestBody Room room){
        doaMySQL.addRoom(room);
    }

    // define a method to handle HTTP POST requests of hotel information, which is directly use the method of Doa class.
    // add @PostMapping annotation to mapping the requests with the endpoint of '/hotel'.
    @PostMapping("/hotel")
    public void addHotel(@RequestBody Hotel hotel) {
        doaMySQL.addHotel(hotel);
    }

    @GetMapping( path = "/room/{room_id}")
    public Optional<Room> getRoom(@PathVariable("room_id") String room_id) throws IOException {
        System.out.println("receive the get information");
//        System.out.println(room_id);
        return doaMySQL.getRoom(room_id);
    }
}
