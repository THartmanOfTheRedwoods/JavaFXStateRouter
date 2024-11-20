package edu.redwoods.cis18.javafxstaterouter;

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

        // Since we made these states JavaFX controllers, they get instantiated via JavaFX
        // The ViewRouter is grabbed via a singleton
        // Could get these via the app, but just as easy to set them via setters.
        /*
        homeViewState = new HomeViewState(this);
        settingsViewState = new SettingsViewState(this);
        profileViewState = new ProfileViewState(this);

        currentState = homeViewState; // Default to Home View
        */
        homeViewState = new HomeViewState();
        settingsViewState = new SettingsViewState();
        profileViewState = new ProfileViewState();

        currentState = homeViewState; // Default to Home View
    }

    public void showCurrentView() {
        currentState.showView(stage);
    }

    public void transitionToNext(ActionEvent event) {
        currentState.transitionToNext(event);
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

