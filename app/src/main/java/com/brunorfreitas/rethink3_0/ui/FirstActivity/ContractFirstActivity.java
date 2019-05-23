package com.brunorfreitas.rethink3_0.ui.FirstActivity;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;

import java.util.List;

public interface ContractFirstActivity {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void showAirports(List<Airport> airportList);
        void showError(String message);
//        void reload();
    }

    interface Presenter{
        void loadAirports();
        void selectAirport(String code);
    }
}
