package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuRegistrarReservasController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MenuRegistrarReservasViewController {
    private final MenuRegistrarReservasController registrarReservasController = new MenuRegistrarReservasController();

    @FXML
    private AnchorPane Screen_03;
    @FXML
    private Button btn_GuardarReservas;
    @FXML
    private Button btn_limpiarReservas;
    @FXML
    private Button btn_regresarAlInicio;
    @FXML
    private TextField txt_dias;
    @FXML
    private TextField txt_placa;
    @FXML
    private TextField txt_tipoDeVehiculo;
    @FXML
    private ComboBox<Cliente> cmb_Clientes;
    @FXML
    private TableView<Vehiculo> tbl_listaVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> tbc_marca;
    @FXML
    private TableColumn<Vehiculo, String> tbc_modelo;
    @FXML
    private TableColumn<Vehiculo, String> tbc_placa;
    @FXML
    private TableColumn<Vehiculo, String> tbc_tipoDeVehiculo;

    @FXML
    void initialize() {
        configurarTabla();
        configurarAccionesBotones();
        cargarDatos();
    }

    private void configurarTabla() {
        tbc_marca.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMarca()));
        tbc_modelo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getModelo()));
        tbc_placa.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMatricula()));
        tbc_tipoDeVehiculo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getClass().getSimpleName()));
    }

    private void cargarDatos() {
        cargarVehiculos();
        cargarClientes();
        configurarListenerTabla();
    }

    private void cargarVehiculos() {
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList(App.getEmpresa().getVehiculosDisponibles());
        tbl_listaVehiculos.setItems(vehiculos);
    }

    private void cargarClientes() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(App.getEmpresa().getClientes());
        cmb_Clientes.setItems(clientes);
    }

    private void configurarListenerTabla() {
        tbl_listaVehiculos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txt_tipoDeVehiculo.setText(newValue.getClass().getSimpleName());
                txt_placa.setText(newValue.getMatricula());
            } else {
                limpiarCampos();
            }
        });
    }

    private void configurarAccionesBotones() {
        btn_GuardarReservas.setOnAction(this::accionGuardarReserva);
        btn_limpiarReservas.setOnAction(event -> limpiarCampos());
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio);
    }

    private void accionGuardarReserva(ActionEvent event) {
        try {
            String placa = txt_placa.getText();
            if (placa.isEmpty()) {
                App.showAlert("Error", "La placa no puede estar vacía.", Alert.AlertType.ERROR);
                return;
            }
            int dias;
            try {
                dias = Integer.parseInt(txt_dias.getText());
            } catch (NumberFormatException e) {
                App.showAlert("Error", "Ingrese un valor numérico válido para los días.", Alert.AlertType.ERROR);
                return;
            }
            Cliente cliente = cmb_Clientes.getSelectionModel().getSelectedItem();
            if (cliente == null) {
                App.showAlert("Error", "Seleccione un cliente.", Alert.AlertType.ERROR);
                return;
            }
            Vehiculo vehiculo = registrarReservasController.buscarVehiculoPorPlaca(placa);
            if (vehiculo != null) {
                Reserva reserva = new Reserva(dias, cliente, vehiculo);
                registrarReservasController.guardarReserva(reserva);
                App.showAlert("Éxito", "Reserva guardada exitosamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                App.showAlert("Error", "Vehículo no encontrado.", Alert.AlertType.ERROR);
                limpiarCampos(); // Limpia los campos si el vehículo no se encuentra
            }
        } catch (Exception e) {
            App.showAlert("Error inesperado", "Ha ocurrido un error inesperado. Detalle: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace(); // Para más detalles en la consola
        }
    }

    private void limpiarCampos() {
        txt_placa.clear();
        txt_dias.clear();
        cmb_Clientes.getSelectionModel().clearSelection();
    }

    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            App.showAlert("Error al Cargar Escena", "Ocurrió un error al regresar al menú de inicio.", Alert.AlertType.ERROR);
        }
    }
}
