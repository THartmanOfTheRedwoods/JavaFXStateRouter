package edu.redwoods.cis18.javafxstaterouter.controllers;

import edu.redwoods.cis18.javafxstaterouter.MainAppDataSingleton;
import edu.redwoods.cis18.javafxstaterouter.staterouter.ViewRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ProfileController implements Initializable, MainAppController {
    ViewRouter viewRouter;
    @FXML
    Button btnHome;

    public ProfileController() {
        // Called first when object is created.
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
        viewRouter.setCurrentState(viewRouter.getProfileViewState());
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Called as part of Controller initializable.
    }

    @FXML
    public void transitionToNext(ActionEvent event) {
        viewRouter.transitionToNext(event, this);
    }

    @Override
    public Map<String, Control> getControls() {
        return Map.of("btnHome", btnHome);
    }
}
