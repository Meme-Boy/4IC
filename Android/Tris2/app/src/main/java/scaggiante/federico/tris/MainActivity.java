package scaggiante.federico.tris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int c=0;
    char posizioni[][];
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(this,ActivityTwo.class);
        Tris.clear();

    }


    public void clickListener(View view){

        Button clicked = (Button)(view);
        char pressed;

        if (c % 2 == 0) { clicked.setText("X"); pressed='X'; }
        else { clicked.setText("O"); pressed='O'; }
        clicked.setEnabled(false);
        c++;
        switch (view.getId()) {
            case R.id.button1: Tris.set(view,pressed); break;
            case R.id.button2: Tris.set(view,pressed); break;
            case R.id.button3: Tris.set(view,pressed); break;
            case R.id.button4: Tris.set(view,pressed); break;
            case R.id.button5: Tris.set(view,pressed); break;
            case R.id.button6: Tris.set(view,pressed); break;
            case R.id.button7: Tris.set(view,pressed); break;
            case R.id.button8: Tris.set(view,pressed); break;
            case R.id.button9: Tris.set(view,pressed); break;
        }

        if(c<9 && Tris.checkVictory(i)) { startActivity(i); finish(); }
        if(c==9) { Tris.pareggio(i); startActivity(i); finish();}
    }




}