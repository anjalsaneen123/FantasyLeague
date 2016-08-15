package com.demo.fantasyleaguefm.fl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    ArrayList<Players> PlayersList = new ArrayList<Players>();
    TextView name;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        name = (TextView) findViewById(R.id.name);
        listview = (ListView) findViewById(R.id.listview);


        PlayersList =  (ArrayList<Players>)getIntent().getSerializableExtra("FILES_TO_SEND");

//        name.setText(PlayersList.get(1).getPlayer_first_name());

        AdapterPlayer Person;

        Person= new AdapterPlayer (TableActivity.this, 0, PlayersList);
        listview.setAdapter(Person);
    }
}
