package com.brunorfreitas.rethink3_0.ui.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.brunorfreitas.rethink3_0.Data.Model.Flight;
import com.brunorfreitas.rethink3_0.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterFlights extends RecyclerView.Adapter<AdapterFlights.MyViewHolder> {

    private Context context;
    private List<Flight> flightList;

    public AdapterFlights(Context context, List<Flight> flightList) {
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

    public void addFlights(List<Flight> flightList) {
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

        public void bind(Flight flight, final int position){

            String data = flight.getDeparture().getDate();
            String codeAirport1 = flight.getDeparture().getAirport().getCode();
            String codeAirport2 = flight.getArrival().getAirport().getCode();

//            Date date = new Date();
//            SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
//            try {
//                date = df.parse(data);
//            } catch (ParseException e) {
//                e.printStackTrace();
//                tv_hora.setText("Erro");
//            }
            String[] dataF = data.split("T");
            String[] dataFF = dataF[1].split(":");


            tv_codeAirport1.setText(codeAirport1);
            tv_codeAirport2.setText(codeAirport2);
            tv_hora.setText(dataFF[0]+":"+dataFF[1]);

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
