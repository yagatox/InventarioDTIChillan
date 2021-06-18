package com.example.inventariodtichillan.interfaces;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.adapters.ReservaListAdapter;
import com.example.inventariodtichillan.adapters.ReservaListFiltradoAdapter;
import com.example.inventariodtichillan.entities.Reserva;
import com.example.inventariodtichillan.entities.ReservasFiltradas;


import java.util.ArrayList;
import java.util.List;

import static com.example.inventariodtichillan.interfaces.Pant_menu.reservas;


public class Pant_busqueda_filtro_reserva extends AppCompatActivity {

    private ListView listViewReservaList;
    TextView mensaje_aviso;
    EditText buscador_reserva_text;
    static int filtro_seleccionado_reserva;

    static List<ReservasFiltradas> reservasFiltradasparalista;
    ReservasFiltradas reservasFiltradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_busqueda_filtro_reserva);
        mensaje_aviso = (TextView) findViewById(R.id.mensaje_aviso);
        listViewReservaList =(ListView) findViewById(R.id.listadeArticulos);
        buscador_reserva_text = (EditText) findViewById(R.id.buscador_reserva_text);

                listViewReservaList.setAdapter(new ReservaListAdapter(getApplicationContext(), reservas));
                mensaje_aviso.setVisibility(View.INVISIBLE);
                listViewReservaList.setTextFilterEnabled(true);
                filtro_seleccionado_reserva=0;


        buscador_reserva_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                filtro_seleccionado_reserva=1;
                String texto_entrada=buscador_reserva_text.getText().toString();

                reservasFiltradasparalista  = new ArrayList<ReservasFiltradas>();
                reservasFiltradasparalista.clear();

                for (Reserva reserva: reservas){


                    if (texto_entrada.length()<=reserva.getNombre_reserva().length()){
                        if (texto_entrada.equals(reserva.getNombre_reserva().substring(0, texto_entrada.length()))) {

                            reservasFiltradas = new ReservasFiltradas(
                                    reserva.getId()
                                    ,reserva.getNombre_reserva()
                                    ,reserva.getFeha_reserva()
                                    ,reserva.getTiempo_reserva()
                                    ,reserva.getNombre_reservante()
                                    ,reserva.getArticulo());

                            reservasFiltradasparalista.add(reservasFiltradas);

                        } else if (texto_entrada.length()<=Integer.toString(reserva.getId()).length()){

                            if(texto_entrada.equals(Integer.toString(reserva.getId()).substring(0, texto_entrada.length()))){

                                reservasFiltradas = new ReservasFiltradas(
                                        reserva.getId()
                                        ,reserva.getNombre_reserva()
                                        ,reserva.getFeha_reserva()
                                        ,reserva.getTiempo_reserva()
                                        ,reserva.getNombre_reservante()
                                        ,reserva.getArticulo());

                                reservasFiltradasparalista.add(reservasFiltradas);

                            }else {
                                listViewReservaList.setAdapter(new ReservaListAdapter(getApplicationContext(), reservas));

                            }
                        }
                    }


                }

                listViewReservaList.setAdapter(new ReservaListFiltradoAdapter(getApplicationContext(),reservasFiltradasparalista));

            }



            @Override
            public void afterTextChanged(Editable editable) {


            }
        });





                //evento click encargado de mandar el seleccionado a pantalla vista
                listViewReservaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Pant_reserva_resultado.class);
                        //mandar los datos por key
                        intent.putExtra("key2",position);
                        startActivity(intent);

                    }
                });

            }






    }

