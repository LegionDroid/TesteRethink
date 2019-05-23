package com.brunorfreitas.rethink3_0.Data.Preferences;

import com.brunorfreitas.rethink3_0.Data.Model.Total;

public interface PreferencesHawk {

    void deleteAll();
    void setCodeAirport1(String codeAirport1);
    String getCodeAirport1();
    void setCodeAirport2(String codeAirport2);
    String getCodeAirport2();
    void setDateFlight1(String dateFliht1);
    void setPassengers(int passengers);
    int getPassengers();
    void setDateFlight2(String dateFlight2);
    Search getDadosFlight();

    void setUidFlight1(String uidFlight1);
    String getUidFlight1();
    void setUidFareFlight1(String uifFareFlight1);
    String getUidFareFlight1();
//    void setUidFlight2(String uidFlight2);
//    String getUidFlight2();

    void setToken(String token);
    String getToken();

    void setTotal(Total total);
    Total getTotal();
}
