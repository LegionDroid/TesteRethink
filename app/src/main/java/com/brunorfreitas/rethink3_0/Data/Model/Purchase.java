package com.brunorfreitas.rethink3_0.Data.Model;

public class Purchase {

    private String flight1;
    private String fare1;
    private String flight2;
    private String fare2;
    private int passengers;
    private Total total;

    public Purchase(String flight1, String fare1, String flight2, String fare2, int passengers, Total total) {
        this.flight1 = flight1;
        this.fare1 = fare1;
        this.flight2 = flight2;
        this.fare2 = fare2;
        this.passengers = passengers;
        this.total = total;
    }

    public Purchase(String flight1, String fare1, int passengers, Total total) {
        this.flight1 = flight1;
        this.fare1 = fare1;
        this.passengers = passengers;
        this.total = total;
    }

    public String getFlight1() {
        return flight1;
    }

    public void setFlight1(String flight1) {
        this.flight1 = flight1;
    }

    public String getFare1() {
        return fare1;
    }

    public void setFare1(String fare1) {
        this.fare1 = fare1;
    }

    public String getFlight2() {
        return flight2;
    }

    public void setFlight2(String flight2) {
        this.flight2 = flight2;
    }

    public String getFare2() {
        return fare2;
    }

    public void setFare2(String fare2) {
        this.fare2 = fare2;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }
}
