package com.example.obzentish.cassaforte;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    final ArrayList<Integer> password=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        password.add(getIntent().getIntExtra("n1",0));
        password.add(getIntent().getIntExtra("n2",0));
        password.add(getIntent().getIntExtra("n3",0));
        password.add(getIntent().getIntExtra("n4",0));
        TextView testo=findViewById(R.id.chpass);

        testo.setText("Password  "+password.toString());

        Button chpass=findViewById(R.id.button);
        chpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(SecondActivity.this,ChangePassword.class);
                it.putExtra("n1",password.get(0));
                it.putExtra("n2",password.get(1));
                it.putExtra("n3",password.get(2));
                it.putExtra("n4",password.get(3));
                startActivity(it);
                finish();
            }
        });

    }
}
