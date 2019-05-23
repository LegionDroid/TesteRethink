package com.brunorfreitas.rethink3_0.Data.API;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlightsResponse;
import com.brunorfreitas.rethink3_0.Data.Model.Purchase;
import com.brunorfreitas.rethink3_0.Data.Model.RequestedFlightSegmentList;
import com.brunorfreitas.rethink3_0.Data.Model.ResponseCode;
import com.brunorfreitas.rethink3_0.Data.Model.Tarifa;
import com.brunorfreitas.rethink3_0.Data.Model.Total;
import com.brunorfreitas.rethink3_0.Data.Model.User;

import java.util.List;

public interface ApiService {
    interface ApiServiceCallback<T> {
        void onSucces(T result);
        void onFailure(String message);
    }

    void getLocations(ApiServiceCallback<List<Airport>> callback);

    void getSearchFlights(String codeOrigin, String codeDestination, String dateDeparture,
                          int passengers, String dateReturn,
                          ApiServiceCallback<RequestedFlightSegmentList> callback);

    void getTarifa(String uidVooPartida, String uidFareVooPartida, int passengers,
                   String uidVooRetorno, String uidFareVooRetorno,
                   ApiServiceCallback<Tarifa> callback);

    void register(String username, ApiServiceCallback<LoginResponse> callback);

    void setCheckout(String token, Purchase purchase,
                     ApiServiceCallback<ResponseCode> callback);

    void getMyFlights(String token, ApiServiceCallback<MyFlightsResponse> callback);

}
