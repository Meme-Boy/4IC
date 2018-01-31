package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 31/01/2018.
 */

public class ActivityTwo  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_two);
        Button back=findViewById(R.id.ButtonInt);
        Intent i = new Intent(this,MainActivity.class);
        back.setOnClickListener((View view) -> {
                startActivity(i);
    });

}
}
