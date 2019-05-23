package com.brunorfreitas.rethink3_0.ui.SecondActivity;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;

import java.util.List;

public interface ContractSecondActivity {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void showAirports(List<Airport> airportList);
        void showError(String message);
        void chamaProximaActivity();
    }

    interface Presenter{
        void loadAirports();
        void selectAirport(String code);
    }
}
