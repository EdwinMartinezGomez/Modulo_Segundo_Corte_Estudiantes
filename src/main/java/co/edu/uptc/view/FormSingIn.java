package co.edu.uptc.view;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

class FormSingIn extends Application {
     public void start(Stage stage) throws Exception{
         StackPane root=new StackPane();
         Label label=new Label("Digite el nombre");
         Scene scene=new Scene(root,300,300);
         root.getChildren().add(label);
         stage.setScene(scene);
         stage.setTitle("Form Sing in");
         stage.show();

     }
     public void in() throws Exception {
         Stage na = null;
         start(na);
     }
 }


