package co.edu.uptc.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.controller.AccountControl;
import co.edu.uptc.model.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class pruebas  extends Application{
    public  void start(Stage primaryStage)    {
        TableView<Student> tableView = new TableView<>();
        TableColumn<Student, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Student, String> colApellido = new TableColumn<>("Apellido");

        tableView.getColumns().addAll(colNombre, colApellido);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        Personans p1 = new Personans("Juan", "Perez");
        Personans p2 = new Personans("Maria", "Loza");
        Personans p3 = new Personans("Adriana", "Mendez");
        AccountControl ac=new AccountControl();
        List<Student> n=ac.showStudentsAccpo();
        /*n.add(p1);
        n.add(p2);
        n.add(p3);*/
        tableView.getItems().addAll(n);

        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("TableView - Tutor de Programación");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
