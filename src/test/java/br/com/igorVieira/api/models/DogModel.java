package br.com.igorVieira.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DogModel {

    @SerializedName("message")
    @Expose
    private Object message;

    @SerializedName("status")
    @Expose
    private String status;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}