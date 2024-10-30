package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuRegistroVehicularController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MenuRegistroVehicularViewController {
    private final MenuRegistroVehicularController controladorVehicular = new MenuRegistroVehicularController();

    @FXML
    private ComboBox<String> cmb_TiposDeVehiculo;
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
    private TextField txt_CapacidadDeCarga, txt_Marca, txt_Matricula, txt_Modelo, txt_NumeroDePuertas, txt_TarifaBase;

    @FXML
    void initialize() {
        try {
            configuracionCombo();
            configureButtons();
        } catch (Exception e) {
            App.showAlert("Error de Inicialización", "Error al inicializar la vista: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void configuracionCombo() {
        ObservableList<String> tiposVehiculos = FXCollections.observableArrayList("Auto", "Moto", "Camioneta");
        cmb_TiposDeVehiculo.setItems(tiposVehiculos);
        cmb_TiposDeVehiculo.valueProperty().addListener((obs, oldVal, newVal) -> habilitarCamposEspecificos(newVal));
    }

    private void habilitarCamposEspecificos(String tipoVehiculo) {
        try {
            checkEsCajaAutomatica.setDisable(!"Moto".equals(tipoVehiculo));
            txt_NumeroDePuertas.setDisable(!"Auto".equals(tipoVehiculo));
            txt_CapacidadDeCarga.setDisable(!"Camioneta".equals(tipoVehiculo));
        } catch (Exception e) {
            App.showAlert("Error al Configurar Campos", "Error al habilitar campos específicos para el tipo de vehículo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void configureButtons() {
        btn_guardarVehiculo.setOnAction(event -> registrarVehiculo());
        btn_regresarMenuInicio.setOnAction(this::accionRegresarAlInicio);
    }

    @FXML
    private void registrarVehiculo() {
        if (!validarCampos()) {
            return;
        }

        try {
            String matricula = txt_Matricula.getText();
            String marca = txt_Marca.getText();
            String modelo = txt_Modelo.getText();
            int año = fechaAñoVehiculo.getValue().getYear();
            boolean esAutomatica = checkEsCajaAutomatica.isSelected();
            double tarifaBase = Double.parseDouble(txt_TarifaBase.getText());
            Integer numeroDePuertas = obtenerValorCampo(txt_NumeroDePuertas);
            Integer capacidadDeCarga = obtenerValorCampo(txt_CapacidadDeCarga);
            String tipoVehiculo = cmb_TiposDeVehiculo.getValue();

            boolean registroExitoso = controladorVehicular.registrarVehiculo(matricula, marca, modelo, año, esAutomatica, tipoVehiculo, tarifaBase, numeroDePuertas, capacidadDeCarga);

            mostrarResultadoRegistro(registroExitoso);
        } catch (Exception e) {
            App.showAlert("Error de Registro", "Error inesperado al registrar el vehículo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarResultadoRegistro(boolean exito) {
        if (exito) {
            App.showAlert("Registro Exitoso", "El vehículo ha sido registrado exitosamente.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } else {
            App.showAlert("Error de Registro", "No se pudo registrar el vehículo. Verifique los datos ingresados.", Alert.AlertType.ERROR);
        }
    }

    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            App.showAlert("Error al Cargar Escena", "Ocurrió un error al regresar al menú de inicio: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private boolean validarCampos() {
        try {
            if (esCampoVacio(txt_Matricula) || esCampoVacio(txt_Marca) || esCampoVacio(txt_Modelo) ||
                fechaAñoVehiculo.getValue() == null || esCampoVacio(txt_TarifaBase) ||
                (cmb_TiposDeVehiculo.getValue() == null || cmb_TiposDeVehiculo.getValue().isEmpty())) {
                App.showAlert("Campos Vacíos", "Por favor, llene todos los campos obligatorios.", Alert.AlertType.WARNING);
                return false;
            }
            return validarCamposNumericos();
        } catch (Exception e) {
            App.showAlert("Error de Validación", "Error al validar campos: " + e.getMessage(), Alert.AlertType.ERROR);
            return false;
        }
    }

    private boolean validarCamposNumericos() {
        try {
            Double.parseDouble(txt_TarifaBase.getText());
            if (!txt_NumeroDePuertas.isDisabled() && !txt_NumeroDePuertas.getText().isEmpty()) {
                Integer.parseInt(txt_NumeroDePuertas.getText());
            }
            if (!txt_CapacidadDeCarga.isDisabled() && !txt_CapacidadDeCarga.getText().isEmpty()) {
                Integer.parseInt(txt_CapacidadDeCarga.getText());
            }
        } catch (NumberFormatException e) {
            App.showAlert("Error de Formato", "Verifique que los campos numéricos contienen valores válidos.", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private Integer obtenerValorCampo(TextField campo) {
        try {
            if (campo.isDisabled() || campo.getText().isEmpty()) {
                return 0;
            } else {
                return Integer.parseInt(campo.getText());
            }
        } catch (NumberFormatException e) {
            App.showAlert("Error de Formato", "Error al obtener valor del campo: " + e.getMessage(), Alert.AlertType.WARNING);
            return 0;
        }
    }

    private boolean esCampoVacio(TextField campo) {
        return campo.getText().isEmpty();
    }

    private void limpiarCampos() {
        txt_Matricula.clear();
        txt_Marca.clear();
        txt_Modelo.clear();
        fechaAñoVehiculo.setValue(null);
        txt_TarifaBase.clear();
        txt_NumeroDePuertas.clear();
        txt_CapacidadDeCarga.clear();
        checkEsCajaAutomatica.setSelected(false);
        cmb_TiposDeVehiculo.getSelectionModel().clearSelection();
    }
}
