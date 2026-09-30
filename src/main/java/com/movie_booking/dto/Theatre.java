package com.movie_booking.dto;

public class Theatre {

    private int theatreId;
    private String theatreName;
    private String location;
    private String screenType;
    private int totalSeats;

    public Theatre() {
    }

    public Theatre(int theatreId, String theatreName, String location,
            String screenType, int totalSeats) {

        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.location = location;
        this.screenType = screenType;
        this.totalSeats = totalSeats;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Theatre [theatreId=" + theatreId +
                ", theatreName=" + theatreName +
                ", location=" + location +
                ", screenType=" + screenType +
                ", totalSeats=" + totalSeats + "]";
    }
}