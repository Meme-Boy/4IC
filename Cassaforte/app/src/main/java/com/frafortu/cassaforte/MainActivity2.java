package com.frafortu.cassaforte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        password = findViewById(R.id.password);
        password.setText("");
        int pw = getIntent().getIntExtra("password",1);
        password.setText("Hai indovinato la password: " + pw);
    }
}
