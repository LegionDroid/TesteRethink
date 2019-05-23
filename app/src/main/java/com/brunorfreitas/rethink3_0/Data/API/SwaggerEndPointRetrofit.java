package com.brunorfreitas.rethink3_0.Data.API;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Model.Login;
import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlightsResponse;
import com.brunorfreitas.rethink3_0.Data.Model.Purchase;
import com.brunorfreitas.rethink3_0.Data.Model.RequestedFlightSegmentList;
import com.brunorfreitas.rethink3_0.Data.Model.ResponseCode;
import com.brunorfreitas.rethink3_0.Data.Model.Tarifa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SwaggerEndPointRetrofit {

    @GET("locations")
    Call<List<Airport>> getLocations();

    @GET("search")
    Call<RequestedFlightSegmentList> getFlights(
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("departure1") String dateDeparture,
            @Query("passengers") int passengers,
            @Query("departure2") String dateReturn
    );

    @GET("taxes")
    Call<Tarifa> getTaxes(
            @Query("flight1") String vooPartida,
            @Query("fare1") String fareVooPartida,
            @Query("passengers") int passengers,
            @Query("flight2") String vooRetorno,
            @Query("fare2") String fareVooRetorno
    );

    @POST("login")
    Call<LoginResponse> register(@Body Login login);

    @POST("checkout")
    Call<ResponseCode> setCheckout(@Header("Authorization") String token,
                                   @Body Purchase purchase);

    @GET("my-flights")
    Call<MyFlightsResponse> getMyFlights(@Header("Authorization") String token);

}
