package com.example.thsk.testproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import java.util.List;

/**
 * Created by thsk on 18/02/2018.
 */

public class PlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PlayerOverviewItem> playerItemList;
    private PlayerItemClickListener listener;
    private static int TYPE_HEADER = 0;
    private static int TYPE_PLAYER = 1;


    private boolean settingState = false;


    public PlayerAdapter(List<PlayerOverviewItem> playerList, PlayerItemClickListener listener) {
        this.playerItemList = playerList;
        this.listener = listener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_header_item, parent, false);
            return new HeaderViewHolder(itemView);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);

        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (playerItemList.get(position).getItem() instanceof Header) {
            ((HeaderViewHolder) holder).title.setText(((Header) playerItemList.get(position).getItem()).getHeaderTitle());

        } else {
            Player player = (Player) playerItemList.get(position).getItem();
            PlayerViewHolder vh = ((PlayerViewHolder) holder);
            vh.name.setText(player.getName());
            vh.age.setText(player.getAge());
            vh.club.setText(player.getClub());
            settingState = true;
            vh.checked.setChecked(player.isChecked());
            settingState = false;
            vh.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });
            vh.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(settingState) return;
                    listener.onCheckedChange(position, isChecked);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return playerItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (playerItemList.get(position).getItem() instanceof Header) {
            return 0;
        }

        return 1;
    }
}
