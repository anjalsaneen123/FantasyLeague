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
        public TextView name,date,id,team_name,rank,total_point,fl;

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
                holder.fl=(TextView)vi.findViewById(R.id.fl_team);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.team_name.setText(lPerson.get(position).getEntry_name());
            holder.name.setText((lPerson.get(position).getPlayer_name()));
            holder.date.setText(lPerson.get(position).getGw_score());
            holder.rank.setText(lPerson.get(position).getRank());
            holder.total_point.setText(lPerson.get(position).getTotal_score());
            holder.fl.setText(getFlTeam(lPerson.get(position).entry));

        } catch (Exception e) {


        }
        return vi;
    }
    public String getFlTeam(String j){
        int i=Integer.parseInt(j);

        if (i==87572 || i==324987 || i==488926 || i==1135 || i==66190 || i==124075 || i==2144 || i==1396989){
            return "Arsenal";
        }
        else if (
        i ==221126 ||
                i ==221390 ||
                i ==2318 ||
                i ==280148 ||
                i ==271084 ||
                i ==6001 ||
                i ==221572 || i==54268){
            return "Bournemouth";
        }
        else if(i==1454 ||
                i==348215 ||
                i==7500 ||
                i==24146 ||
                i==600421 ||
                i==280 ||
                i==264486 ||
                i==1062){
            return "Chelsea";
        }
        else if(i==23185 ||
                i==50968 ||
                i==374 ||
                i==54464 ||
                i==12606 ||
                i==982 ||
                i==3997){
            return "Crystal Palace";
        }
        else if(i== 105997||
                i== 435507||
                i== 224588||
                i== 110823||
                i== 223794||
                i== 703||
                i== 2274794||
                i== 11456){
            return "Everton";
        }
        else  if(i==76599||
                i==131029||
                i==59165||
                i==975999||
                i==668118||
                i==1200237||
                i==1110042||
                i==1524944){
            return  "Hull City";
        }
        else if(i==3763||
                i==57172||
                i==60760||
                i==2476||
                i==53522||
                i==17211||
                i==61622){
            return "Leicester";
        }
        else if(i==7317||
                i==32943||
                i==131372||
                i==212430||
                i==136459||
                i==116637||
                i==11841||
                i==64467){
            return "Liverpool";
        }
        else if(i== 449||
                i== 102||
                i== 558||
                i== 118||
                i== 44977||
                i== 41111||
                i== 2101||
                i== 654){
            return "Man City";
        }
        else if(i==609 ||
                i==843 ||
                i==30571 ||
                i==21041 ||
                i==309083 ||
                i==100811 ||
                i==3911 ||
                i==291868){
            return "Middlesborough";
        }
        else if(i==7360||
                i==44018||
                i==68503||
                i==70154||
                i==67541||
                i==12719||
                i==513840||
                i==861289){
            return "Southampton";
        }
        else if(i==48016||
                i==1001||
                i==779||
                i==28521||
                i==57938||
                i==12959||
                i==8889||
                i==67668){
            return "Spurs";
        }
        else if (i==38081||
                i==582||
                i==798||
                i==414||
                i==132205||
                i==21019||
                i==282336||
                i==45985){
            return "Stoke";
        }
        else if(i==107074||
                i==1312473||
                i==1304034||
                i==618||
                i==678981||
                i==22065||
                i==219949||
                i==818936){
            return "Sunderland";
        }
        else if(i==1201847||
                i==1149083||
                i==852512||
                i==1169314||
                i==944570||
                i==1203692||
                i==1086933||
                i==1165066){
            return "Sweansea";
        }
        else if(i==1050||
                i==32||
                i==52439||
                i==823||
                i==8167||
                i==24091||
                i==108){
            return "Manchester United";
        }
        else if (i==26094||
                i==3693||
                i==123036||
                i==2673||
                i==29780||
                i==292754||
                i==461207||
                i==340790){
            return "Watford";
        }
        else if(i==42555||
                i==838589||
                i==6530||
                i==48139||
                i==693713||
                i==27285||
                i==723324||
                i==1221631){
            return "West Brom";
        }
        else if(i==407||
                i==250657||
                i==85550||
                i==6884||
                i==1375680||
                i==2597420||
                i==2595816){
            return "West Ham";
        }
        else if(i==271511||
                i==136379||
                i==92015||
                i==325034||
                i==80606||
                i==83109||
                i==433374||
                i==442458){
            return "Burnley";
        }





        else
            return "N/A";
    }
}