package com.brunorfreitas.rethink3_0.ui.FirstActivity;

import android.util.Log;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

import java.util.List;

public class PresenterFirstActivity implements ContractFirstActivity.Presenter {

    private ApiService apiService;
    private ContractFirstActivity.View view;
    private PreferencesHawk preferencesHawk;

    public PresenterFirstActivity(ContractFirstActivity.View view, PreferencesHawk preferencesHawk) {
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
        preferencesHawk.deleteAll();
        preferencesHawk.setCodeAirport1(code);

        Log.d("AIRPORT","Aeroporto1 selecionado: "+ code);
    }
}
