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

public class MenuInicioViewController {

    private final MenuInicioController menuInicioController = new MenuInicioController();

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

        configurarBotones();
        
    }

    private void configurarBotones() {
        btn_registrarVehiculo.setOnAction(this::adminBtnRegistrarVehiculo);
        btn_crearCliente.setOnAction(this::adminBtnCrearCliente);
        btn_realizarReserva.setOnAction(this::adminBtnRealizarReserva);
        btn_verReservas.setOnAction(this::adminBtnVerReservas);
    }

    private void adminBtnRegistrarVehiculo(ActionEvent event) {
        cambiarVista("menuRegistroVehicular", 800, 540);
    }

    private void adminBtnCrearCliente(ActionEvent event) {
        cambiarVista("menuRegistroDeClientes", 800, 540);
    }

    private void adminBtnRealizarReserva(ActionEvent event) {
        cambiarVista("menuRegistrarReservas", 800, 540);
    }

    private void adminBtnVerReservas(ActionEvent event) {
        cambiarVista("menuVerReservas", 800, 540);
    }

    private void cambiarVista(String rutaFXML, double ancho, double alto) {
        try {
            App.loadScene(rutaFXML, ancho, alto);
        } catch (Exception e) {
            App.showAlert("Error al cargar la interfaz", "No se pudo cargar la interfaz: " + rutaFXML, AlertType.ERROR);
        }
    }

}


