package com.example.demo.DAO;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DaoMySQL {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoMySQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Room> getRoom(String roomId) {
        final String sql = "select * from room where room_id = ?";

        Room room = jdbcTemplate.queryForObject(
                sql,
                new Object[]{roomId},
                (resultSet, i) -> {
                    String room_id = resultSet.getString("room_id");
                    String hotel_name = resultSet.getString("hotel_name");
                    String room_number = resultSet.getString("room_number");
                    String room_type = resultSet.getString("room_type");
                    int price = resultSet.getInt("price");
                    String features = resultSet.getString("features");
                    return new Room(room_id, hotel_name, room_number, room_type, price, features);
                });

        return Optional.ofNullable(room);
    }

    public void addRoom(Room room){

        String room_id = room.getRoom_id();
        String hotel_name = room.getHotel_name();
        String room_number = room.getRoom_number();
        String room_type = room.getRoom_type();
        int price = room.getPrice();
        String features=room.getFeatures();

        System.out.println("hotel_name:"+hotel_name);

        String sql = "INSERT INTO room(room_id, room_number, hotel_name, room_type, price, features) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, room_id, room_number, hotel_name, room_type, price, features);
    }

    // define a addHotel() method for adding new hotel information to the hotelDate file.
    public void addHotel(Hotel hotel){

        String hotel_name = hotel.getHotel_name();
        String city = hotel.getCity();
        String area = hotel.getArea();
        String address = hotel.getAddress();
        int number_of_room = hotel.getNumber_of_room();
        String administer = hotel.getAdminister();

        String sql = "INSERT INTO hotel(hotel_name, city, area, address, number_of_room, administer) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, hotel_name, city, area, address, number_of_room, administer);
    }





}
