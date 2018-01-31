package com.example.david.triss2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView primo;
    ImageView secondo;
    ImageView terzo;
    ImageView quarto;
    ImageView quinto;
    ImageView sesto;
    ImageView settimo;
    ImageView ottavo;
    ImageView nono;
    boolean griglia[] =new boolean[9];
    int griglia2[] =new int[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primo= findViewById(R.id.primo);
        primo.setOnClickListener(this);

        secondo=findViewById(R.id.secondo);
        secondo.setOnClickListener(this);

        terzo=findViewById(R.id.terzo);
        terzo.setOnClickListener(this);

        quarto=findViewById(R.id.quarto);
        quarto.setOnClickListener(this);

        quinto=findViewById(R.id.quinto);
        quinto.setOnClickListener(this);

        sesto=findViewById(R.id.sesto);
        sesto.setOnClickListener(this);

        settimo=findViewById(R.id.settimo);
        settimo.setOnClickListener(this);

        ottavo=findViewById(R.id.ottavo);
        ottavo.setOnClickListener(this);

        nono=findViewById(R.id.nono);
        nono.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.primo:
                if(!griglia[0]) {
                    primo.setImageResource(R.drawable.bici);
                    griglia[0] = true;
                    griglia2[0] = 1;
                    IA();
                }
                break;

            case R.id.secondo:
                if(!griglia[1]) {
                secondo.setImageResource(R.drawable.bici);
                griglia[1]=true;
                griglia2[1] = 1;
                    IA();
                }
                break;

            case R.id.terzo:
                if(!griglia[2]) {
                 terzo.setImageResource(R.drawable.bici);
                griglia[2]=true;
                griglia2[2] = 1;
                    IA();}
                break;

            case R.id.quarto:
                if(!griglia[3]) {
                quarto.setImageResource(R.drawable.bici);
                griglia[3]=true;
                griglia2[3] = 1;
                    IA();}
                break;
            case R.id.quinto:
                if(!griglia[4]) {
                quinto.setImageResource(R.drawable.bici);
                griglia[4]=true;
                    griglia2[4] = 1;
                    IA();}
                break;
            case R.id.sesto:
                if(!griglia[5]) {
                sesto.setImageResource(R.drawable.bici);
                griglia[5]=true;
                    griglia2[5]=1;
                    IA();}
                break;
            case R.id.settimo:
                if(!griglia[6]) {
                settimo.setImageResource(R.drawable.bici);
                griglia[6]=true;
                    griglia2[6]=1;
                    IA();}
                break;
            case R.id.ottavo:
                if(!griglia[7]) {
                ottavo.setImageResource(R.drawable.bici);
                griglia[7]=true;
                griglia2[7]=1;
                    IA();}
                break;
            case R.id.nono:
                if(!griglia[8]) {
                nono.setImageResource(R.drawable.bici);
                griglia[8]=true;
                griglia2[8]=1;
                    IA();}
                break;

            default:
                break;
        }
    }

    void IA(){

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
            if (random == 0) {
                primo.setImageResource(R.drawable.phone);
                griglia2[0]=-1;
            }
            if (random == 1) {
                secondo.setImageResource(R.drawable.phone);
                griglia2[1]=-1;
            }
            if (random == 2) {
                terzo.setImageResource(R.drawable.phone);
                griglia2[2]=-1;
            }
            if (random == 3) {
                quarto.setImageResource(R.drawable.phone);
                griglia2[3]=-1;
            }
            if (random == 4) {
                quinto.setImageResource(R.drawable.phone);
                griglia2[4]=-1;
            }
            if (random == 5) {
                sesto.setImageResource(R.drawable.phone);
                griglia2[5]=-1;
            }
            if (random == 6) {
                settimo.setImageResource(R.drawable.phone);
                griglia2[6]=-1;
            }
            if (random == 7) {
                ottavo.setImageResource(R.drawable.phone);
                griglia2[7]=-1;
            }
            if (random == 8) {
                nono.setImageResource(R.drawable.phone);
                griglia2[8]=-1;
            }
            checkVittoria();
        }
        }

        void checkVittoria(){

        if(     griglia2[0]==1&&griglia2[1]==1&&griglia2[2]==1 ||
                griglia2[3]==1&&griglia2[4]==1&&griglia2[5]==1 ||
                griglia2[6]==1&&griglia2[7]==1&&griglia2[8]==1 ||
                griglia2[0]==1&&griglia2[3]==1&&griglia2[6]==1 ||
                griglia2[1]==1&&griglia2[4]==1&&griglia2[7]==1 ||
                griglia2[2]==1&&griglia2[5]==1&&griglia2[8]==1 ||
                griglia2[0]==1&&griglia2[4]==1&&griglia2[8]==1 ||
                griglia2[2]==1&&griglia2[4]==1&&griglia2[6]==1){
            Context context = getApplicationContext();
            CharSequence text = "Vittoria";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }if(        griglia2[0]==-1&&griglia2[1]==-1&&griglia2[2]==-1 ||
                    griglia2[3]==-1&&griglia2[4]==-1&&griglia2[5]==-1 ||
                    griglia2[6]==-1&&griglia2[7]==-1&&griglia2[8]==-1 ||
                    griglia2[0]==-1&&griglia2[3]==-1&&griglia2[6]==-1 ||
                    griglia2[1]==-1&&griglia2[4]==-1&&griglia2[7]==-1 ||
                    griglia2[2]==-1&&griglia2[5]==-1&&griglia2[8]==-1 ||
                    griglia2[0]==-1&&griglia2[4]==-1&&griglia2[8]==-1 ||
                    griglia2[2]==-1&&griglia2[4]==-1&&griglia2[6]==-1) {
                Context context = getApplicationContext();
                CharSequence text = "Vittoria dell'avversario";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        }

        private boolean checkUltimo() { //controlla se si va a cliccare l'ultimo ImageView
            int cont =0;                //in modo da non far crashare il programma
            for (int i=0; i<griglia.length; i++){//altrimenti si bloccherebbe nel while
                if(!griglia[i]){
                    cont++;
                }
            }
            System.out.println(cont);
            return(cont==0);

        }



    }

