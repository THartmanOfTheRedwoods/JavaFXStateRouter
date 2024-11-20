package edu.redwoods.cis18.javafxstaterouter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileViewState implements Initializable, ViewState {
    ViewRouter viewRouter;
    @FXML
    Button btnHome;

    // Need an empty constructor since we're also treating this state as a JavaFX controller
    // Thus, we get the application router from the MainAppDataSingleton instead, and update the router with
    // our own java instance in the default constructor.
    /*
    public ProfileViewState(ViewRouter viewRouter) {
        // Called first when object is created.
        this.viewRouter = viewRouter;
    }
    */

    public ProfileViewState() {
        // Called first when object is created.
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Called as part of Controller initializable.
    }

    @Override
    public void showView(Stage stage) {
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
        this.viewRouter.setProfileViewState(this);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Profile View");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    @Override
    public void transitionToNext(ActionEvent event) {
        viewRouter.setCurrentState(viewRouter.getHomeViewState());
        viewRouter.showCurrentView();
    }
}
