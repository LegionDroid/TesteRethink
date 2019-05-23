package com.brunorfreitas.rethink3_0.Data.Model;

import java.util.List;

public class MyFlightsResponse {

    private User user;
    private List<MyFlight> myFlights;

    public MyFlightsResponse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MyFlight> getMyFlights() {
        return myFlights;
    }

    public void setMyFlights(List<MyFlight> myFlights) {
        this.myFlights = myFlights;
    }

    @Override
    public String toString() {
        return "MyFlightsResponse{" +
                "user=" + user +
                ", myFlights=" + myFlights +
                '}';
    }
}



