package com.cieep.a03_ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Atributos para la Vista
    private EditText txtFrase;
    private Button btnContarPalabras;
    private Button btnContarCaracteres;

    // CONSTANTES
    public static final int PALABRAS = 1;
    public static final int CARACTERES = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();

      //  inicializaEventos();

    }

    private void inicializaEventos() {
        btnContarCaracteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(CARACTERES);
            }
        });

        btnContarPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(PALABRAS);
            }
        });
    }

    private void click(int caracteres) {
        String frase = txtFrase.getText().toString();
        int boton = caracteres;
        Bundle bundle = new Bundle();
        bundle.putString("FRASE", frase);
        bundle.putInt("BOTON", boton);
        Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void inicializaVistas() {
        txtFrase = findViewById(R.id.txtFraseMain);
        btnContarCaracteres = findViewById(R.id.btnContarCaracteresMain);
        btnContarPalabras = findViewById(R.id.btnContarPalabrasMain);
    }

    public void clickEficiente(View button) {
        String frase = txtFrase.getText().toString();
        int boton = button.getId();
        Bundle bundle = new Bundle();
        bundle.putString("FRASE", frase);
        bundle.putInt("BOTON", boton);
        Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}