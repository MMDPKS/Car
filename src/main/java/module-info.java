module com.example.egorov {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;


    opens com.example.egorov to javafx.fxml;
    exports com.example.egorov;
}