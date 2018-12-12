package com.rajesh.showtime.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rajesh.showtime.R;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsHolder> {

    List<String> list;
    String image_url = "https://www.showtimeon.com/wp-content/uploads/2018/12/New-Year-Event-2019.jpg";

    public EventsAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.event_row, viewGroup, false);
        return new EventsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder eventsHolder, int i) {

        Glide.with(eventsHolder.itemView.getContext()).load(image_url).into(eventsHolder.event_image).getView();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventsHolder extends RecyclerView.ViewHolder {
        ImageView event_image;

        public EventsHolder(@NonNull View itemView) {
            super(itemView);
            event_image = itemView.findViewById(R.id.event_image);
        }
    }
}
