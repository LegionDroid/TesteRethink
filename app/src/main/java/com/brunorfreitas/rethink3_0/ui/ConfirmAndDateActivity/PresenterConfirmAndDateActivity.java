package com.brunorfreitas.rethink3_0.ui.ConfirmAndDateActivity;

import android.util.Log;

import com.brunorfreitas.rethink3_0.Data.Preferences.PreferencesHawk;

public class PresenterConfirmAndDateActivity implements ContractConfirmAndDateActivity.Presenter {

    ContractConfirmAndDateActivity.View view;
    PreferencesHawk preferencesHawk;

    public PresenterConfirmAndDateActivity(ContractConfirmAndDateActivity.View view, PreferencesHawk preferencesHawk) {
        this.view = view;
        this.preferencesHawk = preferencesHawk;
    }

    @Override
    public void carregaAeroportos() {
        String codeAirport1 = preferencesHawk.getCodeAirport1();
        String codeAirport2 = preferencesHawk.getCodeAirport2();
        Log.i("CODEAIRPORT", codeAirport1 + "+" + codeAirport2);
        view.carregarAeroportos(codeAirport1, codeAirport2);
    }


    @Override
    public void validaVoo(String dataIda, String nmrPassageiros, String dataVolta) {

        //formatar data para padrao do servidor
        String[] f = dataIda.trim().split("-");
        String dataPartida = f[2] +"-"+ f[1] + "-" + f[0];

        String dataRetorno = dataVolta.trim();

        String numeroPassageiros = nmrPassageiros.trim();
        int nmr = 0;

        if (dataPartida.isEmpty()) {
            view.mostrarErro("Informe a Data de ida!");
            return;
        }

        if (!validaData(dataPartida)) {
            view.mostrarErro("Data de ida invalida!");
            return;
        }

        if (!dataRetorno.isEmpty()) {
            if (!validaData(dataRetorno)) {
                view.mostrarErro("Data de volta invalida!");
                return;
            }
            String[] f2 = dataRetorno.split("-");
            dataRetorno = f2[2] + "-" + f2[1] + "-" + f2[0];
            preferencesHawk.setDateFlight2(dataRetorno);
        }

        if (numeroPassageiros.isEmpty()) {
            view.mostrarErro("Informe o número de passageiros!");
            return;
        }

        try {
            nmr = Integer.parseInt(nmrPassageiros);
        } catch (NumberFormatException e) {
            view.mostrarErro("Numero de passageiros invalido!");
            return;
        }

        if (nmr > 9) {
            view.mostrarErro("Numero maximo de passageiros: 9");
            return;
        }

        if (nmr < 1) {
            view.mostrarErro("Numero minimo de passageiros: 1");
            return;
        }

        preferencesHawk.setPassengers(nmr);
        preferencesHawk.setDateFlight1(dataPartida);

        view.abrirProximaActivity();
    }

    public boolean validaData(String data) {
        String[] arrayData = data.split("-");
        for (String string : arrayData) {
            try {
                Integer.parseInt(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
