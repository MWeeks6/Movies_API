package com.example.movies_api;

import java.io.IOException;

public interface MovieLoader {
    public void loadMovie(String imdbID) throws IOException, InterruptedException;
}
