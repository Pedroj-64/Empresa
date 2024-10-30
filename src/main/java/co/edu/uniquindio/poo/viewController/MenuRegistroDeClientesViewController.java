package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuRegistroDeClientesController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class MenuRegistroDeClientesViewController {

    // Instancia del controlador que gestiona la lógica de negocio
    private final MenuRegistroDeClientesController registroDeClientesController = new MenuRegistroDeClientesController();

    @FXML
    private AnchorPane Screen_05;

    @FXML
    private Button btn_guardar; // Botón para guardar el registro de cliente

    @FXML
    private Button btn_regresarAlInicio;

    @FXML
    private Label lbl_TituloRegistroCliente;

    @FXML
    private Label lbl_TituloRegistroVehicular1;

    @FXML
    private Label lbl_apellido;

    @FXML
    private Label lbl_cedula;

    @FXML
    private Label lbl_edad;

    @FXML
    private Label lbl_nombre;

    @FXML
    private TextField txt_apellido; // Campo de texto para el apellido del cliente

    @FXML
    private TextField txt_cedula; // Campo de texto para la cédula del cliente

    @FXML
    private TextField txt_edad; // Campo de texto para la edad del cliente

    @FXML
    private TextField txt_nombre; // Campo de texto para el nombre del cliente

    @FXML
    void initialize() {
        configureButtonActions();
        registroDeClientesController.instancia();
    }

    // Configuración de las acciones de los botones
    private void configureButtonActions() {
        btn_guardar.setOnAction(this::handleRegistrarCliente);
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio);
    }

    // Método para manejar el evento de registro de cliente
    @FXML
    private void handleRegistrarCliente(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String cedula = txt_cedula.getText();
        int edad;

        // Validación de campos vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || txt_edad.getText().isEmpty()) {
            App.showAlert("Campos vacíos", "Por favor, complete todos los campos.", Alert.AlertType.ERROR);
            return;
        }

        // Validación de la edad
        try {
            edad = Integer.parseInt(txt_edad.getText());
            if (edad < 0 || edad > 120) {
                App.showAlert("Edad inválida", "Por favor, ingrese una edad válida entre 0 y 120.", Alert.AlertType.ERROR);
                return;
            }
        } catch (NumberFormatException e) {
            App.showAlert("Edad inválida", "Por favor, ingrese un número válido para la edad.", Alert.AlertType.ERROR);
            return;
        }

        // Validación de la cédula
        if (!cedula.matches("\\d+")) {
            App.showAlert("Cédula inválida", "La cédula debe contener solo números.", Alert.AlertType.ERROR);
            return;
        }

        // Llamada al controlador de lógica de negocio para registrar el cliente
        boolean registrado = registroDeClientesController.registrarCliente(nombre, apellido, cedula, edad);

        if (registrado) {
            App.showAlert("Registro exitoso", "El cliente ha sido registrado con éxito.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } else {
            App.showAlert("Error en el registro", "Por favor, verifique los datos ingresados.", Alert.AlertType.ERROR);
        }
    }

    // Método para limpiar los campos de texto después de registrar
    private void limpiarCampos() {
        txt_nombre.clear();
        txt_apellido.clear();
        txt_cedula.clear();
        txt_edad.clear();
    }
    private void accionRegresarAlInicio(ActionEvent event) {
        App.loadScene("menuInicio", 850, 740);
    }
}
