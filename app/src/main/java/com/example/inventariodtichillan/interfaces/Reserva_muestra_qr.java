package com.example.inventariodtichillan.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.entities.Reserva;
import static com.example.inventariodtichillan.interfaces.Pant_menu.articulos;
import static com.example.inventariodtichillan.interfaces.Pant_menu.reservas;

public class Reserva_muestra_qr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_muestra_qr);
        TextView contenidos_reservas = (TextView) findViewById(R.id.datos_qr_reserva);

        int contador;


        //resivir datos con key
        int id_articulo_qr=getIntent().getExtras().getInt("articulo_numero_qr");



        //contador de reservas con articulo
        contador=0;
        for (Reserva reserva: reservas){

            if (reservas.get(contador).getArticulo()==articulos.get(id_articulo_qr).getId()){

                String contenido="";
                contenido += "******** \n";
                contenido += "Numero de Reserva: " + reserva.getId() + "\n";
                contenido += "Nombre de Reserva: " + reserva.getNombre_reserva() + "\n";
                contenido += "Fecha de Reserva : " + reserva.getFeha_reserva() + "\n";
                contenido += "Nombre del Reservante : "+ reserva.getNombre_reservante() + "\n";
                contenido += "Tiempo de reserva: " + reserva.getTiempo_reserva() + "\n";
                contenido += "Numero de Articulo : " + reserva.getArticulo() + "\n ******** \n \n \n \n";
             contenidos_reservas.append(contenido);

         //       nombre_reserva_get.setText(reservas.get(position).getNombre_reserva());


            }
            contador++;

        }




        Button boton_articulo = findViewById(R.id.boton_articulo);
        boton_articulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}