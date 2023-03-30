package com.example.java_fx_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemViewModel {
    private final ItemModel itemModel = new ItemModel();
    private ObservableList<Item> dataTable = FXCollections.observableArrayList();

    public void editData(int index){
        dataTable = itemModel.inputDataFromFile();
        createEditMenu(dataTable.get(index),index);
    }
    public void deleteData(int index){
        dataTable = itemModel.inputDataFromFile();
        dataTable.remove(index);
        itemModel.outputDataInFile(dataTable);
    }
    public void addData(){
        createAddMenu();
    }

    public void createEditMenu(Item item, int index){
        Stage stage1 = new Stage();
        EditView view = new EditView(stage1, item,index);
        stage1.setScene(new Scene(view));
        stage1.setTitle("Edit data");
        stage1.show();
    }
    public void createAddMenu(){
        Stage stage1 = new Stage();
        EditView view = new EditView(stage1);
        stage1.setScene(new Scene(view));
        stage1.setTitle("New data");
        stage1.show();
    }

    public ObservableList<Item> setItems() {
       return itemModel.inputDataFromFile();
    }
}
