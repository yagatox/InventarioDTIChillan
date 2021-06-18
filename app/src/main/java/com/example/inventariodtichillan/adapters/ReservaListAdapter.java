package com.example.inventariodtichillan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.entities.Reserva;
import java.util.List;

public class ReservaListAdapter extends ArrayAdapter<Reserva> {

    private Context context;
    private List<Reserva> reserva;

    public ReservaListAdapter(Context context, List<Reserva> reserva){
        super(context, R.layout.reserva_componente_lista, reserva);
        this.context=context;
        this.reserva = reserva;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.reserva_componente_lista, parent, false);

        final Reserva Reserva = reserva.get(position);

        TextView textViewId = (TextView) convertView.findViewById(R.id.textViewId);
        textViewId.setText(String.valueOf(Reserva.getId()));


        TextView textViewNombre = (TextView) convertView.findViewById(R.id.textViewNombre);
        textViewNombre.setText("Nombre de Reserva: "+Reserva.getNombre_reserva());




        return convertView;
    }
}
