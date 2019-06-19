package edu.udayton.thelatestmusicscene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne =(Button)findViewById(R.id.button);
        Button buttonTwo = (Button)findViewById(R.id.button2);

        View.OnClickListener buttonInfoListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(MainActivity.this, MusicStoryOne.class);
                startActivity(infoIntent);
            }
        };

        buttonOne.setOnClickListener(buttonInfoListener);

        View.OnClickListener buttonInfoListenerTwo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntentTwo = new Intent(MainActivity.this, MusicStoryTwo.class);
                startActivity(infoIntentTwo);
            }
        };

        buttonTwo.setOnClickListener(buttonInfoListenerTwo);
    }
}
