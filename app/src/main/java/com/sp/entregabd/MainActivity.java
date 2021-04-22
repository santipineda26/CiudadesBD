package com.sp.entregabd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformacion;
    private EditText txtCodigo;
    private EditText txtNombre;
    private EditText txtPoblacion;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private Button btnAgregar;
    private Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvInformacion = findViewById(R.id.tvInformacion);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtPoblacion = findViewById(R.id.txtPoblacion);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnMostrar = findViewById(R.id.btnMostrar);

        btnAgregar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnAgregar){


            if (txtCodigo.getText().toString().equals("")) {
                CustomToastView.makeErrorToast(this, "Error al validar el Código", R.layout.custom_toast).show();
                return;
            }
            if (txtNombre.getText().toString().equals("")) {
                CustomToastView.makeErrorToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
            }
            if (txtPoblacion.getText().toString().equals("")) {
                CustomToastView.makeErrorToast(this, "Error al validar la Población", R.layout.custom_toast).show();
                return;
            }
            if (txtLatitud.getText().toString().equals("")) {
                CustomToastView.makeErrorToast(this, "Error al validar la Latitud", R.layout.custom_toast).show();
                return;
            }
            if (txtLongitud.getText().toString().equals("")) {
                CustomToastView.makeErrorToast(this, "Error al validar la Longitud", R.layout.custom_toast).show();
                return;
            }
            int Codigo = Integer.parseInt(txtCodigo.getText().toString());
            String Nombre = txtNombre.getText().toString();
            int Poblacion = Integer.parseInt(txtPoblacion.getText().toString());
            int Latitud = Integer.parseInt(txtLatitud.getText().toString());
            int Longitud = Integer.parseInt(txtLongitud.getText().toString());

            MyDbHelper db = new MyDbHelper(this);
            Ciudad ciudad = new Ciudad();

            ciudad.setId(Codigo);
            ciudad.setNombre(Nombre);
            ciudad.setPoblacion(Poblacion);
            ciudad.setLatitud(Latitud);
            ciudad.setLongitud(Longitud);

            db.insertarCiudad(db.getWritableDatabase(),ciudad);
            
        }

        if (v.getId() == R.id.btnMostrar){

            MyDbHelper db = new MyDbHelper(this);
            Ciudad ciudad = new Ciudad();

            ArrayList<Ciudad> ciudades = db.selectedCiudad(db.getWritableDatabase());

            int i = 1;
            for(Ciudad mostrarCiudad : ciudades){
                tvInformacion.setText(tvInformacion.getText().toString()+"\nCiudad " +
                        "Id: " + mostrarCiudad.getId() +
                        " Nombre: " + mostrarCiudad.getNombre() +
                        " Población: " + mostrarCiudad.getPoblacion() +
                        " Latitud: " + mostrarCiudad.getLatitud() +
                        " Longitud: " + mostrarCiudad.getLongitud());

            }

        }



    }
}
