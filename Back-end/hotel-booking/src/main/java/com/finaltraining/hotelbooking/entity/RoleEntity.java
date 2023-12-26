package com.finaltraining.hotelbooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_entity")
public class RoleEntity extends BaseEntity {

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}