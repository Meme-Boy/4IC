package tris.daminatoluca.it.tris.OnlineClasses;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * Created by pigro on 01/02/2018.
 */

public class LobbyLoader extends Thread {

    private TextView text;

    private boolean refresh;

    private Socket server;
    private int timeoutConnection;
    private String ipServer;
    private int portServer;

    private Activity activity;

    public LobbyLoader(String ipServer, int portServer, TextView text, Activity activity){
        this.ipServer = ipServer;
        this.portServer = portServer;
        this.text = text;
        this.activity = activity;
        timeoutConnection = 1000;
        refresh = false;
    }

    @Override
    public void run(){
        if(server == null || !server.isConnected()){
            System.out.println("Provo a connettermi!");
            setText(text,"Provo a connettermi...");
            try {
                server = new Socket();
                server.connect(new InetSocketAddress(ipServer, portServer), timeoutConnection);
                System.out.println("Connesso!");
                setText(text,"Connesso!");
            } catch (IOException e) {
                System.out.println("Errore Socket!");
                setText(text,"Errore nel collegamento...");
                makeToast("Server non raggiungibile");
                e.printStackTrace();
                interrupt();
            }
        }
        while(!isInterrupted()){
            invia(server, "Lobbies");
            String messaggio = ricevi(server);
            setText(text, messaggio);
        }
    }

    private void setText(final TextView textView, final String text){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(text);
            }
        });
    }

    private void makeToast(final String text){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void refreshLobbies(){
        refresh = true;
    }

    private void invia(Socket socket, String data){
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(data);
        }  catch(SocketException ex) {
            System.out.println("Errore nel Socket del Client");
            ex.printStackTrace();
        }catch(IOException ex) {
            System.out.println("Errore nel DataOutputStream");
            ex.printStackTrace();
        }
    }

    private String ricevi(Socket socket){
        try {
            DataInputStream input = new DataInputStream(server.getInputStream());
            String s = input.readUTF();
            while(s == null)
                s = input.readUTF();
            return s;
        }  catch(SocketException ex) {
            System.out.println("Errore nel Socket del Server");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Errore nel DataInputStream");
            ex.printStackTrace();
        }
        return null;
    }
}
