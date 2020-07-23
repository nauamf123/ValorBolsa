package com.example.bolsavalor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Receber extends AppCompatActivity {


    TextView lpa;
    TextView pa;
    TextView roe;
    TextView vpa;
    TextView pvp;

    Double resultedlpa;
    Double resultadopl;
    Double resultadoroe;
    Double resultadovpa;
    Double resultadopvp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        receberValores();
        setarText();



    }

    //Setar os valores no TextView
    public void setarText() {
        lpa = (TextView) findViewById(R.id.txlpc);
        pa = (TextView) findViewById(R.id.txpa1);
        roe = (TextView) findViewById(R.id.txroe);
        vpa = (TextView) findViewById(R.id.txvpa);
        pvp = (TextView) findViewById(R.id.txpvp);

        pvp.setText(resultadopvp.toString());
        vpa.setText(resultadovpa.toString());
        roe.setText(resultadoroe.toString());
        lpa.setText(resultedlpa.toString());
        pa.setText(resultadopl.toString());



    }


    //Receber os valores da primeira actitity
    public void receberValores() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            resultedlpa = b.getDouble("valor3");
            resultadopl = b.getDouble("valor4");
            resultadoroe = b.getDouble("valor5");
            resultadovpa = b.getDouble("valor6");
            resultadopvp = b.getDouble("valor7");

        }


        }

    }


