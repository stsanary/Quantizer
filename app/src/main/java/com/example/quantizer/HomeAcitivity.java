package com.example.quantizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeAcitivity extends AppCompatActivity {

    TextView guessit,solveit,mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);
        guessit=findViewById(R.id.tv_guessit_home);
        solveit= findViewById(R.id.tv_solveit_home);
        mainmenu=findViewById(R.id.tv_MainMenu_home);

        getSupportActionBar().hide();


        guessit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAcitivity.this, GuessItActivity.class);
                startActivity(intent);
            }
        });



        solveit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAcitivity.this, SolveItActivity.class);
                startActivity(intent);
            }
        });



        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}