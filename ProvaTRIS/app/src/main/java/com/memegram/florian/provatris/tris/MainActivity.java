package com.memegram.florian.provatris.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.memegram.florian.provatris.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void PVPNames(View v){
        startActivity(new Intent(this, PVPNames.class));
    }

    public void PVCNames(View v){
        startActivity(new Intent(this, PVCNames.class));
    }
}
