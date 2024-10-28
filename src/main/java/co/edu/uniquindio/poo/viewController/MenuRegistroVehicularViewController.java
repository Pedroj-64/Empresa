package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuRegistroVehicularController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MenuRegistroVehicularViewController {

    // Instancia del controlador de negocio
    private MenuRegistroVehicularController vehicleController = new MenuRegistroVehicularController();

    @FXML
    private ComboBox<String> Cmbox_tiposDeVehiculo;
    @FXML
    private DatePicker Date_añoVehiculo;
    @FXML
    private AnchorPane Screen_02;
    @FXML
    private CheckBox check_esCajaAutomatica;
    @FXML
    private Label lbl_Año;
    @FXML
    private Label lbl_TituloRegistroVehicular;
    @FXML
    private TextField txt_capacidadDeCarga;
    @FXML
    private TextField txt_marca;
    @FXML
    private TextField txt_matricula;
    @FXML
    private TextField txt_modelo;
    @FXML
    private TextField txt_numeroDePuertas;

    // Método que inicializa la interfaz
    @FXML
    void initialize() {
        // Rellena el ComboBox con opciones de tipos de vehículo
        Cmbox_tiposDeVehiculo.getItems().addAll("Auto", "Moto", "Camioneta");
    }

    // Método que maneja el evento de registrar un vehículo
    @FXML
    private void onRegisterVehicle() {
        String matricula = txt_matricula.getText();
        String marca = txt_marca.getText();
        String modelo = txt_modelo.getText();
        int año = Date_añoVehiculo.getValue().getYear();
        boolean esAutomatica = check_esCajaAutomatica.isSelected();
        String tipoVehiculo = Cmbox_tiposDeVehiculo.getValue();

        // Llamada al método registerVehicle en el controlador de negocio
        boolean isRegistered = vehicleController.registerVehicle(matricula, marca, modelo, año, esAutomatica, tipoVehiculo);

        // Muestra una alerta si el registro es exitoso
        if (isRegistered) {
            showAlert("Registro Exitoso", "El vehículo ha sido registrado exitosamente.");
        } else {
            showAlert("Error de Registro", "No se pudo registrar el vehículo.");
        }
    }

    // Método auxiliar para mostrar una alerta
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
