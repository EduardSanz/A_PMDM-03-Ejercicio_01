package com.cieep.a03_ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.StringTokenizer;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView lblResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        lblResultado = findViewById(R.id.lblResultadoCalculadora);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int boton = bundle.getInt("BOTON");
            String frase = bundle.getString("FRASE");
            if (boton == R.id.btnContarCaracteresMain)
                contarCaracteres(frase);
            else if (boton == R.id.btnContarPalabrasMain)
                contarPalabras(frase);
            else
                lblResultado.setText("ERROR EN LOS DATOS");
        }
    }

    private void contarPalabras(String frase) {
        StringTokenizer stringTokenizer = new StringTokenizer(frase);
        int palabras = stringTokenizer.countTokens();
        lblResultado.setText("Tenemos: "+palabras+" palabras");
    }

    private void contarCaracteres(String frase) {
        lblResultado.setText("Tenemos "+frase.length()+ " caracteres");
    }
}