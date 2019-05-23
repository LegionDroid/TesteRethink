package com.brunorfreitas.rethink3_0.ui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brunorfreitas.rethink3_0.Data.Model.Flight;
import com.brunorfreitas.rethink3_0.Data.Model.MyFlight;
import com.brunorfreitas.rethink3_0.R;

import java.util.List;

public class AdapterMyFlights extends RecyclerView.Adapter<AdapterMyFlights.MyViewHolder> {

    private Context context;
    private List<MyFlight> flightList;

    public AdapterMyFlights(Context context, List<MyFlight> flightList) {
        this.context = context;
        this.flightList = flightList;
    }

    public interface I_AdapterFlights{
        void onFlightClickListener(int position);
    }

    private I_AdapterFlights i_adapterFlights;

    public void setI_adapterFlights(I_AdapterFlights i_adapterFlights) {
        this.i_adapterFlights = i_adapterFlights;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_flights, viewGroup, false);

        return new MyViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.bind(flightList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    public void addFlights(List<MyFlight> flightList) {
        this.flightList = flightList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView tv_codeAirport1;
        private TextView tv_codeAirport2;
        private TextView tv_hora;

        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            cardView = itemView.findViewById(R.id.item_flights_cv);
            tv_codeAirport1 = itemView.findViewById(R.id.item_flights_tv_airport_partida);
            tv_codeAirport2 = itemView.findViewById(R.id.item_flights_tv_airport_destino);
            tv_hora = itemView.findViewById(R.id.item_flights_tv_hora);
        }

        public void bind(MyFlight flight, final int position){

            String code = flight.getCode();
            String codeAirport1 = flight.getFlight1().getArrival().getAirport().getCode();
            String codeAirport2 = flight.getFlight1().getDeparture().getAirport().getCode();

            String data = flight.getFlight1().getDeparture().getDate();

            String[] dataF = data.split("T");
            String[] horario = dataF[1].split(":");

            String[] dia = dataF[0].split("-");

            tv_codeAirport1.setText(codeAirport1);
            tv_codeAirport2.setText(codeAirport2);
            tv_hora.setText(dia[2]+"/"+dia[1]+" - "+horario[0]+":"+horario[1] + " Code: "+ code);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i_adapterFlights != null){
                        i_adapterFlights.onFlightClickListener(position);
                    }
                }
            });


        }
    }
}
