package com.brunorfreitas.rethink3_0.ui.ConfirmAndDateActivity;

public interface ContractConfirmAndDateActivity {

    interface View{
        void carregarAeroportos(String codeAirport1, String codeAirport2);
        void abrirDialogDataIda();
        void abrirDialogDataVolta();
        void abrirProximaActivity();
        void mostrarErro(String msg);

    }

    interface Presenter{
        void carregaAeroportos();
        void validaVoo(String dataIda, String nmrPassageiros, String dataVolta);
    }
}
