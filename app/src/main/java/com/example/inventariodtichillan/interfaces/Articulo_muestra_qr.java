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
import static com.example.inventariodtichillan.interfaces.Pant_menu.secciones;
import static com.example.inventariodtichillan.interfaces.Pant_menu.tipoarticulos;


public class Articulo_muestra_qr extends AppCompatActivity {

    int dato;
    int numero_articulo;
    int num_tipoarticulo;
    int num_seccion;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_muestra_qr);
        Button boton_reserva = findViewById(R.id.boton_reserva);


        //dato pasado de la pantalla de qr
         dato=Integer.parseInt(getIntent().getExtras().getString("key_qr"));

              for(int i=0; articulos.get(i).getId()!=dato;){
                  i++;
                  numero_articulo=i;
              }

                //Nombre de articulo
                TextView nombre_articulo = (TextView) findViewById(R.id.nombre_articulo_get);
                nombre_articulo.setText(articulos.get(numero_articulo).getNombre());

                //Numero de articulo
                TextView numero_art = (TextView) findViewById(R.id.numero_art);
                numero_art.setText("Numero de Articulo: "+Integer.toString(articulos.get(numero_articulo).getId()));


                //valor de articulo
                TextView valor_art = (TextView) findViewById(R.id.valor_art);
                valor_art.setText("Valor: "+articulos.get(numero_articulo).getValor());

                //cantidad de articulo
                TextView cantidad_art = (TextView) findViewById(R.id.cantidad_art);
                cantidad_art.setText("Cantidad: "+articulos.get(numero_articulo).getCantidad());

                //color de articulo
                TextView color_art = (TextView) findViewById(R.id.color_art);
                color_art.setText("Color: "+articulos.get(numero_articulo).getColor());

                //estado de articulo
                TextView estado_art = (TextView) findViewById(R.id.estado_art);
                estado_art.setText("Estado de Articulo: "+articulos.get(numero_articulo).getEstado());

                //fecha de compra de articulo
                TextView fechacompra_art = (TextView) findViewById(R.id.fechacompra_art);
                fechacompra_art.setText("Fecha de Compra: "+articulos.get(numero_articulo).getFecha_compra());

                //orden de compra de articulo
                TextView ordencompra_art = (TextView) findViewById(R.id.ordencompra_art);
                ordencompra_art.setText("Orden de Compra: "+Integer.toString(articulos.get(numero_articulo).getNumero_orden_compra()));

                //marca de articulo
                TextView marca_art = (TextView) findViewById(R.id.marca_art);
                marca_art.setText("Marca de Articulo: "+articulos.get(numero_articulo).getMarca());

                //modelo de articulo
                TextView modelo_art = (TextView) findViewById(R.id.modelo_art);
                modelo_art.setText("Modelo de Articulo: "+articulos.get(numero_articulo).getModelo());

                //proveedor de articulo
                TextView proveedor_art = (TextView) findViewById(R.id.proveedor_art);
                proveedor_art.setText("Proveedor de Articulo: "+articulos.get(numero_articulo).getProveedor());

                //stock actual de articulo
                TextView stockactual_art = (TextView) findViewById(R.id.stockactual_art);
                stockactual_art.setText("Stock Actual : "+Integer.toString(articulos.get(numero_articulo).getStock_actual()));

                //stock minimo de articulo
                TextView stockminimo_art = (TextView) findViewById(R.id.stockminimo_art);
                stockminimo_art.setText("Stock Minimo: "+Integer.toString(articulos.get(numero_articulo).getStock_minimo()));

                //ultimo precio de articulo
                TextView ultimoprecio_art = (TextView) findViewById(R.id.ultimoprecio_art);
                ultimoprecio_art.setText("Precio de Compra: "+Integer.toString(articulos.get(numero_articulo).getUltimo_precio_compra()));

                //estado de reserva de articulo
                TextView estadoreserva_art = (TextView) findViewById(R.id.estadoreserva_art);
                estadoreserva_art.setText("Estado de Reserva: "+articulos.get(numero_articulo).getEstado_reserva());

                //numero de serie de articulo
                TextView numeroserie_art = (TextView) findViewById(R.id.numeroserie_art);
                numeroserie_art.setText("Numero de Serie: "+Integer.toString(articulos.get(numero_articulo).getNumero_de_serie()));


        //buscar el tipo de articulo
        num_tipoarticulo=-1;
        do {

            num_tipoarticulo++;

        }while (tipoarticulos.get(num_tipoarticulo).getId()!=articulos.get(numero_articulo).getTipo());


        //tipo de articulo
        TextView tipo_art = (TextView) findViewById(R.id.tipo_art);
        tipo_art.setText("Tipo de articulo: "+ tipoarticulos.get(num_tipoarticulo).getNombre());



        //buscar la seccion del articulo

        num_seccion = -1;

        do {

            num_seccion++;

        }while (secciones.get(num_seccion).getId()!=articulos.get(numero_articulo).getSeccion());



        //seccion de articulo
        TextView seccion_art = (TextView) findViewById(R.id.seccion_art);
        seccion_art.setText("seccion de articulo: "+ secciones.get(num_seccion).getNombre());




        //caracteristicas de articulo
                TextView caracteristicas_art = (TextView) findViewById(R.id.caracteristicas_art);
                caracteristicas_art.setText(articulos.get(numero_articulo).getCaracteristicas());




        boton_reserva.setVisibility(View.INVISIBLE);


                //contador de reservas
                    contador=0;
                for (Reserva reserva: reservas){

                    if (reservas.get(contador).getArticulo()==articulos.get(numero_articulo).getId()){
                    boton_reserva.setVisibility(View.VISIBLE);

                    }
                    contador++;

                }


        boton_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  Intent intent = new Intent(getApplicationContext(), Reserva_muestra_qr.class);
                                     // mandar el numero del articulo
                                       intent.putExtra("articulo_numero_qr",numero_articulo);
                                       startActivity(intent);

            }
        });
    }
}