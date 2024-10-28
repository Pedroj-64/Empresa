package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuRegistrarReservasController;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class MenuRegistrarReservasViewController {

    private MenuRegistrarReservasController registrarReservasController = new MenuRegistrarReservasController();

    @FXML
    private AnchorPane Screen_03;

    @FXML
    private Button btn_GuardarReservas;

    @FXML
    private Button btn_limpiarReservas;

    @FXML
    private Label lbl_marca;

    @FXML
    private Label lbl_marca1;

    @FXML
    private Label lbl_marca11;

    @FXML
    private Label lbl_tituloRegistroDeReservas;

    @FXML
    private TableColumn<Vehiculo, String> tbc_marca;

    @FXML
    private TableColumn<Vehiculo, String> tbc_modelo;

    @FXML
    private TableColumn<Vehiculo, String> tbc_placa;

    @FXML
    private TableColumn<Vehiculo, String> tbc_tipoDeVehiculo;

    @FXML
    private TableView<Vehiculo> tbl_listaVehiculos;

    @FXML
    void initialize() {
        configureTable();
        loadVehiculos();
        configureButtonActions();
    }

    private void configureTable() {
        // Configura las columnas de la tabla con los atributos del modelo Vehiculo
        tbc_marca.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());
        tbc_modelo.setCellValueFactory(cellData -> cellData.getValue().modeloProperty());
        tbc_placa.setCellValueFactory(cellData -> cellData.getValue().placaProperty());
        tbc_tipoDeVehiculo.setCellValueFactory(cellData -> cellData.getValue().tipoDeVehiculoProperty());
    }

    private void loadVehiculos() {
        // Carga la lista de vehículos en la tabla
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList(registrarReservasController.obtenerListaVehiculosDisponibles());
        tbl_listaVehiculos.setItems(vehiculos);
    }

    private void configureButtonActions() {
        btn_GuardarReservas.setOnAction(this::handleGuardarReserva);
        btn_limpiarReservas.setOnAction(this::handleLimpiarReservas);
    }

    private void handleGuardarReserva(ActionEvent event) {
        // TODO: Crear un objeto Reserva y pasar los datos necesarios
        Reserva reserva = new Reserva(); // Aquí se deben asignar los datos necesarios
        registrarReservasController.guardarReserva(reserva);
        System.out.println("Reserva guardada.");
    }

    private void handleLimpiarReservas(ActionEvent event) {
        registrarReservasController.limpiarReservas();
        System.out.println("Reservas limpiadas.");
    }
}
