package com.demo.fantasyleaguefm.fl.Teams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.fantasyleaguefm.fl.Players;
import com.demo.fantasyleaguefm.fl.R;

import java.util.ArrayList;

public class Arsenal extends AppCompatActivity {

    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name1,name2,name3,name4,name5,name6,name7,name8,total,score1,score2,score3,score4,score5,score6,score7,score8,title;
    ImageView a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8;
    Button home,away;
    RelativeLayout border;

    int total_score=0,min=0;

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
        title.setText("Arsenal");

        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("87572")){
                name1.setText((PlayersList.get(i).getPlayer_name()));
                score1.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                min=Integer.parseInt(PlayersList.get(i).getGw_score());
                break;
            }
        }
        for(int i=0;i<PlayersList.size();i++)
        {
            if((PlayersList.get(i).getEntry()).equals("324987")){
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
            if((PlayersList.get(i).getEntry()).equals("488926")){
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
            if((PlayersList.get(i).getEntry()).equals("1135")){
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
            if((PlayersList.get(i).getEntry()).equals("66190")){
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
            if((PlayersList.get(i).getEntry()).equals("124075")){
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
            if((PlayersList.get(i).getEntry()).equals("2144")){
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
            if((PlayersList.get(i).getEntry()).equals("1396989")){
                name8.setText((PlayersList.get(i).getPlayer_name()));
                score8.setText(PlayersList.get(i).getGw_score());
                total_score=total_score+Integer.parseInt(PlayersList.get(i).getGw_score());
                if (min>Integer.parseInt(PlayersList.get(i).getGw_score())){
                    min=Integer.parseInt(PlayersList.get(i).getGw_score());
                }
                break;
            }
        }
        total_score=total_score+min;
        total.setText(String.valueOf(total_score));

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setImageResource(R.drawable.green_fill);
                b1.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a1.setClickable(false);


                total_score=total_score+Integer.parseInt(score1.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a2.setImageResource(R.drawable.green_fill);
                b2.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a2.setClickable(false);


                total_score=total_score+Integer.parseInt(score2.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


                total_score=total_score+Integer.parseInt(score3.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a4.setImageResource(R.drawable.green_fill);
                b4.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a4.setClickable(false);


                total_score=total_score+Integer.parseInt(score4.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a5.setImageResource(R.drawable.green_fill);
                b5.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a5.setClickable(false);


                total_score=total_score+Integer.parseInt(score5.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a6.setImageResource(R.drawable.green_fill);
                b6.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a6.setClickable(false);

                total_score=total_score+Integer.parseInt(score6.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a7.setImageResource(R.drawable.green_fill);
                b7.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a8.setVisibility(View.GONE);
                a7.setClickable(false);

                total_score=total_score+Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a8.setImageResource(R.drawable.green_fill);
                b8.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                a7.setClickable(false);

                total_score=total_score+Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a1.setVisibility(View.GONE);
                b1.setClickable(false);

                total_score=total_score-Integer.parseInt(score1.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setImageResource(R.drawable.red_fill);
                b1.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a2.setVisibility(View.GONE);
                b2.setClickable(false);

                total_score=total_score-Integer.parseInt(score2.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                a3.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b3.setClickable(false);


                total_score=total_score-Integer.parseInt(score3.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a4.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b4.setClickable(false);

                total_score=total_score-Integer.parseInt(score4.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                a5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b5.setClickable(false);


                total_score=total_score-Integer.parseInt(score5.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a6.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b6.setClickable(false);
                b8.setVisibility(View.GONE);

                total_score=total_score-Integer.parseInt(score6.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b7.setClickable(false);
                b8.setVisibility(View.GONE);

                total_score=total_score-Integer.parseInt(score7.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8.setImageResource(R.drawable.red_fill);
                b2.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                a7.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b1.setVisibility(View.GONE);
                b8.setClickable(false);
                b7.setVisibility(View.GONE);

                total_score=total_score-Integer.parseInt(score8.getText().toString());
                total.setText(String.valueOf(total_score));
                Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
