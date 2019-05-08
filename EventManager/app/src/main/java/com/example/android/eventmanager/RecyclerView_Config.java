package com.example.android.eventmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private EventAdapter meventadapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Eventdata> eventData, List<String> keys){
        mContext =context;
        meventadapter=new EventAdapter(eventData, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(meventadapter);

    }
    class EventItemView extends RecyclerView.ViewHolder {

        private TextView cname;
        private TextView cdate;
        private TextView clocation;
        private String key;

        public EventItemView(View itemView){
            super(itemView);
            cname=(TextView) itemView.findViewById(R.id.nametextview);
            cdate=(TextView) itemView.findViewById(R.id.datetextview);
            clocation=(TextView) itemView.findViewById(R.id.locationtextview);
        }

        public void setEventdata(Eventdata ev, String key){
            cname.setText(ev.getName());
            clocation.setText(ev.getLocation());
            cdate.setText(ev.getDate());
            this.key = key;
        }

    }


    class EventAdapter extends RecyclerView.Adapter<EventItemView> {
        private List<Eventdata> mEventList;
        private List<String> mkeys;

        public EventAdapter(List<Eventdata> meventList, List<String> mkeys) {
            this.mEventList = meventList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public EventItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            final View listItem = layoutInflater.inflate(R.layout.eventist_item, parent, false);

            EventItemView viewHolder = new EventItemView(listItem);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final EventItemView eventItemView, int i) {
            eventItemView.setEventdata(mEventList.get(i), mkeys.get(i));

            eventItemView.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if((eventItemView.cname.getText().toString()).equals("cognizance"))
                    Toast.makeText(mContext,"Show your text here",Toast.LENGTH_SHORT).show();
                    else if((eventItemView.cname).equals("tryst"))
                    {
                        Toast.makeText(mContext,"Show your text here",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(mContext,"not work"+eventItemView.cname,Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }
}
