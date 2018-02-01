package com.example.studente.safe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Database extends AppCompatActivity {
    public static EditText text;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        send = findViewById(R.id.send);
        text=findViewById(R.id.text);
        send.setOnClickListener((View view)->{
            try {
                Socket client = new Socket("79.54.6.193",8080);
                DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                String testo=text.getText() + "";
                if(!testo.substring(0,3).contains("get")) {
                    dout.write(testo.getBytes(), 0, testo.getBytes().length);
                    dout.flush();
                    dout.close();
                }
                else{
                    if(testo.substring(5,8).contains("all")){
                        dout.write("get all".getBytes(),0,"get all".getBytes().length);
                        dout.flush();
                        dout.close();
                    }
                    if(testo.charAt(5)=='{'){
                        String arg="";
                        for(int i=0; testo.charAt(i)=='}';i++){
                            arg+=testo.charAt(i);
                        }
                        new Thread(new ListenForResponse(client,this)).start();
                        dout.write(("get "+arg).getBytes(),0,("get "+arg).getBytes().length);
                        dout.flush();
                        dout.close();
                    }
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
