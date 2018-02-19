package scaggiante.federico.tris4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent i;
    AlertDialog.Builder dlgAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnsingle:
                i = new Intent(this,SingleActivity.class);
                startActivity(i);
                break;
            case R.id.btnhome:
                i = new Intent(this,HomeActivity.class);
                startActivity(i);
                break;
            case R.id.btnonline:
                //i = new Intent(this,OnlineActivity.class);
                dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Under construction");
                dlgAlert.setTitle("comming soon");
                dlgAlert.setCancelable(true);
                dlgAlert.show();
                break;
            case R.id.btnexit:
                dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("are you sure?");
                dlgAlert.setTitle("exit");
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dlgAlert.show();
                break;
        }
    }
}
