package com.example.inventariodtichillan.interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inventariodtichillan.R;

import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_reserva.filtro_seleccionado_reserva;
import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_reserva.reservasFiltradasparalista;
import static com.example.inventariodtichillan.interfaces.Pant_menu.reservas;

public class Pant_reserva_resultado extends AppCompatActivity {

TextView nombre_reserva_get,numero_reser,fecha_reser,tiempo_reser,nombre_reservant,numero_articulo_reser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_reserva_resultado);



        //resivir datos con key
        int position=getIntent().getExtras().getInt("key2");


        switch (filtro_seleccionado_reserva) {
            case 0:
                //Nombre de reserva
                nombre_reserva_get = (TextView) findViewById(R.id.nombre_reserva_get);
                nombre_reserva_get.setText(reservas.get(position).getNombre_reserva());

                //Numero de reserva
                numero_reser = (TextView) findViewById(R.id.numero_reser);
                numero_reser.setText("Numero de Reserva: "+Integer.toString(reservas.get(position).getId()));

                //fecha de reserva
                fecha_reser = (TextView) findViewById(R.id.fecha_reser);
                fecha_reser.setText("Fecha de Reserva: "+reservas.get(position).getFeha_reserva());

                //tiempo de reserva
                tiempo_reser = (TextView) findViewById(R.id.tiempo_reser);
                tiempo_reser.setText("Tiempo de Reserva: "+reservas.get(position).getTiempo_reserva());

                //nombre de reservante
                nombre_reservant = (TextView) findViewById(R.id.nombre_reservant);
                nombre_reservant.setText("Nombre del Reservante: "+reservas.get(position).getNombre_reservante());

                //Numero de articulo de reserva
                numero_articulo_reser = (TextView) findViewById(R.id.numero_articulo_reser);
                numero_articulo_reser.setText("Numero de Articulo Reservado: "+Integer.toString(reservas.get(position).getArticulo()));
                break;

            case 1:
                nombre_reserva_get = (TextView) findViewById(R.id.nombre_reserva_get);
                nombre_reserva_get.setText(reservasFiltradasparalista.get(position).getNombre_reserva());

                //Numero de reserva
                numero_reser = (TextView) findViewById(R.id.numero_reser);
                numero_reser.setText("Numero de Reserva: "+Integer.toString(reservasFiltradasparalista.get(position).getId()));

                //fecha de reserva
                fecha_reser = (TextView) findViewById(R.id.fecha_reser);
                fecha_reser.setText("Fecha de Reserva: "+reservasFiltradasparalista.get(position).getFeha_reserva());

                //tiempo de reserva
                tiempo_reser = (TextView) findViewById(R.id.tiempo_reser);
                tiempo_reser.setText("Tiempo de Reserva: "+reservasFiltradasparalista.get(position).getTiempo_reserva());

                //nombre de reservante
                nombre_reservant = (TextView) findViewById(R.id.nombre_reservant);
                nombre_reservant.setText("Nombre del Reservante: "+reservasFiltradasparalista.get(position).getNombre_reservante());

                //Numero de articulo de reserva
                numero_articulo_reser = (TextView) findViewById(R.id.numero_articulo_reser);
                numero_articulo_reser.setText("Numero de Articulo Reservado: "+Integer.toString(reservasFiltradasparalista.get(position).getArticulo()));
                break;

            default:
                //Codigo a ejecutar si no se cumple ningún caso anterior

                break;
        }






        Button boton_articulo = findViewById(R.id.boton_articulo);
        boton_articulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Pant_reserva_resultado.this, Articulo_de_Reserva_pantalla_normal.class);
                // mandar el numero del articulo
                if(filtro_seleccionado_reserva==0){
                    intent.putExtra("id_articulo",reservas.get(position).getArticulo());
                }else if(filtro_seleccionado_reserva==1){
                    intent.putExtra("id_articulo",reservasFiltradasparalista.get(position).getArticulo());
                }

                startActivity(intent);



            }
        });


    }
}
