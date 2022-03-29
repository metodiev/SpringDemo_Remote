package com.example.demo.models;


import javax.persistence.*;

@Entity
public class RemoteControl {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private boolean powerButton;
    private int distance;

    public boolean isPowerButton() {
        System.out.println("none");
        return powerButton;
    }

    public void setPowerButton(boolean powerButton) {
        this.powerButton = powerButton;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
