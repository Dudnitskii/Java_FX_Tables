package com.example.java_fx_table;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemViewModel {
    public ObservableList<Item> editData(ObservableList<Item> dataTable, int index, Stage stage){
        createEditMenu(dataTable.get(index),index);
        return dataTable;
    }
    public ObservableList<Item> deleteData(ObservableList<Item> dataTable, int index){
        dataTable.remove(index);
        return dataTable;
    }
    public ObservableList<Item> addData(ObservableList<Item> dataTable, Stage stage){
        createAddMenu();
        return dataTable;
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
}
