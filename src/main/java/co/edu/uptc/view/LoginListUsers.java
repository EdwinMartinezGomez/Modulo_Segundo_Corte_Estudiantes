package co.edu.uptc.view;

import co.edu.uptc.model.Account;
import co.edu.uptc.model.ClaseAux;
import co.edu.uptc.model.Person;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class LoginListUsers extends Header  {
    LoginView parent;
    BorderPane borderPane;
    TableView table;
    TableColumn idColumn;
    TableColumn nameColumn;
    TableColumn lastNameColumn;
    TableColumn roleColumn;
    TableColumn actionColumn;
    TableColumn emailColumn;
    TableColumn phoneColumn;
    TableColumn emailGeneratedColumn;
    Button Home;
    ClaseAux claseAux;
    ModifyPersonItems modifyPersons;
    ObservableList<Person> PersonList = FXCollections.observableArrayList();
    //ObservableList<Account> accountList=FXCollections.observableArrayList();
    ObservableList<ClaseAux> aux=FXCollections.observableArrayList();
    /**
     * Constructor of the LoginListUsers class.
     * @param loginView The parent LoginView instance.
     * @param home The Button instance to be set as home button in the header.
     */
    public LoginListUsers(LoginView loginView, Button home) {
        super(home);
        this.parent = loginView;
        this.home = home;
        modifyPersons=new ModifyPersonItems(this,home);
        borderPane = new BorderPane();
        table = new TableView<Person>();
        //addingRegisters();
        creationColumns();
    }

    /**
     * Method that returns the user list view scene.
     * @return Scene of the user list view.
     */
    public Scene loginListUsers(){
        updateTable();
        table.setItems(aux);
        borderPane.setCenter(table);
        HBox header = this.getHeader();
        this.setOption("Ver cuentas");
        this.setName(parent.controller.getName());
        VBox root = new VBox(header, borderPane);
        Scene scene = new Scene(root, 1000, 600);
        return scene;
    }

    // Método para actualizar la tabla con las cuentas actuales
    private void updateTable() {
        List<Person> updatedAccounts = parent.controller.getPersonController().getPersons();
        List<Account> accounts=parent.controller.getPersonController().getAccounts();
        // Comparar las cuentas actuales con las cuentas en la tabla
        // Agregar cuentas nuevas si las hay
        for (Person updatedAccount : updatedAccounts) {
            if (!PersonList.contains(updatedAccount)) {
                addPerson(updatedAccount);
            }
        }
        /*for (Account a:accounts){
            if(!accountList.contains(a)){
                addAccount(a);
            }
        }*/
        // Eliminar cuentas que ya no están presentes
        PersonList.removeIf(account -> !updatedAccounts.contains(account));
        //accountList.removeIf(account -> !accounts.contains(account));
        for (Person p:this.PersonList) {
            ClaseAux c=new ClaseAux(p.getId(),p.getName(),p.getLastname(),p.getPhone(),p.getEmail(),p.getAccount().getRole(),p.getAccount().getEmail(),new Button("Modificar"));
            aux.add(c);
        }
    }
    /*public void removeAccount(Account account) {
        accountList.remove(account);
    }*/
    /**
     * Method to add an account to the table.
     * @param account User account to be added.
     */
    public void addPerson(Person account){
        PersonList.add(account);
    }
    /*public void addAccount(Account account){
        accountList.add(account);
    }*/

//    /**
//     * Private method to add records to the
//     * table from the controller's account list.
//     */
//    private void addingRegisters(){
//        for (Account account: parent.controller.getPersonController().getAccounts()) {
//            table.getItems().add(new Account(account.getId(), account.getUserName(), account.getPassword(), account.getRole(), account.getEmail()));
//        }
//    }

    /**
     *Private method to create the columns of the table.
     */
    private void creationColumns() {
        idColumn = new TableColumn<ClaseAux, String> ("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("id"));

        nameColumn = new TableColumn<ClaseAux, String> ("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("name"));

        lastNameColumn = new TableColumn<ClaseAux, String> ("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("lastname"));

        roleColumn = new TableColumn<ClaseAux, String> ("Rol");
        roleColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("role"));

        emailColumn = new TableColumn<ClaseAux, String> ("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("email"));
        phoneColumn = new TableColumn<ClaseAux, String> ("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("phone"));
        emailGeneratedColumn = new TableColumn<ClaseAux, String> ("email generated");
        emailGeneratedColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux, String>("emailGenerado"));
        actionColumn = new TableColumn<ClaseAux, Button>("Actions");
        actionColumn.setCellValueFactory(new PropertyValueFactory<ClaseAux,Button>("bt"));
        actionColumn.setCellFactory(column -> {
            return new TableCell<ClaseAux, Button>() {
                @Override
                protected void updateItem(Button item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(item);
                        item.setOnAction(event -> {
                            ClaseAux rowData = getTableView().getItems().get(getIndex());
                            Person p=parent.controller.getPersonController().findPersonById(rowData.getId());
                            parent.stage.setTitle("Modificar Informacion");
                            parent.stage.setScene(modifyPersons.modifyPersonsItems(p));
                        });
                    }
                }
            };
        });
        table.getColumns().add(idColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(roleColumn);
        table.getColumns().add(emailColumn);
        table.getColumns().add(phoneColumn);
        table.getColumns().add(emailGeneratedColumn);
        table.getColumns().add(actionColumn);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



    }


}
