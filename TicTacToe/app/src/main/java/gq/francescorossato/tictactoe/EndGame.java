package gq.francescorossato.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        String result = getIntent().getStringExtra("result");
        if(result == "draft") {
            ((TextView)findViewById(R.id.mainMessage)).setText(R.string.ohNo);
            ((TextView)findViewById(R.id.subMessage)).setText(R.string.draft);
        }
        else{
            if(result == "X"){
                ((TextView)findViewById(R.id.mainMessage)).setText(R.string.congratulations);
                ((TextView)findViewById(R.id.subMessage)).setText(R.string.win);
            }
            else{
                ((TextView)findViewById(R.id.mainMessage)).setText(R.string.ohNo);
                ((TextView)findViewById(R.id.subMessage)).setText(R.string.lost);
            }
        }
    }

    public void onPress(View v){
        if(v.getId() == R.id.exit) finishAffinity();
        if(v.getId() == R.id.playAgain) finish();
    }
}
