package com.demo.fantasyleaguefm.fl.Teams;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.fantasyleaguefm.fl.Players;
import com.demo.fantasyleaguefm.fl.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Liverpool extends AppCompatActivity {

    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name1,name2,name3,name4,name5,name6,name7,name8,total,score1,score2,score3,score4,score5,score6,score7,score8,title;
    ImageView a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8;
    int minindex;
    LinearLayout ll;
    ProgressBar pb;
    Button home,away;
    RelativeLayout border;

    ArrayList<String> score = new ArrayList();
    ArrayList<String> hit = new ArrayList();
    ArrayList<String> fname = new ArrayList();
    ArrayList<String> lname = new ArrayList();
    ArrayList<String> fpl_total = new ArrayList<>();
    int total_score=0,min=0,caoid=0,subid=0,state=0,vc=0,capscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arsenal);

        PlayersList = (ArrayList<Players>) getIntent().getSerializableExtra("FILES_TO_SEND");

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);
        name5 = (TextView) findViewById(R.id.name5);
        name6 = (TextView) findViewById(R.id.name6);
        name7 = (TextView) findViewById(R.id.name7);
        name8 = (TextView) findViewById(R.id.name8);

        pb = (ProgressBar) findViewById(R.id.progressBar1);

        ll=(LinearLayout) findViewById(R.id.ll);
        ll.setVisibility(View.GONE);

        total = (TextView) findViewById(R.id.total);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);
        score6 = (TextView) findViewById(R.id.score6);
        score7 = (TextView) findViewById(R.id.score7);
        score8 = (TextView) findViewById(R.id.score8);

        a1 = (ImageView) findViewById(R.id.a1);
        a2 = (ImageView) findViewById(R.id.a2);
        a3 = (ImageView) findViewById(R.id.a3);
        a4 = (ImageView) findViewById(R.id.a4);
        a5 = (ImageView) findViewById(R.id.a5);
        a6 = (ImageView) findViewById(R.id.a6);
        a7 = (ImageView) findViewById(R.id.a7);
        a8 = (ImageView) findViewById(R.id.a8);

        b1 = (ImageView) findViewById(R.id.b1);
        b2 = (ImageView) findViewById(R.id.b2);
        b3 = (ImageView) findViewById(R.id.b3);
        b4 = (ImageView) findViewById(R.id.b4);
        b5 = (ImageView) findViewById(R.id.b5);
        b6 = (ImageView) findViewById(R.id.b6);
        b7 = (ImageView) findViewById(R.id.b7);
        b8 = (ImageView) findViewById(R.id.b8);

        title = (TextView) findViewById(R.id.title);
        title.setText("Liverpool");


        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/7317");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/32943");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/131372");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/212430");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/136459");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/116637");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/11841");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/64467");

    }
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            try
            {
                JSONObject jsonRootObject = new JSONObject(result);
                JSONObject object  = jsonRootObject.getJSONObject("entry");

                score.add(object.getString("summary_event_points"));
                hit.add(object.getString("extra_free_transfers"));
                fname.add((object.getString("player_first_name")).substring(0,1).toUpperCase()+(object.getString("player_first_name")).substring(1)
                        + " " +(object.getString("player_last_name")).substring(0,1).toUpperCase());
                lname.add(object.getString("player_last_name"));
                fpl_total.add(object.getString("summary_overall_points"));

                Log.e("name: ",fname.get(0));
                state++;
                if (state == 8) {
                    ll.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);

                    name1.setText(fname.get(0));
                    name2.setText(fname.get(1));
                    name3.setText(fname.get(2));
                    name4.setText(fname.get(3));
                    name5.setText(fname.get(4));
                    name6.setText(fname.get(5));
                    name7.setText(fname.get(6));
                    name8.setText(fname.get(7));

                    score1.setText(score.get(0));
                    score2.setText(score.get(1));
                    score3.setText(score.get(2));
                    score4.setText(score.get(3));
                    score5.setText(score.get(4));
                    score6.setText(score.get(5));
                    score7.setText(score.get(6));
                    score8.setText(score.get(7));

                    total_score=Integer.parseInt(score.get(0))+Integer.parseInt(score.get(1))+Integer.parseInt(score.get(2))+
                            Integer.parseInt(score.get(3))+
                            Integer.parseInt(score.get(4))+Integer.parseInt(score.get(5))+Integer.parseInt(score.get(6))+
                            Integer.parseInt(score.get(7));
                    total.setText(String.valueOf(total_score));

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
                            a8.setVisibility(View.GONE);

                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);
                            caoid=1;
                            score.set(0,"500");

                            name1.setTextColor(Color.parseColor("#00ff00"));
                            name1.setText(name1.getText()+" (C)");

                            capscore=Integer.parseInt(score1.getText().toString());


                            total_score=total_score+Integer.parseInt(score1.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

                        }
                    });
                    a2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            caoid=2;
                            score.set(1,"500");

                            capscore=Integer.parseInt(score2.getText().toString());

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            caoid=3;
                            score.set(2,"500");

                            capscore=Integer.parseInt(score3.getText().toString());

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            capscore=Integer.parseInt(score4.getText().toString());

                            caoid=4;
                            score.set(3,"500");

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            capscore=Integer.parseInt(score5.getText().toString());

                            caoid=5;
                            score.set(4,"500");

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            capscore=Integer.parseInt(score6.getText().toString());

                            caoid=6;
                            score.set(5,"500");

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.VISIBLE);

                            capscore=Integer.parseInt(score7.getText().toString());

                            caoid=7;
                            score.set(6,"500");

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
                            a1.setVisibility(View.GONE);
                            a2.setVisibility(View.GONE);
                            a3.setVisibility(View.GONE);
                            a4.setVisibility(View.GONE);
                            a5.setVisibility(View.GONE);
                            a6.setVisibility(View.GONE);
                            a7.setVisibility(View.GONE);
                            a8.setVisibility(View.GONE);
                            a2.setClickable(false);

                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);

                            capscore=Integer.parseInt(score8.getText().toString());

                            caoid=8;
                            score.set(7,"500");

                            name8.setTextColor(Color.parseColor("#00ff00"));
                            name8.setText(name8.getText()+" (C)");


                            total_score=total_score+Integer.parseInt(score8.getText().toString());
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

                            name1.setTextColor(Color.parseColor("#ff0000"));
                            name1.setText(name1.getText()+" (Sub)");


                            subid=1;
                            score.set(0,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));


                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


                            total_score=total_score-Integer.parseInt(score1.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();


                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
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

                            name2.setTextColor(Color.parseColor("#ff0000"));
                            name2.setText(name2.getText()+" (Sub)");



                            subid=2;
                            score.set(1,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));

                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


                            total_score=total_score-Integer.parseInt(score2.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
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

                            name3.setTextColor(Color.parseColor("#ff0000"));
                            name3.setText(name3.getText()+" (Sub)");

                            subid=3;
                            score.set(2,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));

                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


                            total_score=total_score-Integer.parseInt(score3.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
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

                            name4.setTextColor(Color.parseColor("#ff0000"));
                            name4.setText(name3.getText()+" (Sub)");


                            subid=4;
                            score.set(3,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));

                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


                            total_score=total_score-Integer.parseInt(score4.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b5.setOnClickListener(new View.OnClickListener() {
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

                            name5.setTextColor(Color.parseColor("#ff0000"));
                            name5.setText(name5.getText()+" (Sub)");

                            subid=5;
                            score.set(4,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));
                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));



                            total_score=total_score-Integer.parseInt(score5.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b6.setOnClickListener(new View.OnClickListener() {
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

                            name6.setTextColor(Color.parseColor("#ff0000"));
                            name6.setText(name6.getText()+" (Sub)");

                            subid=6;
                            score.set(5,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));
                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));




                            total_score=total_score-Integer.parseInt(score6.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b7.setOnClickListener(new View.OnClickListener() {
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

                            name7.setTextColor(Color.parseColor("#ff0000"));
                            name7.setText(name7.getText()+" (Sub)");

                            subid=7;
                            score.set(6,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));
                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


                            total_score=total_score-Integer.parseInt(score7.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b8.setOnClickListener(new View.OnClickListener() {
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

                            name8.setTextColor(Color.parseColor("#ff0000"));
                            name8.setText(name8.getText()+" (Sub)");

                            subid=8;
                            score.set(7,"500");

                            int minindex=score.indexOf(Collections.min(score));
                            Log.d("yyyyyyy:",String.valueOf(minindex));


                            if(minindex==0){
                                name1.setTextColor(Color.parseColor("#fea400"));
                                name1.setText(name1.getText()+" (VC)");
                            }
                            else if(minindex==1){
                                name2.setTextColor(Color.parseColor("#fea400"));
                                name2.setText(name2.getText()+" (VC)");
                            }
                            else if(minindex==2){
                                name3.setTextColor(Color.parseColor("#fea400"));
                                name3.setText(name3.getText()+" (VC)");
                            }
                            else if(minindex==3){
                                name4.setTextColor(Color.parseColor("#fea400"));
                                name4.setText(name4.getText()+" (VC)");

                            }
                            else if(minindex==4){
                                name5.setTextColor(Color.parseColor("#fea400"));
                                name5.setText(name5.getText()+" (VC)");

                            }
                            else if(minindex==5){
                                name6.setTextColor(Color.parseColor("#fea400"));
                                name6.setText(name6.getText()+" (VC)");

                            }else if(minindex==6){
                                name7.setTextColor(Color.parseColor("#fea400"));
                                name7.setText(name7.getText()+" (VC)");

                            }else if(minindex==7){
                                name8.setTextColor(Color.parseColor("#fea400"));
                                name8.setText(name8.getText()+" (VC)");
                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

                            total_score=total_score-Integer.parseInt(score8.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), "Sub Score Reduced", Toast.LENGTH_SHORT).show();
                        }
                    });

                }


            }
            catch (JSONException e)
            {
                e.printStackTrace();
                Log.d("ArsenalPage:",e.toString());
            }

        }
    }
    public int minx(String a,String b,String c,String d,String e,String f,String g,String h) {
        min = Integer.parseInt(a);
        vc = 1;
        for (int i = 0; i < 7; i++) {
            if (min > Integer.parseInt(b)) {
                min = Integer.parseInt(b);
                vc = 2;
            }
            if (min > Integer.parseInt(c)) {
                min = Integer.parseInt(c);
                vc = 3;
            }
            if (min > Integer.parseInt(d)) {
                min = Integer.parseInt(d);
                vc = 4;
            }
            if (min > Integer.parseInt(e)) {
                min = Integer.parseInt(e);
                vc = 5;
            }
            if (min > Integer.parseInt(f)) {
                min = Integer.parseInt(f);
                vc = 6;
            }
            if (min > Integer.parseInt(g)) {
                min = Integer.parseInt(g);
                vc = 7;
            }
            if (min > Integer.parseInt(h)) {
                min = Integer.parseInt(h);
                vc = 8;
            }
        }
        return vc;
    }
    public int minxx(String a,String b,String c,String d,String e,String f,String g){
        min=Integer.parseInt(a);
        for(int i=0;i<7;i++){
            if(min>Integer.parseInt(b)){
                min=Integer.parseInt(b);
            }
            if(min>Integer.parseInt(c)){
                min=Integer.parseInt(c);
            }
            if(min>Integer.parseInt(d)){
                min=Integer.parseInt(d);
            }
            if(min>Integer.parseInt(e)){
                min=Integer.parseInt(e);
            }
            if(min>Integer.parseInt(f)){
                min=Integer.parseInt(f);
            }
            if(min>Integer.parseInt(g)){
                min=Integer.parseInt(g);
            }
        }
        return min;

    }
    public int minxxx(String a,String b,String c,String d,String e,String f){
        min=Integer.parseInt(a);
        for(int i=0;i<7;i++){
            if(min>Integer.parseInt(b)){
                min=Integer.parseInt(b);
            }
            if(min>Integer.parseInt(c)){
                min=Integer.parseInt(c);
            }
            if(min>Integer.parseInt(d)){
                min=Integer.parseInt(d);
            }
            if(min>Integer.parseInt(e)){
                min=Integer.parseInt(e);
            }
            if(min>Integer.parseInt(f)){
                min=Integer.parseInt(f);
            }
        }
        return min;

    }
}