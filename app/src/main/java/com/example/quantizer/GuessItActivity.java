package com.example.quantizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class GuessItActivity extends AppCompatActivity {

    TextView guess,check,war,score,reset,home,finish;
    int a,rand,countscore=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guess_it);
        finish=findViewById(R.id.tv_Finish_guessit);
        guess=findViewById(R.id.tv_enterguess_guessit);
        check= findViewById(R.id.tv_check_guessit);
        war= findViewById(R.id.tv_warning_guessit);
        score=findViewById(R.id.tv_score_guessit);
        reset= findViewById(R.id.tv_reset_guessit);
        home=findViewById(R.id.tv_home_guessit);

        getSupportActionBar().hide();

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuessItActivity.this, GameOverActivity.class);
                intent.putExtra("arg", countscore);
                intent.putExtra("name", "guessIt");
                startActivity(intent);
            }
        });
        finish.setEnabled(false);

        rand= new Random().nextInt(101);
        //Toast.makeText(GuessItActivity.this, String.valueOf(rand), Toast.LENGTH_LONG).show();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFocus();
                a =Integer.parseInt(guess.getText().toString());
                if (a<rand){
                    Snackbar.make(findViewById(R.id.parent),"OOPS!! ENTER A GREATER NUMBER", Snackbar.LENGTH_SHORT).show();
                    guess.setText("");
                    countscore--;

                }
                else if (a>rand){
                    Snackbar.make(findViewById(R.id.parent),"OOPS!!! ENTER A SMALLER NUMBER", Snackbar.LENGTH_SHORT).show();
                    countscore--;
                    guess.setText("");
                }
                else {
                    war.setText("YOU WIN !!!!!");
                    finish.setEnabled(true);
                }
            score.setText(String.valueOf(countscore));
            }


        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                war.setText("");
                a=0;
                countscore=0;
                score.setText(String.valueOf(countscore));
                guess.setText("");
                score.setText("");
                rand= new Random().nextInt(101);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void removeFocus(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
        guess.clearFocus();
    }


}