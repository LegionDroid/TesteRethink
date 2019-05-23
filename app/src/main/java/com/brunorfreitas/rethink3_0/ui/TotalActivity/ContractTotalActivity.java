package com.brunorfreitas.rethink3_0.ui.TotalActivity;

import com.brunorfreitas.rethink3_0.Data.Model.Total;
import com.brunorfreitas.rethink3_0.ui.FlightsActivity.ContractFlightsActivity;

public interface ContractTotalActivity {

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void mostrarTotal(Total total);
        void abrirProximaTela();
        void mostrarErros(String msg);
    }

    interface Presenter{
        void carregarTotal();
    }
}
