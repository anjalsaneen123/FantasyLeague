package com.demo.fantasyleaguefm.fl.Teams;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.fantasyleaguefm.fl.Players;
import com.demo.fantasyleaguefm.fl.R;

import java.util.ArrayList;

public class Liverpool extends AppCompatActivity {

    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name1,name2,name3,name4,name5,name6,name7,name8,total,score1,score2,score3,score4,score5,score6,score7,score8,title;
    ImageView a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8;
    Button home,away;
    RelativeLayout border;

    int total_score=0,min=0,id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arsenal);

        PlayersList =  (ArrayList<Players>)getIntent().getSerializableExtra("FILES_TO_SEND");

        name1=(TextView) findViewById(R.id.name1);
        name2=(TextView) findViewById(R.id.name2);
        name3=(TextView) findViewById(R.id.name3);
        name4=(TextView) findViewById(R.id.name4);
        name5=(TextView) findViewById(R.id.name5);
        name6=(TextView) findViewById(R.id.name6);
        name7=(TextView) findViewById(R.id.name7);
        name8=(TextView) findViewById(R.id.name8);

        total = (TextView)findViewById(R.id.total);

        score1=(TextView) findViewById(R.id.score1);
        score2=(TextView) findViewById(R.id.score2);
        score3=(TextView) findViewById(R.id.score3);
        score4=(TextView) findViewById(R.id.score4);
        score5=(TextView) findViewById(R.id.score5);
        score6=(TextView) findViewById(R.id.score6);
        score7=(TextView) findViewById(R.id.score7);
        score8=(TextView) findViewById(R.id.score8);

        a1=(ImageView) findViewById(R.id.a1);
        a2=(ImageView) findViewById(R.id.a2);
        a3=(ImageView) findViewById(R.id.a3);
        a4=(ImageView) findViewById(R.id.a4);
        a5=(ImageView) findViewById(R.id.a5);
        a6=(ImageView) findViewById(R.id.a6);
        a7=(ImageView) findViewById(R.id.a7);
        a8=(ImageView) findViewById(R.id.a8);

        b1=(ImageView) findViewById(R.id.b1);
        b2=(ImageView) findViewById(R.id.b2);
        b3=(ImageView) findViewById(R.id.b3);
        b4=(ImageView) findViewById(R.id.b4);
        b5=(ImageView) findViewById(R.id.b5);
        b6=(ImageView) findViewById(R.id.b6);
        b7=(ImageView) findViewById(R.id.b7);
        b8=(ImageView) findViewById(R.id.b8);

        title = (TextView) findViewById(R.id.title);
        title.setText("Liverpool");

        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("11841")){
                name1.setText((PlayersList.get(i).getPlayer_name()));
                score1.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                min=Integer.parseInt(PlayersList.get(i).getGw_score());
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("64467")){
                name2.setText((PlayersList.get(i).getPlayer_name()));
                score2.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("7317")){
                name3.setText((PlayersList.get(i).getPlayer_name()));
                score3.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("32943")){
                name4.setText((PlayersList.get(i).getPlayer_name()));
                score4.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("131372")){
                name5.setText((PlayersList.get(i).getPlayer_name()));
                score5.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("212430")){
                name6.setText((PlayersList.get(i).getPlayer_name()));
                score6.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("136459")){
                name7.setText((PlayersList.get(i).getPlayer_name()));
                score7.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("116637")){
                name8.setText((PlayersList.get(i).getPlayer_name()));
                score8.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        total.setText(String.valueOf(total_score));


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a1.setClickable(false);

                name1.setTextColor(Color.parseColor("#00ff00"));
                name1.setText(name1.getText()+" (C)");


                total_score=total_score+Integer.parseInt(score1.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a2.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a2.setClickable(false);

                name2.setTextColor(Color.parseColor("#00ff00"));
                name2.setText(name2.getText()+" (C)");


                total_score=total_score+Integer.parseInt(score2.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a3.setVisibility(View.GONE);
                a3.setImageResource(R.drawable.green_fill);
                b3.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a3.setClickable(false);

                name3.setTextColor(Color.parseColor("#00ff00"));
                name3.setText(name3.getText()+" (C)");


                total_score=total_score+Integer.parseInt(score3.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a4.setImageResource(R.drawable.green_fill);
                a4.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a4.setClickable(false);

                name4.setTextColor(Color.parseColor("#00ff00"));
                name4.setText(name4.getText()+" (C)");


                total_score=total_score+Integer.parseInt(score4.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a5.setImageResource(R.drawable.green_fill);
                a5.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a5.setClickable(false);

                name5.setTextColor(Color.parseColor("#00ff00"));
                name5.setText(name5.getText()+" (C)");


                total_score=total_score+Integer.parseInt(score5.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a6.setImageResource(R.drawable.green_fill);
                a6.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a6.setClickable(false);

                name6.setTextColor(Color.parseColor("#00ff00"));
                name6.setText(name6.getText()+" (C)");

                total_score=total_score+Integer.parseInt(score6.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a7.setImageResource(R.drawable.green_fill);
                a7.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a7.setClickable(false);

                name7.setTextColor(Color.parseColor("#00ff00"));
                name7.setText(name7.getText()+" (C)");

                total_score=total_score+Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a8.setImageResource(R.drawable.green_fill);
                a8.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a7.setClickable(false);

                name8.setTextColor(Color.parseColor("#00ff00"));
                name8.setText(name8.getText()+" (C)");

                total_score=total_score+Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                b1.setClickable(false);

                name1.setTextColor(Color.parseColor("#ff0000"));
                name1.setText(name1.getText()+" (Sub)");


                total_score=total_score-Integer.parseInt(score1.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                update1();

                if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                b2.setClickable(false);

                name2.setTextColor(Color.parseColor("#ff0000"));
                name2.setText(name2.getText()+" (Sub)");

                total_score=total_score-Integer.parseInt(score2.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                update2();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setImageResource(R.drawable.red_fill);
                b3.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b3.setClickable(false);

                name3.setTextColor(Color.parseColor("#ff0000"));
                name3.setText(name3.getText()+" (Sub)");


                total_score=total_score-Integer.parseInt(score3.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update3();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setImageResource(R.drawable.red_fill);
                b4.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b4.setClickable(false);

                name4.setTextColor(Color.parseColor("#ff0000"));
                name4.setText(name4.getText()+" (Sub)");

                total_score=total_score-Integer.parseInt(score4.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update4();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setImageResource(R.drawable.red_fill);
                b5.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b5.setClickable(false);

                name5.setTextColor(Color.parseColor("#ff0000"));
                name5.setText(name5.getText()+" (Sub)");


                total_score=total_score-Integer.parseInt(score5.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update5();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6.setImageResource(R.drawable.red_fill);
                b6.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b6.setClickable(false);
                b8.setVisibility(View.GONE);

                name6.setTextColor(Color.parseColor("#ff0000"));
                name6.setText(name6.getText()+" (Sub)");

                total_score=total_score-Integer.parseInt(score6.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update6();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7.setImageResource(R.drawable.red_fill);
                b7.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b7.setClickable(false);
                b8.setVisibility(View.GONE);

                name7.setTextColor(Color.parseColor("#ff0000"));
                name7.setText(name7.getText()+" (Sub)");

                total_score=total_score-Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update7();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name7.getText()+" (VC)");

                }
                else if(id==8){
                    name8.setTextColor(Color.parseColor("#fea400"));
                    name8.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8.setImageResource(R.drawable.red_fill);
                b8.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b8.setClickable(false);
                b7.setVisibility(View.GONE);

                name8.setTextColor(Color.parseColor("#ff0000"));
                name8.setText(name8.getText()+" (Sub)");

                total_score=total_score-Integer.parseInt(score8.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

                update8();

                if(id==1){
                    name1.setTextColor(Color.parseColor("#fea400"));
                    name1.setText(name1.getText()+" (VC)");

                }
                else if(id==3){
                    name3.setTextColor(Color.parseColor("#fea400"));
                    name3.setText(name3.getText()+" (VC)");

                }
                else if(id==4){
                    name4.setTextColor(Color.parseColor("#fea400"));
                    name4.setText(name4.getText()+" (VC)");

                }
                else if(id==5){
                    name5.setTextColor(Color.parseColor("#fea400"));
                    name5.setText(name5.getText()+" (VC)");

                }
                else if(id ==6){
                    name6.setTextColor(Color.parseColor("#fea400"));
                    name6.setText(name6.getText()+" (VC)");

                }
                else if(id==7){
                    name7.setTextColor(Color.parseColor("#fea400"));
                    name7.setText(name7.getText()+" (VC)");

                }
                else if(id==2){
                    name2.setTextColor(Color.parseColor("#fea400"));
                    name2.setText(name8.getText()+" (VC)");

                }
                total_score=total_score+min;

                Log.d("min:",String.valueOf(min));

                Log.d("id:",String.valueOf(id));

            }
        });
    }
    public  void  update1(){
        min=0;
        id=0;

        min=Integer.parseInt(String.valueOf(score2.getText()));
        id=2;

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }


    }
    public  void  update2(){
        min=0;
        id=1;

        min=Integer.parseInt(String.valueOf(score1.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }



    }
    public  void   update3(){

        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }



    }
    public  void  update4(){
        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }


    }
    public  void  update5(){

        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }





    }
    public  void  update6(){

        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }








    }
    public  void  update7(){

        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }
        if (min>Integer.parseInt(String.valueOf(score8.getText()))){
            min=Integer.parseInt(String.valueOf(score8.getText()));
            id=8;
        }


    }
    public  void  update8(){

        min=0;
        id=2;

        min=Integer.parseInt(String.valueOf(score2.getText()));

        if (min>Integer.parseInt(String.valueOf(score3.getText()))){
            min=Integer.parseInt(String.valueOf(score3.getText()));
            id=3;
        }
        if(min>Integer.parseInt(String.valueOf(score4.getText()))){
            min=Integer.parseInt(String.valueOf(score4.getText()));
            id=4;
        }
        if (min>Integer.parseInt(String.valueOf(score5.getText()))){
            min=Integer.parseInt(String.valueOf(score5.getText()));
            id=5;
        }
        if (min>Integer.parseInt(String.valueOf(score6.getText()))){
            min=Integer.parseInt(String.valueOf(score6.getText()));
            id=6;
        }
        if (min>Integer.parseInt(String.valueOf(score7.getText()))){
            min=Integer.parseInt(String.valueOf(score7.getText()));
            id=7;
        }
        if (min>Integer.parseInt(String.valueOf(score1.getText()))){
            min=Integer.parseInt(String.valueOf(score1.getText()));
            id=1;
        }


    }
}