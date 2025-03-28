package com.saulop.calculadora_imc_n1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import com.example.calculadoraimc.R;

public abstract class BaseFeedbackActivity extends AppCompatActivity {

    protected TextView textViewClassificacao;
    protected TextView textViewPeso;
    protected TextView textViewAltura;
    protected TextView textViewIMC;
    protected TextView textViewMensagem;
    protected MaterialButton buttonFechar;

    protected float peso;
    protected float altura;
    protected float imc;
    protected String classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        textViewClassificacao = findViewById(R.id.textViewClassificacao);
        textViewPeso = findViewById(R.id.textViewPeso);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewIMC = findViewById(R.id.textViewIMC);
        textViewMensagem = findViewById(R.id.textViewMensagem);
        buttonFechar = findViewById(R.id.buttonFechar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            peso = extras.getFloat("peso");
            altura = extras.getFloat("altura");
            imc = extras.getFloat("imc");
            classificacao = extras.getString("classificacao");
        }

        textViewClassificacao.setText(getString(R.string.label_classificacao) + " " + classificacao);
        textViewPeso.setText(getString(R.string.label_peso_resultado) + " " + String.format("%.1f", peso) + " kg");
        textViewAltura.setText(getString(R.string.label_altura_resultado) + " " + String.format("%.2f", altura) + " m");
        textViewIMC.setText(getString(R.string.label_imc) + " " + String.format("%.1f", imc));

        textViewMensagem.setText(getFeedbackMessage());

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseFeedbackActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    protected abstract int getLayoutResource();
    protected abstract String getFeedbackMessage();
}