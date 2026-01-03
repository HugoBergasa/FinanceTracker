module com.hbm.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.hbm.financetracker to javafx.fxml;
    exports com.hbm.financetracker;
}
