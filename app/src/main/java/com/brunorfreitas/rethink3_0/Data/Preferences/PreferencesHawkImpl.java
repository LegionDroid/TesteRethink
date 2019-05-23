package com.brunorfreitas.rethink3_0.Data.Preferences;

import android.content.Context;
import android.util.Log;

import com.orhanobut.hawk.Hawk;

public class PreferencesHawkImpl implements PreferencesHawk {

    private Context context;

    private final String TAG = "HAWK";

//    private String codeAirport1;
//    private String codeAirport2;
//    private String dateFliht1;
//    private int passengers;
//    private String dateFlight2;

    private final String CHAVE_CODEAIRPORT1 = "chaveCodeAirport1";
    private final String CHAVE_CODEAIRPORT2 = "chaveCodeAirport2";
    private final String CHAVE_DATEFLIGHT1 = "chaveDateFlight1";
    private final String CHAVE_DATEFLIGHT2 = "chaveDateFlight2";
    private final String CHAVE_PASSENGERS = "chavePassengers";
        private final String CHAVE_UIDFLIGHT1 = "chaveUidFlight1";
//        private final String CHAVE_FARE1 = "chaveFare1";
    //    private final String CHAVE_FLIGHT2 = "chaveFlight2";
//    private final String CHAVE_FARE2 = "chaveFare2";

    public PreferencesHawkImpl(Context context) {
        this.context = context;
        Hawk.init(context).build();
    }

    @Override
    public void deleteAll() {
        Hawk.deleteAll();
    }

    public void setCodeAirport1(String codeAirport1) {
        Hawk.put(CHAVE_CODEAIRPORT1, codeAirport1);
        Log.i("TAG", "salvou o codigo do aeroporto2: "+ codeAirport1);
    }

    @Override
    public String getCodeAirport1() {
        String codeAirport1 = Hawk.get(CHAVE_CODEAIRPORT1);
        Log.i(TAG, "Retornou codigo do aeroporto1: "+ codeAirport1);
        return codeAirport1;

    }

    public void setCodeAirport2(String codeAirport2) {
        Hawk.put(CHAVE_CODEAIRPORT2, codeAirport2);
        Log.i("TAG", "salvou o codigo do aeroporto2: "+ codeAirport2);
    }

    @Override
    public String getCodeAirport2() {
        String codeAirport2= Hawk.get(CHAVE_CODEAIRPORT2);
        Log.i(TAG, "Retornou codigo do aeroporto2: "+ codeAirport2);
        return codeAirport2;
    }

    public void setDateFlight1(String dateFliht1) {
        Hawk.put(CHAVE_DATEFLIGHT1, dateFliht1);
        Log.i("TAG", "salvou a data: "+ dateFliht1);

    }

    public void setPassengers(int passengers) {
        Hawk.put(CHAVE_PASSENGERS, passengers);
        Log.i("TAG", "salvou numero de passageiros: "+ passengers);
    }

    public void setDateFlight2(String dateFlight2) {
        Hawk.put(CHAVE_DATEFLIGHT2, dateFlight2);
        Log.i("TAG", "salvou a data: "+ dateFlight2);

    }

    public Search getDadosFlight(){
        String codAer1 = Hawk.get(CHAVE_CODEAIRPORT1);
        String codAer2 = Hawk.get(CHAVE_CODEAIRPORT2);
        String dateIda = Hawk.get(CHAVE_DATEFLIGHT1);

//        String teste = Hawk.get(CHAVE_PASSENGERS);

        String dateVolta = Hawk.get(CHAVE_DATEFLIGHT2);
        int passengers = Hawk.get(CHAVE_PASSENGERS);

        Search search = null;
        if (dateVolta!=null) {
            search = new Search(codAer1, codAer2, dateIda, passengers, dateVolta);
        }else{
            search = new Search(codAer1, codAer2, dateIda, passengers);
        }

        Log.d(TAG, "hawk criou search: codAer1: "+ codAer1+"\n"+
                "codAer2: "+ codAer1+"\n"+
                "dateIda: " + dateIda+"\n"+
                "passengers: " + passengers + "\n"+
                "dataVolta: " + dateVolta);

        return search;
    }

    @Override
    public void setUidFlight1(String uidFlight1) {
        Hawk.put(CHAVE_UIDFLIGHT1, uidFlight1);
        Log.i("TAG", "salvou uid flight1: "+ uidFlight1);
    }

    @Override
    public String getUidFlight1() {
        String uidFlight1= Hawk.get(CHAVE_UIDFLIGHT1);
        Log.i(TAG, "Retornou uidFlight1: "+ uidFlight1);
        return uidFlight1;
    }
}
