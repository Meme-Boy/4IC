package com.example.david.triss2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by David on 03/02/2018.
 */

public class Tris implements View.OnClickListener {
    public Activity activity;

   private ImageView primo;
    private ImageView secondo;
    private ImageView terzo;
    private ImageView quarto;
    private ImageView quinto;
    private ImageView sesto;
    private ImageView settimo;
    private  ImageView ottavo;
    private  ImageView nono;
    private  boolean griglia[] =new boolean[9];
    private  int vittoria[] =new int[9];
    private int nMosse=0;

    public Tris(MainActivity activity) {
        this.activity=activity;

        primo=this.activity.findViewById(R.id.primo);
        primo.setOnClickListener(this);

        secondo=this.activity.findViewById(R.id.secondo);
        secondo.setOnClickListener(this);

        terzo=this.activity.findViewById(R.id.terzo);
        terzo.setOnClickListener(this);

        quarto=this.activity.findViewById(R.id.quarto);
        quarto.setOnClickListener(this);

        quinto=this.activity.findViewById(R.id.quinto);
        quinto.setOnClickListener(this);

        sesto=this.activity.findViewById(R.id.sesto);
        sesto.setOnClickListener(this);

        settimo=this.activity.findViewById(R.id.settimo);
        settimo.setOnClickListener(this);

        ottavo=this.activity.findViewById(R.id.ottavo);
        ottavo.setOnClickListener(this);

        nono=this.activity.findViewById(R.id.nono);
        nono.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.primo:
                if(!griglia[0]) {
                    primo.setImageResource(R.drawable.bici);
                    griglia[0] = true;
                    vittoria[0] = 1;
                    IA();
                }
                break;

            case R.id.secondo:
                if(!griglia[1]) {
                    secondo.setImageResource(R.drawable.bici);
                    griglia[1]=true;
                    vittoria[1] = 1;
                    IA();
                }
                break;

            case R.id.terzo:
                if(!griglia[2]) {
                    terzo.setImageResource(R.drawable.bici);
                    griglia[2]=true;
                    vittoria[2] = 1;
                    IA();}
                break;

            case R.id.quarto:
                if(!griglia[3]) {
                    quarto.setImageResource(R.drawable.bici);
                    griglia[3]=true;
                    vittoria[3] = 1;
                    IA();}
                break;
            case R.id.quinto:
                if(!griglia[4]) {
                    quinto.setImageResource(R.drawable.bici);
                    griglia[4]=true;
                    vittoria[4] = 1;
                    IA();}
                break;
            case R.id.sesto:
                if(!griglia[5]) {
                    sesto.setImageResource(R.drawable.bici);
                    griglia[5]=true;
                    vittoria[5]=1;
                    IA();}
                break;
            case R.id.settimo:
                if(!griglia[6]) {
                    settimo.setImageResource(R.drawable.bici);
                    griglia[6]=true;
                    vittoria[6]=1;
                    IA();}
                break;
            case R.id.ottavo:
                if(!griglia[7]) {
                    ottavo.setImageResource(R.drawable.bici);
                    griglia[7]=true;
                    vittoria[7]=1;
                    IA();}
                break;
            case R.id.nono:
                if(!griglia[8]) {
                    nono.setImageResource(R.drawable.bici);
                    griglia[8]=true;
                    vittoria[8]=1;
                    IA();}
                break;

            default:
                break;
        }
    }

  private  void IA(){

        if(!checkUltimo()) {
            System.out.println("entrato nel if");
            Random r=new Random();
            int random = r.nextInt(9);
            if (griglia[random]) {
                while (griglia[random]) {
                    random = r.nextInt(9);
                }
            }

            griglia[random] = true;

            System.out.println("random scritto " + random);
            /***********ROBA DEPRECARIA****************/
            if (random == 0) {
                primo.setImageResource(R.drawable.phone);
                vittoria[0]=-1;
            }
            if (random == 1) {
                secondo.setImageResource(R.drawable.phone);
                vittoria[1]=-1;
            }
            if (random == 2) {
                terzo.setImageResource(R.drawable.phone);
                vittoria[2]=-1;
            }
            if (random == 3) {
                quarto.setImageResource(R.drawable.phone);
                vittoria[3]=-1;
            }
            if (random == 4) {
                quinto.setImageResource(R.drawable.phone);
                vittoria[4]=-1;
            }
            if (random == 5) {
                sesto.setImageResource(R.drawable.phone);
                vittoria[5]=-1;
            }
            if (random == 6) {
                settimo.setImageResource(R.drawable.phone);
                vittoria[6]=-1;
            }
            if (random == 7) {
                ottavo.setImageResource(R.drawable.phone);
                vittoria[7]=-1;
            }
            if (random == 8) {
                nono.setImageResource(R.drawable.phone);
                vittoria[8]=-1;
            }
            checkVittoria();
        }
      checkVittoria();
    }

  private  void checkVittoria(){
        Intent intent =new Intent(this.activity, Main2Activity.class);
        if(     vittoria[0]==1&& vittoria[1]==1&& vittoria[2]==1 ||
                vittoria[3]==1&& vittoria[4]==1&& vittoria[5]==1 ||
                vittoria[6]==1&& vittoria[7]==1&& vittoria[8]==1 ||
                vittoria[0]==1&& vittoria[3]==1&& vittoria[6]==1 ||
                vittoria[1]==1&& vittoria[4]==1&& vittoria[7]==1 ||
                vittoria[2]==1&& vittoria[5]==1&& vittoria[8]==1 ||
                vittoria[0]==1&& vittoria[4]==1&& vittoria[8]==1 ||
                vittoria[2]==1&& vittoria[4]==1&& vittoria[6]==1){

            String strPlayer="Hai vinto!!";
            intent.putExtra("player", strPlayer);
            this.activity.startActivity(intent);

        }else if(        vittoria[0]==-1&& vittoria[1]==-1&& vittoria[2]==-1 ||
                vittoria[3]==-1&& vittoria[4]==-1&& vittoria[5]==-1 ||
                vittoria[6]==-1&& vittoria[7]==-1&& vittoria[8]==-1 ||
                vittoria[0]==-1&& vittoria[3]==-1&& vittoria[6]==-1 ||
                vittoria[1]==-1&& vittoria[4]==-1&& vittoria[7]==-1 ||
                vittoria[2]==-1&& vittoria[5]==-1&& vittoria[8]==-1 ||
                vittoria[0]==-1&& vittoria[4]==-1&& vittoria[8]==-1 ||
                vittoria[2]==-1&& vittoria[4]==-1&& vittoria[6]==-1) {

            String strPlayer="Ha vinto il pc!!";
            intent.putExtra("player", strPlayer);
            this.activity.startActivity(intent);

        }else if(controlloPareggio()){
          String strPlayer="Pareggio!!";
          intent.putExtra("player", strPlayer);
          this.activity.startActivity(intent);

      }
    }

    private boolean checkUltimo() {
        int cont =0;
        for (int i=0; i<griglia.length; i++){
            if(!griglia[i]){
                cont++;
            }
        }
       // System.out.println(cont);
        return(cont==0);

    }


    private boolean controlloPareggio(){
      return ++nMosse==9;

    }



}