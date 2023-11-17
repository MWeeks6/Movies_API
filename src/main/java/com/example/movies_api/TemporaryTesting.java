package com.example.movies_api;

import javafx.application.Application;
import javafx.stage.Stage;

public class TemporaryTesting extends Application {

    public static void main(String[] args) {
        try{
            APIUtility.callAPI("The Dark Knight");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
