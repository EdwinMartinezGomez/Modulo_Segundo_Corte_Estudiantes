module co.edu.uptc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;

    opens co.edu.uptc.controller to com.google.gson;
    opens co.edu.uptc.model to com.google.gson, javafx.base;
    opens co.edu.uptc.view to javafx.fxml;
    exports co.edu.uptc.view;
    opens co.edu.uptc.model.persontypes to com.google.gson, javafx.base;
}