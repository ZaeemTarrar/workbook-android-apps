package com.example.mydroid3.model;

public class RoleModel {
    private int _id;
    private String title;
    private boolean activeStatus;
    private String SubRole;

    public RoleModel() {
    }

    public RoleModel(int id, String title, boolean activeStatus, String subRole) {
        _id = id;
        this.title = title;
        this.activeStatus = activeStatus;
        SubRole = subRole;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getSubRole() {
        return SubRole;
    }

    public void setSubRole(String subRole) {
        SubRole = subRole;
    }
}
