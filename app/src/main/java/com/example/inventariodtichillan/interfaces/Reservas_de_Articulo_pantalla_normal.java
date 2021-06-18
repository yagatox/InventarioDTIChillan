package com.example.inventariodtichillan.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.entities.Reserva;

import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_articulo.articulosFiltradosparalist;
import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_articulo.filtro_seleccionado;
import static com.example.inventariodtichillan.interfaces.Pant_menu.articulos;
import static com.example.inventariodtichillan.interfaces.Pant_menu.reservas;

public class Reservas_de_Articulo_pantalla_normal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_de__articulo_pantalla_normal);
        TextView contenidos_reservas = (TextView) findViewById(R.id.datos_qr_reserva);

        int contador;


        //resivir datos con key
        int num_artculo_list=getIntent().getExtras().getInt("articulo_select");




        switch (filtro_seleccionado) {
            case 0:

                contador=0;
                for (Reserva reserva: reservas){

                    if (reservas.get(contador).getArticulo()==articulos.get(num_artculo_list).getId()){

                        String contenido="";
                        contenido += "******** \n";
                        contenido += "Numero de Reserva: " + reserva.getId() + "\n";
                        contenido += "Nombre de Reserva: " + reserva.getNombre_reserva() + "\n";
                        contenido += "Fecha de Reserva : " + reserva.getFeha_reserva() + "\n";
                        contenido += "Nombre del Reservante : "+ reserva.getNombre_reservante() + "\n";
                        contenido += "Tiempo de reserva: " + reserva.getTiempo_reserva() + "\n";
                        contenido += "Numero de Articulo : " + reserva.getArticulo() + "\n ******** \n \n \n \n";
                        contenidos_reservas.append(contenido);

                    }
                    contador++;

                }

                break;

            case 1:

                contador=0;
                for (Reserva reserva: reservas){

                    if (reservas.get(contador).getArticulo()==articulosFiltradosparalist.get(num_artculo_list).getId()){

                        String contenido="";
                        contenido += "******** \n";
                        contenido += "Numero de Reserva: " + reserva.getId() + "\n";
                        contenido += "Nombre de Reserva: " + reserva.getNombre_reserva() + "\n";
                        contenido += "Fecha de Reserva : " + reserva.getFeha_reserva() + "\n";
                        contenido += "Nombre del Reservante : "+ reserva.getNombre_reservante() + "\n";
                        contenido += "Tiempo de reserva: " + reserva.getTiempo_reserva() + "\n";
                        contenido += "Numero de Articulo : " + reserva.getArticulo() + "\n ******** \n \n \n \n";
                        contenidos_reservas.append(contenido);

                    }
                    contador++;

                }

                break;

            case 2:
                //Codigo a ejecutar...
                break;

            default:
                //Codigo a ejecutar si no se cumple ningún caso anterior

                break;
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