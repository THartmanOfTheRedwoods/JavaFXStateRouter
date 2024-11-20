module edu.redwoods.cis18.javafxstaterouter {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.redwoods.cis18.javafxstaterouter to javafx.fxml;
    opens edu.redwoods.cis18.javafxstaterouter.controllers to javafx.fxml;
    opens edu.redwoods.cis18.javafxstaterouter.staterouter to javafx.fxml;
    exports edu.redwoods.cis18.javafxstaterouter;
    exports edu.redwoods.cis18.javafxstaterouter.staterouter;
    exports edu.redwoods.cis18.javafxstaterouter.controllers;
}