package co.edu.uniquindio.poo.viewController;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuVerReservarController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class MenuVerReservarViewController {

    // Controlador que maneja la lógica de negocio de las reservas
    private MenuVerReservarController reservaController = new MenuVerReservarController();

    // Lista observable que contiene las reservas
    private ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();

    // Elementos de la interfaz de usuario
    @FXML
    private AnchorPane Screen_04;
    @FXML
    private Button btn_eliminarSeleccion;
    @FXML
    private Button btn_regresarAlInicio;
    @FXML
    private Label lbl_tituloRegistroDeReservas;
    @FXML
    private TableColumn<Reserva, Cliente> tbc_cliente;
    @FXML
    private TableColumn<Reserva, Integer> tbc_dias;
    @FXML
    private TableColumn<Reserva, LocalDate> tbc_fechaDeInicio;
    @FXML
    private TableColumn<Reserva, String> tbc_tipoDeVehiculo;
    @FXML
    private TableColumn<Reserva, Double> tbc_totalCosto;
    @FXML
    private TableView<Reserva> tbl_verReservas;

    // Método inicializador que configura la vista y sus componentes
    @FXML
    void initialize() {
        try {
            // Inicializa el controlador de reservas
            reservaController.instancia();
            // Configura las columnas de la tabla
            configurarColumnas();
            // Carga las reservas en la tabla
            cargarReservas();
            // Configura los listeners de los eventos
            configuracionListener();
            // Configura las acciones de los botones
            configurarAccionesBotones();
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Inicialización", "Ocurrió un error al inicializar la vista: " + e.getMessage(),
                    AlertType.ERROR);
        }
    }

    // Configura las columnas de la tabla de reservas
    private void configurarColumnas() {
        try {
            // Configura la columna de cliente
            tbc_cliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCliente()));
            // Configura la columna de días
            tbc_dias.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDias()));
            // Configura la columna de fecha de inicio
            tbc_fechaDeInicio.setCellValueFactory(
                    cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaDeReserva()));
            tbc_fechaDeInicio.setCellFactory(col -> new TextFieldTableCell<>(
                    new LocalDateStringConverter(DateTimeFormatter.ofPattern("dd/MM/yyyy"), null)));
            // Configura la columna de tipo de vehículo
            tbc_tipoDeVehiculo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(
                    cellData.getValue().getVehiculo().getClass().getSimpleName()));
            // Configura la columna de costo total
            tbc_totalCosto
                    .setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCostoTotal()));
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Configuración", "Error al configurar las columnas de la tabla: " + e.getMessage(),
                    AlertType.ERROR);
        }
    }

    // Carga las reservas en la tabla desde el controlador
    private void cargarReservas() {
        try {
            // Obtiene las reservas del controlador y las añade a la lista observable
            listaReservas.setAll(reservaController.obtenerReservas());
            // Establece los elementos de la tabla con la lista observable
            tbl_verReservas.setItems(listaReservas);
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Carga", "No se pudieron cargar las reservas: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Configura las acciones de los botones
    private void configurarAccionesBotones() {
        try {
            // Configura la acción del botón de eliminar selección
            btn_eliminarSeleccion.setOnAction(this::eliminarReservaSeleccionada);
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Configuración", "No se pudo configurar la acción del botón: " + e.getMessage(),
                    AlertType.ERROR);
        }
        // Configura la acción del botón de regresar al inicio
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio);
    }

    // Configura los listeners de selección de la tabla
    private void configuracionListener() {
        try {
            // Añade un listener para habilitar o deshabilitar el botón de eliminar según la
            // selección
            tbl_verReservas.getSelectionModel().selectedItemProperty()
                    .addListener((obs, oldSelection, newSelection) -> {
                        btn_eliminarSeleccion.setDisable(newSelection == null);
                    });
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Listener", "Error al configurar el listener de selección: " + e.getMessage(),
                    AlertType.ERROR);
        }
    }

    // Elimina la reserva seleccionada en la tabla
    private void eliminarReservaSeleccionada(ActionEvent event) {
        try {
            // Obtiene la reserva seleccionada
            Reserva reservaSeleccionada = tbl_verReservas.getSelectionModel().getSelectedItem();
            if (reservaSeleccionada != null) {
                // Muestra una alerta de confirmación
                Alert alertaConfirmacion = new Alert(AlertType.CONFIRMATION);
                alertaConfirmacion.setTitle("Confirmar eliminación");
                alertaConfirmacion.setContentText("¿Estás seguro de que deseas eliminar la reserva seleccionada?");
                Optional<ButtonType> respuesta = alertaConfirmacion.showAndWait();
                // Elimina la reserva si el usuario confirma
                if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
                    if (reservaController.eliminarReserva(reservaSeleccionada)) {
                        // Muestra un mensaje de éxito y recarga las reservas
                        App.showAlert("Éxito", "Reserva eliminada correctamente.", AlertType.INFORMATION);
                        cargarReservas();
                    } else {
                        // Muestra un mensaje de error si no se pudo eliminar la reserva
                        App.showAlert("Error", "No se pudo eliminar la reserva.", AlertType.ERROR);
                    }
                }
            } else {
                // Muestra un mensaje de advertencia si no hay ninguna selección
                App.showAlert("Sin selección", "Seleccione una reserva para eliminar.", AlertType.WARNING);
            }
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error de Eliminación", "Ocurrió un error al intentar eliminar la reserva: " + e.getMessage(),
                    AlertType.ERROR);
        }
    }

    // Acción para regresar al menú inicial
    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error
            App.showAlert("Error al Cambiar de Vista", "No se pudo regresar al menú de inicio: " + e.getMessage(),
                    AlertType.ERROR);
        }
    }
}
