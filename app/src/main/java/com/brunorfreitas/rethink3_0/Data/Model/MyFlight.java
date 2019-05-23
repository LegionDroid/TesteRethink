package com.brunorfreitas.rethink3_0.Data.Model;

import java.util.List;

public class MyFlight {
    private String code;
    private List<Passenger> passengers = null;
    private Flight flight1;
    private Flight flight2;
    private Total total;

    public MyFlight() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Flight getFlight1() {
        return flight1;
    }

    public void setFlight1(Flight flight1) {
        this.flight1 = flight1;
    }

    public Flight getFlight2() {
        return flight2;
    }

    public void setFlight2(Flight flight2) {
        this.flight2 = flight2;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MyFlight{" +
                "code='" + code + '\'' +
                ", passengers=" + passengers +
                ", flight1=" + flight1 +
                ", flight2=" + flight2 +
                ", total=" + total +
                '}';
    }
}
