//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno: Deividi Pinheiro Cavalheiro
//Cidade:Pelotas
//******************************************************
package com.example.deividi.projeto_final;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private DBHelper dh;

    EditText etNome, etCpf, etIdade, etFone, etEmail;
    Button btVoltar, btListar, btInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.dh = new DBHelper(this);

        etNome = (EditText) findViewById(R.id.etnome);
        etCpf = (EditText) findViewById(R.id.etcpf);
        etIdade = (EditText) findViewById(R.id.etidade);
        etFone = (EditText) findViewById(R.id.etfone);
        etEmail = (EditText) findViewById(R.id.etmail);


        btInserir = (Button) findViewById(R.id.btinserir);             //instanciação do botão inserir
        btListar = (Button) findViewById(R.id.btlistar);               //instanciação do botão listar
        btVoltar = (Button) findViewById(R.id.btvoltar);               //instanciação do botão voltar


        btVoltar.setOnClickListener(new View.OnClickListener() {    //método que chama a função de trocar a tela
            @Override                                               //
            public void onClick(View v) {                          // método botão voltar//////////
                primeiratela();                                      //
            }                                                       //
        });                                                      ////////////////////////////////////////////

        btInserir.setOnClickListener(new View.OnClickListener() {   //método para aquisição dos dados e inserir no DBHelper
            @Override                                               //
            public void onClick(View v) {                        //método para o botão inserir///////////
                if (etNome.getText().length()>0 && etCpf.getText().length()>0 && etIdade.getText().length()>0 && etFone.getText().length()>0 && etEmail.getText().length()>0){
                    dh.insert(etNome.getText().toString(),etCpf.getText().toString(),etIdade.getText().toString(),etFone.getText().toString(),etEmail.getText().toString());
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Sucesso");                        //
                    adb.setMessage("Cadastro Realizado!");          //
                    adb.show();                                     //
                    etNome.setText("");                             //
                    etCpf.setText("");                              //
                    etIdade.setText("");                            //
                    etFone.setText("");                             //
                    etEmail.setText("");                            //
                }else{                                              //
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Erro");                           //
                    adb.setMessage("Todos os campos devem ser preenchidos!");
                    adb.show();                                     //
                    etNome.setText("");                             //
                    etCpf.setText("");                              //
                    etIdade.setText("");                            //
                    etFone.setText("");                             //
                    etEmail.setText("");                            //
                }                                                   //
            }                                                       //
        });                                                     //////////////////////////////////////////////

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                        //Método para o botão listar
                List<Pessoa> pessoas = dh.queryGetAll();           //
                if (pessoas==null){                                //
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Mensagem");                         //
                    adb.setMessage("Não há registros cadastrados!");  //
                    adb.show();                                       //
                    return;                                           //
                }                                                     //
                for( int i=0; i<pessoas.size(); i++){                 //
                    Pessoa pessoa = (Pessoa) pessoas.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Registro "+ i);
                    adb.setMessage("Nome: "+pessoa.getNome()+"\nCPF: "+pessoa.getCpf()+"\nIdade: "+pessoa.getIdade()+"\nTelefone: "+pessoa.getTelefone()+"\nEmail: "+pessoa.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {   //
                            dialog.dismiss();                          //
                        }
                    });                                                //
                    adb.show();                                        //
                }                                                      //
            }
        });                                                            //////////////////////////////////////////////////
    }
    void primeiratela(){                                            //Função para trocar de tela
        Intent intent = new Intent();                               //
        intent.setClass(Main2Activity.this,MainActivity.class);     //
        startActivity(intent);                                      //
        finish();                                                   //
    }                                                               ///////////////////////////////////////////
}
