package com.example.thsk.testproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by thsk on 18/02/2018.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public TextView title;


    public HeaderViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.player_header_tv);
    }
}
