package com.StreamFusion.buscador_service.dto;

public class RentRequest {
    private String platformName;
    private Long id;

    private int duration; // En días

    // Getters y Setters

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (long) id;
    }
}
