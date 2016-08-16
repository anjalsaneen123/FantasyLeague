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

public class United extends AppCompatActivity {

    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name1,name2,name3,name4,name5,name6,name7,total,score1,score2,score3,score4,score5,score6,score7,title;
    ImageView a1,a2,a3,a4,a5,a6,a7;
    Button home,away;
    RelativeLayout border;

    int total_score=0,min=0,id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_united);

        PlayersList =  (ArrayList<Players>)getIntent().getSerializableExtra("FILES_TO_SEND");

        name1=(TextView) findViewById(R.id.name1);
        name2=(TextView) findViewById(R.id.name2);
        name3=(TextView) findViewById(R.id.name3);
        name4=(TextView) findViewById(R.id.name4);
        name5=(TextView) findViewById(R.id.name5);
        name6=(TextView) findViewById(R.id.name6);
        name7=(TextView) findViewById(R.id.name7);

        total = (TextView)findViewById(R.id.total);

        score1=(TextView) findViewById(R.id.score1);
        score2=(TextView) findViewById(R.id.score2);
        score3=(TextView) findViewById(R.id.score3);
        score4=(TextView) findViewById(R.id.score4);
        score5=(TextView) findViewById(R.id.score5);
        score6=(TextView) findViewById(R.id.score6);
        score7=(TextView) findViewById(R.id.score7);

        a1=(ImageView) findViewById(R.id.a1);
        a2=(ImageView) findViewById(R.id.a2);
        a3=(ImageView) findViewById(R.id.a3);
        a4=(ImageView) findViewById(R.id.a4);
        a5=(ImageView) findViewById(R.id.a5);
        a6=(ImageView) findViewById(R.id.a6);
        a7=(ImageView) findViewById(R.id.a7);


        title = (TextView) findViewById(R.id.title);
        title.setText("Manchester United");

        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("1050")){
                name1.setText((PlayersList.get(i).getPlayer_name()));
                score1.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                min=Integer.parseInt(PlayersList.get(i).getGw_score());
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("32")){
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
            if((PlayersList.get(i).getEntry()).equals("52439")){
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
            if((PlayersList.get(i).getEntry()).equals("823")){
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
            if((PlayersList.get(i).getEntry()).equals("8167")){
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
            if((PlayersList.get(i).getEntry()).equals("24091")){
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
            if((PlayersList.get(i).getEntry()).equals("108")){
                name7.setText((PlayersList.get(i).getPlayer_name()));
                score7.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        total.setText(String.valueOf(total_score));

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

        if(id==1){
            name1.setTextColor(Color.parseColor("#fea400"));
            name1.setText(name1.getText()+" (VC)");

        }
        else if(id==2){
            name2.setTextColor(Color.parseColor("#fea400"));
            name2.setText(name2.getText()+" (VC)");

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
        total_score=total_score+min;


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
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
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
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
                a1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
              
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
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
              
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
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
              
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
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
              
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
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
              
                a7.setClickable(false);

                name7.setTextColor(Color.parseColor("#00ff00"));
                name7.setText(name7.getText()+" (C)");

                total_score=total_score+Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

    }
}