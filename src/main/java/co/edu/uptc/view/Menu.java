package co.edu.uptc.view;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Menu extends Application{

    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Button btn1=new Button("Say, Hello World");


        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                abrirnuevaventana();
                // TODO Auto-generated method stub
                System.out.println("hello world");
            }
        });
        StackPane root=new StackPane();
        root.getChildren().add(btn1);
        Scene scene=new Scene(root,600,400);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:src\\main\\java\\co\\edu\\uptc\\view\\Logo_uptc_oficial.png"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void abrirnuevaventana(){
        FormSingIn.mostrar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
