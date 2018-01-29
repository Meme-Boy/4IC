package com.example.administrator.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String password="8088";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    TextView text=findViewById(R.id.textView);
    public void ClickButton(View view) {
        text.setText(text.getText() + "" + ((Button)view).getText());
        checkPassword(view);

    }

    public void cancellaChar(View view) {
        String temp=text.getText()+"";
        text.setText(temp.substring(0,temp.length()-1));
    }


    public void checkPassword(View view){
        if(text.getText()!=password){
            text.setTextColor(Color.RED);
        }else{
            text.setTextColor(Color.GREEN);
        }
    }

    public void logIn(View view) {
        if(text.getText()==password){
            text.setText("password corretta");
        }
    }
}
