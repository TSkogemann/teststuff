package com.example.thsk.testproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by thsk on 18/02/2018.
 */

public class PlayerViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView age;
    public TextView club;
    public CheckBox checked;



    public PlayerViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        age = itemView.findViewById(R.id.age);
        club = itemView.findViewById(R.id.club);
        checked = itemView.findViewById(R.id.checkbox);
    }


}
