package com.brunorfreitas.rethink3_0.ui.MyFlights;

public interface ContractMyFlights {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void mostrarMeusVoos();
    }

    interface Presenter{
        void loadMyFlights();
    }
}
