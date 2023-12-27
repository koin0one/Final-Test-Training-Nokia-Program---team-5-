package com.finaltraining.hotelbooking.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "booking_entity")
public class BookingEntity extends BaseEntity {
    @Column(name = "booking_code", nullable = false, unique = true)
    private Integer bookingCode;
    @Column(name = "check_in_date")
    private Date checkInDate;
    @Column(name = "check_out_date")
    private Date checkOutDate;
    @Column(name = "total_amount")
    private Integer totalAmount;
    @Column(name = "booking_date")
    private Date bookingDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @OneToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    public Integer getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Integer bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}