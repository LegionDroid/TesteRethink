package com.brunorfreitas.rethink3_0.Data.Preferences;

public class Search {

    private String codAer1;
    private String codAer2;
    private String dateIda;
    private int passengers;
    private String dateVolta;

    public Search(String codAer1, String codAer2, String dateIda, int passengers) {
        this.codAer1 = codAer1;
        this.codAer2 = codAer2;
        this.dateIda = dateIda;
        this.passengers = passengers;
    }

    public Search(String codAer1, String codAer2, String dateIda, int passengers, String dateVolta) {
        this.codAer1 = codAer1;
        this.codAer2 = codAer2;
        this.dateIda = dateIda;
        this.passengers = passengers;
        this.dateVolta = dateVolta;
    }

    public String getCodAer1() {
        return codAer1;
    }

    public void setCodAer1(String codAer1) {
        this.codAer1 = codAer1;
    }

    public String getCodAer2() {
        return codAer2;
    }

    public void setCodAer2(String codAer2) {
        this.codAer2 = codAer2;
    }

    public String getDateIda() {
        return dateIda;
    }

    public void setDateIda(String dateIda) {
        this.dateIda = dateIda;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getDateVolta() {
        return dateVolta;
    }

    public void setDateVolta(String dateVolta) {
        this.dateVolta = dateVolta;
    }
}
