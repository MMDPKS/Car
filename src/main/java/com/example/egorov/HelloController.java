package com.example.egorov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private TextField benzin;

    @FXML
    private TextField car;

    @FXML
    private Button rashet;

    @FXML
    private TextField rastoanie;

    @FXML
    void initialize() throws IOException {



        rashet.setOnAction(event -> {
            Double ra = Double.valueOf(rastoanie.getText());
            Dannie dannie = new Dannie();
            ArrayList<String> Avt = null;
            try {
                Avt = dannie.AvtoIBenz();
                for (int i=0;i<Avt.size();i++) {
                    if (car.getText().equals(Avt.get(i))) {
                        int a = Avt.indexOf(car.getText());
                        benzin.setText(String.valueOf(dannie.Rushet(ra, Double.valueOf(Avt.get(a + 1)))));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
