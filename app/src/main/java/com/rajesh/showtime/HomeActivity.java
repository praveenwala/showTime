package com.rajesh.showtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rajesh.showtime.adapter.EventsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<String> eventList = new ArrayList<String>();

    private RecyclerView recyclerView;
    private EventsAdapter eventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupEventList();
        recyclerView = findViewById(R.id.events_recyler_view);
        eventsAdapter = new EventsAdapter(eventList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventsAdapter);

    }


    private void setupEventList() {
        eventList.add("Event One");
        eventList.add("Event Two");
        eventList.add("Event Three");
        eventList.add("Event Four");
    }


}
