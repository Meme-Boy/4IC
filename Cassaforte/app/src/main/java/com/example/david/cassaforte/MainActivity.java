package com.example.david.cassaforte;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView testo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testo=findViewById(R.id.testo);
        Button uno=findViewById(R.id.uno);
        Button due=findViewById(R.id.due);
        Button tre=findViewById(R.id.tre);
        Button quattro=findViewById(R.id.quattro);
        Button cinque=findViewById(R.id.cinque);
        Button sei=findViewById(R.id.sei);
        Button sette=findViewById(R.id.sette);
        Button otto=findViewById(R.id.otto);
        Button nove=findViewById(R.id.nove);
        Button zero=findViewById(R.id.zero);
        Button canc=findViewById(R.id.canc);

        uno.setOnClickListener(this);
        due.setOnClickListener(this);
        tre.setOnClickListener(this);
        quattro.setOnClickListener(this);
        cinque.setOnClickListener(this);
        sei.setOnClickListener(this);
        sette.setOnClickListener(this);
        otto.setOnClickListener(this);
        nove.setOnClickListener(this);
        zero.setOnClickListener(this);
        canc.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.uno :
                aggiungi(1);
                controlla();
                break;
            case R.id.due :
                aggiungi(2);
                controlla();
                break;
            case R.id.tre :
                aggiungi(3);
                controlla();
                break;
            case R.id.quattro :
                aggiungi(4);
                controlla();
                break;
            case R.id.cinque :
                aggiungi(5);
                controlla();
                break;
            case R.id.sei :
                aggiungi(6);
                controlla();
                break;
            case R.id.sette :
                aggiungi(7);
                controlla();
                break;
            case R.id.otto :
                aggiungi(8);
                controlla();
                break;
            case R.id.nove :
                aggiungi(9);
                controlla();
                break;
            case R.id.zero:
                aggiungi(0);
                controlla();
                break;
            case R.id.canc :
                if(numero.length()>0) {
                    numero = numero.substring(0, numero.length() - 1);
                    testo.setText(ris + numero);
                }
                controlla();
                break;

            default:
                break;

        }
    }
    String ris="il pin è: ";
    String numero="";
    private void aggiungi(int i) {

        if(numero.length()<4) {
            numero=numero+i;
           testo.setText(ris + numero);
       }
    }
    String check="1234";
    private void controlla(){
        Intent ritorno= getIntent();
        if(ritorno.hasExtra("newPSW")){
            check=ritorno.getStringExtra("newPSW");
        }
        if(numero.equals(check)){
            testo.setBackgroundColor(getResources().getColor(R.color.green));
            Intent intent=new Intent(this, Main2Activity.class);
            intent.putExtra("old", numero);
            startActivity(intent);
        }else{
            testo.setBackgroundColor(getResources().getColor(R.color.white));
            if(numero.length()==4)
            manageBlinkEffect(testo);
        }
    }


    private void manageBlinkEffect(TextView s) {
        ObjectAnimator anim = ObjectAnimator.ofInt(s, "backgroundColor", Color.WHITE, Color.RED, Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(2);
        anim.start();
    }

}
