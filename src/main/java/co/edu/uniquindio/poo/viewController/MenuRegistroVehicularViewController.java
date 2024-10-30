package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuRegistroVehicularController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    private Button btn_regresarMenuInicio;
    @FXML
    private CheckBox checkEsCajaAutomatica;
    @FXML
    private TextField txtCapacidadDeCarga, txtMarca, txtMatricula, txtModelo, txtNumeroDePuertas, txtTarifaBase;

    @FXML
    void initialize() {
        configureButtons();

    }

    private void populateVehicleTypes() {
        cmbTiposDeVehiculo.getItems().addAll("Auto", "Moto", "Camioneta");
        cmbTiposDeVehiculo.valueProperty().addListener((obs, oldVal, newVal) -> habilitarCamposEspecificos(newVal));
    }

    private void habilitarCamposEspecificos(String tipoVehiculo) {
        checkEsCajaAutomatica.setDisable(!"Moto".equals(tipoVehiculo));
        txtNumeroDePuertas.setDisable(!"Auto".equals(tipoVehiculo));
        txtCapacidadDeCarga.setDisable(!"Camioneta".equals(tipoVehiculo));
    }

    private void configureButtons() {
        btn_guardarVehiculo.setOnAction(event -> registrarVehiculo());
        btn_regresarMenuInicio.setOnAction(this::accionRegresarAlInicio);
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
            Integer numeroDePuertas = txtNumeroDePuertas.isDisabled() ? null
                    : Integer.parseInt(txtNumeroDePuertas.getText());
            Integer capacidadDeCarga = txtCapacidadDeCarga.isDisabled() ? null
                    : Integer.parseInt(txtCapacidadDeCarga.getText());
            String tipoVehiculo = cmbTiposDeVehiculo.getValue();

            boolean registroExitoso = controladorVehicular.registrarVehiculo(matricula, marca, modelo, año,
                    esAutomatica, tipoVehiculo, tarifaBase, numeroDePuertas, capacidadDeCarga);

            if (registroExitoso) {
                App.showAlert("Registro Exitoso", "El vehículo ha sido registrado exitosamente.",
                        Alert.AlertType.INFORMATION);
            } else {
                App.showAlert("Error de Registro", "No se pudo registrar el vehículo. Verifique los datos ingresados.",
                        Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            App.showAlert("Error de Entrada",
                    "Por favor, ingrese un valor numérico válido para la tarifa base, capacidad de carga o número de puertas.",
                    Alert.AlertType.WARNING);
        } catch (Exception e) {
            App.showAlert("Error Inesperado", "Ocurrió un error inesperado: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void accionRegresarAlInicio(ActionEvent event) {
        App.loadScene("menuInicio", 850, 740);
    }
}