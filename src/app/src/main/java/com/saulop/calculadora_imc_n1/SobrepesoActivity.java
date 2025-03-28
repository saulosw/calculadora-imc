package com.saulop.calculadora_imc_n1;

import com.example.calculadoraimc.R;

public class SobrepesoActivity extends BaseFeedbackActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sobrepeso;
    }

    @Override
    protected String getFeedbackMessage() {
        return getString(R.string.mensagem_sobrepeso);
    }
}