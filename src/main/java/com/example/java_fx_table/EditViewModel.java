package com.example.java_fx_table;

import javafx.stage.Stage;

public class EditViewModel {
    public Item save(Item item, Stage stage){
        return item;
    }

    public void back(Stage stage){
        stage.close();
    }
}
