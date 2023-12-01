package com.example.movies_api;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class MovieRatings {
    @SerializedName("Source")
    private String source;
    @SerializedName("Value")
    private String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public String toString(){
        return String.format("%s-%s", source, value);
    }
}
