/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import java.util.ArrayList;

/**
 *
 * @author Tbeur
 */
public class ThreeCards extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane window = new HBox();
        window.setPadding(new Insets(5, 5, 5, 5));
        ArrayList<Integer> ctr = new ArrayList<>();
        for (int k = 0; k < 52; k++) {
            ctr.add(k);
        }

        java.util.Collections.shuffle(ctr);
        Image image = new Image("resources/image/card/" + ctr.get(0) + ".png");
        Image image1 = new Image("resources/image/card/" + ctr.get(1) + ".png");
        Image image2 = new Image("resources/image/card/" + ctr.get(2) + ".png");
        ImageView viewCard1 = new ImageView(image);
        ImageView viewCard2 = new ImageView(image1);
        ImageView viewCard3 = new ImageView(image2);
        window.getChildren().add(viewCard1);
        window.getChildren().add(viewCard2);
        window.getChildren().add(viewCard3);
        Scene scene = new Scene(window);
        stage.setTitle("Trevor Beurman - Lab06 - ThreeCards");
        stage.setScene(scene);
        stage.show();
    }
}
