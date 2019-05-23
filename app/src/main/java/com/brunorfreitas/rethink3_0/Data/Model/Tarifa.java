package com.brunorfreitas.rethink3_0.Data.Model;

public class Tarifa {
    private Total total;
    private Integer passengers;
    private Fares fares;
    private Taxes taxes;

    public Tarifa() {
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Fares getFares() {
        return fares;
    }

    public void setFares(Fares fares) {
        this.fares = fares;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }
}
