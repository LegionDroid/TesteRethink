package com.brunorfreitas.rethink3_0.ui.SecondActivity;

import android.util.Log;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

import java.util.List;

public class PresenterSecondActivity implements ContractSecondActivity.Presenter {

    private ApiService apiService;
    private ContractSecondActivity.View view;
    private PreferencesHawk preferencesHawk;

    public PresenterSecondActivity(ContractSecondActivity.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        if (apiService==null) this.apiService = new ApiServiceImpl();
        this.preferencesHawk = preferencesHawk;
    }

    @Override
    public void loadAirports() {
        view.showProgressBar();

        apiService.getLocations(new ApiService.ApiServiceCallback<List<Airport>>() {
            @Override
            public void onSucces(List<Airport> result) {
                view.hideProgressBar();
                view.showAirports(result);
            }

            @Override
            public void onFailure(String message) {
                view.hideProgressBar();
                view.showError(message);
            }
        });
    }

    @Override
    public void selectAirport(String code) {
     preferencesHawk.setCodeAirport2(code);
     String teste = preferencesHawk.getCodeAirport2();
     String teste2 = preferencesHawk.getCodeAirport1();

//     preferencesHawk.getCodeAirport1();
     view.chamaProximaActivity();
     Log.d("AIRPORT2", "retornou do hawk1:"+teste+" 2: " +teste2);
    }
}
