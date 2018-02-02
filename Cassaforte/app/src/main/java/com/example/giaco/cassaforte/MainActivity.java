package com.example.giaco.cassaforte;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity{
    private boolean firstTime = true;
    private boolean flag = true;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            TextView textView = findViewById(R.id.textView);
            textView.setText(savedInstanceState.getString("textView"));
            password = savedInstanceState.getString("password");
            firstTime = savedInstanceState.getBoolean("firstTime");
            flag = savedInstanceState.getBoolean("flag");
            if(!flag)
                textView.setTextColor(getResources().getColor(R.color.red));
        }
    }
    public void onClick(View view){
        TextView textView = findViewById(R.id.textView);
        Button button = (Button)view;
        if(view.getId() == R.id.Button_DEL){
            if(textView.length() > 0){
                if(textView.getText().equals(password) && flag){
                    textView.setText("");
                    flag = false;
                }else
                    textView.setText(textView.getText().toString().substring(0, textView.length() - 1));
            }
        }else{
            if(textView.getText().length() < 5){
                textView.setText(textView.getText().toString().concat(button.getText().toString()));
                if(firstTime){
                    if(textView.getText().length() == 5){
                        password = textView.getText().toString();
                        Toast.makeText(this, "Password set", Toast.LENGTH_LONG).show();
                        firstTime = false;
                    }
                }else{
                    if(textView.getText().equals(password)){
                        textView.setTextColor(getResources().getColor(R.color.green));
                        finish();
                        startActivity(new Intent(this, SecondActivity.class));
                    }else
                        textView.setTextColor(getResources().getColor(R.color.red));
                }
            }else{
                if(flag){
                    textView.setText(button.getText().toString());
                    textView.setTextColor(getResources().getColor(R.color.red));
                    flag = false;
                }
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        TextView textView = findViewById(R.id.textView);
        savedInstanceState.putString("textView", textView.getText().toString());
        savedInstanceState.putString("password", password);
        savedInstanceState.putBoolean("firstTime", firstTime);
        savedInstanceState.putBoolean("flag", flag);
    }
}