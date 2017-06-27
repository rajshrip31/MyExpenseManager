package com.example.rajshri.myexpensemanager;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rajshri on 6/2/2017.
 */

public class SpendAreasAdapter extends RecyclerView.Adapter<SpendAreasAdapter.MyViewHolder> {

    private List<ModelSpendAreas> spendAreasList;
    private Context context;

    public SpendAreasAdapter(Context context, List<ModelSpendAreas> moviesList) {
        this.context = context;
        this.spendAreasList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spend_areas, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelSpendAreas spendAreas = spendAreasList.get(position);

        holder.txtTitle.setText(spendAreas.getTitle());
        holder.txtAmount.setText(spendAreas.getAmount());
        holder.txtPercentage.setText(spendAreas.getPercentage());

        TextView valueTV = new TextView(context);
        //valueTV.setText("hallo hallo");


        switch (position){
            case 0:
                holder.icon.setImageResource(R.drawable.ic_transport);
                valueTV.setBackgroundColor(Color.parseColor("#FFA059"));
                valueTV.setLayoutParams(new ViewGroup.LayoutParams(280,15));
                break;

            case 1:
                holder.icon.setImageResource(R.drawable.ic_dining);
                valueTV.setBackgroundColor(Color.parseColor("#4FB049"));
                valueTV.setLayoutParams(new ViewGroup.LayoutParams(180,15));
                break;

            case 2:
                holder.icon.setImageResource(R.drawable.ic_transfer);
                valueTV.setBackgroundColor(Color.parseColor("#9ECEDD"));
                valueTV.setLayoutParams(new ViewGroup.LayoutParams(120,15));
                break;

            case 3:
                holder.icon.setImageResource(R.drawable.ic_shopping);
                valueTV.setBackgroundColor(Color.parseColor("#FF167F"));
                valueTV.setLayoutParams(new ViewGroup.LayoutParams(80,15));
                break;

            case 4:
                holder.icon.setImageResource(R.drawable.ic_wallet);
                valueTV.setBackgroundColor(Color.parseColor("#BDCE40"));
                valueTV.setLayoutParams(new ViewGroup.LayoutParams(50,15));
                break;

            default:
                holder.icon.setImageResource(R.drawable.ic_transport);
                break;
        }

        ((LinearLayout) holder.linearLayout).addView(valueTV);
    }

    @Override
    public int getItemCount() {
        return spendAreasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle,txtAmount,txtPercentage;
        ImageView icon;
        LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txt_title);
            txtAmount = (TextView) view.findViewById(R.id.txt_amount);
            txtPercentage = (TextView) view.findViewById(R.id.txt_percentage);
            icon = (ImageView) view.findViewById(R.id.icon);
            linearLayout = (LinearLayout)view.findViewById(R.id.layout_color);
        }
    }
}