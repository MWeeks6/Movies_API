package com.example.movies_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class InfoViewController implements MovieLoader{

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label languageLabel;

    @FXML
    private Label plotLabel;

    @FXML
    private Label ratedLabel;

    @FXML
    private ListView<MovieRatings> ratingsListView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @FXML
    void returnToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }

    public void loadMovie(String imdbID) throws IOException, InterruptedException {
        MovieDetails movie = APIUtility.getMovieDetails(imdbID);

        genreLabel.setText(movie.getGenre());
        languageLabel.setText(movie.getLanguage());
        plotLabel.setText(movie.getPlot());
        ratedLabel.setText(movie.getRated());
        ratingsListView.getItems().addAll(movie.getRatings());
        titleLabel.setText(movie.getTitle());
        yearLabel.setText(movie.getYear());
        try{
            imageView.setImage(new Image(movie.getPosterURL()));
        }catch(IllegalArgumentException e){
            imageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
        }

    }

}
