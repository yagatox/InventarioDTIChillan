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
import com.example.inventariodtichillan.entities.Articulo;
import java.util.List;

public class ArticuloListAdapter extends ArrayAdapter<Articulo> {

    private Context context;
    private List<Articulo> articulos;

    public ArticuloListAdapter(Context context, List<Articulo> articulos){
        super(context, R.layout.articulo_componente_lista, articulos);
        this.context=context;
        this.articulos = articulos;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.articulo_componente_lista, parent, false);

        final Articulo articulo = articulos.get(position);

        TextView textViewId = (TextView) convertView.findViewById(R.id.textViewId);
        textViewId.setText(String.valueOf(articulo.getId()));


        TextView textViewNombre = (TextView) convertView.findViewById(R.id.textViewNombre);
        textViewNombre.setText("Nombre de articulo: "+articulo.getNombre());




        return convertView;
    }
}
