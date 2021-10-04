package com.example.quantizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class SolveItActivity extends AppCompatActivity {
    TextView exp,opta,optb,optc,optd,score,reset,home,timer,finish;
    int exp1,exp2,exp3,optsel,a,b,c,ans=0,count=0;
    //boolean clock;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_it);

        exp=findViewById(R.id.tv_exp_solveit);
        opta=findViewById(R.id.tv_opt1_solveit);
        optb=findViewById(R.id.tv_opt2_solveit);
        optc=findViewById(R.id.tv_opt3_solveit);
        optd=findViewById(R.id.tv_opt4_solveit);
        score=findViewById(R.id.tv_score_solveit);
        home= findViewById(R.id.tv_home_solveit);
        reset=findViewById(R.id.tv_reset_solveit);
        timer=findViewById(R.id.tv_timer_solveit);
        finish=findViewById(R.id.tv_Finish_solveit);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolveItActivity.this, GameOverActivity.class);
                intent.putExtra("arg", count);
                intent.putExtra("name", "solveIt");
                startActivity(intent);
            }
        });

        countDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish(){

                exp.setText("TIMES'S UP" );
                opta.setText("YOUR");
                optb.setText("SCORE");
                optc.setText("IS");
                optd.setText(":");
                timer.setText("");
                opta.setEnabled(false);
                optb.setEnabled(false);
                optc.setEnabled(false);
                optd.setEnabled(false);
                finish.setEnabled(true);

            }
        };


        countDownTimer.start();
        newQuestion();


        opta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optsel==1){
                    Snackbar.make(findViewById(R.id.solveParent),"YOU WIN!!!", Snackbar.LENGTH_SHORT).show();
                    count++;
                    score.setText(String.valueOf(count));

                }
                else {
                    Snackbar.make(findViewById(R.id.solveParent),"OOPS!! WRONG ANSWER", Snackbar.LENGTH_SHORT).show();
                    count--;
                    score.setText(String.valueOf(count));

                }
                newQuestion();
            }
        });
        optb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optsel==2){
                    Snackbar.make(findViewById(R.id.solveParent),"YOU WIN!!!", Snackbar.LENGTH_SHORT).show();
                    count++;
                    score.setText(String.valueOf(count));

                }
                else {
                    Snackbar.make(findViewById(R.id.solveParent),"OOPS!! WRONG ANSWER", Snackbar.LENGTH_SHORT).show();
                    count--;
                    score.setText(String.valueOf(count));

                }
                newQuestion();
            }
        });
        optc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optsel==3){
                    Snackbar.make(findViewById(R.id.solveParent),"YOU WIN!!!", Snackbar.LENGTH_SHORT).show();
                    count++;
                    score.setText(String.valueOf(count));

                }
                else {
                    Snackbar.make(findViewById(R.id.solveParent),"OOPS!! WRONG ANSWER", Snackbar.LENGTH_SHORT).show();
                    count--;
                    score.setText(String.valueOf(count));

                }
                newQuestion();
            }
        });
        optd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optsel==4){
                    Snackbar.make(findViewById(R.id.solveParent),"YOU WIN!!!", Snackbar.LENGTH_SHORT).show();
                    count++;
                    score.setText(String.valueOf(count));

                }
                else {
                    Snackbar.make(findViewById(R.id.solveParent),"OOPS!! WRONG ANSWER", Snackbar.LENGTH_SHORT).show();
                    count--;
                    score.setText(String.valueOf(count));

                }
                newQuestion();
            }
        });
        score.setText(String.valueOf(count));


        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                count=0;
                score.setText(String.valueOf(count));

                countDownTimer.cancel();
                countDownTimer.start();
                newQuestion();
                opta.setEnabled(true);
                optb.setEnabled(true);
                optc.setEnabled(true);
                optd.setEnabled(true);


            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void newQuestion() {
        finish.setEnabled(false);
        exp1= new Random().nextInt(50);
        exp2= new Random().nextInt(50);
        exp3= new Random().nextInt(16);
        optsel= new Random().nextInt(4)+1;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("( ").append(exp1).append(" + ").append(exp2).append(")").append(" * ").append(exp3).append(" = ? ");
        exp.setText(stringBuilder.toString());
        ans= (exp1 + exp2) * exp3;

        a= new Random().nextInt(100)+ans;
        b=new Random().nextInt(100)+ans;
        c=new Random().nextInt(100)+ans;

        while (a==b || a==c || a==ans){
            a= new Random().nextInt(100)+ans;
        }

        while (b==c || b==a || b==ans){
            b=new Random().nextInt(100)+ans;
        }

        while (c==a || c==b || c==ans){
            c=new Random().nextInt(100)+ans;
        }

        if(optsel==1){
            opta.setText(String.valueOf(ans));
            optb.setText(String.valueOf(a));
            optc.setText(String.valueOf(b));
            optd.setText(String.valueOf(c));
        }
        else if(optsel==2){
            opta.setText(String.valueOf(a));
            optb.setText(String.valueOf(ans));
            optc.setText(String.valueOf(b));
            optd.setText(String.valueOf(c));
        }
        else if(optsel==3){
            opta.setText(String.valueOf(a));
            optb.setText(String.valueOf(b));
            optc.setText(String.valueOf(ans));
            optd.setText(String.valueOf(c));
        }
        else if(optsel==4){
            opta.setText(String.valueOf(a));
            optb.setText(String.valueOf(b));
            optc.setText(String.valueOf(c));
            optd.setText(String.valueOf(ans));
        }
    }



}