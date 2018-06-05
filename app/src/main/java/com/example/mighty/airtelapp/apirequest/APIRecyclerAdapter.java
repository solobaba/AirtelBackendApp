package com.example.mighty.airtelapp.apirequest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mighty.airtelapp.CreateUser;
import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.model.APImodel;

import java.util.ArrayList;

public class APIRecyclerAdapter extends RecyclerView.Adapter<APIRecyclerAdapter.Holder> {

    private ArrayList<APImodel> apiDataList = new ArrayList<>();
    Context context;

    public  APIRecyclerAdapter(ArrayList<APImodel> apiDataList, Context context){
        this.apiDataList = apiDataList;
        this.context = context;
    }

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_request_list, parent, false);
        Holder holder = new Holder(view, context, apiDataList);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        APImodel apImodel = apiDataList.get(position);

        holder.orderId.setText(apImodel.getOrderId());
        holder.phoneNo.setText(apImodel.getPhoneNo());
        holder.quantity.setText(apImodel.getQuantity());
        holder.network.setText(apImodel.getNetwork());
        holder.status.setText(apImodel.getStatus());
        holder.statusCode.setText(apImodel.getStatusCode());

    }

    @Override
    public int getItemCount() {
        return apiDataList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //API list TextView
        TextView orderId;
        TextView phoneNo;
        TextView quantity;
        TextView network;
        TextView status;
        TextView statusCode;

        ArrayList<APImodel> apiDataList = new ArrayList<>();
        Context context;

        public Holder(View itemView, Context context, ArrayList<APImodel> apiDataList) {
            super(itemView);
            this.apiDataList = apiDataList;
            this.context = context;
            itemView.setOnClickListener(this);

            orderId = (TextView) itemView.findViewById(R.id.orderId);
            phoneNo = (TextView) itemView.findViewById(R.id.phoneNo);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            network = (TextView) itemView.findViewById(R.id.network);
            status = (TextView) itemView.findViewById(R.id.status);
            statusCode = (TextView) itemView.findViewById(R.id.statusCode);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            APImodel apImodel = this.apiDataList.get(position);

            Intent intent = new Intent(this.context, CreateUser.class);
            intent.putExtra("mOrderId", apImodel.getOrderId());
            intent.putExtra("mPhoneNo", apImodel.getPhoneNo());
            intent.putExtra("mQuantity", apImodel.getQuantity());
            intent.putExtra("mNetwork", apImodel.getNetwork());
            intent.putExtra("mStatus", apImodel.getStatus());
            intent.putExtra("mStatusCode", apImodel.getStatusCode());

            this.context.startActivity(intent);
        }
    }
}
