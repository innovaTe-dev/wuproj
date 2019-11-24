/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Tbeur
 */
public class EquityCalculatorWindow extends Application {

    private TextField presentValue = new TextField();
    private TextField Rate = new TextField();
    private TextField Years = new TextField();
    private Button btCalculate = new Button("Calculate");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(new Label("Present Value:"), 0, 0);
        pane.add(presentValue, 1, 0);
        pane.add(new Label("Rate:"), 0, 1);
        pane.add(Rate, 1, 1);
        pane.add(new Label("Years:"), 0, 2);
        pane.add(Years, 1, 2);
        pane.add(btCalculate, 1, 3);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        btCalculate.setOnAction(e -> runEquityEquation());

        Scene scene = new Scene(pane);
        stage.setTitle("Lab07 - Trevor Beurman");
        stage.setScene(scene);
        stage.show();
    }

    private void runEquityEquation() {

        try {
            presentValue.requestFocus();
            double pv = Double.parseDouble(presentValue.getText());
            Equity.setPV(pv);
            Rate.requestFocus();
            double r = Double.parseDouble(Rate.getText());
            Equity.setR(r);
            Years.requestFocus();
            double n = Double.parseDouble(Years.getText());
            Equity.setN(n);

            double fv = Equity.CalculateFV();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Equity Results");
            info.setHeaderText("Future Value Calculated");
            fv = Math.round(fv*100.00)/100.00;
            String i = ("The future value of the current portfolio is: " + fv);
            info.setContentText(i);
            info.show();
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Equity Error");
            alert.setHeaderText("Error Alert");
            String s = "Your input is invalid.  Correct and resubmit.";
            alert.setContentText(s);
            alert.show();
        }
    }
}
