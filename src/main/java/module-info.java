module com.example.ladder_snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ladder_snake to javafx.fxml;
    exports com.example.ladder_snake;
}