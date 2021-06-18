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
import com.example.inventariodtichillan.entities.ArticulosFiltrados;
import java.util.List;

public class ArticuloListFiltradoAdapter extends ArrayAdapter<ArticulosFiltrados> {


    private Context context;
    private List<ArticulosFiltrados> articulosFiltrados;

    public ArticuloListFiltradoAdapter (Context context, List<ArticulosFiltrados> articulosFiltrados){
        super(context, R.layout.articulo_componente_lista, articulosFiltrados);
        this.context=context;
        this.articulosFiltrados = articulosFiltrados;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.articulo_componente_lista, parent, false);

        final ArticulosFiltrados articulosFiltrado = articulosFiltrados.get(position);

        TextView textViewId = (TextView) convertView.findViewById(R.id.textViewId);
        textViewId.setText(String.valueOf(articulosFiltrado.getId()));


        TextView textViewNombre = (TextView) convertView.findViewById(R.id.textViewNombre);
        textViewNombre.setText("Nombre de articulo: "+articulosFiltrado.getNombre());




        return convertView;
    }
}
