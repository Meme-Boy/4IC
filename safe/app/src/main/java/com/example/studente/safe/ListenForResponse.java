package com.example.studente.safe;

import android.app.Activity;
import android.provider.ContactsContract;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Andrea Dattero on 28/01/2018.
 */

class ListenForResponse implements Runnable {
    Socket client;
    Activity activity;
    public ListenForResponse(Socket client, Activity activity) {
        this.client=client;
        this.activity=activity;
    }

    @Override
    public void run() {
        while(true){
            try {
                DataInputStream din = new DataInputStream(client.getInputStream());
                String testo=din.readUTF();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Database.text.setText(testo);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
