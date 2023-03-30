package com.example.java_fx_table;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditView extends VBox {

    private GridPane gp = new GridPane();
    private TextField tfName = new TextField();
    private TextField tfSurname = new TextField();
    private TextField tfDate = new TextField();
    private TextField tfPost = new TextField();
    private Button btnSave = new Button("Save");
    private Button btnBack = new Button("Back");
    private Stage stage1 = null;
    private String str;
    private int index;
    private final EditViewModel viewModel = new EditViewModel();
    public EditView(Stage stage){
        this.stage1 = stage;
        editTableMenu();
        str = "Add";
    }
    public EditView(Stage stage, Item item, int index1){
        this.stage1 = stage;
        editTableMenu();
        tfName.setText(item.getName());
        tfSurname.setText(item.getSurname());
        tfDate.setText(item.getDate());
        tfPost.setText(item.getPost());
        str = "Edit";
        index = index1;
    }
    public void editTableMenu(){
        VBox newBox = new VBox();
        newBox.setAlignment(Pos.CENTER);

        gp.setPadding( new Insets(40) );
        gp.setVgap( 4 );
        gp.add(new Label("Name"), 0, 0);        gp.add(tfName, 1, 0);
        gp.add(new Label("Surname"), 0, 1);     gp.add(tfSurname, 1, 1);
        gp.add(new Label("Date"), 0, 2);        gp.add(tfDate, 1, 2);
        gp.add(new Label("Post"), 0, 3);        gp.add(tfPost, 1, 3);
        final ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth( 50 );
        gp.getColumnConstraints().addAll( col, col );

        newBox.getChildren().add( gp );

        btnSave.setOnAction(this::save);
        btnBack.setOnAction(this::cancel);

        ButtonBar btnbar = new ButtonBar();
        btnbar.setPadding( new Insets(20.0d) );
        btnbar.getButtons().addAll( btnSave, btnBack);

        VBox.setVgrow( newBox, Priority.ALWAYS );
        this.getChildren().addAll(newBox, new Separator(), btnbar);
    }

    private void cancel(ActionEvent event) {
       viewModel.back(stage1);
    }

    private void save(ActionEvent event) {
        Item item = new Item(tfName.getText(), tfSurname.getText(), tfDate.getText(), tfPost.getText());
        if (str == "Add") {
            viewModel.addData(item);
        }else {
           viewModel.editData(item, index);
        }
        stage1.close();
    }
}
