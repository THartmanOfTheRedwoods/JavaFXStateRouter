module edu.redwoods.cis18.javafxstaterouter {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.redwoods.cis18.javafxstaterouter to javafx.fxml;
    exports edu.redwoods.cis18.javafxstaterouter;
}