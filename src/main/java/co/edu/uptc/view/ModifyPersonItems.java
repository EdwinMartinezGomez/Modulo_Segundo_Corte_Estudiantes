package co.edu.uptc.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import java.awt.*;


public class ModifyPersonItems  extends  Header {

    private  LoginListUsers lglusr;
    public  Scene modifyPersonsItems(){
        javafx.scene.control.Label nam = new javafx.scene.control.Label("adas");
        HBox root = new HBox(nam);
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
