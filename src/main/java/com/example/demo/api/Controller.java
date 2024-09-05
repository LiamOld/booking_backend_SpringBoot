package com.example.demo.api;

import com.example.demo.DAO.DaoMySQL;
import com.example.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping( path = "/room/{room_id}")
    public Optional<Room> getRoom(@PathVariable("room_id") String room_id) throws IOException {
        System.out.println("receive the get information");
//        System.out.println(room_id);
        return doaMySQL.getRoom(room_id);
    }
}
