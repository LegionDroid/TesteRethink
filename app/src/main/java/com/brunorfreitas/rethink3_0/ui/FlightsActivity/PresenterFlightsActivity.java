package com.brunorfreitas.rethink3_0.ui.FlightsActivity;

import com.brunorfreitas.rethink3_0.Data.API.ApiService;
import com.brunorfreitas.rethink3_0.Data.API.ApiServiceImpl;
import com.brunorfreitas.rethink3_0.Data.Model.Flight;
import com.brunorfreitas.rethink3_0.Data.Model.RequestedFlightSegmentList;
import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;
import com.brunorfreitas.rethink3_0.Data.Preferences.Search;

import java.util.List;

public class PresenterFlightsActivity implements ContractFlightsActivity.Presenter {

    ApiService apiService;
    ContractFlightsActivity.View view;
    PreferencesHawk preferencesHawk;


    public PresenterFlightsActivity(ContractFlightsActivity.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        this.preferencesHawk = preferencesHawk;
        if (apiService == null) this.apiService = new ApiServiceImpl();
    }

    @Override
    public void loadFlights() {
        Search search = preferencesHawk.getDadosFlight();
        apiService.getSearchFlights(
                search.getCodAer1(),
                search.getCodAer2(),
                search.getDateIda(),
                search.getPassengers(),
                search.getDateVolta(),
                new ApiService.ApiServiceCallback<RequestedFlightSegmentList>() {
                    @Override
                    public void onSucces(RequestedFlightSegmentList result) {
                        //TODO - estou pegando apenas o voo de ida
                        List<Flight> flightList;
                        flightList = result.getRequestedFlightSegmentList().get(0).getFlightList();
                        view.showFlights(flightList);
                    }

                    @Override
                    public void onFailure(String message) {
                        view.mostrarErro(message);
                    }
                }
        );
    }

    @Override
    public void selectFlight(String uidFlight) {
        preferencesHawk.setUidFlight1(uidFlight);
    }
}
