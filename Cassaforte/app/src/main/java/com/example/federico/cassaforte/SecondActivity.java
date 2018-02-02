package com.example.federico.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] password;
    private int[] attempt;
    private int pos;
    private int tries;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        password = extras.getIntArray("PASSWORD");
        attempt = new int[4];
        textViews = new TextView[]{(TextView) findViewById(R.id.field1) ,(TextView) findViewById(R.id.field2), (TextView) findViewById(R.id.field3), (TextView) findViewById(R.id.field4), (TextView) findViewById(R.id.tries) };

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:{
                attempt[pos] = 1;
                textViews[pos].setText("1");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button2:{
                attempt[pos] = 2;
                textViews[pos].setText("2");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button3:{
                attempt[pos] = 3;
                textViews[pos].setText("3");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button4:{
                attempt[pos] = 4;
                textViews[pos].setText("4");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button5:{
                attempt[pos] = 5;
                textViews[pos].setText("5");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button6:{
                attempt[pos] = 6;
                textViews[pos].setText("6");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button7:{
                attempt[pos] = 7;
                textViews[pos].setText("7");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button8:{
                attempt[pos] = 8;
                textViews[pos].setText("8");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            case R.id.button9:{
                attempt[pos] = 9;
                textViews[pos].setText("9");
                if(pos != 3)
                    pos++;
                else reset();
            } break;

            default: break;
        }
    }

    public boolean check(int[] correct, int[] trying){
        boolean equal = true;
        for(int i = 0; i < correct.length; i++){
            if(correct[i] != trying[i]) equal = false;
        }
        return equal;
    }

    public void reset(){
        if(!check(password, attempt)){
            for(int i = 0; i < textViews.length-1; i++) {
                textViews[i].setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                textViews[i].setText("");
                Toast.makeText(getApplicationContext(), "Riprova!", Toast.LENGTH_SHORT).show();
            }
            tries++;
            textViews[4].setText("Tentativi: " + tries);
            pos = 0;
            attempt = new int[4];

        }else{
            for(int i = 0; i < textViews.length-1; i++) {
                textViews[i].setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
            textViews[4].setTextColor(getResources().getColor(android.R.color.holo_green_light));
            textViews[4].setText("Sbloccato!");
            Toast.makeText(getApplicationContext(), "Sbloccato!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
