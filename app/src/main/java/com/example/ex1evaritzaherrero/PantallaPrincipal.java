package com.example.ex1evaritzaherrero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Buscamos los botones del xml
        ImageButton imgBtnTorreEiffel = findViewById(R.id.imgBtnTorreEiffel);
        ImageButton imgBtnBasilica = findViewById(R.id.imgBtnBasilica);
        ImageButton imgBtnCascada = findViewById(R.id.imgBtnCascada);
        ImageButton imgBtnCupula = findViewById(R.id.imgBtnCupula);

        // Buscar la cantidad de favoritos que tiene
        EditText editTextTorreEiffel = findViewById(R.id.editTextTorreEiffel);
        EditText editTextBasilica = findViewById(R.id.editTextBasilica);
        EditText editTextCascada = findViewById(R.id.editTextCascada);
        EditText editTextCupula = findViewById(R.id.editTextCupula);

        Intent intent = getIntent();
        int puntuacion = intent.getIntExtra("favoritoActualizado" , 0);
        String nombreLugar= intent.getStringExtra("nombreLugar");

        //Aqui comprobamos de que lugar proviene, y le ponemos la puntuacion
        if ("Torre Eiffel".equals(nombreLugar)) {
            editTextTorreEiffel.setText(String.valueOf(puntuacion));
        } else if ("Cascada".equals(nombreLugar)) {
            editTextCascada.setText(String.valueOf(puntuacion));
        } else if ("Basilica".equals(nombreLugar)) {
            editTextBasilica.setText(String.valueOf(puntuacion));
        } else if ("Cupula".equals(nombreLugar)) {
            editTextCupula.setText(String.valueOf(puntuacion));
        }



        //Estos son los 4 action listener para cada imagen, llaman al metodo pasarInformacion, al cual le pasamos desde aqui los parametros que queramos
        imgBtnTorreEiffel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarInformacion("Torre Eiffel", R.drawable.torreeiffel, Integer.parseInt(editTextTorreEiffel.getText().toString()));
            }
        });
        imgBtnBasilica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarInformacion("Basilica", R.drawable.basilica, Integer.parseInt(editTextBasilica.getText().toString()));
            }
        });

        imgBtnCascada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarInformacion("Cascada", R.drawable.cascada, Integer.parseInt(editTextCascada.getText().toString()));
            }
        });

        imgBtnCupula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarInformacion("Cupula", R.drawable.cupula, Integer.parseInt(editTextCupula.getText().toString()));
            }
        });
    }

    //En este metodo le pasamos los tres parametros que queremos pasar a la siguente actividad.
    private void pasarInformacion(String nombreLugar, int imageResource, int puntuacion) {
        Intent intent = new Intent(PantallaPrincipal.this, LugarSeleccionado.class);
        intent.putExtra("nombreLugar", nombreLugar);
        intent.putExtra("imageResource", imageResource);
        intent.putExtra("puntuacion", puntuacion);
        startActivity(intent);
    }
}
