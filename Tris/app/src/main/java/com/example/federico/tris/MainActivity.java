package com.example.federico.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scelto_pve = (Button) findViewById(R.id.scelto_pve);
        Button scelto_pvp = (Button) findViewById(R.id.scelto_pvp);
        scelto_pve.setOnClickListener(this);
        scelto_pvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.scelto_pve)
            startActivity(new Intent(this, PvE.class));
        else if(view.getId() == R.id.scelto_pvp)
            startActivity(new Intent(this, PvP.class));
    }
}

