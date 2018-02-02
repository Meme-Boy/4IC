package tris.daminatoluca.it.tris.OnlineClasses;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import tris.daminatoluca.it.tris.R;

/**
 * Created by pigro on 31/01/2018.
 */

public class OnlineLobbyList extends AppCompatActivity {

    private EditText editSetIp;
    private Button buttonSetIp;
    private Button buttonRefresh;
    private TextView lobbyList;

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;

    private String ipServer;
    private int portServer;
    private Socket server;
    private LobbyLoader lobbyLoader;

    private Activity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online_lobby_list);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        ipServer = getStoredIp();
        portServer = 9000;
        thisActivity = this;

        editSetIp = (EditText) findViewById(R.id.editSetIp);
        buttonSetIp = (Button) findViewById(R.id.buttonSetIp);
        buttonRefresh = (Button) findViewById(R.id.buttonRefreshLobbies);
        lobbyList = (TextView) findViewById(R.id.lobbyList);

        editSetIp.setText(getStoredIp());

        lobbyLoader = new LobbyLoader(ipServer, portServer, lobbyList, this);
        lobbyLoader.start();
    }

    private String getStoredIp(){
        return prefs.getString("ServerIp", "192.168.1.0");
    }

    public void setIpButton(View view){
        prefsEditor.putString("ServerIp", editSetIp.getText().toString());
        prefsEditor.apply();
        ipServer = getStoredIp();
        lobbyLoader.interrupt();
        lobbyLoader = new LobbyLoader(ipServer, portServer, lobbyList, thisActivity);
        lobbyLoader.start();
        editSetIp.setText(getStoredIp());
    }

    public void refreshLobbiesButton(View view){
        lobbyLoader.refreshLobbies();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        lobbyLoader.interrupt();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lobbyLoader.interrupt();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lobbyLoader = new LobbyLoader(ipServer, portServer, lobbyList, this);
        lobbyLoader.start();
    }
}
