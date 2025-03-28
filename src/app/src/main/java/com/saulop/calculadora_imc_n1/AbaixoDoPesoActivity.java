package com.saulop.calculadora_imc_n1;

import com.example.calculadoraimc.R;

public class AbaixoDoPesoActivity extends BaseFeedbackActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_abaixo_do_peso;
    }

    @Override
    protected String getFeedbackMessage() {
        return getString(R.string.mensagem_abaixo_peso);
    }
}