package com.finaltraining.hotelbooking.dto;

import java.io.Serializable;
import java.net.URL;
import java.util.Collection;
import java.util.UUID;

/**
 * DTO for {@link com.finaltraining.hotelbooking.entity.HotelEntity}
 */
public class HotelEntityDto {
    private UUID id;
    private String hotelName;
    private String imageURL;
    private String description;
    private String address;
    private Collection<RoomEntityDto> rooms;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<RoomEntityDto> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<RoomEntityDto> rooms) {
        this.rooms = rooms;
    }

}