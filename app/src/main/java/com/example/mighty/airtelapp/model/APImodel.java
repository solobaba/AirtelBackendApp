package com.example.mighty.airtelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APImodel {

    @SerializedName("orderId")
    @Expose
    private String orderId;

    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;

    @SerializedName("quantity")
    @Expose
    private String quantity;

    @SerializedName("network")
    @Expose
    private String network;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "APImodel{" +
                "orderId = '" + orderId + '\'' +
                ", phoneNo = '" + phoneNo + '\'' +
                ", quantity = '" + quantity + '\'' +
                ", network = '" + network + '\'' +
                ", status = '" + status + '\'' +
                ", statusCose = " + statusCode +
                '}';
    }
}
