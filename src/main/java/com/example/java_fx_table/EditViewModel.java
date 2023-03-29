package com.example.java_fx_table;

import javafx.stage.Stage;

public class EditViewModel {

    private final ItemModel itemModel = new ItemModel();
    public void editData(Item item, int index){
        itemModel.data.remove(index);
        itemModel.data.add(index, item);
    }

    public void back(Stage stage){
        stage.close();
    }

    public void addData(Item item){
        itemModel.data.add(item);
    }
}
