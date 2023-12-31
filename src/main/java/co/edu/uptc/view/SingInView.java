package co.edu.uptc.view;

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
/**
 * The SingInView class represents the view for user registration.
 * It extends the Header class and implements the EventHandler interface for handling events.
 */
public class SingInView extends Header implements EventHandler<ActionEvent> {
    private InputLibrary util;
    private LoginView parent;
    private HBox nameField;
    private HBox lastNameField;
    private HBox idField;
    private HBox roleField;
    private HBox phoneField;
    private HBox emailField;
    private HBox nomEmpresaField;
    private HBox cargoFiel;
    private HBox estadoField;
    private Label nameError;
    private Label lastNameError;
    private Label idError;
    private Label emailError;
    private Label phoneError;

    private Label nomEmpresaError;
    private Label cargoError;
    private TextField name;
    private TextField phone;
    private TextField email;
    private TextField lastName;
    private TextField id;

    private TextField nomEmpresa;
    private TextField cargo;
    private ChoiceBox<String> estadoEmp;
    private ChoiceBox<String> roles;

    private VBox messageContainer;
    private Label message;

    private Button summit;

    private static final String[] ROLES = {"Student", "Professor", "Secretary", "Administrator","Graduated"};
    private static final String[] ESTADOS={"Si","No"};
    private Label idLabel;

    /**
     * Constructs a SingInView instance.
     *
     * @param parent The parent LoginView instance.
     * @param btn    The Button instance to be set as home button in the header.
     */
    public SingInView(LoginView parent, Button btn) {
        super(btn);
        this.parent = parent;
        this.util = new InputLibrary();
    }

    /**
     * Creates the scene for user registration.
     *
     * @return The Scene for user registration.
     */
    public Scene singIn(){
        HBox header = this.getHeader();
        this.setName(this.parent.controller.getName());
        this.setOption("Crear Usuario");

        this.settingNameField();
        this.settingLastNameField();
        this.settingIdField();
        this.settingRoleField();
        this.settingPhoneField();
        this.settingEmailField();
        this.settingSummitButton();
        this.settingEstadoField();
        this.settingNombreEmpresaField();
        this.settingCargoField();
        this.settingMessage();
        VBox formContainer = new VBox(this.roleField,this.nameField, this.lastNameField, this.idField,this.phoneField,this.emailField,this.estadoField,this.nomEmpresaField,this.cargoFiel, this.summit);
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
        scene.getStylesheets().add(new File("./styles/signin.css").toURI().toString());
        return scene;
    }

    /**
     * Sets up the UI elements for entering the user's first name.
     * Configures a label for the field, a text input for the first name,
     * and an error label to display validation messages.
     */
    private void settingNameField() {
        this.nameField = new HBox();
        this.nameField.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Nombres");
        nameLabel.getStyleClass().add("tag");

        this.name = new TextField();
        this.name.setPromptText("Jhon");
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
    private void settingLastNameField() {
        this.lastNameField = new HBox();
        this.lastNameField.setAlignment(Pos.CENTER);

        Label lastNameLabel = new Label("Apellidos");
        lastNameLabel.getStyleClass().add("tag");

        this.lastName = new TextField();
        this.lastName.setPromptText("Doe");
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

    /**
     * Sets up the UI elements for entering the user's identification.
     * Configures a label for the field, a text input for the identification,
     * and an error label to display validation messages.
     */
    private void settingIdField() {
        this.idField = new HBox();
        this.idField.setAlignment(Pos.CENTER);

        this.idLabel = new Label();
        this.idLabel.setText("código");
        this.idLabel.getStyleClass().add("tag");

        this.id = new TextField();
        this.id.getStyleClass().add("input");
        this.id.setPromptText("Ej: 202210583");
        this.id.textProperty().addListener(((observable, oldValue, newValue) -> {
            validateIdStyle(this.id, this.idError, newValue);
        }));
        ;

        this.idError = new Label();
        this.idError.getStyleClass().add("errorLabel");
        this.idError.setVisible(false);
        VBox labelContainer = new VBox(idLabel);
        VBox inputContainer = new VBox(this.id, this.idError);

        inputContainer.setAlignment(Pos.CENTER);
        this.idField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    /**
     * Sets up the UI elements for selecting a role.
     * Configures a label for the role selection, a choice box to select a role,
     * and sets up event handling for role selection changes.
     */
    private void settingRoleField() {
        this.roleField = new HBox();
        this.roleField.setAlignment(Pos.CENTER);
        Label roleLabel = new Label("Rol");
        roleLabel.getStyleClass().add("tag");

        this.roles = new ChoiceBox<>();
        this.roles.getStyleClass().add("input");
        this.roles.getItems().addAll(ROLES);
        this.roles.setValue(ROLES[0]);
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

    /**
     * Configures the "Registrar" button for user registration.
     * Sets the button label, CSS ID, cursor style, and event handling for button clicks.
     */
    private void settingSummitButton() {
        this.summit = new Button("Registrar");
        this.summit.setId("summit");
        this.summit.setCursor(Cursor.HAND);
        this.summit.setOnAction(this);
        VBox.setMargin(this.summit, new Insets(20, 0, 0, 0));
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

    public void settingPhoneField() {
        this.phoneField = new HBox();
        this.phoneField.setAlignment(Pos.CENTER);
        Label phoneLabel = new Label("Phone");
        phoneLabel.getStyleClass().add("tag");
        this.phone = new TextField();
        this.phone.getStyleClass().add("input");
        this.phone.setOnKeyReleased(event -> {
            String newValue = this.phone.getText();
            validatePhoneStyle(this.phone, this.phoneError,newValue);
        });

        this.phoneError = new Label();
        this.phoneError.getStyleClass().add("errorLabel");
        this.phoneError.setVisible(false);
        VBox labelContainer = new VBox(phoneLabel);
        VBox inputContainer = new VBox(this.phone, this.phoneError);
        inputContainer.setAlignment(Pos.CENTER);
        this.phoneField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    public void settingEmailField() {
        this.emailField = new HBox();
        this.emailField.setAlignment(Pos.CENTER);
        Label phoneLabel = new Label("Email");
        phoneLabel.getStyleClass().add("tag");
        this.email = new TextField();
        this.email.getStyleClass().add("input");

        this.email.setOnKeyReleased(event -> {
            String newValue = this.email.getText();
            validateContainsArr(this.email, this.emailError,newValue);
        });



        this.emailError = new Label();
        this.emailError.getStyleClass().add("errorLabel");
        this.emailError.setVisible(false);
        VBox labelContainer = new VBox(phoneLabel);
        VBox inputContainer = new VBox(this.email, this.emailError);
        inputContainer.setAlignment(Pos.CENTER);
        this.emailField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
    }

    private void settingEstadoField( ){
        this.estadoField = new HBox();
        this.estadoField.setAlignment(Pos.CENTER);
        Label estadoLabel = new Label("Estado");
        estadoLabel.getStyleClass().add("tag");

        this.estadoEmp = new ChoiceBox<>();
        this.estadoEmp.getStyleClass().add("input");
        this.estadoEmp.getItems().addAll(ESTADOS);
        this.estadoEmp.setValue(ESTADOS[1]);
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
    public void settingNombreEmpresaField(){
        this.nomEmpresaField =new HBox();
        this.nomEmpresaField.setAlignment(Pos.CENTER);
        Label nombreEmpresa=new Label("Nombre Empresa");
        nombreEmpresa.getStyleClass().add("tag");
        this.nomEmpresa=new TextField();
        this.nomEmpresa.getStyleClass().add("input");
        this.nomEmpresa.setOnKeyReleased(event -> {
            String newValue = this.nomEmpresa.getText();
            validateNumbers(this.nomEmpresa, this.nomEmpresaError,newValue);
        });
        this.nomEmpresaError=new Label();
        this.nomEmpresaError.getStyleClass().add("errorLabel");
        this.nomEmpresaError.setVisible(false);
        VBox labelContainer = new VBox(nombreEmpresa);
        VBox inputContainer = new VBox(this.nomEmpresa, this.nomEmpresaError);
        inputContainer.setAlignment(Pos.CENTER);
        this.nomEmpresaField.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
        nomEmpresaField.setVisible(false);
    }
    public void settingCargoField(){
        this.cargoFiel =new HBox();
        this.cargoFiel.setAlignment(Pos.CENTER);
        Label cargoLabel=new Label("Cargo");
        cargoLabel.getStyleClass().add("tag");
        this.cargo=new TextField();
        this.cargo.getStyleClass().add("input");
        this.cargo.setOnKeyReleased(event -> {
            String newValue = this.cargo.getText();
            validateNumbers(this.cargo, this.cargoError,newValue);
        });
        this.cargoError=new Label();
        this.cargoError.getStyleClass().add("errorLabel");
        this.cargoError.setVisible(false);
        VBox labelContainer = new VBox(cargoLabel);
        VBox inputContainer = new VBox(this.cargo, this.cargoError);
        inputContainer.setAlignment(Pos.CENTER);
        this.cargoFiel.getChildren().addAll(labelContainer, inputContainer);
        HBox.setHgrow(inputContainer, Priority.ALWAYS);
        cargoFiel.setVisible(false);
    }

    private void validateContainsArr(TextField ob, Label error, String value) {
        String errorMessage = "Debe contener @";

        if (!this.util.containsArr(value)) {
            if (!error.getText().contains(errorMessage)) {
                error.setText(error.getText() + errorMessage);
                ob.getStyleClass().add("errorInput");
                error.setVisible(true);
            }
        } else {
            // Elimina el mensaje de error si se cumple la condición
            error.setText(error.getText().replace(errorMessage, ""));
            if (error.getText().isEmpty()) {
                ob.getStyleClass().remove("errorInput");
                error.setVisible(false);
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
    private void validatePhoneStyle(TextField ob, Label error, String value) {
        if (value.isBlank() || this.util.containSpecialCharactersId(value)||this.util.contieneSoloNumeros(value)) {
            ob.getStyleClass().add("errorInput");
            error.setVisible(true);
            if (value.isBlank()) {
                if (!error.getText().contains(" Obligatorio*")) {
                    error.setText(error.getText() + " Obligatorio*");
                    error.setVisible(true);
                }
            }

            if (this.util.containSpecialCharactersId(value)) {
                if (!error.getText().contains("caracteres especiales ")) {
                    error.setText(error.getText() + "caracteres especiales ");
                    error.setVisible(true);
                }
            }
            if (this.util.contieneSoloNumeros(value)) {
                if (!error.getText().contains(" Sin letras o  caracteres especiales ")) {
                    error.setText(error.getText() + " Sin letras o  caracteres especiales ");
                    error.setVisible(true);
                }
            }

            if (! util.validateSizePhone(this.phone.getText())) {
                this.phoneError.setText("Son 10 numeros*");
                this.phoneError.setVisible(true);
            }
        }


        if (!this.util.containSpecialCharactersId(ob.getText()) && !ob.getText().isBlank()&&this.util.contieneSoloNumeros(ob.getText())) {
            error.setText("");
            ob.getStyleClass().remove("errorInput");
            error.setVisible(true);
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

    /**
     * Event handler for handling actions triggered by the user.
     *
     * @param e The ActionEvent that occurred.
     */

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == this.summit) {
            this.roles.requestFocus();
            if (this.validateNames(this.name.getText()) && this.validateNames(this.lastName.getText()) && this.validateId(this.id.getText()) && this.validatePhone(this.phone.getText()) && this.validateEmail(this.email.getText()) && this.estadoEmp.getValue().equals(ESTADOS[1])) {
                boolean response = this.parent.controller.signin(this.name.getText(), this.lastName.getText(), this.id.getText(), this.phone.getText(), this.email.getText(), this.roles.getValue());
                if (response) {
                    this.parent.loginListUsers.addPerson(this.parent.controller.getPersonController().findPersonById(this.id.getText()));
                    this.message.setText("Añadido con éxito!");
                } else {
                    this.message.setText("Ha ocurrido un error!");
                }
                this.messageContainer.setVisible(true);
            } else if (this.validateNames(this.name.getText()) && this.validateNames(this.lastName.getText()) && this.validateId(this.id.getText()) && this.validatePhone(this.phone.getText()) && this.validateEmail(this.email.getText()) && this.estadoEmp.getValue().equals(ESTADOS[0]) && this.validateNames(this.nomEmpresa.getText())&& this.validateNames(this.cargo.getText())) {
                boolean response = this.parent.controller.signin(this.name.getText(), this.lastName.getText(), this.id.getText(), this.phone.getText(), this.email.getText(), this.roles.getValue(),true,this.nomEmpresa.getText(),this.cargo.getText());
                if (response) {
                    this.parent.loginListUsers.addPerson(this.parent.controller.getPersonController().findPersonById(this.id.getText()));
                    this.message.setText("Añadido con éxito!");
                } else {
                    this.message.setText("Ha ocurrido un error!");
                }
                this.messageContainer.setVisible(true);
            } else {
                this.message.setText("Los nombres no deben contener espacios al iniciar números o caracteres especiales.\n" +
                        "Asegúrese de que el teléfono no contenga letras y que el correo electrónico tenga '@'.");
                this.messageContainer.setVisible(true);
            }

            if (this.name.getText().isBlank()) {
                this.nameError.setText("Obligatorio*");
                this.nameError.setVisible(true);
            }
            if (this.lastName.getText().isBlank()) {
                this.lastNameError.setText("Obligatorio*");
                this.lastNameError.setVisible(true);
            }
            if (this.phone.getText().isBlank()) {
                this.phoneError.setText("Obligatorio*");
                this.phoneError.setVisible(true);
            }
            if (!util.validateSizePhone(this.phone.getText())) {
                this.phoneError.setText("Son 10 caracteres*");
                this.phoneError.setVisible(true);
            }
            if (this.email.getText().isBlank() ) {
                this.emailError.setText("olbigatorio*");
                this.emailError.setVisible(true);
            }
            if (!validateEmail(this.email.getText()) ) {
                this.emailError.setText("Debe contener @*");
                this.emailError.setVisible(true);
            }
        }
        if (e.getSource() == this.roles) {
            if (!this.roles.getValue().equals(ROLES[0])) {
                this.idLabel.setText("Identificación");
                this.id.setPromptText("1053893289");
            } else {
                this.idLabel.setText("código");
                this.id.setPromptText("202216034");
            }
        }
    }

    /**
     * Validates the input style and displays appropriate error messages for the phone field.
     *
     * @param phone The phone number to be validated
     * @return True if the phone number is valid (meets the specified criteria), false otherwise
     */
    public boolean validatePhone(String phone) {
        // Use a regular expression to check if the phone number contains only digits

        return util.validateSizePhone(phone) && phone.matches("\\d+") && !phone.isBlank();
    }

    /**
     * Validates the input style and displays appropriate error messages for the email field.
     *
     * @param email The email address to be validated
     * @return True if the email address is valid (contains "@"), false otherwise
     */
    public boolean validateEmail(String email) {
        return email.contains("@");
    }
}