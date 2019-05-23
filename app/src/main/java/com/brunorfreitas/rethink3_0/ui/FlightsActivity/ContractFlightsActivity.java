package com.brunorfreitas.rethink3_0.ui.FlightsActivity;

import com.brunorfreitas.rethink3_0.Data.Model.Flight;

import java.util.List;

public interface ContractFlightsActivity {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void showFlights(List<Flight> flightList);
        void mostrarErro(String msg);
        void mostrarTaxas(int position);
        void chamarProximaActivity();
    }

    interface Presenter{
        void loadFlights();
        void selectFlight(String uidFlight);
        void selectTaxa(String uidFare);
    }
}
