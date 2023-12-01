package com.example.movies_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class SearchViewController {
    @FXML
    private Button fetchAllButton;
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

    private int page, totalNumOfMovies;
    @FXML
    private void initialize(){
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);
        fetchAllButton.setVisible(false);

        listView.getSelectionModel()
                .selectedItemProperty()//disallows multiple selection
                .addListener((obs, oldValue, movieSelected) -> {
                    if(movieSelected != null){
                        selectedVBox.setVisible(true);
                        try{
                            posterImageView.setImage(new Image(movieSelected.getPoster()));
                        }
                        catch(IllegalArgumentException e){
                            posterImageView.setImage(new Image(Main.class.getResourceAsStream("Images/default_poster.png")));
                        }

                    }
                    else{
                        selectedVBox.setVisible(true);
                    }

                });
    }
    @FXML
    private void movieSearch(ActionEvent event) throws IOException, InterruptedException {
        page = 1;
        String movieName = searchTextField.getText().trim();
        APIResponse apiResponse = APIUtility.callAPI(movieName);
        totalNumOfMovies = Integer.parseInt(apiResponse.getTotalResults());
        if(apiResponse.getMovies() != null){
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getMovies());
            updateLabels();
        }
        else{
            titlesVBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText("Enter a movie title and click \"Search\"");
        }




    }

    @FXML
    void getMovieDetails(ActionEvent event) throws IOException, InterruptedException {
        Movie movieSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "info-view.fxml", movieSelected.getImdbID());
    }

    @FXML
    void fetchAll(ActionEvent event) throws IOException, InterruptedException {

    }
    private void updateLabels(){
        resultsLabel.setText("Showing " + listView.getItems().size() + " of " + totalNumOfMovies);
        if(totalNumOfMovies < listView.getItems().size()){
            fetchAllButton.setVisible(true);
        }
        else
            fetchAllButton.setVisible(false);
    }

}

