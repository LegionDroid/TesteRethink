package com.brunorfreitas.rethink3_0.ui.TotalActivity;

import android.util.Log;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.Tarifa;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

public class PresenterTotalActivity implements ContractTotalActivity.Presenter {

    private ContractTotalActivity.View view;
    private ApiService apiService;
    private PreferencesHawk preferencesHawk;

    public PresenterTotalActivity(ContractTotalActivity.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        this.preferencesHawk = preferencesHawk;
        apiService = new ApiServiceImpl();
    }

    @Override
    public void carregarTotal() {
        view.showProgressBar();
        String uidFlight1 = preferencesHawk.getUidFlight1();
        String uidFare1 = preferencesHawk.getUidFareFlight1();
        int nmr = preferencesHawk.getPassengers();

        Log.d("PresenterTotal", uidFlight1+"/"+uidFare1+"/"+nmr);
        apiService.getTarifa(uidFlight1, uidFare1, nmr, null, null,
                new ApiService.ApiServiceCallback<Tarifa>() {
                    @Override
                    public void onSucces(Tarifa result) {
                        view.mostrarTotal(result.getTotal());
                        view.hideProgressBar();
                        preferencesHawk.setTotal(result.getTotal());
                    }

                    @Override
                    public void onFailure(String message) {
                        view.mostrarErros(message);
                        view.hideProgressBar();
                    }
                });
    }
}
