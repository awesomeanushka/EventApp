package com.example.android.eventmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private eventadapter meventadapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Eventdata> even,List<String> keys){
        mContext =context;
        meventadapter=new eventadapter(even,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(meventadapter);

    }
    class EventItemView extends RecyclerView.ViewHolder {

        private TextView cname;
        private TextView cdate;
        private TextView clocation;
        private String key;;
        public EventItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.eventist_item,parent));
            cname=(TextView) itemView.findViewById(R.id.nametextview);
            cdate=(TextView) itemView.findViewById(R.id.datetextview);
            clocation=(TextView) itemView.findViewById(R.id.locationtextview);


        }
        public void Eventdata(Eventdata ev,String key)
        {
            cname.setText(ev.getName());
            clocation.setText(ev.getLocation());
            cdate.setText(ev.getDate());
            this.key=key;
        }

    }
    class eventadapter extends RecyclerView.Adapter<EventItemView>
    {
        private List<Eventdata> meventList;
        private List<String> mkeys;

        public eventadapter(List<Eventdata> meventList, List<String> mkeys) {
            this.meventList = meventList;
            this.mkeys = mkeys;
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemView holder, int position, @NonNull List<Object> payloads) {

        }

        @NonNull
        @Override
        public EventItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new EventItemView(viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemView eventItemView, int i) {
            eventItemView.Eventdata(meventList.get(i),mkeys.get(i));
        }

        @Override
        public int getItemCount() {
            return meventList.size();
        }
    }
}
