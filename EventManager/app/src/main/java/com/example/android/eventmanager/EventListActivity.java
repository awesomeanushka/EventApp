package com.example.android.eventmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.List;
import android.os.Bundle;

import android.widget.ImageView;

import android.widget.Toast;



import com.smarteist.autoimageslider.IndicatorAnimations;

import com.smarteist.autoimageslider.SliderAnimations;

import com.smarteist.autoimageslider.SliderLayout;

import com.smarteist.autoimageslider.DefaultSliderView;

import com.smarteist.autoimageslider.SliderView;
public class EventListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        //adds slider header
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(4); //set scroll delay in seconds :
        setSliderViews();


        mRecyclerView =(RecyclerView) findViewById(R.id.recyclerview_events);
        (new FirebaseDatabaseHelper(FirebaseDatabase.getInstance())).readEvent(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Eventdata> events, List<String> keys) {
                (new RecyclerView_Config()).setConfig(mRecyclerView, EventListActivity.this, events, keys);
           }

            @Override
           public void DataIsInserted() {
           }
           @Override
            public void DataIsUpdated() {
            }
            @Override
            public void DataIsDeleted() {
            }
       });
    }



    private void setSliderViews() {
        for (int i = 0; i <= 4; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.slider2);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.sider1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.slider3);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.slider4);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.slider5);
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("Explore " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(EventListActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

}