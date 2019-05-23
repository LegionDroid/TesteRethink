package com.brunorfreitas.rethink3_0.Data.Model;

class Leg {

    private String cabin;
    private Integer flightNumber;
    private String equipment;
    private Integer stops;
    private Integer duration;
    private Departure departure;
    private Arrival arrival;
    private Airline marketingAirline;
    private Airline operationAirline;

    public Leg() {
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public Airline getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(Airline marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public Airline getOperationAirline() {
        return operationAirline;
    }

    public void setOperationAirline(Airline operationAirline) {
        this.operationAirline = operationAirline;
    }
}
