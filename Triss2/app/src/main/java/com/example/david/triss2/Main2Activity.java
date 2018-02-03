package com.example.david.triss2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent ris=getIntent();
        String vincitore=ris.getStringExtra("player");
        TextView text=findViewById(R.id.risultato);
        text.setText(vincitore);
        btn=findViewById(R.id.ritorna);
        ritorna();
    }
    Intent ritorna;
    private void ritorna() {
       ritorna=new Intent(Main2Activity.this, MainActivity.class);
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ritorna);
            }
        });

    }
}
