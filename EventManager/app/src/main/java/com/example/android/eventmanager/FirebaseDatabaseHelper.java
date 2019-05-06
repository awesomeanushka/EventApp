package com.example.android.eventmanager;

import android.app.usage.UsageEvents;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceEvents;
    private List<Eventdata> events=new ArrayList<>();
    public interface DataStatus{
        void DataIsLoaded(List<Eventdata> events,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper(FirebaseDatabase mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase=FirebaseDatabase.getInstance();
        mReferenceEvents=mDatabase.getReference("Event");
    }
    public void readEvent(final DataStatus dataStatus)
    {
        mReferenceEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    Eventdata event = keyNode.getValue(Eventdata.class);
                    events.add(event);
                }
                dataStatus.DataIsLoaded(events,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
