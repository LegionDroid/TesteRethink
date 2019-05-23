package com.brunorfreitas.rethink3_0.Data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestedFlightSegmentList {

    private List<FlightSegment> requestedFlightSegmentList;

    public RequestedFlightSegmentList() {
    }

    public List<FlightSegment> getRequestedFlightSegmentList() {
        return requestedFlightSegmentList;
    }

    public void setRequestedFlightSegmentList(List<FlightSegment> requestedFlightSegmentList) {
        this.requestedFlightSegmentList = requestedFlightSegmentList;
    }
}
