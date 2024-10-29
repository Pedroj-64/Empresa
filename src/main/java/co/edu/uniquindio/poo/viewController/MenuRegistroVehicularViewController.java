package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuRegistroVehicularController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;

public class MenuRegistroVehicularViewController {

    private MenuRegistroVehicularController controladorVehicular = new MenuRegistroVehicularController();

    @FXML
    private ComboBox<String> cmbTiposDeVehiculo;
    @FXML
    private DatePicker fechaAñoVehiculo;
    @FXML
    private AnchorPane pantallaRegistro;
    @FXML
    private Button btn_guardarVehiculo;
    @FXML
    private CheckBox checkEsCajaAutomatica;
    @FXML
    private Label lblAño, lblTituloRegistroVehicular, lblAclaracionEnEntero, lblAclaracionEnEntero2,
                  lblCapacidadDeCarga, lblDatosAdicionales, lblMarca, lblMatricula, lblModelo, 
                  lblNumeroDePuertas, lblTarifaBase, lblTipoDeVehiculo;
    @FXML
    private TextField txtCapacidadDeCarga, txtMarca, txtMatricula, txtModelo, txtNumeroDePuertas, txtTarifaBase;

    @FXML
    void initialize() {
        controladorVehicular.instancia();
        cmbTiposDeVehiculo.getItems().addAll("Auto", "Moto", "Camioneta");
        // Listener para habilitar los campos específicos según el tipo seleccionado
        cmbTiposDeVehiculo.valueProperty().addListener((obs, oldVal, newVal) -> habilitarCamposEspecificos(newVal));
    }

    // Método para habilitar/deshabilitar campos específicos
    private void habilitarCamposEspecificos(String tipoVehiculo) {
        // Deshabilitar todos los campos específicos al cambiar de opción
        checkEsCajaAutomatica.setDisable(true);
        txtNumeroDePuertas.setDisable(true);
        txtCapacidadDeCarga.setDisable(true);

        if ("Moto".equals(tipoVehiculo)) {
            checkEsCajaAutomatica.setDisable(false); // Habilitar solo para motos
        } else if ("Auto".equals(tipoVehiculo)) {
            txtNumeroDePuertas.setDisable(false); // Habilitar solo para autos
        } else if ("Camioneta".equals(tipoVehiculo)) {
            txtCapacidadDeCarga.setDisable(false); // Habilitar solo para camionetas
        }
    }

    @FXML
    private void registrarVehiculo() {
        try {
            String matricula = txtMatricula.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int año = fechaAñoVehiculo.getValue().getYear();
            boolean esAutomatica = checkEsCajaAutomatica.isSelected();
            double tarifaBase = Double.parseDouble(txtTarifaBase.getText());
            Integer numeroDePuertas = txtNumeroDePuertas.isDisabled() ? null : Integer.parseInt(txtNumeroDePuertas.getText());
            Integer capacidadDeCarga = txtCapacidadDeCarga.isDisabled() ? null : Integer.parseInt(txtCapacidadDeCarga.getText());
    
            // Obtener el tipo de vehículo directamente del ComboBox
            String tipoVehiculo = cmbTiposDeVehiculo.getValue();
    
            boolean registroExitoso = controladorVehicular.registrarVehiculo(matricula, marca, modelo, año, esAutomatica, tipoVehiculo, tarifaBase, numeroDePuertas, capacidadDeCarga);
    
            if (registroExitoso) {
                mostrarAlerta("Registro Exitoso", "El vehículo ha sido registrado exitosamente.");
            } else {
                mostrarAlerta("Error de Registro", "No se pudo registrar el vehículo. Verifique los datos ingresados.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Entrada", "Por favor, ingrese un valor numérico válido para la tarifa base, capacidad de carga o número de puertas.");
        } catch (Exception e) {
            mostrarAlerta("Error Inesperado", "Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
