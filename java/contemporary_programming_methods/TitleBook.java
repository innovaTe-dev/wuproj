/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.io.PrintWriter;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
/**
 *
 * @author Tbeur
 */
public class TitleBook extends Application {
    private TableView<Car> table = new TableView<Car>();
    final static ObservableList<Car> data = FXCollections.observableArrayList();

    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Final Project");
        stage.setWidth(800);
        stage.setHeight(600);
        Car c = new Car();
        c.load(data);

        final Label label = new Label("Title Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        TableColumn vinCol = new TableColumn("VIN");
        vinCol.setMinWidth(100);
        vinCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("VIN"));
        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setVIN(t.getNewValue());
            }
        }
        );

        TableColumn fNameCol = new TableColumn("First Name");
        fNameCol.setMinWidth(100);
        fNameCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("FName"));
        fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        fNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setFName(t.getNewValue());
            }
        }
        );

        TableColumn lNameCol = new TableColumn("Last Name");
        lNameCol.setMinWidth(100);
        lNameCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("LName"));
        lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setLName(t.getNewValue());
            }
        }
        );

        TableColumn makeCol = new TableColumn("Make");
        makeCol.setMinWidth(100);
        makeCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("Make"));
        makeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        makeCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setMake(t.getNewValue());
            }
        }
        );

        TableColumn yearCol = new TableColumn("Year");
        yearCol.setMinWidth(100);
        
        yearCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("YearAsString"));
        yearCol.setCellFactory(TextFieldTableCell.forTableColumn());
        yearCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setYear(Integer.parseInt(t.getNewValue()));
            }
        }
        );
        TableColumn modelCol = new TableColumn("Model");
        modelCol.setMinWidth(100);
        modelCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("Model"));
        modelCol.setCellFactory(TextFieldTableCell.forTableColumn());
        modelCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Car, String>>() {
            @Override
            public void handle(CellEditEvent<Car, String> t) {
                ((Car) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setModel(t.getNewValue());
            }
        }
        );

        table.setItems(data);
        table.getColumns().addAll(vinCol, fNameCol, lNameCol, yearCol, makeCol, modelCol);

        final TextField addVIN = new TextField();
        addVIN.setPromptText("VIN");
        addVIN.setMaxWidth(vinCol.getPrefWidth());
        final TextField addFName = new TextField();
        addFName.setMaxWidth(fNameCol.getPrefWidth());
        addFName.setPromptText("First Name");
        final TextField addLName = new TextField();
        addLName.setMaxWidth(lNameCol.getPrefWidth());
        addLName.setPromptText("Last Name");
        final TextField addMake = new TextField();
        addMake.setPromptText("Make");
        addMake.setMaxWidth(makeCol.getPrefWidth());
        final TextField addModel = new TextField();
        addModel.setMaxWidth(fNameCol.getPrefWidth());
        addModel.setPromptText("Model");
        final TextField addYear = new TextField();
        addYear.setMaxWidth(yearCol.getPrefWidth());
        addYear.setPromptText("Year");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Car(
                        addVIN.getText(),
                        addFName.getText(),
                        addLName.getText(),
                        addMake.getText(),
                        addModel.getText(),
                        Integer.parseInt(addYear.getText())));
                
                addVIN.clear();
                addFName.clear();
                addLName.clear();
                addMake.clear();
                addModel.clear();
                addYear.clear();
            }
        });

        hb.getChildren().addAll(addVIN, addFName, addLName, addYear, addMake, addModel, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
