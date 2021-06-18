package com.example.inventariodtichillan.interfaces;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.entities.Reserva;

import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_articulo.articulosFiltradosparalist;
import static com.example.inventariodtichillan.interfaces.Pant_busqueda_filtro_articulo.filtro_seleccionado;
import static com.example.inventariodtichillan.interfaces.Pant_menu.articulos;
import static com.example.inventariodtichillan.interfaces.Pant_menu.reservas;
import static com.example.inventariodtichillan.interfaces.Pant_menu.secciones;
import static com.example.inventariodtichillan.interfaces.Pant_menu.tipoarticulos;


public class Pant_articulo_resultado extends AppCompatActivity {

    int num_tipoarticulo;
    int num_seccion;
    int contador;
    TextView nombre_articulo,numero_art,valor_art,cantidad_art,color_art,estado_art,fechacompra_art,ordencompra_art,marca_art,modelo_art,proveedor_art,stockactual_art,stockminimo_art,ultimoprecio_art,estadoreserva_art,numeroserie_art,tipo_art,seccion_art,caracteristicas_art;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_articulo_resultado);
        Button boton_reserva = findViewById(R.id.boton_reserva);

        //resivir datos con key
        int position=getIntent().getExtras().getInt("key");
        boton_reserva.setVisibility(View.INVISIBLE);

        switch (filtro_seleccionado) {
            case 0:

                //Nombre de articulo
                nombre_articulo = (TextView) findViewById(R.id.nombre_articulo_get);
                nombre_articulo.setText(articulos.get(position).getNombre());

                //Numero de articulo
                numero_art = (TextView) findViewById(R.id.numero_art);
                numero_art.setText("Numero de Articulo: "+Integer.toString(articulos.get(position).getId()));


                //valor de articulo
                valor_art = (TextView) findViewById(R.id.valor_art);
                valor_art.setText("Valor: "+articulos.get(position).getValor());

                //cantidad de articulo
                cantidad_art = (TextView) findViewById(R.id.cantidad_art);
                cantidad_art.setText("Cantidad: "+articulos.get(position).getCantidad());

                //color de articulo
                color_art = (TextView) findViewById(R.id.color_art);
                color_art.setText("Color: "+articulos.get(position).getColor());

                //estado de articulo
                estado_art = (TextView) findViewById(R.id.estado_art);
                estado_art.setText("Estado de Articulo: "+articulos.get(position).getEstado());

                //fecha de compra de articulo
                fechacompra_art = (TextView) findViewById(R.id.fechacompra_art);
                fechacompra_art.setText("Fecha de Compra: "+articulos.get(position).getFecha_compra());

                //orden de compra de articulo
                ordencompra_art = (TextView) findViewById(R.id.ordencompra_art);
                ordencompra_art.setText("Orden de Compra: "+Integer.toString(articulos.get(position).getNumero_orden_compra()));

                //marca de articulo
                marca_art = (TextView) findViewById(R.id.marca_art);
                marca_art.setText("Marca de Articulo: "+articulos.get(position).getMarca());

                //modelo de articulo
                modelo_art = (TextView) findViewById(R.id.modelo_art);
                modelo_art.setText("Modelo de Articulo: "+articulos.get(position).getModelo());

                //proveedor de articulo
                proveedor_art = (TextView) findViewById(R.id.proveedor_art);
                proveedor_art.setText("Proveedor de Articulo: "+articulos.get(position).getProveedor());

                //stock actual de articulo
                stockactual_art = (TextView) findViewById(R.id.stockactual_art);
                stockactual_art.setText("Stock Actual : "+Integer.toString(articulos.get(position).getStock_actual()));

                //stock minimo de articulo
                stockminimo_art = (TextView) findViewById(R.id.stockminimo_art);
                stockminimo_art.setText("Stock Minimo: "+Integer.toString(articulos.get(position).getStock_minimo()));

                //ultimo precio de articulo
                ultimoprecio_art = (TextView) findViewById(R.id.ultimoprecio_art);
                ultimoprecio_art.setText("Precio de Compra: "+Integer.toString(articulos.get(position).getUltimo_precio_compra()));

                //estado de reserva de articulo
                estadoreserva_art = (TextView) findViewById(R.id.estadoreserva_art);
                estadoreserva_art.setText("Estado de Reserva: "+articulos.get(position).getEstado_reserva());

                //numero de serie de articulo
                numeroserie_art = (TextView) findViewById(R.id.numeroserie_art);
                numeroserie_art.setText("Numero de Serie: "+Integer.toString(articulos.get(position).getNumero_de_serie()));


                //buscar el tipo de articulo
                num_tipoarticulo=-1;
                do {

                    num_tipoarticulo++;

                }while (tipoarticulos.get(num_tipoarticulo).getId()!=articulos.get(position).getTipo());


                //tipo de articulo
                tipo_art = (TextView) findViewById(R.id.tipo_art);
                tipo_art.setText("Tipo de articulo: "+ tipoarticulos.get(num_tipoarticulo).getNombre());



                //buscar la seccion

                num_seccion = -1;

                do {

                    num_seccion++;

                }while (secciones.get(num_seccion).getId()!=articulos.get(position).getSeccion());



                //seccion de articulo
                seccion_art = (TextView) findViewById(R.id.seccion_art);
                seccion_art.setText("seccion de articulo: "+ secciones.get(num_seccion).getNombre());

                //caracteristicas de articulo
                caracteristicas_art = (TextView) findViewById(R.id.caracteristicas_art);
                caracteristicas_art.setText(articulos.get(position).getCaracteristicas());

              //  Toast.makeText(this,Integer.toString(articulos.get(position).getId()), Toast.LENGTH_SHORT).show();

                //contador de reservas

                for (Reserva reserva: reservas){
                   // Toast.makeText(this,Integer.toString(reserva.getArticulo()), Toast.LENGTH_SHORT).show();
                    if (reserva.getArticulo() == articulos.get(position).getId()){
                        boton_reserva.setVisibility(View.VISIBLE);

                    }

                }

                break;

            case 1:


                //Nombre de articulo
                nombre_articulo = (TextView) findViewById(R.id.nombre_articulo_get);
                nombre_articulo.setText(articulosFiltradosparalist.get(position).getNombre());


                //Numero de articulo
                numero_art = (TextView) findViewById(R.id.numero_art);
                numero_art.setText("Numero de Articulo: "+Integer.toString(articulosFiltradosparalist.get(position).getId()));


                //valor de articulo
                valor_art = (TextView) findViewById(R.id.valor_art);
                valor_art.setText("Valor: "+articulosFiltradosparalist.get(position).getValor());

                //cantidad de articulo
                cantidad_art = (TextView) findViewById(R.id.cantidad_art);
                cantidad_art.setText("Cantidad: "+articulosFiltradosparalist.get(position).getCantidad());

                //color de articulo
                color_art = (TextView) findViewById(R.id.color_art);
                color_art.setText("Color: "+articulosFiltradosparalist.get(position).getColor());

                //estado de articulo
                estado_art = (TextView) findViewById(R.id.estado_art);
                estado_art.setText("Estado de Articulo: "+articulosFiltradosparalist.get(position).getEstado());

                //fecha de compra de articulo
                fechacompra_art = (TextView) findViewById(R.id.fechacompra_art);
                fechacompra_art.setText("Fecha de Compra: "+articulosFiltradosparalist.get(position).getFecha_compra());

                //orden de compra de articulo
                ordencompra_art = (TextView) findViewById(R.id.ordencompra_art);
                ordencompra_art.setText("Orden de Compra: "+Integer.toString(articulosFiltradosparalist.get(position).getNumero_orden_compra()));

                //marca de articulo
                marca_art = (TextView) findViewById(R.id.marca_art);
                marca_art.setText("Marca de Articulo: "+articulosFiltradosparalist.get(position).getMarca());

                //modelo de articulo
                modelo_art = (TextView) findViewById(R.id.modelo_art);
                modelo_art.setText("Modelo de Articulo: "+articulosFiltradosparalist.get(position).getModelo());

                //proveedor de articulo
                proveedor_art = (TextView) findViewById(R.id.proveedor_art);
                proveedor_art.setText("Proveedor de Articulo: "+articulosFiltradosparalist.get(position).getProveedor());

                //stock actual de articulo
                stockactual_art = (TextView) findViewById(R.id.stockactual_art);
                stockactual_art.setText("Stock Actual : "+Integer.toString(articulosFiltradosparalist.get(position).getStock_actual()));

                //stock minimo de articulo
                stockminimo_art = (TextView) findViewById(R.id.stockminimo_art);
                stockminimo_art.setText("Stock Minimo: "+Integer.toString(articulosFiltradosparalist.get(position).getStock_minimo()));

                //ultimo precio de articulo
                ultimoprecio_art = (TextView) findViewById(R.id.ultimoprecio_art);
                ultimoprecio_art.setText("Precio de Compra: "+Integer.toString(articulosFiltradosparalist.get(position).getUltimo_precio_compra()));

                //estado de reserva de articulo
                estadoreserva_art = (TextView) findViewById(R.id.estadoreserva_art);
                estadoreserva_art.setText("Estado de Reserva: "+articulosFiltradosparalist.get(position).getEstado_reserva());

                //numero de serie de articulo
                numeroserie_art = (TextView) findViewById(R.id.numeroserie_art);
                numeroserie_art.setText("Numero de Serie: "+Integer.toString(articulosFiltradosparalist.get(position).getNumero_de_serie()));


                //buscar el tipo de articulo
                num_tipoarticulo=-1;
                do {

                    num_tipoarticulo++;

                }while (tipoarticulos.get(num_tipoarticulo).getId()!=articulosFiltradosparalist.get(position).getTipo());


                //tipo de articulo
                tipo_art = (TextView) findViewById(R.id.tipo_art);
                tipo_art.setText("Tipo de articulo: "+ tipoarticulos.get(num_tipoarticulo).getNombre());



                //buscar la seccion

                num_seccion = -1;

                do {

                    num_seccion++;

                }while (secciones.get(num_seccion).getId()!=articulosFiltradosparalist.get(position).getSeccion());



                //seccion de articulo
                seccion_art = (TextView) findViewById(R.id.seccion_art);
                seccion_art.setText("seccion de articulo: "+ secciones.get(num_seccion).getNombre());

                //caracteristicas de articulo
                caracteristicas_art = (TextView) findViewById(R.id.caracteristicas_art);
                caracteristicas_art.setText(articulosFiltradosparalist.get(position).getCaracteristicas());


                //contador de reservas
                contador=0;
                for (Reserva reserva: reservas){


                    if (reservas.get(contador).getArticulo()==articulosFiltradosparalist.get(position).getId()){
                        boton_reserva.setVisibility(View.VISIBLE);

                    }
                    contador++;

                }

                break;

            default:
                Toast.makeText(this,"Error al Mostrar Informacion",Toast.LENGTH_LONG).show();
                break;
        }









        boton_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Pant_articulo_resultado.this, Reservas_de_Articulo_pantalla_normal.class);
                // mandar el numero del articulo
                intent.putExtra("articulo_select",position);
                startActivity(intent);

            }
        });

    }
}
