  package com.example.biodun.lagosjavacoders;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Biodun on 3/8/2017.
 */
public class UserClassAdapter extends ArrayAdapter<UserClass> {

    ArrayList<UserClass> userClass;
    Context context;
    int resource;

    public UserClassAdapter(Context context, int resource, ArrayList<UserClass> userClass) {
        super(context, resource, userClass);
        this.userClass=userClass;
        this.context=context;
        this.resource=resource;
    }

    // Call xml file inside Adapter for each listView row(Use of layoutInflater inside Adapter)
    @Override
    public View getView(int position,View convertView,ViewGroup parent){

        if (convertView==null){

            LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.custom_list,null,true);
        }
        UserClass users=getItem(position);

        ImageView imageView=(ImageView) convertView.findViewById(R.id.avatarId);
        Picasso.with(context).load(users.getAvatarUrl()).placeholder(R.drawable.images).resize(80,80).into(imageView);

        TextView textView=(TextView) convertView.findViewById(R.id.user_textView);
        textView.setText(users.getUserName());
        return convertView;
    }
}

