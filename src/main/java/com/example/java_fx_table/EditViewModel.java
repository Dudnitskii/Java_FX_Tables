package com.example.java_fx_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class EditViewModel {
    private final ItemModel itemModel = new ItemModel();
    public void editData(Item item, int index){
        ObservableList<Item> dataTable = FXCollections.observableArrayList();
        dataTable = itemModel.inputDataFromFile();
        dataTable.remove(index);
        dataTable.add(index, item);
        itemModel.outputDataInFile(dataTable);
    }

    public void back(Stage stage){
        stage.close();
    }

    public void addData(Item item){
        ObservableList<Item> dataTable = FXCollections.observableArrayList();
        dataTable = itemModel.inputDataFromFile();
        dataTable.add(item);
        itemModel.outputDataInFile(dataTable);
    }
}
