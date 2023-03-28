package com.example.java_fx_table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVVMTable extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ItemView view = new ItemView(stage);
        Scene scene = new Scene(view);

        stage.setTitle("MVVM Table");
        stage.setScene( scene );
        stage.setWidth( 600 );
        stage.setHeight( 460 );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
