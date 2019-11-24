/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author Tbeur
 */
public class ArrowKeys extends Application {
    private double x = 100;
    private double y = 100;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane window = new Pane();
        Text text = new Text(x, y, " ");
        window.getChildren().addAll(text);
        text.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    text.setY(text.getY() + 1);
                    Line l1 = new Line(text.getX(), text.getY(), text.getX(), text.getY() + 1);
                    window.getChildren().addAll(l1); break;
                case UP:
                    text.setY(text.getY() - 1);
                    Line l2 = new Line(text.getX(), text.getY(), text.getX(), text.getY() - 1);
                    window.getChildren().addAll(l2); break;
                case LEFT:
                    text.setX(text.getX() - 1);
                    Line l3 = new Line(text.getX(), text.getY(), text.getX() - 1, text.getY());
                    window.getChildren().addAll(l3); break;
                case RIGHT:
                    text.setX(text.getX() + 1);
                    Line l4 = new Line(text.getX(), text.getY(), text.getX() + 1, text.getY());
                    window.getChildren().addAll(l4); break;
                default:
                    Line ld = new Line(x, y, text.getX(), text.getY());
                    window.getChildren().addAll(ld); break;
            }
        });
        Scene scene = new Scene(window);
        stage.setTitle("Lab07 - Trevor Beurman");
        stage.setScene(scene);
        stage.show();
        text.requestFocus();
        }
    }
