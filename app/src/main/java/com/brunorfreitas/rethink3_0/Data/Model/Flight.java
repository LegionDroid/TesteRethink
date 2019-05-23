package com.brunorfreitas.rethink3_0.Data.Model;

import java.util.List;

public class Flight {

    private String uid;
    private String cabin;
    private Integer stops;
    private Departure departure;
    private Arrival arrival;
    private Airline airline;
    private Integer duration;
    private List<Leg> legList = null;
    private List<Fare> fareList = null;
    private Integer availableSeats;

    public Flight() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Leg> getLegList() {
        return legList;
    }

    public void setLegList(List<Leg> legList) {
        this.legList = legList;
    }

    public List<Fare> getFareList() {
        return fareList;
    }

    public void setFareList(List<Fare> fareList) {
        this.fareList = fareList;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "uid='" + uid + '\'' +
                ", cabin='" + cabin + '\'' +
                ", stops=" + stops +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", airline=" + airline +
                ", duration=" + duration +
                ", legList=" + legList +
                ", fareList=" + fareList +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
