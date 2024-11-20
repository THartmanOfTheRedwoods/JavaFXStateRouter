package edu.redwoods.cis18.javafxstaterouter;

import edu.redwoods.cis18.javafxstaterouter.staterouter.ViewRouter;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ViewRouter viewRouter = new ViewRouter(primaryStage);
        // Store our router in the Application singleton so controllers can easily access it.
        MainAppDataSingleton.getInstance().add("router", viewRouter);
        viewRouter.showCurrentView(); // Start with Home View
    }

    public static void main(String[] args) {
        launch(args);
    }
}
