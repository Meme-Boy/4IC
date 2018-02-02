package com.example.federico.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] password;
    private int pos;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews = new TextView[]{(TextView) findViewById(R.id.field1) ,(TextView) findViewById(R.id.field2), (TextView) findViewById(R.id.field3), (TextView) findViewById(R.id.field4)};
        pos = 0;
        password = new int[4];

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
        Button btnDel = (Button) findViewById(R.id.delButton);
        btnDel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){

        switch (v.getId()){

            case R.id.button1:{
                password[pos] = 1;
                textViews[pos].setText("1");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button2:{
                password[pos] = 2;
                textViews[pos].setText("2");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button3:{
                password[pos] = 3;
                textViews[pos].setText("3");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button4:{
                password[pos] = 4;
                textViews[pos].setText("4");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button5:{
                password[pos] = 5;
                textViews[pos].setText("5");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button6:{
                password[pos] = 6;
                textViews[pos].setText("6");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button7:{
                password[pos] = 7;
                textViews[pos].setText("7");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button8:{
                password[pos] = 8;
                textViews[pos].setText("8");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.button9:{
                password[pos] = 9;
                textViews[pos].setText("9");
                if(pos != 3)
                    pos++;
                else change();
            } break;

            case R.id.delButton:{
                if(pos == 0) {
                    textViews[pos].setText("_");
                    pos++;
                }else{
                    pos--;
                    textViews[pos].setText("_");
                }

            } break;

            default: break;
        }
    }

    public void change(){
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("PASSWORD", password);
        startActivity(i);
    }
}
