package com.finaltraining.hotelbooking.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.finaltraining.hotelbooking.entity.RoleEntity}
 */
public class RoleEntityDto {
    private UUID id;
    private String roleName;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntityDto entity = (RoleEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.roleName, entity.roleName) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "roleName = " + roleName + ", " +
                "description = " + description + ")";
    }
}