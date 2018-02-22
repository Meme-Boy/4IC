package com.example.studente.cassaforte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView test=findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.b1);
        Button button2=findViewById(R.id.b2);
        Button button3=findViewById(R.id.b3);
        Button button4=findViewById(R.id.b4);
        Button button5=findViewById(R.id.b5);
        Button button6=findViewById(R.id.b6);
        Button button7=findViewById(R.id.b7);
        Button button8=findViewById(R.id.b8);
        Button button9=findViewById(R.id.b9);
        Button button0=findViewById(R.id.b0);
        Button back=findViewById(R.id.bBack);

        button0.setOnClickListener((view)-->actionClick(button0));
        button1.setOnClickListener((view)-->actionClick(button1));
        button2.setOnClickListener((view)-->actionClick(button2));
        button3.setOnClickListener((view)-->actionClick(button3));
        button4.setOnClickListener((view)-->actionClick(button4));
        button5.setOnClickListener((view)-->actionClick(button5));
        button6.setOnClickListener((view)-->actionClick(button6));
        button7.setOnClickListener((view)-->actionClick(button7));
        button8.setOnClickListener((view)-->actionClick(button8));
        button9.setOnClickListener((view)-->actionClick(button9));



    }
    public void actionClick(Button b){
        int val=Integer.parseInt(b.getText().toString());
        test.setText(""+val);


    }
}
