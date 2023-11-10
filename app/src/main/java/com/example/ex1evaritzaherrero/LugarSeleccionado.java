package com.example.ex1evaritzaherrero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LugarSeleccionado extends AppCompatActivity {
    private int puntuacion;
    private String nombreLugar;
    private int imageResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar_seleccionado);


        //Recogemos los strign de descripcion para cada lugar
        String descripcionTorreEiffel = getString(R.string.txtDescripcionTorreEiffel);
        String descripcionCascada = getString(R.string.txtDescripcionCascada);
        String descripcionCupula = getString(R.string.txtDescripcionCupula);
        String descripcionBasilica = getString(R.string.txtDescripcionBasilica);

        ImageView imgLugar = findViewById(R.id.imgLugar);
        TextView txtNombreLugar = findViewById(R.id.txtNombreLugar);
        TextView txtDescripcion = findViewById(R.id.txtDescripcion);
        EditText editTextFavorito = findViewById(R.id.editTextFavorito);
        Button btnAtras = findViewById(R.id.btnAtras);
        Button btnMarcarFavorito = findViewById(R.id.btnMarcarFavorito);

        //Recogemos los parametros que hemos pasado desde la anterior activity
        Intent intent = getIntent();
        nombreLugar = intent.getStringExtra("nombreLugar");
        imageResource = intent.getIntExtra("imageResource", 0);
        puntuacion = intent.getIntExtra("puntuacion", 0);

        //Seteamos los datos que hemos recuperado en nuestra nueva actividad
        imgLugar.setImageResource(imageResource);
        txtNombreLugar.setText(nombreLugar);
        editTextFavorito.setText(String.valueOf(puntuacion));


        //Segun el nombre del lugar ponemos una descripcion u otra
        if ("Torre Eiffel".equals(nombreLugar)) {
            txtDescripcion.setText(descripcionTorreEiffel);
        } else if ("Cascada".equals(nombreLugar)) {
            txtDescripcion.setText(descripcionCascada);
        } else if ("Basilica".equals(nombreLugar)) {
            txtDescripcion.setText(descripcionBasilica);
        } else if ("Cupula".equals(nombreLugar)) {
            txtDescripcion.setText(descripcionCupula);
        }


        //Creamos un OnActionListener para que cuando demos al boton Atras vuelva a la activity PantallaPrincipal
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LugarSeleccionado.this, PantallaPrincipal.class);
                intent.putExtra("favoritoActualizado", puntuacion);
                intent.putExtra("nombreLugar", nombreLugar);
                startActivity(intent);
            }
        });

        //Creamos un OnActionListener para que cada vez que le de al boton sume en el editTextFavorito
        btnMarcarFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuacion++;
                editTextFavorito.setText(String.valueOf(puntuacion));
            }
        });

    }
}