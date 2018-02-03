package com.memegram.florian.provatris.tris;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.memegram.florian.provatris.R;

public class PVPGame extends AppCompatActivity {

    private Boolean giocoFinito = false;
    private Integer punteggiox = 0;
    private Integer punteggioO = 0;

    private final String CASELLA_VUOTA = "";
    private final String X = "X";
    private final String O = "O";
    private final int VITTORIAX = 1;
    private final int VITTORIAO = -1;
    private int turnoCorrente;
    private final int PARITA = 42;
    private int nMosse = 0;

    private final int PARTITA_IN_CORSO = 0;

    private final int coloreVittoriaX = Color.rgb(78, 200, 244);
    private final int coloreVittoriaO = Color.GREEN;
    private final int coloreBase = Color.BLACK;

    private String turnoDi;
    private String parita ;
    private String ha_vinto;

    private int[] griglia = {
            PARTITA_IN_CORSO,PARTITA_IN_CORSO,PARTITA_IN_CORSO,
            PARTITA_IN_CORSO,PARTITA_IN_CORSO,PARTITA_IN_CORSO,
            PARTITA_IN_CORSO,PARTITA_IN_CORSO,PARTITA_IN_CORSO
    };

    /*
     * Determina tenendo conto solo del movimento piu recente
     * chi vince...
     *
     *   0 | 1 | 2
     *  ---+---+---
     *   3 | 4 | 5
     *  ---+---+---
     *   6 | 7 | 8
     *
     */
    private final int[][][] lineeVincitrici = {
                {{1,2},{4,8},{3,6}},
                {{0,2},{4,7}},
                {{0,1},{4,6},{5,8}},
                {{4,5},{0,6}},
                {{3,5},{0,8},{2,6},{1,7}},
                {{3,4},{2,8}},
                {{7,8},{2,4},{0,3}},
                {{6,8},{1,4}},
                {{6,7},{0,4},{2,5}}
    };

    private void haVinto(int ultimoMovimento) {
        griglia[ultimoMovimento] = turnoCorrente;
        int[] linee;
        for (int i = 0; i < lineeVincitrici[ultimoMovimento].length; i++) {
            linee = lineeVincitrici[ultimoMovimento][i];
            if(turnoCorrente == griglia[linee[0]] && turnoCorrente == griglia[linee[1]]) {
                vinto();
                evidenzia(ultimoMovimento,linee[0],linee[1],turnoCorrente == VITTORIAX ? coloreVittoriaX : coloreVittoriaO);
                return ;
            }
        }

        // NON HA VINTO ... proviamo a vedere se si tratta di un pareggio
        if(++nMosse==9) {
            turnoView.setText(parita);
        }
    }

    private void vinto() {
        giocoFinito = true;
        if(turnoCorrente == VITTORIAX) {
            punteggioO++;
            p2Score.setText(punteggioO.toString());
            turnoView.setText(ics.getText().toString().toUpperCase()+ha_vinto);
        }else{
            punteggiox++;
            p1Score.setText(punteggiox.toString());
            turnoView.setText(pallina.getText().toString().toUpperCase()+ha_vinto);
        }
    }

    private TextView turnoView,p1Score,p2Score,pallina,ics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvpgame);

        turnoDi = getResources().getString(R.string.turnoDi);
        parita = getResources().getString(R.string.parita);
        ha_vinto = getResources().getString(R.string.havinto);
        turnoView = (TextView) findViewById(R.id.resultView);
        p1Score = (TextView) findViewById(R.id.player1Score);
        p2Score = (TextView) findViewById(R.id.player2Score);

        pallina = (TextView) findViewById(R.id.player1View);
        ics = (TextView) findViewById(R.id.player2View);

        Intent i = getIntent();
        String nomeGiocatoreO = i.getStringExtra("pallina");
        String nomeGiocatoreX = i.getStringExtra("ics");

        pallina.setText(nomeGiocatoreO);
        ics.setText(nomeGiocatoreX);

        //turnoCorrente = Math.min(2,caso);
        if((int)(Math.random()*2) == VITTORIAX) {
            turnoCorrente = VITTORIAX;
            turnoView.setText(turnoDi + " "+nomeGiocatoreX);
        }else{
            turnoCorrente = VITTORIAO;
            turnoView.setText(turnoDi + " " + nomeGiocatoreO);
        }
    }


    public void execute(View v){
        Button premuto = (Button) findViewById(v.getId());

        if(premuto.getText().toString() != CASELLA_VUOTA || giocoFinito)
            return;

        premuto.setText(turnoCorrente == VITTORIAX ? X : O);

        haVinto(Integer.parseInt(premuto.getTag().toString()));

        if (!giocoFinito) {
            turnoView.setText(turnoCorrente == VITTORIAX ? turnoDi + " " + pallina.getText().toString() : turnoDi + " "+ ics.getText().toString());
            turnoCorrente = -turnoCorrente;
        }

    }

    private void colora(int colore, Button... bottoniDaColorare) {
        for (int i=0;i<bottoniDaColorare.length;i++){
            bottoniDaColorare[i].setTextColor(colore);
        }
    }

    public void resettaGioco(View v){
        giocoFinito = false;

        if((int)(Math.random()*2) == VITTORIAX) {
            turnoCorrente = VITTORIAX;
            turnoView.setText(turnoDi + " " + ics.getText().toString());
        }else{
            turnoCorrente = VITTORIAO;
            turnoView.setText(turnoDi + " " + pallina.getText().toString());
        }

        Button ts = (Button) findViewById(R.id.ts);
        Button tc =(Button) findViewById(R.id.tc);
        Button tr = (Button) findViewById(R.id.tr);
        Button cs = (Button) findViewById(R.id.cs);
        Button cc = (Button) findViewById(R.id.cc);
        Button cr = (Button) findViewById(R.id.cr);
        Button bs = (Button) findViewById(R.id.bs);
        Button bc = (Button) findViewById(R.id.bc);
        Button br = (Button) findViewById(R.id.br);

        ts.setText(CASELLA_VUOTA);
        tc.setText(CASELLA_VUOTA);
        tr.setText(CASELLA_VUOTA);
        cs.setText(CASELLA_VUOTA);
        cc.setText(CASELLA_VUOTA);
        cr.setText(CASELLA_VUOTA);
        bs.setText(CASELLA_VUOTA);
        bc.setText(CASELLA_VUOTA);
        br.setText(CASELLA_VUOTA);

        colora(coloreBase,ts,tc,tr,cs,cc,cr,bs,bc,br);

        for (int i=0;i<griglia.length;i++){
            griglia[i] = PARTITA_IN_CORSO;
        }

        nMosse=0;

    }
    private void evidenzia(int uno, int due, int tre, int colore) {

        Button[] array = {(Button) findViewById(R.id.ts)
                , (Button) findViewById(R.id.tc)
                , (Button) findViewById(R.id.tr)
                , (Button) findViewById(R.id.cs)
                , (Button) findViewById(R.id.cc)
                , (Button) findViewById(R.id.cr)
                , (Button) findViewById(R.id.bs)
                , (Button) findViewById(R.id.bc)
                , (Button) findViewById(R.id.br)
        };

        colora(colore, array[uno],array[due],array[tre]);
    }
}