package com.example.theross.strongbox;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SECRET = "1234";

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonDel;
    private Button buttonOk;
    private EditText password;

    View.OnClickListener clk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(password.getText().toString().length() < 4) {
                switch (v.getId()) {
                    case R.id.button0:
                        password.append("0");
                        break;
                    case R.id.button1:
                        password.append("1");
                        break;
                    case R.id.button2:
                        password.append("2");
                        break;
                    case R.id.button3:
                        password.append("3");
                        break;
                    case R.id.button4:
                        password.append("4");
                        break;
                    case R.id.button5:
                        password.append("5");
                        break;
                    case R.id.button6:
                        password.append("6");
                        break;
                    case R.id.button7:
                        password.append("7");
                        break;
                    case R.id.button8:
                        password.append("8");
                        break;
                    case R.id.button9:
                        password.append("9");
                        break;
                    case R.id.buttonOk:
                        check();
                        break;
                }
                check();
            }
            if(v.getId() == R.id.buttonDel)
                if (password.getText().length() > 0)
                    password.setText(password.getText().subSequence(0, password.getText().length() - 1));
                else {
                    if (v.getId() == R.id.buttonOk)
                        check();
                }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDel = findViewById(R.id.buttonDel);
        buttonOk = findViewById(R.id.buttonOk);
        password = findViewById(R.id.password);

        password.setCursorVisible(false);

        button0.setOnClickListener(clk);
        button1.setOnClickListener(clk);
        button2.setOnClickListener(clk);
        button3.setOnClickListener(clk);
        button4.setOnClickListener(clk);
        button5.setOnClickListener(clk);
        button6.setOnClickListener(clk);
        button7.setOnClickListener(clk);
        button8.setOnClickListener(clk);
        button9.setOnClickListener(clk);
        buttonDel.setOnClickListener(clk);
        buttonOk.setOnClickListener(clk);
    }

    private void check() {
        if(password.getText().toString().equals(SECRET)) {
            Toast t = Toast.makeText(this, "Correct PIN", Toast.LENGTH_SHORT);
            t.show();
            password.setTextColor(0xff15ff00);
            new CountDownTimer(1000, 1000) {
                public void onFinish() {
                    password.setText("");
                    startActivity(new Intent(MainActivity.this, Opened.class));
                }

                public void onTick(long millisUntilFinished) {
                }
            }.start();
        }
        else {
            if(password.getText().toString().length() >= 4)
                password.setTextColor(0xffff0000);
            else
                password.setTextColor(0xff000000);
        }
    }



}
