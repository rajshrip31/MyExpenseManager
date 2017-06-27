package com.example.rajshri.myexpensemanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rajshri on 6/2/2017.
 */

public class BillsAndEmisAdapter extends RecyclerView.Adapter<BillsAndEmisAdapter.MyBillViewHolder> {

    private List<ModelBillAndEmis> billAndEmisList;
    private Context context;

    public BillsAndEmisAdapter(Context context, List<ModelBillAndEmis> billAndEmisList) {
        this.context = context;
        this.billAndEmisList = billAndEmisList;
    }

    @Override
    public BillsAndEmisAdapter.MyBillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bills_and_emis, parent, false);
        return new BillsAndEmisAdapter.MyBillViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyBillViewHolder holder, int position) {
        ModelBillAndEmis modelBillAndEmis = billAndEmisList.get(position);
        holder.txtTitle.setText(modelBillAndEmis.getTitle());
        holder.txtAmount.setText(modelBillAndEmis.getAmount());
        holder.txtSubTitle.setText(modelBillAndEmis.getSubTitle());
        holder.txtDate.setText(modelBillAndEmis.getDate());

        if(billAndEmisList.size() == 3){
            switch (position){
                case 0:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_icici);
                    break;

                case 1:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_sbi);
                    break;

                case 2:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_hdfc);
                    break;

                default:
                    break;
            }
        }
        else if(billAndEmisList.size() == 4){
            switch (position){
                case 0:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_reliance);
                    break;

                case 1:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_icici);
                    break;

                case 2:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_sbi);
                    break;

                case 3:
                    holder.imgBillIcon.setImageResource(R.drawable.ic_hdfc);
                    break;

                default:
                    break;
            }
        }
    }


    @Override
    public int getItemCount() {
        return billAndEmisList.size();
    }

    public class MyBillViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle,txtAmount,txtSubTitle,txtDate;
        ImageView imgBillIcon;

        public MyBillViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txt_title_bill);
            txtSubTitle = (TextView) view.findViewById(R.id.txt_sub_title_bill);
            txtAmount = (TextView) view.findViewById(R.id.txt_amount_bill);
            txtDate = (TextView) view.findViewById(R.id.txt_date_bill);
            imgBillIcon = (ImageView)view.findViewById(R.id.bill_icon);
        }
    }
}
