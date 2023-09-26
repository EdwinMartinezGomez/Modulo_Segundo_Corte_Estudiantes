package co.edu.uptc.view;


import co.edu.uptc.model.Account;
import co.edu.uptc.model.Person;
import co.edu.uptc.model.persontypes.Graduated;
import co.edu.uptc.utilities.InputLibrary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.File;


public class ModifyPersonItems  extends  Header implements EventHandler<ActionEvent> {
    BorderPane borderPane;
    LoginView lgView;
    private InputLibrary util;
    private HBox nameField;
    private HBox lastNameField;
    private HBox roleField;
    private HBox phoneField;
    private HBox emailField;
    private HBox nomEmpresaField;
    private HBox cargoFiel;
    private HBox estadoField;
    private Label nameError;
    private Label lastNameError;
    private Label emailError;
    private Label phoneError;

    private Label nomEmpresaError;
    private Label cargoError;
    private TextField name;
    private TextField phone;
    private TextField email;
    private TextField lastName;

    private TextField nomEmpresa;
    private TextField cargo;
    private ChoiceBox<String> estadoEmp;
    private ChoiceBox<String> roles;

    private VBox messageContainer;
    private HBox Buttons;
    private Label message;

    private Button summit;
    private Button delete;
    private Person person;
    private Graduated graduated;
    private static final String[] ROLES = {"Student", "Professor", "Secretary", "Administrator","Graduated"};
    private static final String[] ESTADOS={"Si","No"};
    private Label idLabel;

    private  LoginListUsers lglusr;
    public  Scene modifyPersonsItems(Person p){
        verifyType(p);
        HBox header = this.getHeader();
        this.setName(this.lgView.controller.getName());
        this.setOption("Modificar Usuario");
        this.settingNameField(p.getName());
        this.settingLastNameField(p.getLastname());
        this.settingRoleField(p.getAccount().getRole());
        this.settingPhoneField(p.getPhone());
        this.settingEmailField(p.getEmail());
        this.settingSummitButton();
        this.settingMessage();
        VBox formContainer = new VBox(this.roleField,this.nameField, this.lastNameField,this.phoneField,this.emailField,this.estadoField,this.nomEmpresaField,this.cargoFiel, this.Buttons);
        formContainer.setId("form");
        formContainer.setSpacing(10);
        formContainer.setAlignment(Pos.CENTER);
        VBox.setMargin(formContainer, new Insets( 10));
        VBox container = new VBox(formContainer,this.messageContainer);
        container.setId("main");
        container.setAlignment(Pos.CENTER);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(container);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Desactiva la barra de desplazamiento horizontal
        scrollPane.setFitToWidth(true); // Ajusta el contenido al ancho de la ventana

        BorderPane root = new BorderPane();
        root.setId("root");
        root.setTop(header); // Coloca el encabezado en la parte superior
        root.setCenter(scrollPane); // Coloca el ScrollPane en el centro
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(new File("./styles/modifyPerson.css").toURI().toString());
        return scene;
    }
    public void verifyType(Person p){
        System.out.println(p.toString());
        graduated=(Graduated) p;
        person=p;
    }
    public  ModifyPersonItems(LoginView lgView,  Button bt){
        super(bt);
        this.lgView = lgView;
        this.util = new InputLibrary();
        borderPane = new BorderPane();
    }
    private void settingNameField(String name) {
        this.nameField = new HBox();
        this.nameField.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Nombres");
        nameLabel.getStyleClass().add("tag");

        this.name = new TextField(name);
        this.name.getStyleClass().add("input");
        this.name.textProperty().addListener(((observable, oldValue, newValue) -> {
            validateNumbers(this.name, this.nameError, newValue);
        }));


        this.nameError = new Label("");
        this.nameError.getStyleClass().add("errorLabel");
        this.nameError.setVisible(false);
        this.nameError.setAlignment(Pos.BASELINE_RIGHT);

        VBox labelContainer = new VBox(nameLabel);
        VBox inputContainer = new VBox(this.name, this.nameError);
        inputContainer.setAlignment(Pos.CENTER);

        this.nameField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    /**
     * Sets up the UI elements for entering the user's last name.
     * Configures a label for the field, a text input for the last name,
     * and an error label to display validation messages.
     */
    private void settingLastNameField(String lastName) {
        this.lastNameField = new HBox();
        this.lastNameField.setAlignment(Pos.CENTER);

        Label lastNameLabel = new Label("Apellidos");
        lastNameLabel.getStyleClass().add("tag");

        this.lastName = new TextField(lastName);
        this.lastName.getStyleClass().add("input");
        this.lastName.textProperty().addListener(((observable, oldValue, newValue) -> {
            validateNumbers(this.lastName, this.lastNameError, newValue);
        }));
        ;

        this.lastNameError = new Label("");
        this.lastNameError.getStyleClass().add("errorLabel");
        this.lastNameError.setVisible(false);

        VBox labelContainer = new VBox(lastNameLabel);
        VBox inputContainer = new VBox(this.lastName, this.lastNameError);
        inputContainer.setAlignment(Pos.CENTER);

        this.lastNameField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    private void settingRoleField(String rol) {
        this.roleField = new HBox();
        this.roleField.setAlignment(Pos.CENTER);
        Label roleLabel = new Label("Rol");
        roleLabel.getStyleClass().add("tag");
        this.roles = new ChoiceBox<>();
        this.roles.getStyleClass().add("input");
        this.roles.getItems().addAll(ROLES);
        int numrol=numRol(rol);
        this.roles.setValue(ROLES[numrol]);
        if(rol.toLowerCase().equals(ROLES[4].toLowerCase())){
            this.settingEstadoField(graduated.getEstadoEmp());
            estadoField.setVisible(true);
        }else {
            this.settingEstadoField(graduated.getEstadoEmp());
            estadoField.setVisible(false);
        }
        this.roles.setOnAction(this);
        this.roles.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Graduated")) {
                estadoField.setVisible(true);
                this.estadoEmp.setValue(ESTADOS[1]);
            } else {
                estadoField.setVisible(false);
                nomEmpresaField.setVisible(false);
                cargoFiel.setVisible(false);
                this.estadoEmp.setValue(ESTADOS[1]);
            }
        });
        VBox labelContainer = new VBox(roleLabel);
        VBox inputContainer = new VBox(this.roles);
        VBox.setMargin(this.roles, new Insets(0, 0, 10, 0));
        inputContainer.setAlignment(Pos.CENTER);

        this.roleField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }
    private int numRol(String rol){
        for (int i=0;i<ROLES.length;i++) {
            if (ROLES[i].toLowerCase().equals(rol.toLowerCase())){
                return i;
            }
        }
        return 0;
    }
    private void settingSummitButton() {
        this.summit = new Button("Guardar");
        this.delete=new Button("Eliminar");
        this.summit.setId("summit");
        this.delete.setId("delete");
        this.delete.setCursor(Cursor.HAND);
        this.summit.setCursor(Cursor.HAND);
        this.delete.setOnAction(this);
        this.summit.setOnAction(this);
        VBox.setMargin(this.delete, new Insets(20, 0, 0, 0));
        VBox.setMargin(this.summit, new Insets(20, 0, 0, 0));
        this.Buttons=new HBox();
        Buttons.getChildren().addAll(summit,delete);
        Buttons.setAlignment(Pos.CENTER);
        Buttons.setSpacing(30);
    }

    /**
     * Configures the message display container and label for displaying status messages.
     * Sets the initial message, container ID for styling, alignment, and visibility.
     */
    private void settingMessage() {
        this.messageContainer = new VBox();
        this.messageContainer.setId("messageContainer");
        this.message = new Label("Error!");
        this.message.setId("message");
        this.messageContainer.setAlignment(Pos.CENTER);
        this.messageContainer.getChildren().add(this.message);
        this.messageContainer.setVisible(false);
    }

    public void settingPhoneField(String phone) {
        this.phoneField = new HBox();
        this.phoneField.setAlignment(Pos.CENTER);
        Label phoneLabel = new Label("Phone");
        phoneLabel.getStyleClass().add("tag");
        this.phone = new TextField(phone);
        this.phone.getStyleClass().add("input");
        this.phone.promptTextProperty().addListener(((observable, oldValue, newValue) -> {
            validateIdStyle(this.phone, this.phoneError, newValue);
        }));
        this.phoneError = new Label();
        this.phoneError.getStyleClass().add("errorLabel");
        this.phoneError.setVisible(false);
        VBox labelContainer = new VBox(phoneLabel);
        VBox inputContainer = new VBox(this.phone, this.phoneError);
        inputContainer.setAlignment(Pos.CENTER);
        this.phoneField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    public void settingEmailField(String email) {
        this.emailField = new HBox();
        this.emailField.setAlignment(Pos.CENTER);
        Label phoneLabel = new Label("Email");
        phoneLabel.getStyleClass().add("tag");
        this.email = new TextField(email);
        this.email.getStyleClass().add("input");
        this.email.promptTextProperty().addListener(((observable, oldValue, newValue) -> {
            validateContainsArr(this.email, this.emailError, newValue);
        }));
        this.emailError = new Label();
        this.emailError.getStyleClass().add("errorLabel");
        this.emailError.setVisible(false);
        VBox labelContainer = new VBox(phoneLabel);
        VBox inputContainer = new VBox(this.email, this.emailError);
        inputContainer.setAlignment(Pos.CENTER);
        this.emailField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    private void settingEstadoField(boolean estado){
        this.estadoField = new HBox();
        this.estadoField.setAlignment(Pos.CENTER);
        Label estadoLabel = new Label("Estado");
        estadoLabel.getStyleClass().add("tag");
        this.estadoEmp = new ChoiceBox<>();
        this.estadoEmp.getStyleClass().add("input");
        this.estadoEmp.getItems().addAll(ESTADOS);
        if (estado){
            this.estadoEmp.setValue(ESTADOS[0]);
            this.settingNombreEmpresaField(graduated.getNombEmpresa());
            this.settingCargoField(graduated.getCargo());
            nomEmpresaField.setVisible(true);
            cargoFiel.setVisible(true);
        }else {
            this.estadoEmp.setValue(ESTADOS[1]);
            this.settingNombreEmpresaField(graduated.getNombEmpresa());
            this.settingCargoField(graduated.getCargo());
            nomEmpresaField.setVisible(false);
            cargoFiel.setVisible(false);
        }
        this.estadoEmp.setOnAction(this);
        this.estadoEmp.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Si")) {
                nomEmpresaField.setVisible(true);
                cargoFiel.setVisible(true);
            } else {
                nomEmpresaField.setVisible(false);
                cargoFiel.setVisible(false);

            }
        });
        VBox labelContainer = new VBox(estadoLabel);
        VBox inputContainer = new VBox(this.estadoEmp);
        VBox.setMargin(this.estadoEmp, new Insets(0,0,10,0));
        inputContainer.setAlignment(Pos.CENTER);
        this.estadoField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
        estadoField.setVisible(false);
    }
    public void settingNombreEmpresaField(String nombreEmp){
        this.nomEmpresaField =new HBox();
        this.nomEmpresaField.setAlignment(Pos.CENTER);
        Label nombreEmpresa=new Label("Nombre Empresa");
        nombreEmpresa.getStyleClass().add("tag");
        this.nomEmpresa=new TextField(nombreEmp);
        this.nomEmpresa.getStyleClass().add("input");
        this.nomEmpresa.promptTextProperty().addListener(((observable, oldValue, newValue) -> {
            validateNumbers(this.nomEmpresa, this.nomEmpresaError, newValue);
        }));
        this.nomEmpresaError=new Label();
        this.nomEmpresaError.getStyleClass().add("errorLabel");
        this.nomEmpresaError.setVisible(false);
        VBox labelContainer = new VBox(nombreEmpresa);
        VBox inputContainer = new VBox(this.nomEmpresa, this.nomEmpresaError);
        inputContainer.setAlignment(Pos.CENTER);
        this.nomEmpresaField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);

    }
    public void settingCargoField(String cargo){
        this.cargoFiel =new HBox();
        this.cargoFiel.setAlignment(Pos.CENTER);
        Label cargoLabel=new Label("Cargo");
        cargoLabel.getStyleClass().add("tag");
        this.cargo=new TextField(cargo);
        this.cargo.getStyleClass().add("input");
        this.cargo.promptTextProperty().addListener(((observable, oldValue, newValue) -> {
            validateNumbers(this.cargo, this.cargoError, newValue);
        }));
        this.cargoError=new Label();
        this.cargoError.getStyleClass().add("errorLabel");
        this.cargoError.setVisible(false);
        VBox labelContainer = new VBox(cargoLabel);
        VBox inputContainer = new VBox(this.cargo, this.cargoError);
        inputContainer.setAlignment(Pos.CENTER);
        this.cargoFiel.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);

    }
    private void validateContainsArr(TextField ob, Label error, String value) {
        if (!this.util.containsArr(value)) {
            error.setText(error.getText() + "Debe contener @");
            if (!error.getText().contains("Debe contener @")) {
                ob.getStyleClass().add("errorInput");
                error.setVisible(true);
            }
        }
    }

    /**
     * Validates the input style and displays appropriate error messages for the ID field.
     *
     * @param ob    The TextField for the ID
     * @param error The Label to display error messages
     * @param value The input value to be validated
     */
    private void validateIdStyle(TextField ob, Label error, String value) {
        if (value.isBlank() || this.util.containSpecialCharactersId(value)) {
            ob.getStyleClass().add("errorInput");
            error.setVisible(true);
        }

        if (value.isBlank()) {
            if (!error.getText().contains(" Obligatorio*")) {
                error.setText(error.getText() + " Obligatorio*");
            }
        }

        if (this.util.containSpecialCharactersId(value)) {
            if (!error.getText().contains(" Sin caracteres especiales")) {
                error.setText(error.getText() + " Sin caracteres especiales");
            }
        }

        if (!this.util.containSpecialCharactersId(ob.getText()) && !ob.getText().isBlank()) {
            error.setText("");
            ob.getStyleClass().remove("errorInput");
        }

    }

    /**
     * Validates the input style and displays appropriate error messages for fields that should not contain numbers.
     *
     * @param ob    The TextField for which the validation is performed
     * @param error The Label to display error messages
     * @param value The input value to be validated
     */
    private void validateNumbers(TextField ob, Label error, String value) {
        if (this.util.containsNums(ob.getText()) || this.util.containSpecialCharactersNums(value) || value.isBlank() || value.startsWith(" ")) {
            if (!ob.getStyleClass().contains("errorInput")) {
                ob.getStyleClass().add("errorInput");
            }
            error.setVisible(true);

            if (value.isBlank()) {
                if (!error.getText().contains(" Obligatorio*")) {
                    error.setText(error.getText() + " Obligatorio*");
                }
            }
            if (value.startsWith(" ")) {
                if (!error.getText().contains("No espacios iniciales.")) {
                    error.setText(error.getText() + "No espacios iniciales.");
                }
            }
            if (this.util.containsNums(value)) {
                if (!error.getText().contains(" Sin Números")) {
                    error.setText(error.getText() + " Sin Números");
                }
            }

            if (this.util.containSpecialCharactersNums(value)) {
                if (!error.getText().contains(" Sin caracteres especiales")) {
                    error.setText(error.getText() + " Sin caracteres especiales");
                }
            }
        }

        if (!this.util.containsNums(ob.getText()) && !this.util.containSpecialCharactersNums(ob.getText()) && !ob.getText().isBlank() && !value.startsWith(" ")) {
            error.setText("");
            ob.getStyleClass().remove("errorInput");
        }
    }

    /**
     * Validates a string to ensure it does not contain numbers, special characters, is not blank, and does not start with a space.
     *
     * @param str The string to be validated
     * @return True if the string is valid (meets the specified criteria), false otherwise
     */
    public boolean validateNames(String str) {
        return !str.isBlank() && !this.util.containsNums(str) && !this.util.containSpecialCharactersNums(str) && !str.startsWith(" ");
    }

    /**
     * Validates an identification string to ensure it is not blank, does not contain special characters, and does not contain spaces.
     *
     * @param str The identification string to be validated
     * @return True if the string is valid (meets the specified criteria), false otherwise
     */
    public boolean validateId(String str) {
        return !str.isBlank() && !this.util.containSpecialCharactersId(str) && !str.contains(" ");
    }

    @Override
    public void handle(ActionEvent e) {
        if(e.getSource()==this.delete){
            lgView.controller.getPersonController().removePerson(person);
            lgView.loginListUsers.remove(person);
            System.out.println("borrando");
        }
        if(e.getSource()==this.summit){
            System.out.println("guardado");
        }
    }
}
