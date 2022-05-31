package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private Long roomNumber;
    private String building;

    public Office() {
    }

    public Office(String building) {
        this.building = building;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Office{" +
                "roomNumber=" + roomNumber +
                ", building='" + building + '\'' +
                '}';
    }
}
