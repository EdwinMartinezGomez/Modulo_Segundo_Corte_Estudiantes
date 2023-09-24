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

import java.io.File;


public class ModifyPersonItems  extends  Header {
    BorderPane borderPane;
    LoginView lgView;

    private  LoginListUsers lglusr;
    public  Scene modifyPersonsItems(Person p){
        Label name = new Label("Name: ");
        TextField nameField = new TextField(p.getName());
        nameField.setId("namePerson");
        Label Apellido = new Label("Last Name: ");
        TextField lastNameField = new TextField(p.getLastname());
        lastNameField.setId("apellidoPerson");
        Label phone = new Label("Phone");
        TextField phoneField = new TextField(p.getPhone());
        phoneField.setId("phonePerson");
        Label personalEmail = new Label("Personal Email");
        TextField personalEmailTextField = new TextField(p.getEmail());
        personalEmailTextField.setId("emalilPeronalPersona");
        HBox head = this.getHeader();
        this.setOption("Modify Information");
        this.setName(lgView.controller.getName());
        HBox nameBox = new HBox(name,nameField);
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setMaxWidth(700);
        HBox lastNameBox = new HBox(Apellido,lastNameField);
        lastNameBox.setAlignment(Pos.CENTER);
        lastNameBox.setMaxWidth(1300);
        HBox phoneBox = new HBox(phone , phoneField);
        phoneBox.setAlignment(Pos.CENTER);
        phoneBox.setMaxWidth(600);
        HBox personalEmailBox = new HBox(personalEmail , personalEmailTextField);
        personalEmailBox.setAlignment(Pos.CENTER);
        personalEmailBox.setMaxWidth(2000);


        VBox root = new VBox(nameBox,lastNameBox,phoneBox, personalEmailBox);
        VBox header = new VBox(head , root);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(header, 1000, 600);
        scene.getStylesheets().add(new File("./styles/modifyPerson.css").toURI().toString());


        return scene;

    }

    public  ModifyPersonItems(LoginView lgView,  Button bt){
        super(bt);
        this.lgView = lgView;
        borderPane = new BorderPane();


    }




}
