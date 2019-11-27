/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * A simple Swing-based client for the capitalization server.
 * It has a main frame window with a text field for entering
 * strings and a textarea to see the results of capitalizing
 * them.
 */
public class CapsClient extends Application {

    private BufferedReader in;
    private PrintWriter out;
    private TextField dataField = new TextField();
    private TextArea messageArea = new TextArea();

    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Enter in the
     * listener sends the textfield contents to the server.
     * @param frame
     */
    @Override
    public void start(Stage frame) throws Exception {

        // Layout GUI
        Pane window = new VBox();
        messageArea.setEditable(false);
        window.getChildren().add(dataField);
        window.getChildren().add(new ScrollPane(messageArea));
        Scene scene = new Scene(window);
        frame.setScene(scene);
        frame.setTitle("Capitalize Client");
        frame.show();

        // Add Listeners
        dataField.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Responds to pressing the enter key in the textfield
             * by sending the contents of the text field to the
             * server and displaying the response from the server
             * in the text area.  If the response is "." we exit
             * the whole application, which closes all sockets,
             * streams and windows.
             */               
            @Override
            public void handle(ActionEvent e) {
                out.println(dataField.getText());
                   String response;
                try {
                    response = in.readLine();
                    if (response == null || response.equals("")) {
                          System.exit(0);
                      }
                } catch (IOException ex) {
                       response = "Error: " + ex;
                }
                messageArea.insertText(0, response + "\n");
                dataField.selectAll();
            }
        });
        this.connectToServer();
    }

    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter IP Address of the Server:");
       
        String serverAddress = JOptionPane.showInputDialog(null,
                "Enter IP Address of the Server:",
                "Welcome to the Capitalization Program",
                JOptionPane.QUESTION_MESSAGE);

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server
        for (int i = 0; i < 3; i++) {
            messageArea.insertText(0, in.readLine() + "\n");
        }
    }

    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}