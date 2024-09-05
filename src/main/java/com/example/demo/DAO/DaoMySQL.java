package com.example.demo.DAO;

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





}