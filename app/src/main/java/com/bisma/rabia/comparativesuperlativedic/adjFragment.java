package com.bisma.rabia.comparativesuperlativedic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class adjFragment extends Fragment {

    Context thisContext;
    ListView list;
    customAdapter adapter;
    String[] adj, comp, sup, exp;

    public adjFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adj, container, false);

        thisContext = container.getContext();

        Resources res = getResources();
        adj = res.getStringArray(R.array.adj);
        comp = res.getStringArray(R.array.comp);
        sup = res.getStringArray(R.array.sup);
        exp = res.getStringArray(R.array.exp);
        list = (ListView) v.findViewById(R.id.listView);
        adapter = new customAdapter(thisContext, adj, comp, sup);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(thisContext, "hhhhhhh", Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }

    class customAdapter extends ArrayAdapter<String> {

        Context context;
        String[] adjArray, compArray, supArray;

        customAdapter(Context c, String[] adjectives, String[] comparatives, String[] superlatives) {
            super(c, R.layout.single_row_adj, R.id.adj_id, adjectives);
            this.context = c;
            this.adjArray = adjectives;
            this.compArray = comparatives;
            this.supArray = superlatives;

        }


        class MyViewHolder {
            TextView adj, comp, sup;

            MyViewHolder(View v) {
                adj = (TextView) v.findViewById(R.id.adj_id);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            MyViewHolder holder = null;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_row_adj, parent, false);
                holder = new MyViewHolder(row);
                row.setTag(holder);

            } else {
                holder = (MyViewHolder) row.getTag();
            }

            holder.adj.setText(adjArray[position]);
            return row;
        }
    }
}
