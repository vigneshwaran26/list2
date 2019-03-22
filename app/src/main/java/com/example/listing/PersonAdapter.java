package com.example.listing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class PersonAdapter extends ArrayAdapter<Person> {

    private static final String TAG = "PersonAdapter";

    private Context mContext;
    int Mresource;
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

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(Mresource , parent , false);

        TextView tvname = (TextView) convertView.findViewById(R.id.textview1);
        TextView tvBirthday = (TextView) convertView.findViewById(R.id.textView2);
        TextView Gender = (TextView) convertView.findViewById(R.id.textview3);

        tvname.setText(name);
        tvBirthday.setText(birthday);
        Gender.setText(gender);


        return convertView;

    }
}
