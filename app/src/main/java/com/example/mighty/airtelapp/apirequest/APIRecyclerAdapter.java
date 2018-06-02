package com.example.mighty.airtelapp.apirequest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.model.APImodel;

import java.util.ArrayList;

public class APIRecyclerAdapter extends RecyclerView.Adapter<APIRecyclerAdapter.Holder> {

    private ArrayList<APImodel> apiDataList = new ArrayList<>();
    public  APIRecyclerAdapter(ArrayList<APImodel> apiDataList){
        this.apiDataList = apiDataList;
    }

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_request_list, parent, false);
        Holder holder = new Holder(view);
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

    public class Holder extends RecyclerView.ViewHolder{

        //API list TextView
        TextView orderId;
        TextView phoneNo;
        TextView quantity;
        TextView network;
        TextView status;
        TextView statusCode;


        public Holder(View itemView) {
            super(itemView);

            orderId = (TextView) itemView.findViewById(R.id.orderId);
            phoneNo = (TextView) itemView.findViewById(R.id.phoneNo);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            network = (TextView) itemView.findViewById(R.id.network);
            status = (TextView) itemView.findViewById(R.id.status);
            statusCode = (TextView) itemView.findViewById(R.id.statusCode);
        }
    }
}
