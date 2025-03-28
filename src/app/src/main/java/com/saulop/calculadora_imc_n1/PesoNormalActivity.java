package com.saulop.calculadora_imc_n1;

import com.example.calculadoraimc.R;

public class PesoNormalActivity extends BaseFeedbackActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_peso_normal;
    }

    @Override
    protected String getFeedbackMessage() {
        return getString(R.string.mensagem_peso_normal);
    }
}