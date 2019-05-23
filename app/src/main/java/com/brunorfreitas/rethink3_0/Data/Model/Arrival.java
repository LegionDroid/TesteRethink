package com.brunorfreitas.rethink3_0.Data.Model;

public class Arrival {
    private String date;
    private Airport airport;

    public Arrival() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
