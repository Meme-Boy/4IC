package scaggiante.federico.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener((View view) -> {

            finish();
        });
    }
}
