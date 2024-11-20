package edu.redwoods.cis18.javafxstaterouter.staterouter;

import edu.redwoods.cis18.javafxstaterouter.controllers.MainAppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SettingsViewState implements ViewState {
    ViewRouter viewRouter;

    public SettingsViewState(ViewRouter viewRouter) {
        // Called first when object is created.
        this.viewRouter = viewRouter;
    }

    @Override
    public void showView(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsView.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Settings View");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transitionToNext(ActionEvent event, MainAppController controller) {
        viewRouter.setCurrentState(viewRouter.getHomeViewState());
        viewRouter.showCurrentView();
    }
}