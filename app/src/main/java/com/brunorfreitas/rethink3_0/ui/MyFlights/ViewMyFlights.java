package com.brunorfreitas.rethink3_0.ui.MyFlights;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.brunorfreitas.rethink3_0.R;

public class ViewMyFlights extends AppCompatActivity implements ContractMyFlights.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myflights);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {

    }

    private void inicializaAcoes() {
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void mostrarMeusVoos() {

    }
}
