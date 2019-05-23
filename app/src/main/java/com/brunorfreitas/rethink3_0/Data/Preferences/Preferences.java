//package com.brunorfreitas.rethink3_0.Data.Preferences;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class Preferences {
//
//    private SharedPreferences sharedPreferences;
//    private Context context;
//    private String NOME_ARQUIVO = "rethink3_0.preferencias";
//    private int MODE = 0;
//    private android.content.SharedPreferences.Editor editor;
//
//    private final String CHAVE_FLIGHT1 = "chaveFlight1";
//    private final String CHAVE_DATEFLIGHT1 = "chaveDateFlight1";
//    private final String CHAVE_FARE1 = "chaveFare1";
//    private final String CHAVE_FLIGHT2 = "chaveFlight2";
//    private final String CHAVE_DATEFLIGHT2 = "chaveDateFlight2";
//    private final String CHAVE_FARE2 = "chaveFare2";
//    private final String CHAVE_PASSENGERS = "chavePassengers";
//
//
//
//    public Preferences(Context context) {
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
//    }
//
//    public void salvarUidFlight1(String uidFlight1){
//        editor.putString(CHAVE_FLIGHT1, uidFlight1);
//        editor.commit();
//    }
//    public void salvarDateFlight1(String dateFlight1){
//        editor.putString(CHAVE_DATEFLIGHT1, dateFlight1);
//        editor.commit();
//    }
//    public void salvarUidFareFlight1(String uidFareFlight1){
//        editor.putString(CHAVE_FARE1, uidFareFlight1);
//        editor.commit();
//    }
//    public void salvarFlight1(String uidFlight1){
//        editor.putString(CHAVE_FLIGHT1, uidFlight1);
//        editor.commit();
//    }
//    public void salvarFlight1(String uidFlight1){
//        editor.putString(CHAVE_FLIGHT1, uidFlight1);
//        editor.commit();
//    }
//}
