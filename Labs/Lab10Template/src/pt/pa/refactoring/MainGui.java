package pt.pa.refactoring;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author amfs
 */
public class MainGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int width = 700, height = 600;

        GUIReviews guiReviews = new GUIReviews(width);

        Scene scene = new Scene(guiReviews,width,height);

        stage.setTitle("Product review");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}

