package com.example.inventariodtichillan.interfaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.inventariodtichillan.R;
import com.example.inventariodtichillan.conexion.APICliente;
import com.example.inventariodtichillan.entities.Token;
import com.example.inventariodtichillan.entities.Usuario;
import com.example.inventariodtichillan.servicios.usuario.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Intent inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login_usuario=(EditText) findViewById(R.id.login_usuario);
        EditText contrasena_usuario=(EditText) findViewById(R.id.contrasena_usuario);
        TextView comprobacion_usuario=(TextView)findViewById(R.id.comprobacion_usuario);

        final UserClient userClient = APICliente.getClient().create(UserClient.class);

         //mensaje de contraseña  incorrecta
        login_usuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                comprobacion_usuario.setVisibility(View.INVISIBLE);

            }
        });

        contrasena_usuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
         public void onFocusChange(View view, boolean b) {

                comprobacion_usuario.setVisibility(View.INVISIBLE);
            }
        });



        Button boton_login = findViewById(R.id.inicio_login_boton);
        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            login_usuario.setError(null);
            contrasena_usuario.setError(null);

                Usuario usuario = new Usuario(login_usuario.getText().toString(), "", contrasena_usuario.getText().toString());
                Call<Token> call = userClient.login(usuario);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Bienvenido "+login_usuario.getText().toString(), Toast.LENGTH_SHORT).show();
                            String token = response.body().getKey();
                            inicio =new Intent(MainActivity.this, Pant_menu.class);
                            inicio.putExtra("autotoken",token);
                            startActivity(inicio);


                            finish();

                        } else {

                            comprobacion_usuario.setVisibility(View.VISIBLE);

                            if ("".equals(login_usuario.getText().toString())){
                                login_usuario.setError("Ingrese Usuario");
                                comprobacion_usuario.setVisibility(View.INVISIBLE);
                                login_usuario.requestFocus();
                            }
                            if("".equals(contrasena_usuario.getText().toString())) {
                                contrasena_usuario.setError("Ingrese Contraseña");
                                comprobacion_usuario.setVisibility(View.INVISIBLE);


                            }
                            if(!login_usuario.getText().toString().equals("") && !contrasena_usuario.getText().toString().equals("")) {

                                login_usuario.setError(null);
                                contrasena_usuario.setError(null);
                                login_usuario.setText("");
                                contrasena_usuario.setText("");
                                contrasena_usuario.clearFocus();
                                login_usuario.clearFocus();
                                contrasena_usuario.clearFocus();
                                comprobacion_usuario.setVisibility(View.VISIBLE);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Problemas de Coneccion", Toast.LENGTH_SHORT).show();

                    }
                });


            }


        });


        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info_wifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo info_datos = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (String.valueOf(info_wifi.getState()).equals("CONNECTED")) {
            Toast.makeText(this, "Conectado Por Wifi", Toast.LENGTH_SHORT).show();

        } else {

            if (String.valueOf(info_datos.getState()).equals("CONNECTED")) {
                Toast.makeText(this, "Conectado Por Datos Móviles, Se Recomienda Conexión Wifi", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "¡No Tiene Conexión a Internet!", Toast.LENGTH_SHORT).show();

            }


        }


    }


}
