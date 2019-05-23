package com.brunorfreitas.rethink3_0.ui.SecondActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterAirports;
import com.brunorfreitas.rethink3_0.ui.ConfirmAndDateActivity.ViewConfirmAndDateActivity;
import com.brunorfreitas.rethink3_0.ui.DatePickerFragment;
import com.brunorfreitas.rethink3_0.ui.FirstActivity.ContractFirstActivity;
import com.brunorfreitas.rethink3_0.ui.FirstActivity.PresenterFirstActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewSecondActivity extends AppCompatActivity implements ContractSecondActivity.View{

    private Context context;
    //
    private ProgressBar progressBar;

    private RecyclerView recyclerView;
    private AdapterAirports adapterAirports;
    private List<Airport> airportsList;
    //
    private ContractSecondActivity.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_arrival);


        inicializaVariaves();
        inicializaAcoes();
    }


    private void inicializaVariaves() {
        context = getBaseContext();
        progressBar = findViewById(R.id.act_aa_pb);
        PreferencesHawk preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterSecondActivity(this, preferencesHawk);
        presenter.loadAirports();

        recyclerView = findViewById(R.id.act_aa_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        airportsList = new ArrayList<>();
        adapterAirports = new AdapterAirports(context, airportsList);
        recyclerView.setAdapter(adapterAirports);
    }

    private void inicializaAcoes() {
        adapterAirports.setI_adapterAirports(new AdapterAirports.I_AdapterAirports() {
            @Override
            public void onClickAirport(int position) {
                Airport airport = airportsList.get(position);
                presenter.selectAirport(airport.getCode());
            }
        });

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showAirports(List<Airport> airportList) {
        airportsList = airportList;
        adapterAirports.addAirports(airportList);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void chamaProximaActivity() {
        Intent intent = new Intent(context, ViewConfirmAndDateActivity.class);
        startActivity(intent);
    }
}
