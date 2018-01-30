package com.example.matteo.cassaforte;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChangePassword extends AppCompatActivity {
    ArrayList<Integer> password=new ArrayList<Integer>();
    TextView oldPass1;
    TextView newPass1;
    private final int REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        password.add(getIntent().getIntExtra("n1",0));
        password.add(getIntent().getIntExtra("n2",0));
        password.add(getIntent().getIntExtra("n3",0));
        password.add(getIntent().getIntExtra("n4",0));



        oldPass1=findViewById(R.id.old1);
        newPass1=findViewById(R.id.new1);

        Button confirm=findViewById(R.id.press);
        Button returnHome=findViewById(R.id.returnHome);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(newPass1.getText().length()==4){
                    int newPassInt1=Integer.parseInt(""+newPass1.getText().charAt(0));
                    int newPassInt2=Integer.parseInt(""+newPass1.getText().charAt(1));
                    int newPassInt3=Integer.parseInt(""+newPass1.getText().charAt(2));
                    int newPassInt4=Integer.parseInt(""+newPass1.getText().charAt(3));


                    if(isPassCorrect()){
                        password.set(0,newPassInt1);
                        password.set(1,newPassInt2);
                        password.set(2,newPassInt3);
                        password.set(3,newPassInt4);
                        Intent it=new Intent(ChangePassword.this,MainActivity.class);
                        it.putExtra("n1",password.get(0));
                        it.putExtra("n2",password.get(1));
                        it.putExtra("n3",password.get(2));
                        it.putExtra("n4",password.get(3));
                        startActivity(it);
                        finish();
                    }else{
                        Context context = getApplicationContext();
                        CharSequence text = "Vecchia password sbagliata";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Password nuova troppo corta";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ChangePassword.this,SecondActivity.class);
                it.putExtra("n1",password.get(0));
                it.putExtra("n2",password.get(1));
                it.putExtra("n3",password.get(2));
                it.putExtra("n4",password.get(3));
                startActivityForResult(it,REQUEST_CODE);
                finish();
            }
        });


    }

    private boolean isPassCorrect(){
        String oldPassStr1=""+oldPass1.getText();
        System.out.println("pass="+oldPassStr1);
        if(password.get(0)== Integer.parseInt(""+oldPassStr1.charAt(0))&&password.get(1)== Integer.parseInt(""+oldPassStr1.charAt(1))&&password.get(2)== Integer.parseInt(""+oldPassStr1.charAt(2))&&password.get(3)== Integer.parseInt(""+oldPassStr1.charAt(3))){
            return true;
        }
        return false;
    }
}
