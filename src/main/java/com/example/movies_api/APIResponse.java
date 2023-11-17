package com.example.movies_api;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class APIResponse {
    @SerializedName("Search")
    private ArrayList<Movie> movies;
    @SerializedName("Response")
    private String response;
    private String totalResults;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public String getResponse() {
        return response;
    }

    public String getTotalResults() {
        return totalResults;
    }
}
