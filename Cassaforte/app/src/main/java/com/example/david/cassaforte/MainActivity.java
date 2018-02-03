package com.example.david.cassaforte;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    private TextView testo;
    private String numero="";
    private String ris;
    private String passwordDefault ="1234";
    private final int NUMERO_MASSIMO_CIFRE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ris = getResources().getString(R.string.pin);
        testo=findViewById(R.id.testo);
    }

    public void onClick(View view) {
        int tmp = Integer.parseInt(((Button) findViewById(view.getId())).getTag().toString());
        if(tmp==-1){
            if(numero.length()>0) {
                numero = numero.substring(0, numero.length() - 1);
                testo.setText(ris + numero);
            }
        }else{
            aggiungi(tmp);
        }

        controlla();
    }


    private void aggiungi(int i) {
        if(numero.length()<NUMERO_MASSIMO_CIFRE) {
            numero=numero+i;
           testo.setText(ris + numero);
       }
    }



    private void controlla(){
        Intent ritorno= getIntent();
        if(ritorno.hasExtra("newPSW")){
            passwordDefault = ritorno.getStringExtra("newPSW");
        }
        if(numero.equals(passwordDefault)){
            // va bene
            testo.setBackgroundColor(getResources().getColor(R.color.green));
            Intent intent=new Intent(this, Main2Activity.class);
            intent.putExtra("old", numero);
            startActivity(intent);

        }else{
            // non va bene
            testo.setBackgroundColor(getResources().getColor(R.color.white));
            if(numero.length()==NUMERO_MASSIMO_CIFRE)
            effettoRosso(testo);
        }
    }


    private void effettoRosso(TextView s) {
        ObjectAnimator anim = ObjectAnimator.ofInt(s, "backgroundColor", Color.WHITE, Color.RED, Color.WHITE);
        anim.setDuration(500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(2);
        anim.start();

        s.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
    }

}
