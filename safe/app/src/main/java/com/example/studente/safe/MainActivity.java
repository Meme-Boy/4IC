package com.example.studente.safe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);

        Button[] buttons = {
                findViewById(R.id.button), findViewById(R.id.button1), findViewById(R.id.button2),
                findViewById(R.id.button3), findViewById(R.id.button4), findViewById(R.id.button5),
                findViewById(R.id.button6), findViewById(R.id.button7), findViewById(R.id.button8),
                findViewById(R.id.CancellaTutto), findViewById(R.id.button0), findViewById(R.id.CancellaUltimo)
        };
        Button ok = findViewById(R.id.Ok);

    }


    public Context getActivity() {
        return this;
    }

    public void bottoneNumerico(View view) {
        if ((this.display.getText() + "").contains("P"))
            display.setText("");
        display.setText(display.getText() + "" + ((Button)view).getText());
    }

    public void bottoneOk(View view) {
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.password), Context.MODE_PRIVATE);

        String pass = display.getText() + "";
        String realPassword = PreferenceManager.getDefaultSharedPreferences(context).getString("password", "12345");

        if (pass.equals(realPassword) && pass.length() > 1) {
            startActivity(new Intent(this, Database.class));
        } else {
            if (realPassword.length() < 1) {
                if ((display.getText() + "").length() > 3) {
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putString("password", (display.getText() + "")).apply();
                } else {
                    display.setText("Enter password (minimum 4 Chars)");
                }
            } else {
                display.setText("Wrong Password");

            }
        }
    }

    public void cancellaTutto(View view){
        this.display.setText("");
    }

    public void cancellaUltimo(View view){
        String testo = this.display.getText()+"";
        testo=testo.substring(0,testo.length()-1);
        this.display.setText(testo);
    }
}