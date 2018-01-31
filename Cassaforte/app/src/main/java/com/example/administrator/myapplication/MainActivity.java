package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String password="8088";
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textView);
        Button del = findViewById(R.id.buttonBack);
        del.setOnClickListener((View view) -> {
            if(text.getText().toString().length()!=0) {
                text.setText(text.getText().toString().substring(0, text.length() - 1));
                text.setTextColor(getResources().getColor(R.color.red));
            }
    });

        clickListener(findViewById(R.id.button1),password);
        clickListener(findViewById(R.id.button2),password);
        clickListener(findViewById(R.id.button3),password);
        clickListener(findViewById(R.id.button4),password);
        clickListener(findViewById(R.id.button5),password);
        clickListener(findViewById(R.id.button6),password);
        clickListener(findViewById(R.id.button7),password);
        clickListener(findViewById(R.id.button8),password);
        clickListener(findViewById(R.id.button9),password);
        clickListener(findViewById(R.id.button0),password);

        Button ok = findViewById(R.id.buttonOk);
        Intent i = new Intent(this,ActivityTwo.class);
        ok.setOnClickListener((View view) -> {
            if(text.getText().toString().equals(password))
                startActivity(i);
            else
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();

        });
    }
    public void clickListener(Button b,String p){
        final String password=p;



        TextView passwd=findViewById(R.id.textView);
        b.setOnClickListener((View view) -> {
            passwd.setText(passwd.getText().toString()+b.getText());
            if(passwd.getText().toString().equals(password))
                passwd.setTextColor(getResources().getColor(R.color.green));
            else
                passwd.setTextColor(getResources().getColor(R.color.red));
        });
    }
}

