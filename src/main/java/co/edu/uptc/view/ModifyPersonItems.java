package co.edu.uptc.view;


import co.edu.uptc.model.Person;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ModifyPersonItems  extends  Header {

    private  LoginListUsers lglusr;
    public  Scene modifyPersonsItems(Person p){
        Label name=new Label("Nombre: ");
        TextField nameField=new TextField(p.getName());
        Label Apellido =new Label("Apellido: ");
        TextField lastNameField=new TextField(p.getLastname());
        HBox nameBox=new HBox(name,nameField);
        HBox lastNameBox=new HBox(Apellido,lastNameField);
        VBox root = new VBox(nameBox,lastNameBox);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1000, 600);
        return scene;
    }

    public  ModifyPersonItems(LoginListUsers lglusr,  Button bt){
        super(bt);
        this.lglusr = lglusr;
        BorderPane border = new BorderPane();


    }




}
