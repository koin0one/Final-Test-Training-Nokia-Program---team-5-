package com.finaltraining.hotelbooking.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "room_type_entity")
public class RoomTypeEntity extends BaseEntity {
    @Column(name = "room_type_name")
    private String roomTypeName;
    @Column(name = "price_per_night")
    private Integer pricePerNight;
    @Column(name = "furniture")
    private String furniture;
    @Lob
    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_entity", joinColumns = @JoinColumn(name = "room_type_id") ,
            inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private Collection<HotelEntity> hotel;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<HotelEntity> getHotel() {
        return hotel;
    }

    public void setHotel(Collection<HotelEntity> hotel) {
        this.hotel = hotel;
    }
}