package com.example.inventariodtichillan.interfaces;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.example.inventariodtichillan.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;

public class Pant_lector_QR extends AppCompatActivity {

private TextView txt_result;
private SurfaceView surfaceView;
private QREader qrEader;
private TextView txt_aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_lector__q_r);


        //permisos
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        setupCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Pant_lector_QR.this, "Debes habilitar el permiso de Camara", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();

    }

    private void setupCamera() {

        txt_aviso=(TextView)findViewById(R.id.estado_boton);
        txt_result=(TextView)findViewById(R.id.code_info);
       final ToggleButton btn_on_off = (ToggleButton)findViewById(R.id.btn_enable_disable);
        btn_on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qrEader.isCameraRunning())
                {
                    btn_on_off.setChecked(false);
                    qrEader.stop();
                    txt_aviso.setText("Escaner Detenido");;
                    txt_aviso.setTextColor(Color.parseColor("#FF0000"));
                }
                else
                {
                    btn_on_off.setChecked(true);
                    qrEader.start();
                    txt_aviso.setText("Escaner en Funcionamiento");
                    txt_aviso.setTextColor(Color.parseColor("#004E81"));
                }
            }
        });

        surfaceView = (SurfaceView) findViewById(R.id.camera_view);
        setupQrEader();

    }

    private void setupQrEader() {

        qrEader = new QREader.Builder(this, surfaceView, new QRDataListener() {
            @Override
            public void onDetected(String data) {
                txt_result.post(new Runnable() {
                    @Override
                    public void run() {
                        txt_result.setText("Numero De Articulo: "+data);
                           txt_result.setTextColor(Color.parseColor("#00385d"));

                             txt_result.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                    public void onClick(View view) {

                                     Intent intent = new Intent(getApplicationContext(), Articulo_muestra_qr.class);
                                     //mandar los datos por key
                                     intent.putExtra("key_qr",data);
                                     startActivity(intent);
                                     finish();

                                 }
                             });
                        }
                    });



                 }
        }).facing(QREader.BACK_CAM)
                .enableAutofocus(true)
                .height(surfaceView.getHeight())
                .width(surfaceView.getWidth())
                .build();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        if(qrEader!=null)
                            qrEader.initAndStart(surfaceView);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Pant_lector_QR.this, "Debes habilitar el permiso de Camara", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        if(qrEader !=null)
                            qrEader.releaseAndCleanup();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Pant_lector_QR.this, "Debes habilitar el permiso de Camara", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
    }
}