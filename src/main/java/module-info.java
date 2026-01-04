module com.hbm.financetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires jbcrypt;
    
    
    opens com.hbm.financetracker to javafx.fxml;
    opens controller to javafx.fxml;
    
    exports com.hbm.financetracker;
    exports controller;
}
