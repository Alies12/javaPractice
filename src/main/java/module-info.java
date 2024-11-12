module com.javafx.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    requires org.controlsfx.controls;

    opens com.javafx.demofx to javafx.fxml;
    exports com.javafx.demofx;
}