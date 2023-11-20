package com.jesusfercan.associate.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum Role {

    ADMINISTRATOR (Arrays.asList(Permission.READ_ALL_DATABASE,Permission.SAVE_DATA)),
    USER (Arrays.asList(Permission.READ_ALL_DATABASE));

    private List<Permission> permissions;

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
