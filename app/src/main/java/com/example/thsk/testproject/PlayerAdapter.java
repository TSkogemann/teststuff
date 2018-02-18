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
        final PlayerViewHolder viewholder = new PlayerViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, viewholder.getPosition());
            }
        });
        viewholder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.onCheckedChange(viewholder.getPosition(), isChecked);
            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (playerItemList.get(position).getItem() instanceof Header) {
            ((HeaderViewHolder) holder).title.setText(((Header) playerItemList.get(position).getItem()).getHeaderTitle());

        } else {
            Player player = (Player) playerItemList.get(position).getItem();
            ((PlayerViewHolder) holder).name.setText(player.getName());
            ((PlayerViewHolder) holder).age.setText(player.getAge());
            ((PlayerViewHolder) holder).club.setText(player.getClub());
            ((PlayerViewHolder) holder).checked.setChecked(player.isChecked());
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
