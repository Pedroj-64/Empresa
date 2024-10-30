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
    private ComboBox<String> combo_tipoDeVehiculo;
    @FXML
    private ComboBox<Cliente> Combox_Clientes;
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
        configurarComboTipoDeVehiculo();
        configurarListenerTabla();
    }

    private void cargarVehiculos() {
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList(App.getEmpresa().getVehiculosDisponibles());
        tbl_listaVehiculos.setItems(vehiculos);
    }

    private void cargarClientes() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(App.getEmpresa().getClientes());
        Combox_Clientes.setItems(clientes);
    }

    private void configurarComboTipoDeVehiculo() {
        combo_tipoDeVehiculo.setItems(FXCollections.observableArrayList("Auto", "Moto", "Camioneta"));
    }

    private void configurarListenerTabla() {
        tbl_listaVehiculos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txt_placa.setText(newValue.getMatricula());
                combo_tipoDeVehiculo.setValue(newValue.getClass().getSimpleName());
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
            String tipoDeVehiculo = combo_tipoDeVehiculo.getValue();
            int dias = Integer.parseInt(txt_dias.getText());
            Cliente cliente = Combox_Clientes.getSelectionModel().getSelectedItem();
            if (cliente == null || tipoDeVehiculo == null) {
                App.showAlert("Error", "Seleccione un cliente y tipo de vehículo.", Alert.AlertType.ERROR);
                return;
            }
            Vehiculo vehiculo = registrarReservasController.buscarVehiculoPorPlacaYTipo(placa, tipoDeVehiculo);
            if (vehiculo != null) {
                Reserva reserva = new Reserva(dias, cliente, vehiculo);
                App.getEmpresa().agregarReserva(reserva);
                App.showAlert("Éxito", "Reserva guardada exitosamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                App.showAlert("Error", "Vehículo no encontrado.", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            App.showAlert("Error", "Ingrese un valor numérico para los días.", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txt_placa.clear();
        combo_tipoDeVehiculo.getSelectionModel().clearSelection();
        txt_dias.clear();
        Combox_Clientes.getSelectionModel().clearSelection();
    }

    private void accionRegresarAlInicio(ActionEvent event) {
        App.loadScene("menuInicio", 850, 740);
    }
    
}
