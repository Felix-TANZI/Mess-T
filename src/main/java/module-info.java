module javafxtest.test12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens javafxtest.test12 to javafx.fxml;
    exports javafxtest.test12;
}