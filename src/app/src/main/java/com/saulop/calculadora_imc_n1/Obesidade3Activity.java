package com.saulop.calculadora_imc_n1;

import com.example.calculadoraimc.R;

public class Obesidade3Activity extends BaseFeedbackActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_obesidade3;
    }

    @Override
    protected String getFeedbackMessage() {
        return getString(R.string.mensagem_obesidade3);
    }
}