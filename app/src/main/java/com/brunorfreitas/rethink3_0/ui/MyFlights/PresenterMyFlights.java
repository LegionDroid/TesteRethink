package com.brunorfreitas.rethink3_0.ui.MyFlights;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlight;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlightsResponse;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

import java.util.List;

public class PresenterMyFlights implements ContractMyFlights.Presenter {

    ContractMyFlights.View view;
    ApiService apiService;
    PreferencesHawk preferencesHawk;

    public PresenterMyFlights(ContractMyFlights.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        this.preferencesHawk = preferencesHawk;
        apiService = new ApiServiceImpl();
    }

    @Override
    public void loadMyFlights() {

        view.showProgressBar();
        apiService.getMyFlights(preferencesHawk.getToken(),
                new ApiService.ApiServiceCallback<MyFlightsResponse>() {
                    @Override
                    public void onSucces(MyFlightsResponse result) {
                        List<MyFlight> myFlights = result.getMyFlights();
                        view.hideProgressBar();
                        view.mostrarMeusVoos(myFlights);

                    }

                    @Override
                    public void onFailure(String message) {
                        view.hideProgressBar();
                        view.mostrarMensagem(message);
                    }
                });

    }
}
