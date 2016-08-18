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

public class West extends AppCompatActivity {

    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name1,name2,name3,name4,name5,name6,name7,total,score1,score2,score3,score4,score5,score6,score7,title;
    ImageView a1,a2,a3,a4,a5,a6,a7;
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
        setContentView(R.layout.activity_united);

        PlayersList = (ArrayList<Players>) getIntent().getSerializableExtra("FILES_TO_SEND");

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);
        name5 = (TextView) findViewById(R.id.name5);
        name6 = (TextView) findViewById(R.id.name6);
        name7 = (TextView) findViewById(R.id.name7);

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

        a1 = (ImageView) findViewById(R.id.a1);
        a2 = (ImageView) findViewById(R.id.a2);
        a3 = (ImageView) findViewById(R.id.a3);
        a4 = (ImageView) findViewById(R.id.a4);
        a5 = (ImageView) findViewById(R.id.a5);
        a6 = (ImageView) findViewById(R.id.a6);
        a7 = (ImageView) findViewById(R.id.a7);


        title = (TextView) findViewById(R.id.title);
        title.setText("West Ham");


        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/407");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/250657");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/85550");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/6884");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/1375680");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/2597420");
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/entry/2595816");

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
                if (state == 7) {
                    ll.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);

                    name1.setText(fname.get(0));
                    name2.setText(fname.get(1));
                    name3.setText(fname.get(2));
                    name4.setText(fname.get(3));
                    name5.setText(fname.get(4));
                    name6.setText(fname.get(5));
                    name7.setText(fname.get(6));

                    score1.setText(score.get(0));
                    score2.setText(score.get(1));
                    score3.setText(score.get(2));
                    score4.setText(score.get(3));
                    score5.setText(score.get(4));
                    score6.setText(score.get(5));
                    score7.setText(score.get(6));

                    total_score=Integer.parseInt(score.get(0))+Integer.parseInt(score.get(1))+Integer.parseInt(score.get(2))+
                            Integer.parseInt(score.get(3))+
                            Integer.parseInt(score.get(4))+Integer.parseInt(score.get(5))+Integer.parseInt(score.get(6));
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

                            caoid=1;
                            score.set(0,"500");

                            name1.setTextColor(Color.parseColor("#00ff00"));
                            name1.setText(name1.getText()+" (C)");

                            capscore=Integer.parseInt(score1.getText().toString());

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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));



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


                            caoid=2;
                            score.set(1,"500");

                            capscore=Integer.parseInt(score2.getText().toString());

                            name2.setTextColor(Color.parseColor("#00ff00"));
                            name2.setText(name2.getText()+" (C)");

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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));


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


                            caoid=3;
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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

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


                            capscore=Integer.parseInt(score4.getText().toString());

                            caoid=4;
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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

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


                            capscore=Integer.parseInt(score5.getText().toString());

                            caoid=5;
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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

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


                            capscore=Integer.parseInt(score6.getText().toString());

                            caoid=6;
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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

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


                            capscore=Integer.parseInt(score7.getText().toString());

                            caoid=7;
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

                            }
                            total_score=total_score+Integer.parseInt(score.get(minindex));

                            name7.setTextColor(Color.parseColor("#00ff00"));
                            name7.setText(name7.getText()+" (C)");


                            total_score=total_score+Integer.parseInt(score7.getText().toString());
                            total.setText(String.valueOf(total_score));
                            Toast.makeText(getBaseContext(), " Captain Score Doubled", Toast.LENGTH_SHORT).show();

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