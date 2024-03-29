package com.finaltraining.hotelbooking.entity;

import jakarta.persistence.*;

import java.net.URL;
import java.util.Collection;

@Entity
@Table(name = "room_entity")
public class RoomEntity extends BaseEntity {
    @Column(name = "room_number", nullable = false, unique = true)
    private Integer roomNumber;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "facilities")
    private String facilities;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "number_of_bed")
    private Integer numberOfBed;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomTypeEntity roomType;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(Integer numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
}