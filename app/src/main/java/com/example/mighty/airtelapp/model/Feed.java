package com.example.mighty.airtelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Feed {

    @SerializedName("data")
    @Expose
    private ArrayList<APImodel> data;

    public ArrayList<APImodel> getData(){
        return data;
    }

    public void setData(ArrayList<APImodel> data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "data = " + data + '}';
    }
}
