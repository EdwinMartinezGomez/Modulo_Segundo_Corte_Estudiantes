package co.edu.uptc.view;

import java.time.LocalDate;
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
        TableView<Personans> tableView = new TableView<>();
        TableColumn<Personans, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Personans, String> colApellido = new TableColumn<>("Apellido");

        tableView.getColumns().addAll(colNombre, colApellido);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        Personans p1 = new Personans("Juan", "Perez");
        Personans p2 = new Personans("Maria", "Loza");
        Personans p3 = new Personans("Adriana", "Mendez");

        tableView.getItems().addAll(p1, p2, p3);

        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("TableView - Tutor de Programación");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
