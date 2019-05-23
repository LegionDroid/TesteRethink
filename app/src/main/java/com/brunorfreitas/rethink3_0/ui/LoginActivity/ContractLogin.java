package com.brunorfreitas.rethink3_0.ui.LoginActivity;

public interface ContractLogin {

    interface View{
        void chamaProximaActivity();
        void mostrarError(String msg);
    }

    interface Presenter{
        void register(String username);
        void checkout();
    }
}
