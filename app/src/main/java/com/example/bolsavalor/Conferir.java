package com.example.bolsavalor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class Conferir extends AppCompatActivity {

        Button confirmar;

        EditText ll;
        EditText nba;
        EditText pa;
        EditText pl;

        Double llconta;
        Double paconta;
        Double plconta;
        Double resultadopl;
        Double resultadolpa;
        Double resultadoroe;
        Double resultadovpa;
        Double resultadopvp;

        Long nbaconta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegar os valores
        confirmar = (Button) findViewById(R.id.confirmar);
        ll = (EditText) findViewById(R.id.txll);
        nba = (EditText) findViewById(R.id.txnab);
        pa  = (EditText) findViewById(R.id.txpa);
        pl = (EditText) findViewById(R.id.txpl);



        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularLPA();
                CalcularPL();
                CalcularROE();
                CalcularVPA();
                CalcularPVP();
                goToNewActivity();

            }
        });


    }


    //Calcular  Lucro por ação
    public void CalcularLPA(){
        llconta = Double.parseDouble(ll.getText().toString());
        nbaconta = Long.parseLong(nba.getText().toString());
        resultadolpa = (llconta / nbaconta);



    }

    //Calcular   Preço Lucro
    public void CalcularPL(){
        paconta = Double.parseDouble(pa.getText().toString());
        resultadopl = (paconta / resultadolpa);



    }

    //Calcular   Retorno sobre o Patrimônio Líquido
    public void CalcularROE() {
        plconta = Double.parseDouble(pl.getText().toString());
        resultadoroe = ((llconta / plconta)*100);



    }

    //Calcular  Valor Patrimonial por ação
    public void CalcularVPA() {
        resultadovpa = (plconta / nbaconta);


    }

    //Calcular  Preço sobre o Valor Patrimonial
    public void CalcularPVP() {
        resultadopvp = (plconta/resultadovpa );


    }

        //Passar Valores para a outra activity
    public void goToNewActivity() {
        Intent intent = new Intent(Conferir.this, Receber.class);
        Bundle b = new Bundle();
        b.putDouble("valor3" , resultadolpa);
        b.putDouble("valor4",  resultadopl);
        b.putDouble("valor5",  resultadoroe);
        b.putDouble("valor6",  resultadovpa);
        b.putDouble("valor7",  resultadopvp);

        intent.putExtras(b);
        startActivity(intent);

        finish();

    }



}
