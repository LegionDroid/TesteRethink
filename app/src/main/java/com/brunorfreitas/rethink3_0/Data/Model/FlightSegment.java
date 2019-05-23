package com.brunorfreitas.rethink3_0.Data.Model;

import java.util.List;

public class FlightSegment {

    private String type;
    private List<Flight> flightList;
    private Airports airports;
    private List<Airline> companyList;

    public FlightSegment() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
    }

    public List<Airline> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Airline> companyList) {
        this.companyList = companyList;
    }
}
