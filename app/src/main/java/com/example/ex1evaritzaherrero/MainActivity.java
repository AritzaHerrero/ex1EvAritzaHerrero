package com.example.ex1evaritzaherrero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscmos el boton del xml
        ImageButton imgBotonlogo = findViewById(R.id.imgBotonLogo);

        //Metemos un onActionListener para que cuando clique al boton (en este caso toda la pantalla) cambie de activity
        imgBotonlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PantallaPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
