package com.brunorfreitas.rethink3_0.ui.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawkImpl;
import com.brunorfreitas.rethink3_0.R;
import com.brunorfreitas.rethink3_0.ui.MyFlights.ViewMyFlights;
import com.orhanobut.hawk.Hawk;

public class LoginActivity extends AppCompatActivity implements ContractLogin.View {

    private Context context;

    private EditText et_username;
    private Button button;

    private PreferencesHawk preferencesHawk;
    private ContractLogin.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();

        button = findViewById(R.id.act_login_btn);
        et_username = findViewById(R.id.act_login_username);

        preferencesHawk = new PreferencesHawkImpl(context);
        presenter = new PresenterLogin(this, preferencesHawk);

    }

    private void inicializaAcoes() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString().trim();
                if (!username.isEmpty()){
                    presenter.register(username);
                }

                Toast.makeText(context, "Conectando...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void chamaProximaActivity() {
        Intent intent = new Intent(context, ViewMyFlights.class);
        startActivity(intent);
    }

    @Override
    public void mostrarError(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
