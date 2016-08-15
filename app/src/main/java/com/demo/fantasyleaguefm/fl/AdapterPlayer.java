package com.demo.fantasyleaguefm.fl;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anjal on 30-Jul-16.
 */
public class AdapterPlayer extends ArrayAdapter<Players> {
    private Activity activity;
    private ArrayList<Players> lPerson;
    private static LayoutInflater inflater = null;

    public AdapterPlayer (Activity activity, int textViewResourceId, ArrayList<Players> _lPerson) {
        super(activity, textViewResourceId, _lPerson);
        try {
            this.activity = activity;
            this.lPerson = _lPerson;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lPerson.size();
    }

    public Players getItem(Players position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView name,date,id,team_name,rank,total_point;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.player_item, null);
                holder = new ViewHolder();

                holder.team_name = (TextView) vi.findViewById(R.id.team_name);
                holder.name = (TextView) vi.findViewById(R.id.name);
                holder.date = (TextView) vi.findViewById(R.id.date);
                holder.rank = (TextView) vi.findViewById(R.id.rank);
                holder.total_point = (TextView) vi.findViewById(R.id.total_point);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.team_name.setText(lPerson.get(position).getEntry_name());
            holder.name.setText((lPerson.get(position).getPlayer_name()));
            holder.date.setText(lPerson.get(position).getGw_score());
            holder.rank.setText(lPerson.get(position).getRank());
            holder.total_point.setText(lPerson.get(position).getTotal_score());

        } catch (Exception e) {


        }
        return vi;
    }
}