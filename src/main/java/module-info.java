module com.hbm.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.hbm.financetracker to javafx.fxml;
    exports com.hbm.financetracker;
}
