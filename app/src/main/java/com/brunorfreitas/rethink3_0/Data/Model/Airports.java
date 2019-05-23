package com.brunorfreitas.rethink3_0.Data.Model;

import java.util.List;

public class Airports {

    private List<Airport> departureAirportList;
    private List<Airport> arrivalAirportList;

    public Airports() {
    }

    public List<Airport> getDepartureAirportList() {
        return departureAirportList;
    }

    public void setDepartureAirportList(List<Airport> departureAirportList) {
        this.departureAirportList = departureAirportList;
    }

    public List<Airport> getArrivalAirportList() {
        return arrivalAirportList;
    }

    public void setArrivalAirportList(List<Airport> arrivalAirportList) {
        this.arrivalAirportList = arrivalAirportList;
    }
}
