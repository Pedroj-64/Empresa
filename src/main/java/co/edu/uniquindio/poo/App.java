package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.controller.ReservaController;
import co.edu.uniquindio.poo.viewController.MenuVerReservarViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private ReservaController reservaController;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Inicializar el controlador de negocio
            reservaController = new ReservaController();

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/view/menuVerReservas.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista desde el FXML
            MenuVerReservarViewController viewController = loader.getController();
            
            // Pasar la instancia del ReservaController al ViewController
            viewController.setReservaController(reservaController);
            viewController.actualizarTabla(); // Llamamos para actualizar la tabla al iniciar la aplicación

            // Configurar la escena y mostrarla
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sistema de Gestión de Reservas");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
