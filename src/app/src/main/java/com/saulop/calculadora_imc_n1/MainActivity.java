package com.saulop.calculadora_imc_n1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;

import com.example.calculadoraimc.R;

public class MainActivity extends AppCompatActivity {

    private MaterialButton buttonCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculadora = findViewById(R.id.buttonCalculadora);

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoIMCActivity.class);
                startActivity(intent);
            }
        });
    }
}