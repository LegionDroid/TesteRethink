package com.brunorfreitas.rethink3_0.ui.ConfirmAndDateActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.DatePickerFragment;
import com.brunorfreitas.rethink3_0.ui.FlightsActivity.FlightsActivity;

public class ViewConfirmAndDateActivity extends AppCompatActivity implements ContractConfirmAndDateActivity.View {

    private Context context;
    //
    private TextView tv_codeAirport1;
    private TextView tv_codeAirport2;
    private EditText et_nmrPassageiros;
    private EditText et_dataIda;
    private EditText et_dataVolta;
    private Button btn_proseguir;
    //
    private ContractConfirmAndDateActivity.Presenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_and_date);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();
        //
        tv_codeAirport1 = findViewById(R.id.act_conf_data_tv_code_de);
        tv_codeAirport2 = findViewById(R.id.act_conf_data_tv_code_para);
        et_nmrPassageiros = findViewById(R.id.act_conf_data_et_passageiros);
        et_dataIda = findViewById(R.id.act_conf_data_et_data_ida);
        et_dataVolta = findViewById(R.id.act_conf_data_et_data_volta);
        btn_proseguir = findViewById(R.id.act_conf_data_btn_prosseguir);
        //
        PreferencesHawk preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterConfirmAndDateActivity(this, preferencesHawk);
        presenter.carregaAeroportos();
    }

    private void inicializaAcoes() {

        et_dataIda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDialogDataIda();
            }
        });
        et_dataIda.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) return;
                abrirDialogDataIda();
            }
        });

//        et_dataIda.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(!b) return;
//
//                abrirDialogDataIda();
//            }
//        });
        et_dataVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDialogDataVolta();
            }
        });

        et_dataVolta.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) return;
                abrirDialogDataVolta();
            }
        });



        btn_proseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validaVoo(et_dataIda.getText().toString().replace("/","-"),
                        et_nmrPassageiros.getText().toString(),
                        et_dataVolta.getText().toString().replace("/","-"));
            }
        });
    }

    @Override
    public void carregarAeroportos(String codeAirport1, String codeAirport2) {
        tv_codeAirport1.setText(codeAirport1);
        tv_codeAirport2.setText(codeAirport2);
    }

    @Override
    public void abrirDialogDataIda() {
        DatePickerFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"dataIda");
        dateFragment.setDialogCallback(new DatePickerFragment.DataDialogCallback() {
            @Override
            public void data(String data) {

                String dataFormatada = formatarData(data);

                et_dataIda.setText(dataFormatada);
            }
        });
    }

    @Override
    public void abrirDialogDataVolta() {
        DatePickerFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),"dataIda");
        dateFragment.setDialogCallback(new DatePickerFragment.DataDialogCallback() {
            @Override
            public void data(String data) {
                String dataFormatada = formatarData(data);
                et_dataVolta.setText(dataFormatada);
            }
        });
    }

    private String formatarData(String data) {
        String [] dataArray = data.split("-");
        String dataFormatada = dataArray[2]+"/"+dataArray[1]+"/"+dataArray[0];
        return dataFormatada;
    }

    @Override
    public void abrirProximaActivity() {
        Intent intent = new Intent(context, FlightsActivity.class);
        startActivity(intent);
//        Toast.makeText(context, "vamoooooooooo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarErro(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
