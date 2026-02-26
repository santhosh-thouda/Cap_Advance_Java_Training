package com.university;

import javax.persistence.*;

@Entity
public class InstructorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String officeRoom;
    private String phone;

    public int getId() { return id; }

    public String getOfficeRoom() { return officeRoom; }
    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
