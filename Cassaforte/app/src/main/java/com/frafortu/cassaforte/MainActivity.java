package com.frafortu.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int password = 1234;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.text);
    }
    public boolean isPasswordCorrect(String text) {
        if(text.isEmpty()) {
            display.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if(Integer.parseInt(text) == password) {
            display.setTextColor(getResources().getColor(R.color.green));
            return true;
        } else{
            display.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
    }

    public void onClickListener(View event) {
        if(event.getId() == R.id.number0) {
            display.setText((display.getText() + "0"));
        } else if(event.getId() ==  R.id.number1) {
            display.setText((display.getText() + "1"));
        } else if(event.getId() ==  R.id.number2) {
            display.setText((display.getText() + "2"));
        } else if(event.getId() ==  R.id.number3) {
            display.setText((display.getText() + "3"));
        } else if(event.getId() ==  R.id.number4) {
            display.setText((display.getText() + "4"));
        } else if(event.getId() ==  R.id.number5) {
            display.setText((display.getText() + "5"));
        } else if(event.getId() ==  R.id.number6) {
            display.setText((display.getText() + "6"));
        } else if(event.getId() ==  R.id.number7) {
            display.setText((display.getText() + "7"));
        } else if(event.getId() ==  R.id.number8) {
            display.setText((display.getText() + "8"));
        } else if(event.getId() ==  R.id.number9) {
            display.setText((display.getText() + "9"));
        } else if(event.getId() ==  R.id.delete) {
            if(display.getText().length() > 1) {
                display.setText(((String)display.getText()).substring(0, (display.getText().length() - 1)));
            } else display.setText("");
        } else if(event.getId() == R.id.ok) {
            if(isPasswordCorrect((String) display.getText())) {
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("password", password);
                startActivityForResult(intent,2);
            }
        }
        isPasswordCorrect((String) display.getText());
    }
    /*
        Other version with array of buttons
        Code to be put at onCreate method
        private Button[] buttons;
        int i = 0;
        buttons[i++] = findViewById(R.id.number0);
        buttons[i++] = findViewById(R.id.number1);
        buttons[i++] = findViewById(R.id.number2);
        buttons[i++] = findViewById(R.id.number3);
        buttons[i++] = findViewById(R.id.number4);
        buttons[i++] = findViewById(R.id.number5);
        buttons[i++] = findViewById(R.id.number6);
        buttons[i++] = findViewById(R.id.number7);
        buttons[i++] = findViewById(R.id.number8);
        buttons[i++] = findViewById(R.id.number9);
        buttons[i++] = findViewById(R.id.delete);
        buttons[i++] = findViewById(R.id.ok);

        for(i = 0; i < buttons.length - 1; i++) {
            int val = i;
            buttons[val].setOnClickListener(view -> {
                display.setText(((String) display.getText() + buttons[val].getText()));
                isPasswordCorrect((String) display.getText());
            });
        }
        buttons[buttons.length - 1].setOnClickListener(view -> {
            if(display.getText().length() > 1) {
                display.setText(((String)display.getText()).substring(0, (display.getText().length() - 1)));
                isPasswordCorrect((String) display.getText());
            } else display.setText("");
        });*/
}
