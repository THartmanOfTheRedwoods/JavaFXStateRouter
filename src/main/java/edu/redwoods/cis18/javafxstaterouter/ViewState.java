package edu.redwoods.cis18.javafxstaterouter;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public interface ViewState {
    void showView(Stage stage);
    void transitionToNext(ActionEvent event);
}

