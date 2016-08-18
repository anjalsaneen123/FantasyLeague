package com.demo.fantasyleaguefm.fl;

import android.content.ClipData;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointTable extends AppCompatActivity {

    ArrayList<Integer> point =new ArrayList();
    ArrayList<Integer> gd =new ArrayList();
    ArrayList<String> tt =new ArrayList();
    ArrayList<String> team =new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_table);

        new HttpAsyncTask().execute("https://fantasyleague-474ab.firebaseio.com/.json");
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
            try {
                JSONObject jsonRootObject = new JSONObject(result);
                JSONObject object = jsonRootObject.getJSONObject("point");

                point.add(Integer.parseInt(object.getString("ARSENAL")));
                point.add(Integer.parseInt(object.getString("Bournemouth")));
                point.add(Integer.parseInt(object.getString("Burnley")));
                point.add(Integer.parseInt(object.getString("Chelsea")));
                point.add(Integer.parseInt(object.getString("CrystalPalace")));

                point.add(Integer.parseInt(object.getString("Everton")));
                point.add(Integer.parseInt(object.getString("Hull")));
                point.add(Integer.parseInt(object.getString("Leicester")));
                point.add(Integer.parseInt(object.getString("Liverpool")));
                point.add(Integer.parseInt(object.getString("ManCity")));

                point.add(Integer.parseInt(object.getString("ManUnited")));
                point.add(Integer.parseInt(object.getString("Middlesborough")));
                point.add(Integer.parseInt(object.getString("Southampton")));
                point.add(Integer.parseInt(object.getString("Stoke")));
                point.add(Integer.parseInt(object.getString("Sunderland")));

                point.add(Integer.parseInt(object.getString("Swansea")));
                point.add(Integer.parseInt(object.getString("Spurs")));
                point.add(Integer.parseInt(object.getString("Watford")));
                point.add(Integer.parseInt(object.getString("WestBrom")));
                point.add(Integer.parseInt(object.getString("WestHam")));

                gd.add(Integer.parseInt(object.getString("ARSENAL")));
                gd.add(Integer.parseInt(object.getString("Bournemouth")));
                gd.add(Integer.parseInt(object.getString("Burnley")));
                gd.add(Integer.parseInt(object.getString("Chelsea")));
                gd.add(Integer.parseInt(object.getString("CrystalPalace")));

                gd.add(Integer.parseInt(object.getString("Everton")));
                gd.add(Integer.parseInt(object.getString("Hull")));
                gd.add(Integer.parseInt(object.getString("Leicester")));
                gd.add(Integer.parseInt(object.getString("Liverpool")));
                gd.add(Integer.parseInt(object.getString("ManCity")));

                gd.add(Integer.parseInt(object.getString("ManUnited")));
                gd.add(Integer.parseInt(object.getString("Middlesborough")));
                gd.add(Integer.parseInt(object.getString("Southampton")));
                gd.add(Integer.parseInt(object.getString("Stoke")));
                gd.add(Integer.parseInt(object.getString("Sunderland")));

                gd.add(Integer.parseInt(object.getString("Swansea")));
                gd.add(Integer.parseInt(object.getString("Spurs")));
                gd.add(Integer.parseInt(object.getString("Watford")));
                gd.add(Integer.parseInt(object.getString("WestBrom")));
                gd.add(Integer.parseInt(object.getString("WestHam")));


                team.add("Arsenal");
                team.add("Bournemouth");
                team.add("Burnley");
                team.add("Chelsea");
                team.add("CrystalPalace");
                team.add("Everton");
                team.add("Hull");
                team.add("Leicester");
                team.add("Liverpool");
                team.add("ManCity");
                team.add("Man United");
                team.add("Middlesborough");
                team.add("Southampton");
                team.add("Stoke");
                team.add("Sunderland");
                team.add("Swansea");
                team.add("Spurs");
                team.add("Watford");
                team.add("WestBrom");
                team.add("WestHam");
            }
            catch (Exception e) {

            }
        }
    }
}
