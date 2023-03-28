module com.example.java_fx_table {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.java_fx_table to javafx.fxml;
    exports com.example.java_fx_table;
}