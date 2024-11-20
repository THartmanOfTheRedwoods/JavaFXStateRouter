package edu.redwoods.cis18.javafxstaterouter.staterouter;

import edu.redwoods.cis18.javafxstaterouter.controllers.MainAppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HomeViewState implements ViewState {
    ViewRouter viewRouter;

    public HomeViewState(ViewRouter viewRouter) {
        // Called first when object is created.
        this.viewRouter = viewRouter;
    }

    @Override
    public void showView(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomeView.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Home View");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transitionToNext(ActionEvent event, MainAppController controller) {
        if(event.getSource().equals(controller.getControls().get("btnSettings"))) {
            viewRouter.setCurrentState(viewRouter.getSettingsViewState());
        } else if (event.getSource().equals(controller.getControls().get("btnProfile"))) {
            viewRouter.setCurrentState(viewRouter.getProfileViewState());
        }
        viewRouter.showCurrentView();
    }

}

