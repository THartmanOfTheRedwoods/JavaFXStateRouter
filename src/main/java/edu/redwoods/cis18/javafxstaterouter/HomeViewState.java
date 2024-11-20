package edu.redwoods.cis18.javafxstaterouter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeViewState implements Initializable, ViewState {
    ViewRouter viewRouter;
    @FXML
    Button btnSettings;
    @FXML
    Button btnProfile;

    // Need an empty constructor since we're also treating this state as a JavaFX controller
    // Thus, we get the application router from the MainAppDataSingleton instead, and update the router with
    // our own java instance in the default constructor.
    /*
    public HomeViewState(ViewRouter viewRouter) {
        // Called first when object is created.
        this.viewRouter = viewRouter;
    }
    */

    public HomeViewState() {
        // Called First when object is created.
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Called Second as part of Controller initializable.
    }

    @Override
    public void showView(Stage stage) {
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
        this.viewRouter.setHomeViewState(this);
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomeView.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle("Home View");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    @Override
    public void transitionToNext(ActionEvent event) {
        if(event.getSource().equals(btnSettings)) {
            viewRouter.setCurrentState(viewRouter.getSettingsViewState());
        } else if (event.getSource().equals(btnProfile)) {
            viewRouter.setCurrentState(viewRouter.getProfileViewState());
        }
        viewRouter.showCurrentView();
    }

}

