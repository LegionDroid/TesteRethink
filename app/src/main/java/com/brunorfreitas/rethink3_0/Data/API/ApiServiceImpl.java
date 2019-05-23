package com.brunorfreitas.rethink3_0.Data.API;

import android.util.Log;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Model.Login;
import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlightsResponse;
import com.brunorfreitas.rethink3_0.Data.Model.Purchase;
import com.brunorfreitas.rethink3_0.Data.Model.RequestedFlightSegmentList;
import com.brunorfreitas.rethink3_0.Data.Model.ResponseCode;
import com.brunorfreitas.rethink3_0.Data.Model.Tarifa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceImpl implements ApiService{

    private SwaggerEndPointRetrofit INSTANCE = null;

    private SwaggerEndPointRetrofit getInstance(){

        if (INSTANCE == null){
            Gson gson = new GsonBuilder().serializeNulls().create();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            //
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://rethink-webstack-flights.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

            INSTANCE = retrofit.create(SwaggerEndPointRetrofit.class);
        }
        return INSTANCE;
    }

    @Override
    public void getLocations(final ApiServiceCallback<List<Airport>> callback) {
        Call<List<Airport>> call = getInstance().getLocations();

        call.enqueue(new Callback<List<Airport>>() {
            @Override
            public void onResponse(Call<List<Airport>> call, Response<List<Airport>> response) {

                if(!response.isSuccessful()){

                    callback.onFailure("Error code: " +response.code());
                    return;
                }

                List<Airport> airports = response.body();
                callback.onSucces(airports);
            }

            @Override
            public void onFailure(Call<List<Airport>> call, Throwable t) {
                t.printStackTrace();
                callback.onFailure("Error code: " +t.getMessage());
            }
        });
    }

    @Override
    public void getSearchFlights(String codeOrigin, String codeDestination, String dateDeparture,
                                 int passengers, String dateReturn,
                                 final ApiServiceCallback<RequestedFlightSegmentList> callback) {

        Call<RequestedFlightSegmentList> call = getInstance().getFlights(
                codeOrigin,
                codeDestination,
                dateDeparture,
                passengers,
                dateReturn
        );

        call.enqueue(new Callback<RequestedFlightSegmentList>() {
            @Override
            public void onResponse(Call<RequestedFlightSegmentList> call, Response<RequestedFlightSegmentList> response) {
                if(!response.isSuccessful()){
                    callback.onFailure("Error code: " +response.code());
                    return;
                }

                RequestedFlightSegmentList requestedFlightSegmentList = response.body();
                callback.onSucces(requestedFlightSegmentList);
            }

            @Override
            public void onFailure(Call<RequestedFlightSegmentList> call, Throwable t) {
                t.printStackTrace();
                callback.onFailure("Error code: " +t.getMessage());
            }
        });
    }

    @Override
    public void getTarifa(String uidVooPartida, String uidFareVooPartida, int passengers,
                          String uidVooRetorno, String uidFareVooRetorno,
                          final ApiServiceCallback<Tarifa> callback) {

        Call<Tarifa> call = getInstance().getTaxes(
                uidVooPartida,
                uidFareVooPartida,
                passengers,
                uidVooRetorno,
                uidFareVooRetorno
        );

        call.enqueue(new Callback<Tarifa>() {
            @Override
            public void onResponse(Call<Tarifa> call, Response<Tarifa> response) {
                if (!response.isSuccessful()){
                    callback.onFailure("Error code: " +response.code());
                    return;
                }
                Tarifa tarifa = response.body();
                callback.onSucces(tarifa);
            }

            @Override
            public void onFailure(Call<Tarifa> call, Throwable t) {
                callback.onFailure("Error code: " +t.getMessage());
                t.printStackTrace();
            }
        });

    }

    @Override
    public void register(String username,
                         final ApiServiceCallback<LoginResponse> callback) {
        final Login login = new Login(username);

        Call<LoginResponse> call = getInstance().register(login);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.isSuccessful()){
                    callback.onFailure("Error code: " + response.code());
                    return;
                }

                LoginResponse loginResponse = response.body();
                callback.onSucces(loginResponse);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onFailure("Error code: " +t.getMessage());
                t.printStackTrace();
            }
        });

    }

    @Override
    public void setCheckout(String token, Purchase purchase,
                            final ApiServiceCallback<ResponseCode> callback) {

        Call<ResponseCode> call = getInstance().setCheckout(token, purchase);
        call.enqueue(new Callback<ResponseCode>() {
            @Override
            public void onResponse(Call<ResponseCode> call, Response<ResponseCode> response) {
                if (!response.isSuccessful()){
                    callback.onFailure("Error code: " + response.message());
                    return;
                }
                ResponseCode responseCode = response.body();
                callback.onSucces(responseCode);
                Log.d("APIcheckout", response.toString());
            }

            @Override
            public void onFailure(Call<ResponseCode> call, Throwable t) {
                t.printStackTrace();
                callback.onFailure("Error code: " +t.getMessage());
            }
        });

    }

    @Override
    public void getMyFlights(String token, final ApiServiceCallback<MyFlightsResponse> callback) {

        Call<MyFlightsResponse> call = getInstance().getMyFlights(token);

        call.enqueue(new Callback<MyFlightsResponse>() {
            @Override
            public void onResponse(Call<MyFlightsResponse> call, Response<MyFlightsResponse> response) {
                if(!response.isSuccessful()){
                    callback.onFailure("Error code: " + response.code());
                    return;
                }

                MyFlightsResponse myFlightsResponse = response.body();
                callback.onSucces(myFlightsResponse);
            }

            @Override
            public void onFailure(Call<MyFlightsResponse> call, Throwable t) {
                callback.onFailure("Error code: " +t.getMessage());
                t.printStackTrace();
            }
        });

    }
}
