module com.example.movies_api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires  com.google.gson;


    opens com.example.movies_api to javafx.fxml, com.google.gson;
    exports com.example.movies_api;
}