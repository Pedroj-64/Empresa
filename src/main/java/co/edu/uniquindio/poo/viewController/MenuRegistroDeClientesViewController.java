package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuRegistroDeClientesController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class MenuRegistroDeClientesViewController {

    private MenuRegistroDeClientesController registroDeClientesController = new MenuRegistroDeClientesController();

    @FXML
    private AnchorPane Screen_05;

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
    private Label lbl_marca2311;

    @FXML
    private Label lbl_nombre;

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_cedula;

    @FXML
    private TextField txt_edad;

    @FXML
    private TextField txt_nombre;

    @FXML
    void initialize() {
        // Configura los botones y campos de texto cuando la vista se inicializa
        configureButtonActions();
    }

    // Configuración de las acciones de los botones
    private void configureButtonActions() {
        // Aquí podrías tener un botón "Registrar" al que se le asigna el evento `handleRegistrarCliente`
        // Por ejemplo: btn_RegistrarCliente.setOnAction(this::handleRegistrarCliente);
    }

    // Método para manejar el evento de registro de cliente
    @FXML
    private void handleRegistrarCliente(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String cedula = txt_cedula.getText();
        int edad;

        // Validación de la edad para asegurar que sea un número
        try {
            edad = Integer.parseInt(txt_edad.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad inválida", "Por favor, ingrese un número válido para la edad.");
            return;
        }

        // Llamada al controlador de lógica de negocio para registrar el cliente
        boolean registrado = registroDeClientesController.registrarCliente(nombre, apellido, cedula, edad);
        if (registrado) {
            mostrarAlerta("Registro exitoso", "El cliente ha sido registrado con éxito.");
            limpiarCampos(); // Limpia los campos después de un registro exitoso
        } else {
            mostrarAlerta("Error en el registro", "Por favor, verifique los datos ingresados.");
        }
    }

    // Método para mostrar alertas de información
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para limpiar los campos de texto después de registrar
    private void limpiarCampos() {
        txt_nombre.clear();
        txt_apellido.clear();
        txt_cedula.clear();
        txt_edad.clear();
    }
}
