package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {

    private final String hotel_name;
    private final String city;
    private final String area;
    private final String address;
    private final int number_of_room;
    private final String administer;

    public Hotel(@JsonProperty("hotel_name") String hotel_name,
                 @JsonProperty("city") String city,
                 @JsonProperty("area") String area,
                 @JsonProperty("address") String address,
                 @JsonProperty("number_of_room") int number_of_room,
                 @JsonProperty("administer") String administer) {
        this.hotel_name = hotel_name;
        this.city = city;
        this.area = area;
        this.address = address;
        this.number_of_room = number_of_room;
        this.administer = administer;
    }

    public String getHotel_name() {
        return hotel_name;
    }
    public String getCity() {
        return city;
    }
    public String getArea() {
        return area;
    }
    public String getAddress() {
        return address;
    }
    public int getNumber_of_room() {
        return number_of_room;
    }
    public String getAdminister() {
        return administer;
    }
}