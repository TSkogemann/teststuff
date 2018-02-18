package com.example.thsk.testproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thsk on 18/02/2018.
 */

public class PlayerOverviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlayerAdapter playerAdapter;
    private List<PlayerOverviewItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_overview_activity);

        recyclerView = findViewById(R.id.player_list_rv);

        playerAdapter = new PlayerAdapter(itemList, new PlayerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //do something when clicked on the name
                String temp = itemList.get(position).getItem().toString();
                System.out.println(temp);
            }

            @Override
            public void onCheckedChange(int position, boolean checked) {
                ((Player)itemList.get(position).getItem()).setChecked(checked);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(playerAdapter);

        createPlayerList(125);
    }

    private void createPlayerList(int numberOfPlayers) {
        int headerCounter = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i == headerCounter * 10) {
                itemList.add(new PlayerOverviewItem(new Header("" + headerCounter)));
                headerCounter++;
            }
            Player player = new Player("name" + i, "club" + i, "" + i);
            itemList.add(new PlayerOverviewItem(player));
        }
        playerAdapter.notifyDataSetChanged();
    }
}
