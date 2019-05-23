package com.brunorfreitas.rethink3_0.ui.MyFlights;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.MyFlight;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterAirports;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterFlights;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterMyFlights;

import java.util.ArrayList;
import java.util.List;

public class ViewMyFlights extends AppCompatActivity implements ContractMyFlights.View {

    private Context context;

    private RecyclerView recyclerView;
    private AdapterMyFlights adapterMyFlights;
    private List<MyFlight> myFlightList;

    private ProgressBar progressBar;

    private ContractMyFlights.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myflights);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();

        recyclerView = findViewById(R.id.activity_myflights_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        myFlightList = new ArrayList<>();
        adapterMyFlights = new AdapterMyFlights(context, myFlightList);
        recyclerView.setAdapter(adapterMyFlights);

        progressBar = findViewById(R.id.activity_myflights_pb);

        PreferencesHawk preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterMyFlights(this, preferencesHawk);
        presenter.loadMyFlights();

    }

    private void inicializaAcoes() {

        adapterMyFlights.setI_adapterFlights(new AdapterMyFlights.I_AdapterFlights() {
            @Override
            public void onFlightClickListener(int position) {
                Toast.makeText(context, myFlightList.get(position).getCode(), Toast.LENGTH_SHORT).show();
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
    public void mostrarMeusVoos(List<MyFlight> myFlights) {
        myFlightList = myFlights;
        adapterMyFlights.addFlights(myFlights);
    }

    @Override
    public void mostrarMensagem(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
