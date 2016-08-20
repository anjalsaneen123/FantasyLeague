package com.demo.fantasyleaguefm.fl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.demo.fantasyleaguefm.fl.Teams.Arsenal;
import com.demo.fantasyleaguefm.fl.Teams.Bournemouth;
import com.demo.fantasyleaguefm.fl.Teams.ManCity;
import com.demo.fantasyleaguefm.fl.Teams.Middlesborough;
import com.demo.fantasyleaguefm.fl.Teams.Burnley;
import com.demo.fantasyleaguefm.fl.Teams.CP;
import com.demo.fantasyleaguefm.fl.Teams.Chelsea;
import com.demo.fantasyleaguefm.fl.Teams.Everton;
import com.demo.fantasyleaguefm.fl.Teams.Hull;
import com.demo.fantasyleaguefm.fl.Teams.Lexter;
import com.demo.fantasyleaguefm.fl.Teams.Liverpool;
import com.demo.fantasyleaguefm.fl.Teams.Sou;
import com.demo.fantasyleaguefm.fl.Teams.Spurs;
import com.demo.fantasyleaguefm.fl.Teams.Stoke;
import com.demo.fantasyleaguefm.fl.Teams.Sunderland;
import com.demo.fantasyleaguefm.fl.Teams.Swe;
import com.demo.fantasyleaguefm.fl.Teams.United;
import com.demo.fantasyleaguefm.fl.Teams.Wat;
import com.demo.fantasyleaguefm.fl.Teams.Wba;
import com.demo.fantasyleaguefm.fl.Teams.West;


public class LeagueActivity extends AppCompatActivity {

    ArrayList<Players> PlayerList = new ArrayList<Players>();
    ImageView button;
    ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,link;
    ImageView button11,button12,button13,button14,button15,button16,button17,button18,button19,button20,point_table;
    ImageView fb,insta;
    RelativeLayout bg;
    int j=0,p=2;
    private ProgressBar spinner;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        bg = (RelativeLayout) findViewById(R.id.bg);
        button = (ImageView) findViewById(R.id.button);
        button1 = (ImageView) findViewById(R.id.button1);
        button2 = (ImageView) findViewById(R.id.button2);
        button3 = (ImageView) findViewById(R.id.button3);
        button4 = (ImageView) findViewById(R.id.button4);
        button5 = (ImageView) findViewById(R.id.button5);
        button6 = (ImageView) findViewById(R.id.button6);
        button7 = (ImageView) findViewById(R.id.button7);
        button8 = (ImageView) findViewById(R.id.button8);
        button9 = (ImageView) findViewById(R.id.button9);
        button10 = (ImageView) findViewById(R.id.button10);
        button11 = (ImageView) findViewById(R.id.button11);
        button12 = (ImageView) findViewById(R.id.button12);
        button13 = (ImageView) findViewById(R.id.button13);
        button14 = (ImageView) findViewById(R.id.button14);
        button15 = (ImageView) findViewById(R.id.button15);
        button16 = (ImageView) findViewById(R.id.button16);
        button17 = (ImageView) findViewById(R.id.button17);
        button18 = (ImageView) findViewById(R.id.button18);
        button19 = (ImageView) findViewById(R.id.button19);
        button20 = (ImageView) findViewById(R.id.button20);
        link = (ImageView) findViewById(R.id.link);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);

        fb=(ImageView) findViewById(R.id.fb);
        insta=(ImageView)findViewById(R.id.insta);

        point_table=(ImageView) findViewById(R.id.point_table);
        // get reference to the views


        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/leagues-classic-standings/17264?phase=1&le-page=1&ls-page=1");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, TableActivity.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);

                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Arsenal.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Bournemouth.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Burnley.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Chelsea.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, CP.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Everton.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Hull.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Lexter.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Liverpool.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, ManCity.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Middlesborough.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, United.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Sou.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Stoke.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Sunderland.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Swe.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Spurs.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Wat.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, Wba.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, West.class);
                intent.putExtra("FILES_TO_SEND", PlayerList);
                startActivity(intent);
            }
        });

        point_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeagueActivity.this, PointTable.class);
                startActivity(intent);
            }
        });


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fantasy.premierleague.com/a/leagues/standings/17264/classic"));
                startActivity(myIntent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mullaaabid"));
                startActivity(myIntent);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/MullaGoat"));
                startActivity(myIntent);
            }
        });

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
//        Log.d("result:",result);
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

//            Log.d("RESULT:",result);
            try
            {
                JSONObject jsonRootObject = new JSONObject(result);

                JSONObject JSONnew_entries  = jsonRootObject.getJSONObject("standings");

//                JSONObject jSON_has_next =JSONnew_entries.getJSONObject("has_next");

                Log.d("ASDF",JSONnew_entries.getString("has_next"));


                JSONArray jsonResults = JSONnew_entries.optJSONArray("results");

                for (int i = 0; i < jsonResults.length(); i++) {
                    JSONObject object = jsonResults.getJSONObject(i);

                    Players player = new Players();

                    player.setEntry_name(object.getString("entry_name"));
                    player.setId(object.getString("id"));
                    player.setPlayer_name(object.getString("player_name"));

                    Log.d(String.valueOf(i),player.getPlayer_name());

                    player.setEntry(object.getString("entry"));
                    player.setRank(object.getString("rank"));
                    player.setGw_score(object.getString("event_total"));

                    player.setTotal_score(object.getString("total"));

                    PlayerList.add(player);

                }
                if((JSONnew_entries.getString("has_next")).equals("true")) {
                    new HttpAsyncTask().execute("https://fantasy.premierleague.com/drf/leagues-classic-standings/17264?phase=1&le-page="+String.valueOf(p)+"&ls-page="+String.valueOf(p));
                    p++;
                }
                else
                {
                    bg.setBackgroundResource(R.drawable.cl);
                    Toast.makeText(getBaseContext(), " Data Received!", Toast.LENGTH_SHORT).show();
                    button.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    button5.setVisibility(View.VISIBLE);
                    button6.setVisibility(View.VISIBLE);
                    button7.setVisibility(View.VISIBLE);
                    button8.setVisibility(View.VISIBLE);
                    button9.setVisibility(View.VISIBLE);
                    button10.setVisibility(View.VISIBLE);
                    button11.setVisibility(View.VISIBLE);
                    button12.setVisibility(View.VISIBLE);
                    button13.setVisibility(View.VISIBLE);
                    button14.setVisibility(View.VISIBLE);
                    button15.setVisibility(View.VISIBLE);
                    button16.setVisibility(View.VISIBLE);
                    button17.setVisibility(View.VISIBLE);
                    button18.setVisibility(View.VISIBLE);
                    button19.setVisibility(View.VISIBLE);
                    button20.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.GONE);

                    fb.setVisibility(View.GONE);
                    insta.setVisibility(View.GONE);
                    bg.setBackgroundResource(R.drawable.cl);
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                Log.d("LeagueActivity:",e.toString());
            }

        }
    }
}