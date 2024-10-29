package co.edu.uniquindio.poo.viewController;

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
    private MenuRegistroDeClientesController registroDeClientesController = new MenuRegistroDeClientesController();

    @FXML
    private AnchorPane Screen_05;

    @FXML
    private Button btn_guardar; // Botón para guardar el registro de cliente

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
        // Llamada inicial para asegurar que `Empresa` esté instanciada si no lo está ya (en caso de usar Singleton)
        registroDeClientesController.instancia(); 
        // Configura las acciones de los botones al iniciar la vista
        configureButtonActions();
    }

    // Configuración de las acciones de los botones
    private void configureButtonActions() {
        // Asocia el botón 'guardar' al método que registra el cliente
        btn_guardar.setOnAction(this::handleRegistrarCliente);
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
            mostrarAlerta("Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }
    
        // Validación de la edad
        try {
            edad = Integer.parseInt(txt_edad.getText());
            if (edad < 0 || edad > 120) {
                mostrarAlerta("Edad inválida", "Por favor, ingrese una edad válida entre 0 y 120.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad inválida", "Por favor, ingrese un número válido para la edad.");
            return;
        }
    
        // Validación de la cédula
        if (!cedula.matches("\\d+")) {
            mostrarAlerta("Cédula inválida", "La cédula debe contener solo números.");
            return;
        }
    
        // Llamada al controlador de lógica de negocio para registrar el cliente
        boolean registrado = registroDeClientesController.registrarCliente(nombre, apellido, cedula, edad);
        
        if (registrado) {
            mostrarAlerta("Registro exitoso", "El cliente ha sido registrado con éxito.");
            limpiarCampos();
        } else {
            mostrarAlerta("Error en el registro", "Por favor, verifique los datos ingresados.");
        }
    }

    // Método para mostrar alertas de información
    private void mostrarAlerta(String titulo, String mensaje) {
        // Crea una alerta de tipo Información con el título y mensaje proporcionados
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait(); // Muestra y espera hasta que el usuario cierre la alerta
    }

    // Método para limpiar los campos de texto después de registrar
    private void limpiarCampos() {
        // Limpia todos los campos de texto para que queden vacíos
        txt_nombre.clear();
        txt_apellido.clear();
        txt_cedula.clear();
        txt_edad.clear();
    }
}
