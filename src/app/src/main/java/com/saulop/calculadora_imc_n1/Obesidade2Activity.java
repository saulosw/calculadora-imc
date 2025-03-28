package com.saulop.calculadora_imc_n1;

import com.example.calculadoraimc.R;

public class Obesidade2Activity extends BaseFeedbackActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_obesidade2;
    }

    @Override
    protected String getFeedbackMessage() {
        return getString(R.string.mensagem_obesidade2);
    }
}