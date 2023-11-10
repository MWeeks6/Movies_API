module com.example.movies_api {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movies_api to javafx.fxml;
    exports com.example.movies_api;
}