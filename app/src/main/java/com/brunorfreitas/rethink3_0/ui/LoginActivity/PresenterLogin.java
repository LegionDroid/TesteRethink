package com.brunorfreitas.rethink3_0.ui.LoginActivity;

import android.util.Log;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.LoginResponse;
import com.brunorfreitas.rethink3_0.Data.Model.Purchase;
import com.brunorfreitas.rethink3_0.Data.Model.ResponseCode;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

public class PresenterLogin implements ContractLogin.Presenter {

    private ContractLogin.View view;
    private ApiService apiService;
    private PreferencesHawk preferencesHawk;

    public PresenterLogin(ContractLogin.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        this.preferencesHawk = preferencesHawk;
        apiService = new ApiServiceImpl();
    }

    @Override
    public void register(String username) {
        apiService.register(username, new ApiService.ApiServiceCallback<LoginResponse>() {
            @Override
            public void onSucces(LoginResponse result) {
                String token = result.getToken();
                preferencesHawk.setToken(token);
                checkout();
                view.chamaProximaActivity();

            }

            @Override
            public void onFailure(String message) {
                view.mostrarError(message);
            }
        });

    }

    @Override
    public void checkout() {
        Purchase purchase = new Purchase(preferencesHawk.getUidFlight1(),
                preferencesHawk.getUidFareFlight1(),
                preferencesHawk.getPassengers(),
                preferencesHawk.getTotal()
        );

        String token = preferencesHawk.getToken();
        apiService.setCheckout(token, purchase,
                new ApiService.ApiServiceCallback<ResponseCode>() {
                    @Override
                    public void onSucces(ResponseCode result) {
                        view.chamaProximaActivity();
//                        String teste = responseCode.getCodeFlight();
//                        Log.d("LoginPresenter", teste);
//                        Log.d("LoginPresenter", responseCode.toString());

//                        if (!result.getCodeFlight().isEmpty()){
//                            view.chamaProximaActivity();
//                        }
                    }

                    @Override
                    public void onFailure(String message) {
                        view.mostrarError(message);
                    }
                });
    }
}
