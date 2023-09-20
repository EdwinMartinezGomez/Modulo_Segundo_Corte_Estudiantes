package co.edu.uptc.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.controlsfx.control.action.Action;

public class FormSingIn {
    public static void mostrar() {
        Stage stage=new Stage();
        Label label = new Label("Digite el nombre");
        TextField f = new TextField();

        Label label1 = new Label("Digite su edad");
        TextField f1 = new TextField();
        //f1.setPrefWidth(50);

        f.setStyle("-fx-background-color: lightblue;");
        ObservableList<String> options = FXCollections.observableArrayList(
                "Student",
                "Teacher",
                "Doctor"
        );
        ComboBox<String>comboBox=new ComboBox<>(options);
        comboBox.setPromptText("Tipo");
        Button bt=new Button("registrar");
        VBox vBox = new VBox(label, f, label1, f1,comboBox,bt);
        vBox.setSpacing(10);
        vBox.setMaxSize(100,50);
        vBox.setAlignment(Pos.CENTER); // Cambiar a Pos.CENTER para centrar verticalmente
        StackPane root = new StackPane(vBox);
        root.setStyle("-fx-background-color: orange;");
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (comboBox.getSelectionModel().isEmpty()) {
                    mostrarError("Error", "Debes seleccionar una opción del ComboBox.");
                } else {
                    // Aquí puedes realizar la acción deseada cuando se ha seleccionado una opción.
                    System.out.println("Opción seleccionada: " + comboBox.getValue());
                    Personans p=new Personans(f.getText(),Integer.parseInt(f1.getText()));
                    System.out.println(p.toString());
                    stage.close();
                }

            }
        });
        stage.setTitle("Form Sing in");
        stage.getIcons().add(new javafx.scene.image.Image("file:src\\main\\java\\co\\edu\\uptc\\view\\Logo_uptc_oficial.png"));
        stage.show();
    }
    private static void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}


