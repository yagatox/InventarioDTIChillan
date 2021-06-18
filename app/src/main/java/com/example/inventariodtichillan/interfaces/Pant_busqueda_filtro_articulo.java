package com.example.inventariodtichillan.interfaces;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.inventariodtichillan.adapters.ArticuloListAdapter;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.adapters.ArticuloListFiltradoAdapter;
import com.example.inventariodtichillan.entities.Articulo;
import com.example.inventariodtichillan.entities.ArticulosFiltrados;
import com.example.inventariodtichillan.entities.Seccion;
import com.example.inventariodtichillan.entities.Tipoarticulo;
import java.util.ArrayList;
import java.util.List;

import static com.example.inventariodtichillan.interfaces.Pant_menu.articulos;
import static com.example.inventariodtichillan.interfaces.Pant_menu.secciones;
import static com.example.inventariodtichillan.interfaces.Pant_menu.tipoarticulos;


public class Pant_busqueda_filtro_articulo extends AppCompatActivity {

    private ListView listViewArticuloList;
    EditText buscador_articulo_text;
    TextView mensaje_aviso;
    Spinner filtro_lista;
    TextView selector_texto;

    int selector_spinner;

    static int filtro_seleccionado;

    static List<ArticulosFiltrados> articulosFiltradosparalist;
    ArticulosFiltrados articulosFiltrados;

    int uiOptions;
    View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_busqueda_filtro_articulo);
        buscador_articulo_text = (EditText) findViewById(R.id.buscador_articulo_text);
        mensaje_aviso = (TextView) findViewById(R.id.mensaje_aviso);
        listViewArticuloList =(ListView) findViewById(R.id.listadeArticulos);
        filtro_lista=(Spinner)findViewById(R.id.filtro_lista);
        selector_texto=(TextView)findViewById(R.id.nombre_articulo_get);
        filtro_lista.setVisibility(View.VISIBLE);


        int validadordeopcion=getIntent().getExtras().getInt("autorizacion");



        switch (validadordeopcion) {
            case 1:
                filtro_lista.setVisibility(View.INVISIBLE);
                selector_texto.setText("Mostrar todo los Articulos");
                filtro_seleccionado=0;


                break;

            case 2:

                selector_texto.setText("Filtro de Secciones Disponibles");
                List<String> list = new ArrayList<String>();

                list.add("Mostrar Todo");
                for (Seccion seccion: secciones){
                        list.add(seccion.getNombre());
                }


                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,list);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                filtro_lista.setAdapter(spinnerArrayAdapter);

                filtro_lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(buscador_articulo_text.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);

                        filtro_lista.requestFocus();
                            selector_spinner=0;
                            for (Seccion seccion: secciones){

                                if(spinnerArrayAdapter.getItem(i).equals(seccion.getNombre())){
                                    selector_spinner=seccion.getId();
                                }


                            }

                            listViewArticuloList.setAdapter(null);


                            articulosFiltradosparalist  = new ArrayList<ArticulosFiltrados>();

                            for (Articulo articulo: articulos){

                                if(selector_spinner==articulo.getSeccion()){
                                articulosFiltrados = new ArticulosFiltrados(
                                         articulo.getId()
                                        ,articulo.getNombre()
                                        ,articulo.getValor()
                                        ,articulo.getCantidad()
                                        ,articulo.getCaracteristicas()
                                        ,articulo.getEstado()
                                        ,articulo.getColor()
                                        ,articulo.getFecha_compra()
                                        ,articulo.getNumero_orden_compra()
                                        ,articulo.getMarca()
                                        ,articulo.getStock_actual()
                                        ,articulo.getStock_minimo()
                                        ,articulo.getModelo()
                                        ,articulo.getProveedor()
                                        ,articulo.getQr_code()
                                        ,articulo.getUltimo_precio_compra()
                                        ,articulo.getEstado_reserva()
                                        ,articulo.getNumero_de_serie()
                                        ,articulo.getFecha_creacion_QR()
                                        ,articulo.getTipo()
                                        ,articulo.getSeccion());

                                articulosFiltradosparalist.add(articulosFiltrados);
                                }
                            }


                            if(spinnerArrayAdapter.getItem(i).equals("Mostrar Todo")){
                                filtro_seleccionado=0;
                                listViewArticuloList.setAdapter(new ArticuloListAdapter(getApplicationContext(), articulos));

                            }else{
                                filtro_seleccionado=1;
                                listViewArticuloList.setAdapter(new ArticuloListFiltradoAdapter(getApplicationContext(), articulosFiltradosparalist));
                            }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });




                break;

            case 3:


                selector_texto.setText("Filtro de Categorias Disponibles");
                list = new ArrayList<String>();

                list.add("Mostrar Todo");
                for (Tipoarticulo tipoarticulo: tipoarticulos){
                    list.add(tipoarticulo.getNombre());
                }

                spinnerArrayAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, list);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                filtro_lista.setAdapter(spinnerArrayAdapter);

                filtro_lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(buscador_articulo_text.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);

                        selector_spinner=0;
                        for (Tipoarticulo tipoarticulo: tipoarticulos){

                            if(spinnerArrayAdapter.getItem(i)==tipoarticulo.getNombre()){
                                selector_spinner=tipoarticulo.getId();
                            }


                        }

                        listViewArticuloList.setAdapter(null);


                        articulosFiltradosparalist  = new ArrayList<ArticulosFiltrados>();

                        for (Articulo articulo: articulos){

                            if(selector_spinner==articulo.getTipo()){
                                articulosFiltrados = new ArticulosFiltrados(
                                        articulo.getId()
                                        ,articulo.getNombre()
                                        ,articulo.getValor()
                                        ,articulo.getCantidad()
                                        ,articulo.getCaracteristicas()
                                        ,articulo.getEstado()
                                        ,articulo.getColor()
                                        ,articulo.getFecha_compra()
                                        ,articulo.getNumero_orden_compra()
                                        ,articulo.getMarca()
                                        ,articulo.getStock_actual()
                                        ,articulo.getStock_minimo()
                                        ,articulo.getModelo()
                                        ,articulo.getProveedor()
                                        ,articulo.getQr_code()
                                        ,articulo.getUltimo_precio_compra()
                                        ,articulo.getEstado_reserva()
                                        ,articulo.getNumero_de_serie()
                                        ,articulo.getFecha_creacion_QR()
                                        ,articulo.getTipo()
                                        ,articulo.getSeccion());

                                articulosFiltradosparalist.add(articulosFiltrados);
                            }

                        }


                        if(spinnerArrayAdapter.getItem(i).equals("Mostrar Todo")){
                            filtro_seleccionado=0;
                            listViewArticuloList.setAdapter(new ArticuloListAdapter(getApplicationContext(), articulos));

                        }else{
                            filtro_seleccionado=1;
                            listViewArticuloList.setAdapter(new ArticuloListFiltradoAdapter(getApplicationContext(), articulosFiltradosparalist));
                        }



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });





                break;

            default:
                //Codigo a ejecutar si no se cumple ningún caso anterior

                break;
        }

/*
        buscador_articulo_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                filtro_lista.setSelection(0);
            }
        });

 */
                listViewArticuloList.setAdapter(new ArticuloListAdapter(getApplicationContext(), articulos));
                mensaje_aviso.setVisibility(View.INVISIBLE);
                listViewArticuloList.setTextFilterEnabled(true);



                //filtro de editext
                buscador_articulo_text.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {



                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {


                        if (buscador_articulo_text.getText().toString().equals("")){
                            filtro_lista.setSelection(0);
                        }

                        filtro_seleccionado=1;
                        String texto_entrada=buscador_articulo_text.getText().toString();



                        articulosFiltradosparalist  = new ArrayList<ArticulosFiltrados>();

                        articulosFiltradosparalist.clear();


                        for (Articulo articulo: articulos){


                            if (texto_entrada.length()<=articulo.getNombre().length()){
                                  if (texto_entrada.equals(articulo.getNombre().substring(0, texto_entrada.length()))) {

                                    articulosFiltrados = new ArticulosFiltrados(
                                              articulo.getId()
                                            , articulo.getNombre()
                                            , articulo.getValor()
                                            , articulo.getCantidad()
                                            , articulo.getCaracteristicas()
                                            , articulo.getEstado()
                                            , articulo.getColor()
                                            , articulo.getFecha_compra()
                                            , articulo.getNumero_orden_compra()
                                            , articulo.getMarca()
                                            , articulo.getStock_actual()
                                            , articulo.getStock_minimo()
                                            , articulo.getModelo()
                                            , articulo.getProveedor()
                                            , articulo.getQr_code()
                                            , articulo.getUltimo_precio_compra()
                                            , articulo.getEstado_reserva()
                                            , articulo.getNumero_de_serie()
                                            , articulo.getFecha_creacion_QR()
                                            , articulo.getTipo()
                                            , articulo.getSeccion());

                                articulosFiltradosparalist.add(articulosFiltrados);

                                } else if (texto_entrada.length()<=Integer.toString(articulo.getId()).length()){

                                    if(texto_entrada.equals(Integer.toString(articulo.getId()).substring(0, texto_entrada.length()))){

                                        articulosFiltrados = new ArticulosFiltrados(
                                                articulo.getId()
                                                ,articulo.getNombre()
                                                ,articulo.getValor()
                                                ,articulo.getCantidad()
                                                ,articulo.getCaracteristicas()
                                                ,articulo.getEstado()
                                                ,articulo.getColor()
                                                ,articulo.getFecha_compra()
                                                ,articulo.getNumero_orden_compra()
                                                ,articulo.getMarca()
                                                ,articulo.getStock_actual()
                                                ,articulo.getStock_minimo()
                                                ,articulo.getModelo()
                                                ,articulo.getProveedor()
                                                ,articulo.getQr_code()
                                                ,articulo.getUltimo_precio_compra()
                                                ,articulo.getEstado_reserva()
                                                ,articulo.getNumero_de_serie()
                                                ,articulo.getFecha_creacion_QR()
                                                ,articulo.getTipo()
                                                ,articulo.getSeccion());

                                        articulosFiltradosparalist.add(articulosFiltrados);

                                    }else {
                                        listViewArticuloList.setAdapter(new ArticuloListAdapter(getApplicationContext(), articulos));
                                    }
                                }
                            }


                        }


                       listViewArticuloList.setAdapter(new ArticuloListFiltradoAdapter(getApplicationContext(),articulosFiltradosparalist));


                    }

                    @Override
                    public void afterTextChanged(Editable s) {



                    }
                });



                listViewArticuloList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getApplicationContext(), Pant_articulo_resultado.class);
                        intent.putExtra("key",position);
                        startActivity(intent);

                    }
                });

           }

}

