package scaggiante.federico.tris5;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent i;
    AlertDialog.Builder dlgAlert;
    Button bq1;
    Button bq2;
    AlertDialog a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Tris5 -> Menu");
    }
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnsingle:
                i = new Intent(this,GameActivity.class);
                dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setTitle(R.string.mode);
                dlgAlert.setCancelable(true);
                dlgAlert.setNegativeButton("easy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        i.putExtra("gameMode",0);
                        startActivity(i);
                    }
                });
                dlgAlert.setPositiveButton("difficult", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        i.putExtra("gameMode",3);
                        startActivity(i);
                    }
                });
                a=dlgAlert.create();
                a.show();
                bq1 = a.getButton(DialogInterface.BUTTON_NEGATIVE);
                bq2 = a.getButton(DialogInterface.BUTTON_POSITIVE);
                bq1.setTextColor(Color.BLUE);
                bq2.setTextColor(Color.BLUE);
                break;
            case R.id.btnhome:
                i = new Intent(this,GameActivity.class);
                i.putExtra("gameMode",1);
                startActivity(i);
                break;
            case R.id.btnonline:
                /*i = new Intent(this,GameActivity.class);
                i.putExtra("gameMode",2);
                startActivity(i);*/
                dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage(R.string.under);
                dlgAlert.setTitle(R.string.soon);
                dlgAlert.setCancelable(true);
                dlgAlert.show();
                break;
            case R.id.btnexit:
                dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage(R.string.sure);
                dlgAlert.setTitle(R.string.exit);
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                a=dlgAlert.create();
                a.show();
                bq2 = a.getButton(DialogInterface.BUTTON_POSITIVE);
                bq2.setTextColor(Color.BLUE);
                break;
        }
    }
}
