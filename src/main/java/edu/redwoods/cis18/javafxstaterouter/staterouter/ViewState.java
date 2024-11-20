package edu.redwoods.cis18.javafxstaterouter.staterouter;

import edu.redwoods.cis18.javafxstaterouter.controllers.MainAppController;
import javafx.event.ActionEvent;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.util.List;

public interface ViewState {
    void showView(Stage stage);
    void transitionToNext(ActionEvent event, MainAppController controller);
}

