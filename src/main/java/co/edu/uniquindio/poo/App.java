package co.edu.uniquindio.poo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) {
        try {
            scene = new Scene(loadFXML("menuRegistroVehicular"), 800, 540);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showErrorDialog("Error al cargar la interfaz", "No se pudo cargar el archivo FXML: " + e.getMessage());
        }
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            showErrorDialog("Error al cambiar la vista", "No se pudo cargar el archivo FXML: " + e.getMessage());
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static void showErrorDialog(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}