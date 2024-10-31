package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuInicioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

/**
 * Clase MenuInicioViewController es la principal del programa. Aquí se cambia
 * entre interfaces y se da la bienvenida al usuario.
 */
public class MenuInicioViewController {

    /**
     * Por prácticas, se utiliza siempre una instancia del Controller de la clase
     * para llamar a los métodos necesarios.
     */
    @SuppressWarnings("unused")
    private final MenuInicioController menuInicioController = new MenuInicioController();

    /**
     * Aquí se definen los elementos que integran la interfaz visual.
     */
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

    /**
     * Método que inicializa la interfaz. Es ejecutado automáticamente después de
     * que se cargue el archivo FXML.
     */
    @FXML
    void initialize() {
        configurarBotones(); // Configura las acciones de los botones
    }

    /**
     * Método que, mediante setOnAction, asigna acciones o métodos a ejecutar con
     * cada botón.
     */
    private void configurarBotones() {
        /**
         * Aclaración de la expresión lambda:
         * 'this' hace referencia a la instancia actual de la clase,
         * y '::' se utiliza para referenciar el método llamado de
         * esta clase.
         * Al hacer clic en el botón, el método se ejecuta tomando como argumento la
         * acción del botón.
         */
        btn_registrarVehiculo.setOnAction(this::adminBtnRegistrarVehiculo);
        btn_crearCliente.setOnAction(this::adminBtnCrearCliente);
        btn_realizarReserva.setOnAction(this::adminBtnRealizarReserva);
        btn_verReservas.setOnAction(this::adminBtnVerReservas);
    }

    /**
     * Método que utiliza un método auxiliar para cambiar la interfaz a la de
     * registro vehicular.
     *
     * @param event Acción del botón
     */
    private void adminBtnRegistrarVehiculo(ActionEvent event) {
        cambiarVista("menuRegistroVehicular", 800, 540);
    }

    /**
     * Método que utiliza un método auxiliar para cambiar la interfaz a la de
     * registro de cliente.
     *
     * @param event Acción del botón
     */
    private void adminBtnCrearCliente(ActionEvent event) {
        cambiarVista("menuRegistroDeClientes", 800, 540);
    }

    /**
     * Método que utiliza un método auxiliar para cambiar la interfaz a la de
     * registro de reservas.
     *
     * @param event Acción del botón
     */
    private void adminBtnRealizarReserva(ActionEvent event) {
        cambiarVista("menuRegistrarReservas", 800, 540);
    }

    /**
     * Método que utiliza un método auxiliar para cambiar la interfaz a la de
     * ver reservas.
     *
     * @param event Acción del botón
     */
    private void adminBtnVerReservas(ActionEvent event) {
        cambiarVista("menuVerReservas", 800, 540);
    }

    /**
     * Método que utiliza el método estático e inherente a la clase App para cargar
     * la escena.
     *
     * @param rutaFXML Nombre del archivo FXML
     * @param ancho    Ancho de la ventana
     * @param alto     Alto de la ventana
     */
    private void cambiarVista(String rutaFXML, double ancho, double alto) {
        try {
            App.loadScene(rutaFXML, ancho, alto); // Carga la nueva escena
        } catch (Exception e) {
            App.showAlert("Error al cargar la interfaz", "No se pudo cargar la interfaz: " + rutaFXML, AlertType.ERROR);
        }
    }
}
