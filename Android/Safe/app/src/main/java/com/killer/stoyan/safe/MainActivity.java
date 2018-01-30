package com.killer.stoyan.safe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final Integer[] PIN=new Integer[4];
    private Integer[] tryes;
    private int sentinel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PIN[0]=1;
        PIN[1]=2;
        PIN[2]=3;
        PIN[3]=4;
        sentinel=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    TextView tv=findViewById(R.id.textView);

    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        switch(view.getId()){
            case R.id.button0:
                tryes[sentinel]=0;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button1:
                tryes[sentinel]=1;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button2:
                tryes[sentinel]=2;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button3:
                tryes[sentinel]=3;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button4:
                tryes[sentinel]=4;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button5:
                tryes[sentinel]=5;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button6:
                tryes[sentinel]=6;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button7:
                tryes[sentinel]=7;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button8:
                tryes[sentinel]=8;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.button9:
                tryes[sentinel]=9;
                sentinel++;
                tv.setText(PIN.toString());
            case R.id.delete:
                tryes[sentinel]=null;
                sentinel--;
                tv.setText(PIN.toString());
        }
        startActivity(i);
    }
    //aggiungere se PIN == tryes passare al activity aperto
}
