/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 *
 * @author Tbeur
 */
public class SmileyFace extends Application{
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage){
       Pane window = new Pane();
       Circle c1 = new Circle();
       c1.setCenterX(54);
       c1.setCenterY(50);
       c1.setRadius(50);
       c1.setStroke(Color.BLACK);
       c1.setFill(Color.YELLOW);
       Circle c2 = new Circle();
       c2.setCenterX(30);
       c2.setCenterY(25);
       c2.setRadius(10);
       c2.setStroke(Color.WHITE);
       c2.setFill(Color.WHITE);
       Circle c3 = new Circle();
       c3.setCenterX(35);
       c3.setCenterY(25);
       c3.setRadius(5);
       c3.setStroke(Color.BLUE);
       c3.setFill(Color.BLUE);
       Circle c4 = new Circle();
       c4.setCenterX(70);
       c4.setCenterY(25);
       c4.setRadius(10);
       c4.setStroke(Color.WHITE);
       c4.setFill(Color.WHITE);
       Circle c5 = new Circle();
       c5.setCenterX(75);
       c5.setCenterY(25);
       c5.setRadius(5);
       c5.setStroke(Color.BLUE);
       c5.setFill(Color.BLUE);
       Arc arc1 = new Arc(50, 60, 25, 25, -150, 100);
       arc1.setFill(Color.YELLOW);
       arc1.setStroke(Color.BLACK);
       window.getChildren().add(c1);
       window.getChildren().add(c2);
       window.getChildren().add(c3);
       window.getChildren().add(c4);
       window.getChildren().add(c5);
       window.getChildren().add(arc1);
       Scene scene = new Scene(window);
       stage.setTitle("Trevor Beurman - Lab06 - SmileyFace");
       stage.setScene(scene);
       stage.show();
    }
    
}
