package com.finaltraining.hotelbooking.entity;

import jakarta.persistence.*;

import java.net.URL;
import java.util.Collection;

@Entity
@Table(name = "hotel_entity")
public class HotelEntity extends BaseEntity {
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "image_url")
    private URL imageURL;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @ManyToMany(mappedBy = "hotel")
    private Collection<RoomEntity> room;
    @ManyToMany(mappedBy = "hotel")
    private Collection<RoomTypeEntity> roomType;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
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

    public Collection<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(Collection<RoomEntity> room) {
        this.room = room;
    }

    public Collection<RoomTypeEntity> getRoomType() {
        return roomType;
    }

    public void setRoomType(Collection<RoomTypeEntity> roomType) {
        this.roomType = roomType;
    }
}