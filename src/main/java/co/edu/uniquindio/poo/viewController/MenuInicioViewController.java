package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuInicioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class MenuInicioViewController {

    // Instancia del controlador de lógica de negocio
    private MenuInicioController menuInicioController = new MenuInicioController();

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
    private Button lbl_crearCliente;

    @FXML
    private Button lbl_realizarReserva;

    @FXML
    private Label lbl_titulo;

    @FXML
    private Button lbl_verReservas;

    @FXML
    void initialize() {
        configureButtonActions();
    }

    private void configureButtonActions() {
        btn_registrarVehiculo.setOnAction(this::handleRegistrarVehiculo);
        lbl_crearCliente.setOnAction(this::handleCrearCliente);
        lbl_realizarReserva.setOnAction(this::handleRealizarReserva);
        lbl_verReservas.setOnAction(this::handleVerReservas);
    }

    private void handleRegistrarVehiculo(ActionEvent event) {
        // Llamamos a la lógica de negocio en el controlador
        menuInicioController.registrarVehiculo();
    }

    private void handleCrearCliente(ActionEvent event) {
        menuInicioController.crearCliente();
    }

    private void handleRealizarReserva(ActionEvent event) {
        menuInicioController.realizarReserva();
    }

    private void handleVerReservas(ActionEvent event) {
        menuInicioController.verReservas();
    }
}
