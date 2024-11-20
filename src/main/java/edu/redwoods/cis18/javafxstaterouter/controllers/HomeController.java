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

public class HomeController  implements Initializable, MainAppController {
    ViewRouter viewRouter;
    @FXML
    Button btnSettings;
    @FXML
    Button btnProfile;

    public HomeController() {
        // Called First when object is created.
        this.viewRouter = (ViewRouter) MainAppDataSingleton.getInstance().get("router");
        // Set the state router to this controller's state.
        viewRouter.setCurrentState(viewRouter.getHomeViewState());
        // TODO: Maybe add a setController method to ViewStates and set the controllers on first instantiation?
        // Currently we pass the controller during transition, but might be nice to compose a reference.
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Called Second as part of Controller initializable.
    }

    @FXML
    public void transitionToNext(ActionEvent event) {
        viewRouter.transitionToNext(event, this);
    }

    @Override
    public Map<String, Control> getControls() {
        return Map.of("btnProfile", btnProfile, "btnSettings", btnSettings);
    }
}