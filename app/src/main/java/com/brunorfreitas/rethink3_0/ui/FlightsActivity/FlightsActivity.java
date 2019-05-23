package com.brunorfreitas.rethink3_0.ui.FlightsActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.Fare;
import com.brunorfreitas.rethink3_0.Data.Model.Flight;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.Adapters.AdapterFlights;
import com.brunorfreitas.rethink3_0.ui.TotalActivity.ViewTotalActivity;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity implements ContractFlightsActivity.View {

    private Context context;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private AdapterFlights adapterFlights;
    private List<Flight> flightList;
    //
    private LinearLayout ll_taxas;
    //
    private RadioGroup rg;
    private RadioGroup rg2;
    private RadioButton rb_smiles1;
    private RadioButton rb_smiles2;
    private RadioButton rb_smilesMoney1;
    private RadioButton rb_smilesMoney2;
    private RadioButton rb_smilesMoney3;

    private Button btn_proximo;
    private List<Fare> fares;

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

        ll_taxas = findViewById(R.id.activity_taxas_ll);
        rg = findViewById(R.id.activity_taxas_rg_smiles);
        rg2 = findViewById(R.id.activity_taxas_rg_smiles_money);
        rb_smiles1 = findViewById(R.id.activity_taxas_smiles1);
        rb_smiles2 = findViewById(R.id.activity_taxas_smiles2);
        rb_smilesMoney1 = findViewById(R.id.activity_taxas_smiles_money1);
        rb_smilesMoney2 = findViewById(R.id.activity_taxas_smiles_money2);
        rb_smilesMoney3 = findViewById(R.id.activity_taxas_smiles_money3);

        progressBar = findViewById(R.id.activity_flights_pb);
        recyclerView = findViewById(R.id.activity_flights_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        btn_proximo = findViewById(R.id.activity_flights_btn);
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
                mostrarTaxas(position);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 &&
                        ((RadioButton) findViewById(checkedId)).isChecked()) {
                    rg2.clearCheck();

//                    switch (rg.getCheckedRadioButtonId()) {
//                        case R.id.activity_taxas_smiles1:
//                            uidFare = fares.get(0).getUid();
//                            break;
//                        case R.id.activity_taxas_smiles2:
//                            uidFare = fares.get(1).getUid();
//                            break;
//                    }
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 &&
                        ((RadioButton) findViewById(checkedId)).isChecked()) {
                    rg.clearCheck();
                }
            }
        });

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uidFare = "";
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.activity_taxas_smiles1:
                        uidFare = fares.get(0).getUid();
                        break;
                    case R.id.activity_taxas_smiles2:
                        uidFare = fares.get(1).getUid();
                        break;
                }
                switch (rg2.getCheckedRadioButtonId()) {
                    case R.id.activity_taxas_smiles_money1:
                        uidFare = fares.get(2).getUid();
                        break;
                    case R.id.activity_taxas_smiles_money2:
                        uidFare = fares.get(3).getUid();
                        break;
                    case R.id.activity_taxas_smiles_money3:
                        uidFare = fares.get(4).getUid();
                        break;
                }

                presenter.selectTaxa(uidFare);
                chamarProximaActivity();
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

    @Override
    public void mostrarTaxas(int position) {
        ll_taxas.setVisibility(View.VISIBLE);

        fares = flightList.get(position).getFareList();

        rb_smiles1.setText(String.valueOf(fares.get(0).getMiles()));
        rb_smiles2.setText(String.valueOf(fares.get(1).getMiles()));

        rb_smilesMoney1.setText("Smiles: " + fares.get(2).getMiles() + "\n" + "Money: " + fares.get(2).getMoney());
        rb_smilesMoney2.setText("Smiles: " + fares.get(3).getMiles() + "\n" + "Money: " + fares.get(3).getMoney());
        rb_smilesMoney3.setText("Smiles: " + fares.get(4).getMiles() + "\n" + "Money: " + fares.get(4).getMoney());

    }

    @Override
    public void chamarProximaActivity() {
        Intent intent = new Intent(context, ViewTotalActivity.class);
        startActivity(intent);
    }
}
