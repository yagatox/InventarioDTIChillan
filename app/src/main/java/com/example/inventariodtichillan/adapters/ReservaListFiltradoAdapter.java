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
import com.example.inventariodtichillan.entities.ReservasFiltradas;
import java.util.List;

public class ReservaListFiltradoAdapter extends ArrayAdapter<ReservasFiltradas> {

    private Context context;
    private List<ReservasFiltradas> reservasFiltradas;

    public ReservaListFiltradoAdapter(Context context, List<ReservasFiltradas> reservasFiltradas){
        super(context, R.layout.reserva_componente_lista, reservasFiltradas);
        this.context=context;
        this.reservasFiltradas = reservasFiltradas;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.reserva_componente_lista, parent, false);

        final ReservasFiltradas reservaFiltrada = reservasFiltradas.get(position);

        TextView textViewId = (TextView) convertView.findViewById(R.id.textViewId);
        textViewId.setText(String.valueOf(reservaFiltrada.getId()));


        TextView textViewNombre = (TextView) convertView.findViewById(R.id.textViewNombre);
        textViewNombre.setText("Nombre de Reserva: "+reservaFiltrada.getNombre_reserva());




        return convertView;
    }
}
