package com.example.movies_api;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    /**
     * This method will call the OMDB API with a movie title passed in as an argument
     */
    public static APIResponse callAPI(String movieName, int page) throws IOException, InterruptedException {
        //if we received "Star Wars", we need to translate that to be "Star%20Wars"
        movieName = movieName.replaceAll(" ", "%20");

        String uri = "http://www.omdbapi.com/?apikey=ac34f608&s=" + movieName + "&page=" + page;//URI =

        //configure the environment to make an HTTP request (this includes an update to the
        // module-info.java file)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save a file called movies.json with the APIs response
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                                                        .ofFile(Paths.get("movies.json")));
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();

        return gson.fromJson(httpResponse.body(), APIResponse.class);
    }

    public static MovieDetails getMovieDetails(String imdbID) throws IOException, InterruptedException {
        //if we received "Star Wars", we need to translate that to be "Star%20Wars"
        imdbID = imdbID.replaceAll(" ", "%20");

        String uri = "http://www.omdbapi.com/?apikey=ac34f608&i=" + imdbID;//URI =

        //configure the environment to make an HTTP request (this includes an update to the
        // module-info.java file)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save a file called movies.json with the APIs response
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                                                        .ofFile(Paths.get("movies.json")));
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();

        return gson.fromJson(httpResponse.body(), MovieDetails.class);
    }

    public static APIResponse getMoviesFromFile(String fileName){
        Gson gson = new Gson();
        //benefit of putting this in the round brackets () = automatically close it (call the .close())
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                ){
            return gson.fromJson(jsonReader, APIResponse.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
