package com.saulop.calculadora_imc_n1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

// Importação explícita da classe R
import com.example.calculadoraimc.R;

public class CalculoIMCActivity extends AppCompatActivity {

    private TextInputEditText editTextPeso;
    private TextInputEditText editTextAltura;
    private MaterialButton buttonCalcular;
    private MaterialButton buttonLimpar;
    private MaterialButton buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonFechar = findViewById(R.id.buttonFechar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = editTextPeso.getText().toString().trim();
        String alturaStr = editTextAltura.getText().toString().trim();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, R.string.erro_campos_vazios, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            pesoStr = pesoStr.replace(',', '.');
            alturaStr = alturaStr.replace(',', '.');

            float peso = Float.parseFloat(pesoStr);
            float altura = Float.parseFloat(alturaStr);

            if (peso <= 0) {
                Toast.makeText(this, R.string.erro_valores_invalidos, Toast.LENGTH_SHORT).show();
                return;
            }

            if (altura <= 0) {
                Toast.makeText(this, R.string.erro_valores_invalidos, Toast.LENGTH_SHORT).show();
                return;
            } else if (altura > 3.0) {
                altura = altura / 100.0f;
            }

            float imc = calcularValorIMC(peso, altura);

            String classificacao = determinarClassificacaoIMC(imc);

            Bundle bundle = new Bundle();
            bundle.putFloat("peso", peso);
            bundle.putFloat("altura", altura);
            bundle.putFloat("imc", imc);
            bundle.putString("classificacao", classificacao);

            Intent intent = null;

            if (imc < 18.5) {
                intent = new Intent(CalculoIMCActivity.this, AbaixoDoPesoActivity.class);
            } else if (imc < 25) {
                intent = new Intent(CalculoIMCActivity.this, PesoNormalActivity.class);
            } else if (imc < 30) {
                intent = new Intent(CalculoIMCActivity.this, SobrepesoActivity.class);
            } else if (imc < 35) {
                intent = new Intent(CalculoIMCActivity.this, Obesidade1Activity.class);
            } else if (imc < 40) {
                intent = new Intent(CalculoIMCActivity.this, Obesidade2Activity.class);
            } else {
                intent = new Intent(CalculoIMCActivity.this, Obesidade3Activity.class);
            }

            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.erro_valores_invalidos, Toast.LENGTH_SHORT).show();
        }
    }

    private float calcularValorIMC(float peso, float altura) {
        if (altura <= 0) {
            return 0;
        }
        return peso / (altura * altura);
    }

    private String determinarClassificacaoIMC(float imc) {
        if (imc < 18.5) {
            return getString(R.string.abaixo_do_peso);
        } else if (imc < 25) {
            return getString(R.string.peso_normal);
        } else if (imc < 30) {
            return getString(R.string.sobrepeso);
        } else if (imc < 35) {
            return getString(R.string.obesidade_grau_1);
        } else if (imc < 40) {
            return getString(R.string.obesidade_grau_2);
        } else {
            return getString(R.string.obesidade_grau_3);
        }
    }

    private void limparCampos() {
        editTextPeso.setText("");
        editTextAltura.setText("");
        editTextPeso.requestFocus();
    }
}