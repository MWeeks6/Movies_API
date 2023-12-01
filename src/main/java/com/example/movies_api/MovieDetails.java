package com.example.movies_api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetails {
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Poster")
    private String posterURL;
    @SerializedName("Language")
    private String language;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Ratings")
    private ArrayList<MovieRatings> ratings;
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;

    public String getGenre() {
        return genre;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getLanguage() {
        return language;
    }

    public String getPlot() {
        return plot;
    }

    public String getRated() {
        return rated;
    }

    public ArrayList<MovieRatings> getRatings() {
        return ratings;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
