package com.example.movies_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class SearchViewController {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label resultsLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;
    @FXML
    private void initialize(){
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);
    }
    @FXML
    private void movieSearch(ActionEvent event) throws IOException, InterruptedException {
        String movieName = searchTextField.getText().trim();
        APIResponse apiResponse = APIUtility.callAPI(movieName);

        titlesVBox.setVisible(true);
        listView.getItems().clear();
        listView.getItems().addAll(apiResponse.getMovies());
    }

}

