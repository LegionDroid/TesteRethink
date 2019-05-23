package com.brunorfreitas.rethink3_0.ui.FlightsActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.Flight;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterFlights;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity implements ContractFlightsActivity.View {

    private Context context;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private AdapterFlights adapterFlights;
    private List<Flight> flightList;

    private ContractFlightsActivity.Presenter presenter;
    private PreferencesHawk preferencesHawk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();

        progressBar = findViewById(R.id.activity_flights_pb);
        recyclerView = findViewById(R.id.activity_flights_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        flightList = new ArrayList<>();
        adapterFlights = new AdapterFlights(context, flightList);

        recyclerView.setAdapter(adapterFlights);

        preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterFlightsActivity(this, preferencesHawk);

        presenter.loadFlights();

    }

    private void inicializaAcoes() {
        adapterFlights.setI_adapterFlights(new AdapterFlights.I_AdapterFlights() {
            @Override
            public void onFlightClickListener(int position) {
                String uidFlight = flightList.get(position).getUid();
                presenter.selectFlight(uidFlight);
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
    public void showFlights(List<Flight> flightList) {
        this.flightList = flightList;
        adapterFlights.addFlights(flightList);
    }

    @Override
    public void mostrarErro(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
