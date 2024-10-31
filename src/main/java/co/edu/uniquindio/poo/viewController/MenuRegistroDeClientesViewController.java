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

/**
 * Clase MenuRegistroDeClientesViewController maneja la lógica de la interfaz de
 * registro de clientes.
 */
public class MenuRegistroDeClientesViewController {

    // Controlador para gestionar las operaciones de registro de clientes
    private final MenuRegistroDeClientesController registroDeClientesController = new MenuRegistroDeClientesController();

    // Elementos de la interfaz definidos en el archivo FXML
    @FXML
    private AnchorPane Screen_05;
    @FXML
    private Button btn_guardar;
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
    private TextField txt_apellido;
    @FXML
    private TextField txt_cedula;
    @FXML
    private TextField txt_edad;
    @FXML
    private TextField txt_nombre;

    /**
     * Método que inicializa la interfaz y se ejecuta automáticamente después de
     * cargar el archivo FXML.
     */
    @FXML
    void initialize() {
        registroDeClientesController.instancia(); // Inicializa el controlador
        configureButtonActions(); // Configura las acciones de los botones
    }

    /**
     * Configura las acciones de los botones mediante expresiones lambda.
     */
    private void configureButtonActions() {
        btn_guardar.setOnAction(this::accionRegistrarCliente); // Asigna acción al botón de guardar
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio); // Asigna acción al botón de regresar al inicio
    }

    /**
     * Maneja el evento de registro de un cliente.
     * 
     * @param event Evento de acción del botón
     */
    @FXML
    private void accionRegistrarCliente(ActionEvent event) {
        try {
            if (!validarCampos())
                return; // Valida los campos de entrada
            String nombre = txt_nombre.getText();
            String apellido = txt_apellido.getText();
            String cedula = txt_cedula.getText();
            int edad = validarEdad(txt_edad.getText());
            if (!cedula.matches("\\d+")) { // Valida que la cédula contenga solo números
                App.showAlert("Cédula inválida", "La cédula debe contener solo números.", Alert.AlertType.ERROR);
                return;
            }
            boolean registrado = registroDeClientesController.registrarCliente(nombre, apellido, cedula, edad);
            if (registrado) {
                App.showAlert("Registro exitoso", "El cliente ha sido registrado con éxito.",
                        Alert.AlertType.INFORMATION);
                limpiarCampos(); // Limpia los campos después de registrar el cliente
            } else {
                App.showAlert("Error en el registro", "Por favor, verifique los datos ingresados.",
                        Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            App.showAlert("Formato de edad incorrecto", "La edad debe ser un número entero.", Alert.AlertType.ERROR);
        } catch (IllegalArgumentException e) {
            App.showAlert("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            App.showAlert("Error inesperado", "Ha ocurrido un error. Por favor intente nuevamente.",
                    Alert.AlertType.ERROR);
        }
    }

    /**
     * Valida que todos los campos de entrada estén completos.
     * 
     * @return true si todos los campos están completos, false de lo contrario
     */
    private boolean validarCampos() {
        if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_cedula.getText().isEmpty()
                || txt_edad.getText().isEmpty()) {
            App.showAlert("Campos vacíos", "Por favor, complete todos los campos.", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    /**
     * Valida que la edad esté en un rango aceptable.
     * 
     * @param edadTexto Texto que representa la edad
     * @return la edad convertida a entero
     * @throws IllegalArgumentException si la edad no es válida
     */
    private int validarEdad(String edadTexto) throws IllegalArgumentException {
        int edad = Integer.parseInt(edadTexto);
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
        }
        return edad;
    }

    /**
     * Limpia los campos de entrada.
     */
    private void limpiarCampos() {
        txt_nombre.clear();
        txt_apellido.clear();
        txt_cedula.clear();
        txt_edad.clear();
    }

    /**
     * Maneja la acción de regresar al menú de inicio.
     * 
     * @param event Evento de acción del botón
     */
    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540); // Carga la escena del menú de inicio
        } catch (Exception e) {
            App.showAlert("Error al Cargar Escena", "Ocurrió un error al regresar al menú de inicio: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }
}
