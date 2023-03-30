package com.example.java_fx_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class ItemModel {
    private ArrayList<Item> data = new ArrayList<Item>();
    private File file = new File("Data.txt");

    public ItemModel(){}

    public ObservableList<Item> inputDataFromFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            data = (ArrayList<Item>) ois.readObject();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(data);
    }
    public void outputDataInFile(ObservableList<Item> data){
        ArrayList<Item> arrayList = new ArrayList<Item>(data);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(arrayList);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
