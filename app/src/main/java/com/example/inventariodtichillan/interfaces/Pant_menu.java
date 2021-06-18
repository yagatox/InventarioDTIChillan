package com.example.inventariodtichillan.interfaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.conexion.APICliente;
import com.example.inventariodtichillan.entities.Articulo;
import com.example.inventariodtichillan.entities.Reserva;
import com.example.inventariodtichillan.entities.Seccion;
import com.example.inventariodtichillan.entities.Tipoarticulo;
import com.example.inventariodtichillan.servicios.articulo.ArticuloServicio;
import com.example.inventariodtichillan.servicios.reserva.ReservaServicio;
import com.example.inventariodtichillan.servicios.seccion.SeccionServicio;
import com.example.inventariodtichillan.servicios.tipoarticulo.TipoarticuloServicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Pant_menu extends AppCompatActivity  {


    static List<Articulo> articulos;
    static List<Reserva> reservas;
    static List<Seccion> secciones;
    static List<Tipoarticulo> tipoarticulos;

    String tokenUser;

    Button mostrar_articulo_QR_boton,boton_todo,boton_por_area,boton_por_categoria,boton_por_reserva,boton_cerrar_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_menu);

        boton_todo = findViewById(R.id.mostrar_todo_art_boton);
        boton_por_area = findViewById(R.id.mostrar_articulo_area_boton);
        boton_por_categoria = findViewById(R.id.mostrar_articulo_categoria_boton);
        boton_por_reserva = findViewById(R.id.mostrar_articulo_reserva_boton);
        boton_cerrar_sesion= findViewById(R.id.cerrar_sesion_boton);
         mostrar_articulo_QR_boton= findViewById(R.id.mostrar_articulo_QR_boton);




        String permission = Manifest.permission.CAMERA;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }



        //validador token
        tokenUser=getIntent().getExtras().getString("autotoken");


        getArticulos();
        getReservas();
        getSecciones();
        getTipoarticulos();




        boton_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder pregunta_cierre_sesiom = new AlertDialog.Builder(Pant_menu.this);
                pregunta_cierre_sesiom.setTitle("Confirmacion");
                pregunta_cierre_sesiom.setMessage("¿ Seguro que desea Cerrar Sesion ?");
                pregunta_cierre_sesiom.setCancelable(false);
                pregunta_cierre_sesiom.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface pregunta_cierre_sesiom, int id) {
                        aceptar();
                    }
                });
                pregunta_cierre_sesiom.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface pregunta_cierre_sesiom, int id) {
                        cancelar();
                    }
                });
                pregunta_cierre_sesiom.show();

            }
        });



        boton_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Pant_menu.this, Pant_busqueda_filtro_articulo.class);
                //mandar validador de seleccion
                intent.putExtra("autorizacion",1);
                startActivity(intent);

            }
        });



        boton_por_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Pant_menu.this, Pant_busqueda_filtro_articulo.class);
                //mandar validador de seleccion
                intent.putExtra("autorizacion",2);
                startActivity(intent);

            }
        });




        boton_por_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Pant_menu.this, Pant_busqueda_filtro_articulo.class);
                //mandar validador de seleccion
                intent.putExtra("autorizacion",3);
                startActivity(intent);

            }
        });




        boton_por_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent busqueda_reserva =new Intent(v.getContext(), Pant_busqueda_filtro_reserva.class);
                startActivityForResult(busqueda_reserva, 0);
            }
        });



        mostrar_articulo_QR_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrcode =new Intent(v.getContext(), Pant_lector_QR.class);
                startActivityForResult(qrcode, 0);
            }
        });


    }


    public void aceptar(){
        Toast t=Toast.makeText(this,"Sesión de Inventario DTI Chillan finalizada", Toast.LENGTH_SHORT);
        t.show();
       finish();
    }

    public void cancelar(){

    }


    //llamadas y conecciones a distintas tablas


    public List<Articulo> getArticulos() {

        final ArticuloServicio articuloServicio = APICliente.getClient().create(ArticuloServicio.class);
        Call call = articuloServicio.findAll("Token "+tokenUser);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                articulos = (List<Articulo>)response.body();

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Pant_menu.this,"Coneccion fallida, no se pudo Obtener datos de articulos",Toast.LENGTH_SHORT).show();
            }
        });

        return articulos;
    }




    public List<Reserva> getReservas() {

        final ReservaServicio reservaServicio = APICliente.getClient().create(ReservaServicio.class);
        Call call = reservaServicio.findAll("Token "+tokenUser);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                reservas = (List<Reserva>)response.body();
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(Pant_menu.this,"Coneccion fallida, no se pudo Obtener datos de Reeserva",Toast.LENGTH_SHORT).show();
            }
        });

        return reservas;
    }



    public List<Seccion>getSecciones(){

        final SeccionServicio seccionServicio = APICliente.getClient().create(SeccionServicio.class);
        Call call = seccionServicio.findAll("Token "+tokenUser);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                secciones=(List<Seccion>)response.body();
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(Pant_menu.this,"Coneccion fallida, no se pudo Obtener datos de Secciones",Toast.LENGTH_SHORT).show();
            }
        });

        return secciones;
    }


    public List<Tipoarticulo>getTipoarticulos(){
        final TipoarticuloServicio tipoarticuloServicio = APICliente.getClient().create(TipoarticuloServicio.class);
        Call call = tipoarticuloServicio.findAll("Token "+tokenUser);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                tipoarticulos=(List<Tipoarticulo>)response.body();

            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(Pant_menu.this,"Coneccion fallida, no se pudo Obtener datos de Tipo de Articulo",Toast.LENGTH_SHORT).show();
            }
        });


        return tipoarticulos;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   mostrar_articulo_QR_boton.setEnabled(true);
                mostrar_articulo_QR_boton.setBackgroundResource(R.drawable.boton_punt_curva);

            } else {
                Toast.makeText(this,"Para habilitar el lector QR otorgar los permisos de uso de cámara ", Toast.LENGTH_SHORT).show();
                mostrar_articulo_QR_boton.setBackgroundResource(R.drawable.boton_punt_curva_negativo);
                mostrar_articulo_QR_boton.setEnabled(false);
            }
        }

    }


}