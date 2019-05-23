package com.brunorfreitas.rethink3_0.ui.TotalActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.Total;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.LoginActivity.LoginActivity;
import com.orhanobut.hawk.Hawk;

public class ViewTotalActivity extends AppCompatActivity implements ContractTotalActivity.View {

    private Context context;
    private TextView tv_total;
    private Button btn_proximo;
    private ProgressBar progressBar;

    private ContractTotalActivity.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();

        tv_total = findViewById(R.id.act_total_tv_total);
        btn_proximo = findViewById(R.id.act_total_btn);
        progressBar = findViewById(R.id.act_total_pb);

        PreferencesHawk preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterTotalActivity(this, preferencesHawk);
        presenter.carregarTotal();
    }

    private void inicializaAcoes() {
        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirProximaTela();
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
    public void mostrarTotal(Total total) {
        tv_total.setText("Miles: "+ total.getMiles()+ "\n"+"Money: "+total.getMoney());
    }

    @Override
    public void abrirProximaTela() {
        Intent intent = new Intent(context, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void mostrarErros(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
