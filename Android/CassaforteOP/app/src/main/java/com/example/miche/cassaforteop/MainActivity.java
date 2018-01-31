package com.example.miche.cassaforteop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count =0;
    String password="1234";
    String passwordc="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().hasExtra("n1")){
            password+=getIntent().getIntExtra("n1",0);
            password+=getIntent().getIntExtra("n2",0);
            password+=getIntent().getIntExtra("n3",0);
            password+=getIntent().getIntExtra("n4",0);
        }else{
            password+=0;
            password+=0;
            password+=0;
            password+=1;
        }

        final TextView testo=findViewById(R.id.testo);
        Button b0=findViewById(R.id.b0);
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        Button b5=findViewById(R.id.b5);
        Button b6=findViewById(R.id.b6);
        Button b7=findViewById(R.id.b7);
        Button b8=findViewById(R.id.b8);
        Button b9=findViewById(R.id.b9);
        Button back=findViewById(R.id.back);
        Button enter=findViewById(R.id.enter);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=0;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=1;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=2;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=3;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=4;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=5;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=6;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=7;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=8;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    passwordc+=9;
                    testo.setText(passwordc.toString());
                    count++;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count!=0) {
                    passwordc="";
                    testo.setText(passwordc.toString());
                    count--;
                    if(passCorretta()&&count==4){
                        testo.setTextColor(Color.GREEN);
                    }else{
                        testo.setTextColor(Color.RED);
                    }
                }
            }
        }); enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passCorretta()){
                    Intent it=new Intent();
                    it.putExtra("n1",password.charAt(0));
                    it.putExtra("n2",password.charAt(1));
                    it.putExtra("n3",password.charAt(2));
                    it.putExtra("n4",password.charAt(3));
                    testo.setText("Password corretta");
                    finish();
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Password sbagliata!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
    public boolean passCorretta() {
        if (count == 4) {
            for (int i = 0; i < passwordc.length(); i++) {
                if (passwordc.charAt(i) != password.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
