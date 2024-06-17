package com.StreamFusion.operador_service.Dto;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
