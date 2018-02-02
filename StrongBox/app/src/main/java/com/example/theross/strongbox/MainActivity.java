package com.example.theross.strongbox;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SECRET = "1234";
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.password);
    }

    public void listener(View v){
        switch (v.getId()) {
            case R.id.button0: password.append("0"); check(); break;
            case R.id.button1: password.append("1"); check(); break;
            case R.id.button2: password.append("2"); check(); break;
            case R.id.button3: password.append("3"); check(); break;
            case R.id.button4: password.append("4"); check(); break;
            case R.id.button5: password.append("5"); check(); break;
            case R.id.button6: password.append("6"); check(); break;
            case R.id.button7: password.append("7"); check(); break;
            case R.id.button8: password.append("8"); check(); break;
            case R.id.button9: password.append("9"); check(); break;
            case R.id.buttonOk: check(); break;
            case R.id.buttonDel:
                if(password.getText().length() > 0) {
                    String text = password.getText().toString();
                    password.setText(text.substring(0, text.length()-1));
                }
                break;
        }
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
