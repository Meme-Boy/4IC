package scaggiante.federico.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String PASSWORD="1234";
        TextView passwd=findViewById(R.id.passwd);
        clickListener(findViewById(R.id.button1),PASSWORD);
        clickListener(findViewById(R.id.button2),PASSWORD);
        clickListener(findViewById(R.id.button3),PASSWORD);
        clickListener(findViewById(R.id.button4),PASSWORD);
        clickListener(findViewById(R.id.button5),PASSWORD);
        clickListener(findViewById(R.id.button6),PASSWORD);
        clickListener(findViewById(R.id.button7),PASSWORD);
        clickListener(findViewById(R.id.button8),PASSWORD);
        clickListener(findViewById(R.id.button9),PASSWORD);
        clickListener(findViewById(R.id.button0),PASSWORD);
        Button del = findViewById(R.id.buttonDEL);
        Button ok = findViewById(R.id.buttonOK);
        del.setOnClickListener((View view) -> {
            if(passwd.getText().toString().length()!=0) {
                passwd.setText(passwd.getText().toString().substring(0, passwd.length() - 1));
                passwd.setTextColor(getResources().getColor(R.color.red));
            }
        });
        Intent i = new Intent(this,ActivityTwo.class);
        ok.setOnClickListener((View view) -> {
            if(passwd.getText().toString().equals(PASSWORD)) {
                Toast.makeText(this, "Correct Password", Toast.LENGTH_LONG).show();
                startActivity(i);
            }else
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
        });
    }
    public void clickListener(Button b,String p){
        final String PASSWORD=p;
        TextView passwd=findViewById(R.id.passwd);
        b.setOnClickListener((View view) -> {
            passwd.setText(passwd.getText().toString()+b.getText());
            if(passwd.getText().toString().equals(PASSWORD))
                passwd.setTextColor(getResources().getColor(R.color.green));
            else
                passwd.setTextColor(getResources().getColor(R.color.red));
        });
    }
}
