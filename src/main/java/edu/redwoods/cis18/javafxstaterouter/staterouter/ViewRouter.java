package edu.redwoods.cis18.javafxstaterouter.staterouter;

import edu.redwoods.cis18.javafxstaterouter.controllers.MainAppController;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ViewRouter {

    ViewState homeViewState;
    ViewState settingsViewState;
    ViewState profileViewState;

    ViewState currentState;
    Stage stage;

    public ViewRouter(Stage stage) {
        this.stage = stage;

        homeViewState = new HomeViewState(this);
        settingsViewState = new SettingsViewState(this);
        profileViewState = new ProfileViewState(this);

        currentState = homeViewState; // Default to Home View
    }

    public void showCurrentView() {
        currentState.showView(stage);
    }

    public void transitionToNext(ActionEvent event, MainAppController controller) {
        currentState.transitionToNext(event, controller);
    }

    public void setCurrentState(ViewState state) {
        this.currentState = state;
    }

    // Getters and Setters for different states
    public ViewState getHomeViewState() {
        return homeViewState;
    }

    public ViewState getSettingsViewState() {
        return settingsViewState;
    }

    public ViewState getProfileViewState() {
        return profileViewState;
    }

    public void setHomeViewState(ViewState state) {
        this.homeViewState = state;
    }

    public void setProfileViewState(ViewState state) {
        this.profileViewState = state;
    }

    public void setSettingsViewState(ViewState state) {
        this.settingsViewState = state;
    }
}