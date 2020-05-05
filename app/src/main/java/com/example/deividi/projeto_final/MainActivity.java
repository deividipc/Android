//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno: Deividi Pinheiro Cavalheiro
//Cidade:Pelotas
//******************************************************
package com.example.deividi.projeto_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btTrocatela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btTrocatela = (Button) findViewById(R.id.bttrocatela);
        btTrocatela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChamaSegundaTela();
            }
        });

    }
    void ChamaSegundaTela(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
