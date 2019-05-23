package com.brunorfreitas.rethink3_0.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.API.SwaggerEndPointRetrofit;
import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Model.FlightSegment;
import com.brunorfreitas.rethink3_0.Data.Model.Login;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlightsResponse;
import com.brunorfreitas.rethink3_0.Data.Model.Purchase;
import com.brunorfreitas.rethink3_0.Data.Model.RequestedFlightSegmentList;
import com.brunorfreitas.rethink3_0.Data.Model.ResponseCode;
import com.brunorfreitas.rethink3_0.Data.Model.Tarifa;
import com.brunorfreitas.rethink3_0.Data.Model.Total;
import com.brunorfreitas.rethink3_0.Data.Model.User;
import com.brunorfreitas.rethink3_0.R;
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

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    SwaggerEndPointRetrofit swaggerEndPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {

        textView = findViewById(R.id.tv);

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rethink-webstack-flights.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        swaggerEndPoint = retrofit.create(SwaggerEndPointRetrofit.class);

        getLocations();
//        getSearchFlights();
//        getTarifa();
//        register();
//        setCheckout();
        getMyFlights();
    }

    private void getMyFlights() {
//        String token = "4587a2f9-e1e4-4541-8de9-17ea4cacddb2";
//
//        Call<MyFlightsResponse> call = swaggerEndPoint.getMyFlights(token);
//
//        call.enqueue(new Callback<MyFlightsResponse>() {
//            @Override
//            public void onResponse(Call<MyFlightsResponse> call, Response<MyFlightsResponse> response) {
//                if(!response.isSuccessful()){
//                    textView.setText(String.valueOf(response.code()));
//                    return;
//                }
//
//                MyFlightsResponse myFlightsResponse = response.body();
////                String teste = myFlightsResponse.getMyFlights().get(0).getCode();
//                User teste2 = myFlightsResponse.getUser();
//                int teste3 = myFlightsResponse.getMyFlights().size();
//
//                textView.setText(String.valueOf(teste3));
//
////                textView.setText(String.valueOf(response.code()));
//            }
//
//            @Override
//            public void onFailure(Call<MyFlightsResponse> call, Throwable t) {
//                textView.setText(t.getMessage());
//            }
//        });
    }

    private void setCheckout() {
        Total total = new Total();
        total.setMiles(75000);
        total.setMoney(90.6);

        String token = "0f1dd917-8556-43e4-9eee-f64526069b52";

        Purchase purchase = new Purchase(
                "fc7b19e9-9bbf-49cf-9ebf-4dc9d518b601",
                "19046ecd-eaa2-4f4d-b12c-3fc5edebf407",
                "ca81315b-a7cc-4c28-bd73-66064bf6ec58",
                "8469f5c8-54a2-4cf1-8f40-fbe1b33bc5a9",
                1,
                total
        );

        Call<ResponseCode> call = swaggerEndPoint.setCheckout(token, purchase);
        call.enqueue(new Callback<ResponseCode>() {
            @Override
            public void onResponse(Call<ResponseCode> call, Response<ResponseCode> response) {
                if (!response.isSuccessful()){
                    textView.setText(response.message());
                    return;
                }
                textView.setText((CharSequence) response.body());
                Log.d("checkout", response.toString());
            }

            @Override
            public void onFailure(Call<ResponseCode> call, Throwable t) {
                t.printStackTrace();
                textView.setText(t.getMessage());
            }
        });
    }

    private void register() {
        final Login login = new Login("bruno");

        Call<LoginResponse> call = swaggerEndPoint.register(login);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: " + response.code());
                    return;
                }

                LoginResponse loginResponse = response.body();

                textView.setText(loginResponse.getToken());
                Log.d("Token", loginResponse.getToken());
                //TODO - salvar Token em preferencias
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private void getTarifa() {
        Call<Tarifa> call = swaggerEndPoint.getTaxes(
                "fc7b19e9-9bbf-49cf-9ebf-4dc9d518b601",
                "19046ecd-eaa2-4f4d-b12c-3fc5edebf407",
                1,
                "ca81315b-a7cc-4c28-bd73-66064bf6ec58",
                "8469f5c8-54a2-4cf1-8f40-fbe1b33bc5a9"
        );
        call.enqueue(new Callback<Tarifa>() {
            @Override
            public void onResponse(Call<Tarifa> call, Response<Tarifa> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: "+response.code());
                    return;
                }

                Tarifa tarifa = response.body();
                String content = "";
                content += "Miles: "+tarifa.getTotal().getMiles()+"\n";
                content += "Money: "+tarifa.getTotal().getMoney()+"\n";

                textView.setText(content);
            }

            @Override
            public void onFailure(Call<Tarifa> call, Throwable t) {

            }
        });
    }

    private void getSearchFlights() {
        //TODO - fazer dinamico
        Call<RequestedFlightSegmentList> call = swaggerEndPoint.getFlights(
                "GRU",
                "GIG",
                "2019-05-22",
                1,
                "2019-05-23"
        );

        call.enqueue(new Callback<RequestedFlightSegmentList>() {
            @Override
            public void onResponse(Call<RequestedFlightSegmentList> call, Response<RequestedFlightSegmentList> response) {
                if(!response.isSuccessful()){
                    textView.setText("Code: "+response.code());
                    return;
                }

                RequestedFlightSegmentList requestedFlightSegmentList = response.body();

                List<FlightSegment> flightSegments
                        = requestedFlightSegmentList.getRequestedFlightSegmentList();

                FlightSegment flightSegment = flightSegments.get(0);

                flightSegment.getType();

                textView.setText(String.valueOf(flightSegment.getType()));

            }

            @Override
            public void onFailure(Call<RequestedFlightSegmentList> call, Throwable t) {
                t.printStackTrace();
            }
        });

//        call.enqueue(new Callback<List<FlightSegment>>() {
//            @Override
//            public void onResponse(Call<List<FlightSegment>> call, Response<List<FlightSegment>> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code: "+response.code());
//                    return;
//                }
//
//                List<FlightSegment> requestedFlightSegmentList
//                        = response.body();
//
//                String teste = requestedFlightSegmentList.get(0).getType();
//                textView.setText(teste);
//            }
//
//            @Override
//            public void onFailure(Call<List<FlightSegment>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

//        call.enqueue(new Callback<FlightSegment>() {
//            @Override
//            public void onResponse(Call<FlightSegment> call, Response<FlightSegment> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code: "+response.code());
//                    return;
//                }
//
//                FlightSegment requestedFlightSegments = response.body();
//
//                String teste = requestedFlightSegments.getType();
//                textView.setText(teste);
//
////                String teste = requestedFlightSegments.getRequestedFlightSegments().get(0).getType();
////                textView.setText(teste);
////
////                List<FlightSegment> requestedFlightSegments1 =
////                        requestedFlightSegments.getRequestedFlightSegments();
////
////                textView.setText(requestedFlightSegments1.get(0).getType());
//
////                for (FlightSegment requestedFlightSegment
////                        : requestedFlightSegments1)
////                {
////                    String content = "";
////
////                    content += requestedFlightSegment.getType()+ "\n";
////
////                    List<Flight> flights = requestedFlightSegment.getFlightList();
////                    List<Fare> fares = flights.get(1).getFareList();
////                    content = String.valueOf(+ fares.get(1).getMiles())+ "\n";
////
////                    textView.append(content);
////                }
//            }
//
//            @Override
//            public void onFailure(Call<FlightSegment> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

//        call.enqueue(new Callback<FlightSegment>() {
//            @Override
//            public void onResponse(Call<FlightSegment> call, Response<FlightSegment> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code: "+response.code());
//                    return;
//                }
//
//                List<FlightSegment> requestedFlightSegments = response.body();
//
//                for (FlightSegment requestedFlightSegment
//                        : requestedFlightSegments)
//                {
//                    String content = "";
//
//                    content += requestedFlightSegment.getType()+ "\n";
//
//                    List<Flight> flights = requestedFlightSegment.getFlightList();
//                    List<Fare> fares = flights.get(1).getFareList();
//                    content = String.valueOf(+ fares.get(1).getMiles());
//
//                    textView.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<FlightSegment>> call, Throwable t) {
//                    textView.setText(t.getMessage());
//                    t.printStackTrace();
//            }
//        });
    }

    private void getLocations() {
        Call<List<Airport>> call = swaggerEndPoint.getLocations();

        call.enqueue(new Callback<List<Airport>>() {
            @Override
            public void onResponse(Call<List<Airport>> call, Response<List<Airport>> response) {

                if(!response.isSuccessful()){
                    textView.setText("Code: "+response.code());
                    return;
                }

                List<Airport> Airports = response.body();

                for (Airport location: Airports) {

                    String content = "";
                    content += "code:"+location.getCode()+ "\n";
                    content += "name:"+location.getName()+ "\n";
                    content += "city:"+location.getCity()+ "\n";
                    content += "country:"+location.getCountry()+ "\n";
                    content += "timezone:"+location.getTimezone()+ "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Airport>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void inicializaAcoes() {

    }
}
