package com.example.listing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class PersonAdapter extends ArrayAdapter<Person> {

    private static final String TAG = "PersonAdapter";

    private Context mContext;
    private int Mresource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView name;
        TextView birthday;
        TextView gender;

    }
        /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */

    public PersonAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        Mresource = resource;
    }



        //get person information
    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String gender = getItem(position).getGender();

        Person person = new Person(name,birthday,gender);

        //create view result for showing animation
        final View result;

        //view holder object
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(Mresource , parent , false);

            holder= new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textview1);
            holder.birthday = (TextView) convertView.findViewById(R.id.textView2);
            holder.gender = (TextView) convertView.findViewById(R.id.textview3);

            result = convertView;

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext ,
                (position > lastPosition) ? R.anim.loading__down_anim : R.anim.loading_up_anim      );
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(person.getName());
        holder.birthday.setText(person.getBirthday());
        holder.gender.setText(person.getGender());


        return convertView;

    }
}
