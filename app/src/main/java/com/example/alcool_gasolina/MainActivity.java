package com.example.alcool_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText precoAlcool, precoGasolina;
    private Button calculo;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.edit_alcool);
        precoGasolina = findViewById(R.id.edit_gasolina);
        calculo = findViewById(R.id.bt_calculo);
        tv_resultado = findViewById(R.id.tv_resultado);
    }

    public void calcularPreco(View view){
        // recuperar valores digitados
        String preco_alcool = precoAlcool.getText().toString();
        String preco_gasolina = precoGasolina.getText().toString();

        // validar os campos digitados
        Boolean camposValidados = validarCampos(preco_alcool, preco_gasolina);
        if (camposValidados) {
            // converter string para números
            Double valorAlcool = Double.parseDouble(preco_alcool);
            Double valorGasolina = Double.parseDouble(preco_gasolina);

            // cálculo da melhor opção de combustível
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7) {
                tv_resultado.setText("Opte por usar a Gasolina!");
            } else {
                tv_resultado.setText("Opte por usar o Álcool!");
            }
        }else{
                tv_resultado.setText("Campos obrigatórios!");
            }
    }
    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        if(pAlcool == null || pAlcool.equals(""))
            camposValidados = false;
        else if(pGasolina == null || pGasolina.equals(""))
            camposValidados = false;

        return camposValidados;
    }
}
