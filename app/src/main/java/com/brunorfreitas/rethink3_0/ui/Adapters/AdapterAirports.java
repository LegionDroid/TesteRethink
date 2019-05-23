package com.brunorfreitas.rethink3_0.ui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brunorfreitas.rethink3_0.Data.Model.Airport;
import com.brunorfreitas.rethink3_0.R;

import java.util.List;

public class AdapterAirports extends RecyclerView.Adapter<AdapterAirports.MyViewHolder> {

    private List<Airport> airportsList;
    private Context context;

    public AdapterAirports(Context context, List<Airport> airportsList) {
        this.context = context;
        this.airportsList = airportsList;
    }

    public interface I_AdapterAirports{
        void onClickAirport(int position);
    }

    private I_AdapterAirports i_adapterAirports;

    public void setI_adapterAirports(I_AdapterAirports i_adapterAirports) {
        this.i_adapterAirports = i_adapterAirports;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_airport, parent, false);
        return new MyViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.bind(airportsList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return airportsList.size();
    }

    public void addAirports(List<Airport> airports){
        this.airportsList = airports;
        notifyDataSetChanged();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_nomeECodAirpot;
        TextView tv_localizacaoAirpot;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            tv_nomeECodAirpot = itemView.findViewById(R.id.item_airport_name);
            tv_localizacaoAirpot = itemView.findViewById(R.id.item_airport_localizacao);
            cardView = itemView.findViewById(R.id.item_airport_cardview);
        }

        public void bind(Airport airport, final int position){

            String nomeAeroporto = airport.getName();
            String codAeroporto = airport.getCode();
            tv_nomeECodAirpot.setText(nomeAeroporto+" ("+codAeroporto+")");
            String cidade = airport.getCity();
            String pais = airport.getCountry();
            tv_localizacaoAirpot.setText(cidade+"/"+pais);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(i_adapterAirports != null){
                        i_adapterAirports.onClickAirport(position);
                    }
                }
            });

        }
    }
}
