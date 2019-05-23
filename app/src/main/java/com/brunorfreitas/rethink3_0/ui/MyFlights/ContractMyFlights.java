package com.brunorfreitas.rethink3_0.ui.MyFlights;

import com.brunorfreitas.rethink3_0.Data.Model.MyFlight;

import java.util.List;

public interface ContractMyFlights {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void mostrarMeusVoos(List<MyFlight> myFlights);
        void mostrarMensagem(String msg);
    }

    interface Presenter{
        void loadMyFlights();
    }
}
