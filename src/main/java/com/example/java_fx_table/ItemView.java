package com.example.java_fx_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ItemView extends VBox {
    private TableView<Item> tbItems = new TableView<>();
    private TableColumn<Item, String> columnName = new TableColumn<>("Name");
    private TableColumn<Item, String> columnSurname = new TableColumn<>("Surname");
    private TableColumn<Item, String> columnDate = new TableColumn<>("Date");
    private TableColumn<Item, String> columnPost = new TableColumn<>("Post");

    private Button btnAdd = new Button("Add");
    private Button btnDelete = new Button("Delete");
    private Button btnEdit = new Button("Edit");
    private Button btnRefresh = new Button("Refresh");

    private Stage stage = null;

    private final ItemViewModel viewModel = new ItemViewModel();
    private final ItemModel itemModel = new ItemModel();
    ObservableList<Item> dataTable = FXCollections.observableArrayList();
    public ItemView(Stage stage){
        this.stage = stage;
        createTable();
    }
    public void createTable(){
        VBox newBox = new VBox();
        newBox.setAlignment(Pos.CENTER);

        Item item = new Item("Dima","Dudnitskii", "19.07.2002","Student");
        dataTable.add(item);
        tbItems.setItems(dataTable);

        tbItems.getColumns().addAll(columnName, columnSurname, columnDate, columnPost);
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnName.setMinWidth(150);
        columnSurname.setMinWidth(200);
        columnDate.setMinWidth(50);
        columnPost.setMinWidth(150);
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnPost.setCellValueFactory(new PropertyValueFactory<>("post"));

        ButtonBar btnbar = new ButtonBar();
        btnbar.setPadding( new Insets(20.0d) );
        btnbar.getButtons().addAll( btnRefresh, btnDelete, btnEdit, btnAdd);

        btnAdd.setOnAction(this::addItem);
        btnDelete.setOnAction(this::deleteItem);
        btnEdit.setOnAction(this::editItem);
        btnRefresh.setOnAction(this::setDataTable);

        btnDelete.disableProperty().bind(tbItems.getSelectionModel().selectedItemProperty().isNull());
        btnEdit.disableProperty().bind(tbItems.getSelectionModel().selectedItemProperty().isNull());

        newBox.getChildren().add(tbItems);
        VBox.setVgrow( newBox, Priority.ALWAYS );
        this.getChildren().addAll(newBox, new Separator(), btnbar);
        itemModel.data = dataTable;
    }

    public void setDataTable(ActionEvent event){
        tbItems.setItems(itemModel.data);
    }
    public void deleteItem(ActionEvent event){
        itemModel.data = viewModel.deleteData( itemModel.data,tbItems.getSelectionModel().getFocusedIndex());
    }
    public void editItem(ActionEvent event){
        itemModel.data = viewModel.editData( itemModel.data, tbItems.getSelectionModel().getFocusedIndex(), stage);
    }
    public void addItem(ActionEvent event){

        itemModel.data = viewModel.addData( itemModel.data, stage);
    }
}
