package com.example.thsk.testproject;

import android.view.View;

/**
 * Created by thsk on 19/02/2018.
 */

public interface PlayerItemClickListener {

    public void onItemClick(View v, int position);
    public void onCheckedChange(int position, boolean checked);
}
