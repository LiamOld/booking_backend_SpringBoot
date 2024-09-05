package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Room {
    private final String room_id;
    private final String hotel_name;
    private final String room_number;
    private final String room_type;
    private final int price;
    private final String features;

    public Room(@JsonProperty("room_id") String room_id,
                @JsonProperty("hotel_name") String hotel_name,
                @JsonProperty("room_number") String room_number,
                @JsonProperty("room_type") String room_type,
                @JsonProperty("price") int price,
                @JsonProperty("features") String features) {
        this.room_id = room_id;
        this.hotel_name = hotel_name;
        this.room_number = room_number;
        this.room_type = room_type;
        this.price = price;
        this.features = features;
    }

    public String getRoom_id() {
        return room_id;
    }
    public String getHotel_name() {
        return hotel_name;
    }
    public String getRoom_number() {
        return room_number;
    }
    public String getRoom_type() {
        return room_type;
    }
    public int getPrice() {
        return price;
    }
    public String getFeatures() {
        return features;
    }
}
