package com.example.quantizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {

    //step one
    SharedPreferences sharedPreferences;
    // edit the values stored inside the sharedpreferences
    SharedPreferences.Editor editor;


    TextView yourscore, highscore,home;
    int a,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int yourScore = intent.getIntExtra("arg", 0);
        //Toast.makeText(GameOverActivity.this, String.valueOf(yourScore)+" "+name, Toast.LENGTH_SHORT).show();

        //getting the sharedpreferences for the corresponding games
        sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        int highScore = sharedPreferences.getInt("highscore"+name,-1000);
        //Toast.makeText(GameOverActivity.this, String.valueOf(highScore), Toast.LENGTH_SHORT).show();
        if(yourScore > highScore){
            highScore = yourScore;
            editor.putInt("highscore"+name, highScore);
            //compulsory to commit the changes
            editor.commit();
        }

        yourscore = findViewById(R.id.tv_yourscore_gameover);
        highscore = findViewById(R.id.tv_highscore_gameover);
        home = findViewById(R.id.tv_home_gameover);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOverActivity.this, HomeAcitivity.class);
                startActivity(intent);
                finish();
            }
        });

        yourscore.setText(String.valueOf(yourScore));
        highscore.setText(String.valueOf(highScore));

    }
}