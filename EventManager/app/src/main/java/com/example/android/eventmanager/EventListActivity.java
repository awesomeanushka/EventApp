package com.example.android.eventmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class EventListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        mRecyclerView =(RecyclerView) findViewById(R.id.recyclerview_events);
//        (new FirebaseDatabaseHelper()).readEvent(new FirebaseDatabaseHelper.DataStatus() {
//            @Override
//            public void DataIsLoaded(List<Eventdata> events, List<String> keys) {
//                new RecyclerView_Config().setConfig(mRecyclerView, EventListActivity.this, events, keys);
//            }
//
//            @Override
//            public void DataIsInserted() {
//
//            }
//
//            @Override
//            public void DataIsUpdated() {
//
//            }
//
//            @Override
//            public void DataIsDeleted() {
//
//            }
//        });
    }
}
