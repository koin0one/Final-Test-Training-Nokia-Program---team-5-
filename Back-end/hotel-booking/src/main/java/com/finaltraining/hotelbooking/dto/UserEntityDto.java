package com.finaltraining.hotelbooking.dto;

import com.finaltraining.hotelbooking.entity.RoleEntity;

import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.finaltraining.hotelbooking.entity.UserEntity}
 */
public class UserEntityDto{
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private Boolean gender;
    private Long age;
    private String email;
    private Long phoneNumber;
    private String address;
    private Long pinCode;
    private RoleEntity role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDto entity = (UserEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.pinCode, entity.pinCode) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, email, phoneNumber, address, pinCode, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fistName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "gender = " + gender + ", " +
                "age = " + age + ", " +
                "email = " + email + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "address = " + address + ", " +
                "pinCode = " + pinCode + ", " +
                "role = " + role + ")";
    }
}