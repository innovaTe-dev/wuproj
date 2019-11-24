/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 *
 * @author Tbeur
 */
public class VINSearch extends Application {

    private TextField VIN = new TextField();
    final Button btSearch = new Button("Search");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane window = new GridPane();
        Car c = new Car();
        c.load(TitleBook.data);
        window.setAlignment(Pos.CENTER);
        window.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        window.setHgap(5.5);
        window.setVgap(5.5);
        window.add(new Label("VIN Number:"), 0, 0);
        window.add(VIN, 1, 0);
        window.add(btSearch, 2, 0);
        GridPane.setHalignment(btSearch, HPos.RIGHT);

        Scene scene = new Scene(window);
        stage.setTitle("VIN Search");
        stage.setScene(scene);
        stage.show();

        btSearch.setOnAction(e -> runSearch(TitleBook.data));
    }

    public void runSearch(ObservableList<Car> data) {
        try {
            VIN.requestFocus();
            for (int k = 0; k < data.size(); k++) {
                if (data.get(k).getVIN().equals(VIN.getText())) {
                    VIN.clear();
                    System.out.println("==========================");
                    System.out.println("       TITLE REPORT       ");
                    System.out.println("==========================");
                    System.out.printf("VIN: %s%n", data.get(k).getVIN());
                    System.out.printf("First Name: %s%n", data.get(k).getFName());
                    System.out.printf("Last Name: %s%n", data.get(k).getLName());
                    System.out.printf("Year: %d%n", data.get(k).getYear());
                    System.out.printf("Make: %s%n", data.get(k).getMake());
                    System.out.printf("Model: %s%n", data.get(k).getModel());
                    System.out.println("==========================");
                }
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Title Error");
            alert.setHeaderText("Error Alert");
            String s = "Your input is invalid.  Correct and resubmit.";
            alert.setContentText(s);
            alert.show();
        }
    }
}
