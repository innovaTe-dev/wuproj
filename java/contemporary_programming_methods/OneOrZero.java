/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Tbeur
 */
public class OneOrZero extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }
    private static int HEIGHT = 300;
    private static int WIDTH = 300;
    @Override
    public void start(Stage stage) {




        GridPane pane = new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField text = new TextField(Integer.toString((int)(Math.random() * 2)));
                text.setMinWidth(WIDTH / 10.0);
                text.setMaxWidth(WIDTH / 10.0);
                text.setMinHeight(HEIGHT / 10.0);
                text.setMaxHeight(HEIGHT / 10.0);
                pane.add(text, j, i);
            }
        }
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.setTitle("Trevor Beurman - Lab06 - OneOrZero");
        stage.show();
    }

    
}
