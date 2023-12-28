package com.finaltraining.hotelbooking.dto;

import com.finaltraining.hotelbooking.entity.HotelEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * DTO for {@link com.finaltraining.hotelbooking.entity.RoomTypeEntity}
 */
public class RoomTypeEntityDto {
    private UUID id;
    private String roomTypeName;
    private Integer pricePerNight;
    private String furniture;
    private String description;
    private Collection<RoomEntityDto> rooms;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Collection<RoomEntityDto> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<RoomEntityDto> rooms) {
        this.rooms = rooms;
    }

}