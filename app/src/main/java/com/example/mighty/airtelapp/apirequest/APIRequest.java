package com.example.mighty.airtelapp.apirequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mighty.airtelapp.CreateUser;
import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.model.APImodel;
import com.example.mighty.airtelapp.model.Feed;

import java.util.ArrayList;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIRequest extends AppCompatActivity{

    private static final String TAG = APIRequest.class.getSimpleName();

    //ProgressBar
    ProgressDialog progressDialog;
    ProgressBar progressBar;
//    RingProgressBar ringProgressBar1, ringProgressBar2;
//    int progress = 0;
//
//    Handler myHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 0){
//                if (progress<100){
//                    progress++;
//                    ringProgressBar1.setProgress(progress);
//                    ringProgressBar2.setProgress(progress);
//                }
//            }
//        }
//    };

    Toolbar mtoolbar;
    Handler mHandler;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private APIRecyclerAdapter adapter;

    private APIInterface apiInterface;
    private ArrayList<APImodel> dataList = new ArrayList<>();
    private APImodel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_request);

        getSupportActionBar().setTitle("API_Request");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mtoolbar);
//        mtoolbar.setTitle("Request History");
//        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//        mtoolbar.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                backToMain();
//            }
//        });


        progressDialog = new ProgressDialog(APIRequest.this);
        progressDialog.setTitle("Hello");
        progressDialog.setMessage("Loading, please wait....");
        progressDialog.show();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int columnNumbers = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columnNumbers));

        //Method for fetching data from API
        clickApiItem();

        //Timer for getting data from API
//        mHandler = new Handler();
//        mHandler.postDelayed(runnable, 1200000);

    }

//    private Runnable runnable = new Runnable () {
//        @Override
//        public void run() {
//            //Check data balance
//            clickApiItem();
//            //Track data balance
//            mHandler.postDelayed(this, 1200000);
//        }
//    };

//    private void backToMain() {
//        startActivity(new Intent(this, CreateUser.class));
//    }

    public void clickApiItem(){

//        ringProgressBar1 = (RingProgressBar) findViewById(R.id.progress_bar_1);
//        ringProgressBar2 = (RingProgressBar) findViewById(R.id.progress_bar_2);
//
//        ringProgressBar2.setOnProgressListener(new RingProgressBar.OnProgressListener() {
//            @Override
//            public void progressToComplete() {
//                Toast.makeText(APIRequest.this, "Completed!!!", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++){
//                    try {
//                        Thread.sleep(10);
//                        myHandler.sendEmptyMessage(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        apiInterface = APIClient.getAPIClient().create(APIInterface.class);

        Call<Feed> call = apiInterface.getData();
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                progressDialog.dismiss();
                Log.i("api", "onResponse: Server Response: " + response.toString());
                Log.i("api", "onResponse: Received information: " + response.body().toString());

                dataList = response.body().getData();
                adapter = new APIRecyclerAdapter(dataList, APIRequest.this);
                recyclerView.setAdapter(adapter);

                for (int i = 0; i<dataList.size(); i++){
                    Log.i("api", "onResponse: \n" +
                    "orderId: " + dataList.get(i).getOrderId() + "\n" +
                    "phoneNo: " + dataList.get(i).getPhoneNo() + "\n" +
                    "quantity: " + dataList.get(i).getQuantity() + "\n" +
                    "network: " + dataList.get(i).getNetwork() + "\n" +
                    "status: " + dataList.get(i).getStatus() + "\n" +
                    "statusCode : " + dataList.get(i).getStatusCode());
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.i("apiInfo", "onFailure :Error: " + t.getMessage());
                Toast.makeText(APIRequest.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
