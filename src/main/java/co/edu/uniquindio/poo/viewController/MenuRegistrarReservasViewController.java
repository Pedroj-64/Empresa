package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.MenuRegistrarReservasController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class MenuRegistrarReservasViewController {

    // Instancia del controlador de lógica de negocio
    private MenuRegistrarReservasController registrarReservasController = new MenuRegistrarReservasController();

    @FXML
    private AnchorPane Screen_03;

    // Botones para guardar y limpiar reservas
    @FXML
    private Button btn_GuardarReservas;
    @FXML
    private Button btn_limpiarReservas;

    // Etiquetas y campos de texto
    @FXML
    private Label lbl_tituloRegistroDeReservas;
    @FXML
    private TextField txt_dias;        // Campo para los días de reserva
    @FXML
    private TextField txt_placa;       // Campo para la placa del vehículo
    @FXML
    private TextField txt_tipoDeVehiculo; // Campo para el tipo de vehículo
    @FXML
    private TextField txt_cliente;     // Campo para el nombre del cliente

    // ComboBox para seleccionar clientes disponibles
    @FXML
    private ComboBox<Cliente> Combox_Clientes;

    // Tabla para mostrar la lista de vehículos
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
        // Configurar la instancia del controlador
        registrarReservasController.instancia();
        configurarTabla();
        cargarVehiculos();
        configurarListenerTabla();
        configurarAccionesBotones();
        cargarClientes();
    }

    // Método para configurar la tabla de vehículos
    private void configurarTabla() {
        tbc_marca.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMarca()));
        tbc_modelo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getModelo()));
        tbc_placa.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMatricula()));
        tbc_tipoDeVehiculo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getClass().getSimpleName()));
    }

    // Cargar lista de vehículos a la tabla
    private void cargarVehiculos() {
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList(registrarReservasController.obtenerListaVehiculosDisponibles());
        tbl_listaVehiculos.setItems(vehiculos);
    }

    // Cargar clientes en el ComboBox
    private void cargarClientes() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(registrarReservasController.obtenerListaClientes());
        Combox_Clientes.setItems(clientes);
    }

    // Configurar listener para la selección de la tabla
    private void configurarListenerTabla() {
        tbl_listaVehiculos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> rellenarCamposVehiculo(newValue));
    }

    // Rellenar campos con la información del vehículo seleccionado
    private void rellenarCamposVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txt_placa.setText(vehiculo.getMatricula());
            txt_tipoDeVehiculo.setText(vehiculo.getClass().getSimpleName());
        } else {
            txt_placa.clear();
            txt_tipoDeVehiculo.clear();
        }
    }

    // Configurar acciones de los botones
    private void configurarAccionesBotones() {
        btn_GuardarReservas.setOnAction(this::accionGuardarReserva);
        btn_limpiarReservas.setOnAction(this::accionLimpiarReservas);
    }

    // Acción para guardar una reserva
    private void accionGuardarReserva(ActionEvent event) {
        try {
            // Obtener datos del formulario
            String placa = txt_placa.getText();
            String tipoDeVehiculo = txt_tipoDeVehiculo.getText();
            int dias = Integer.parseInt(txt_dias.getText());
            Cliente cliente = Combox_Clientes.getSelectionModel().getSelectedItem();

            if (cliente == null) {
                mostrarAlerta("Error", "Seleccione un cliente.");
                return;
            }

            // Buscar el vehículo por placa y tipo
            Vehiculo vehiculo = registrarReservasController.buscarVehiculoPorPlacaYTipo(placa, tipoDeVehiculo);
            if (vehiculo != null) {
                Reserva reserva = new Reserva(dias, cliente, vehiculo);
                registrarReservasController.guardarReserva(reserva);
                mostrarAlerta("Éxito", "Reserva guardada exitosamente.");
                accionLimpiarReservas(event);
            } else {
                mostrarAlerta("Error", "Vehículo no encontrado.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un valor numérico para los días.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error al guardar la reserva: " + e.getMessage());
        }
    }

    // Acción para limpiar los campos de reserva
    private void accionLimpiarReservas(ActionEvent event) {
        txt_placa.clear();
        txt_tipoDeVehiculo.clear();
        txt_dias.clear();
        Combox_Clientes.getSelectionModel().clearSelection();
    }

    // Mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}





