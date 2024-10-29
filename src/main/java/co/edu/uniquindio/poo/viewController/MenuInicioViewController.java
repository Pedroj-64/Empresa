package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuInicioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MenuInicioViewController {

    MenuInicioController menuInicioController = new MenuInicioController();

    @FXML
    private Button btn_registrarVehiculo;
    @FXML
    private AnchorPane img_Carro;
    @FXML
    private ImageView img_Persona;
    @FXML
    private ImageView img_calendario;
    @FXML
    private ImageView img_carro;
    @FXML
    private ImageView img_ojo;
    @FXML
    private Button btn_crearCliente;
    @FXML
    private Button btn_realizarReserva;
    @FXML
    private Label lbl_titulo;
    @FXML
    private Button btn_verReservas;

    @FXML
    void initialize() {
        menuInicioController.instancia();
        configurarBotones();
        
    }

    private void configurarBotones() {
        btn_registrarVehiculo.setOnAction(this::adminBtnRegistrarVehiculo);
        btn_crearCliente.setOnAction(this::adminBtnCrearCliente);
        btn_realizarReserva.setOnAction(this::adminBtnRealizarReserva);
        btn_verReservas.setOnAction(this::adminBtnVerReservas);
    }

    private void adminBtnRegistrarVehiculo(ActionEvent event) {
        cargarInterfaz("/resource/menuRegistroVehicular.fxml", event);
    }

    private void adminBtnCrearCliente(ActionEvent event) {
        cargarInterfaz("menuRegistroDeClientes.fxml", event);
    }

    private void adminBtnRealizarReserva(ActionEvent event) {
        cargarInterfaz("menuRegistrarReservas.fxml", event);
    }

    private void adminBtnVerReservas(ActionEvent event) {
        cargarInterfaz("menuVerReservas.fxml", event);
    }

    private void cargarInterfaz(String rutaFXML, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlertaError("Error al cargar la interfaz", "No se pudo cargar la interfaz: " + rutaFXML);
        }
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}






