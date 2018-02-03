package com.example.david.cassaforte;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    String old;
    EditText oldTXT;
    EditText newTXT;
    String newPSW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
         old=intent.getStringExtra("old");

       oldTXT=findViewById(R.id.editOld);
       newTXT=findViewById(R.id.editNew);

        Button apply=findViewById(R.id.apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPSW=newTXT.getText().toString();
                if(old.equals(oldTXT.getText().toString()) && newPSW.length()<5){
                    Intent ritorno=new Intent(Main2Activity.this, MainActivity.class);
                    ritorno.putExtra("newPSW", newPSW);

                    startActivity(ritorno);
                }if(newPSW.length()>4 ){
                    manageBlinkEffect(newTXT);
                    Context context = getApplicationContext();
                    CharSequence text = "La nuova password è troppo lunga" ;
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }if(!old.equals(oldTXT.getText().toString()) ){
                    manageBlinkEffect(oldTXT);
                    Context context = getApplicationContext();
                    CharSequence text = "Vecchia password Sbagliata" ;
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });


    }
    private void manageBlinkEffect(EditText s) {
        ObjectAnimator anim = ObjectAnimator.ofInt(s, "backgroundColor", Color.WHITE, Color.RED, Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(2);
        anim.start();
    }
}





