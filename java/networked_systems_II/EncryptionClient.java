package PL4Handouts;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import javax.swing.JOptionPane;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EncryptionClient extends Application {

    private BufferedReader in;
    private PrintWriter out;
    private BorderPane pane = new BorderPane();
    private TextField dataField = new TextField();
    private TextArea messageArea = new TextArea();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        /**
         * Constructs the client by laying out the GUI and registering a
         * listener with the textfield so that pressing Enter in the listener
         * sends the textfield contents to the server.
         */
        // Layout GUI
        messageArea.setEditable(false);
        pane.setTop(dataField);
        pane.setCenter(new ScrollPane(messageArea));
        dataField.setOnAction(e -> processInput());

        // Create a scene and place it in the stage
        
        this.connectToServer();
        Scene scene = new Scene(pane);
        pane.setStyle("-fx-border-color: red");
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        primaryStage.setTitle("Capitalizer Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage   
    }

    private void processInput() {

        /**
         * Responds to pressing the enter key in the textfield by sending the
         * contents of the text field to the server and displaying 
         * the response from the server in the text area.
         * If the response is "." we exit the
         * whole application, which closes all sockets, streams and windows.
         */
        out.println(CeaserCipher.encrypt(dataField.getText(),3));
        String response;
        try {
            response = in.readLine();
            if (response == null || response.equals("")) {
                System.exit(0);
            }
        } catch (IOException ex) {
            response = "Error: " + ex;
        }
        messageArea.appendText(response + "\n");
        dataField.selectAll();

    }

    /**
     * Implements the connection logic by prompting the end user for the
     * server's IP address, connecting, setting up streams, and consuming  
     * the welcome messages from the server. The Capitalizer protocol says 
     * that the server sends three lines of text to the client immediately 
     * after establishing a connection.
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
        String serverAddress = JOptionPane.showInputDialog(
                null,
                "Enter IP Address of the Server:",
                "Welcome to the Encryption Program",
                JOptionPane.QUESTION_MESSAGE);

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        messageArea.appendText("You are now connected to the server. \n");
        // Consume the initial welcoming messages from the server
        for (int i = 0; i < 3; i++) {
            messageArea.appendText(in.readLine() + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
