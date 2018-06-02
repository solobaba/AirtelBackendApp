package com.example.mighty.airtelapp.apirequest;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mighty.airtelapp.CreateUser;
import com.example.mighty.airtelapp.R;
import com.example.mighty.airtelapp.data.RequestCursorAdapter;
import com.example.mighty.airtelapp.model.APImodel;
import com.example.mighty.airtelapp.model.Feed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIRequest extends AppCompatActivity{

    private static final String TAG = APIRequest.class.getSimpleName();

    Toolbar mtoolbar;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private APIRecyclerAdapter adapter;

    private APIInterface apiInterface;
    private ArrayList<APImodel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_request);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitle("Request History");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mtoolbar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int columnNumbers = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columnNumbers));

        apiInterface = APIClient.getAPIClient().create(APIInterface.class);

        Call<Feed> call = apiInterface.getData();
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.i("api", "onResponse: Server Response: " + response.toString());
                Log.i("api", "onResponse: Received information: " + response.body().toString());

                dataList = response.body().getData();
                adapter = new APIRecyclerAdapter(dataList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.i("apiInfo", "onFailure :Error: " + t.getMessage());
                Toast.makeText(APIRequest.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void backToMain() {
        startActivity(new Intent(this, CreateUser.class));
    }
}
