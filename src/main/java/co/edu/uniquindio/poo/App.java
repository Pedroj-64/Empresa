package co.edu.uniquindio.poo;

import java.io.IOException;

import co.edu.uniquindio.poo.model.Empresa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Clase App la central de cualquier programa java en esta misma se utilizan varios metodos correspondientes
 * a la linea de vida de javaFx como "Start"
 */

public class App extends Application {

    private static Scene scene;
    private static Empresa empresa; // Instancia única de Empresa
    
    
    @SuppressWarnings("exports")
    @Override
    /**
     * Metodo Start fundamental en JavaFx es quien inicializa todo al darle play a la app
     */
    public void start(Stage stage) {
        try {
            // Inicializa la Empresa al inicio de la aplicación
            empresa = Empresa.getInstance("mi empresa");
            empresa.crearReservaEjemplo();

            // Carga la escena inicial
            scene = new Scene(loadFXML("menuInicio"), 800, 540);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error al cargar la interfaz", "No se pudo cargar el archivo FXML: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Método para cambiar la raíz de la escena
    public static void loadScene(String fxml, double width, double height) {
        try {
            scene.setRoot(loadFXML(fxml));
            scene.getWindow().setWidth(width);
            scene.getWindow().setHeight(height);
        } catch (IOException e) {
            showAlert("Error al cambiar la vista", "No se pudo cargar el archivo FXML: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Método para cargar FXML
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Método generalizado para mostrar alertas
    @SuppressWarnings("exports")
    public static void showAlert(String title, String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Acceso a la instancia de Empresa desde cualquier parte de la aplicación
    public static Empresa getEmpresa() {
        return empresa;
    }



    public static void main(String[] args) {
        launch();
    }
}
