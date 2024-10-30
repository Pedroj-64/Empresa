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

    private MenuVerReservarController reservaController = new MenuVerReservarController();
    private ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();

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

    @FXML
    void initialize() {
        try {
            reservaController.instancia();
            configurarColumnas();
            cargarReservas();
            configuracionListener();
            configurarAccionesBotones();
        } catch (Exception e) {
            App.showAlert("Error de Inicialización", "Ocurrió un error al inicializar la vista: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void configurarColumnas() {
        try {
            tbc_cliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCliente()));
            tbc_dias.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDias()));
            tbc_fechaDeInicio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaDeReserva()));
            tbc_fechaDeInicio.setCellFactory(col -> new TextFieldTableCell<>(new LocalDateStringConverter(DateTimeFormatter.ofPattern("dd/MM/yyyy"), null)));
            tbc_tipoDeVehiculo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVehiculo().getClass().getSimpleName()));
            tbc_totalCosto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCostoTotal()));
        } catch (Exception e) {
            App.showAlert("Error de Configuración", "Error al configurar las columnas de la tabla: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void cargarReservas() {
        try {
            listaReservas.setAll(reservaController.obtenerReservas());
            tbl_verReservas.setItems(listaReservas);
        } catch (Exception e) {
            App.showAlert("Error de Carga", "No se pudieron cargar las reservas: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void configurarAccionesBotones() {
        try {
            btn_eliminarSeleccion.setOnAction(this::eliminarReservaSeleccionada);
        } catch (Exception e) {
            App.showAlert("Error de Configuración", "No se pudo configurar la acción del botón: " + e.getMessage(), AlertType.ERROR);
        }
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio);
    }

    private void configuracionListener() {
        try {
            tbl_verReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                btn_eliminarSeleccion.setDisable(newSelection == null);
            });
        } catch (Exception e) {
            App.showAlert("Error de Listener", "Error al configurar el listener de selección: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void eliminarReservaSeleccionada(ActionEvent event) {
        try {
            Reserva reservaSeleccionada = tbl_verReservas.getSelectionModel().getSelectedItem();
            if (reservaSeleccionada != null) {
                Alert alertaConfirmacion = new Alert(AlertType.CONFIRMATION);
                alertaConfirmacion.setTitle("Confirmar eliminación");
                alertaConfirmacion.setContentText("¿Estás seguro de que deseas eliminar la reserva seleccionada?");
                Optional<ButtonType> respuesta = alertaConfirmacion.showAndWait();

                if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
                    if (reservaController.eliminarReserva(reservaSeleccionada)) {
                        App.showAlert("Éxito", "Reserva eliminada correctamente.", AlertType.INFORMATION);
                        cargarReservas();
                    } else {
                        App.showAlert("Error", "No se pudo eliminar la reserva.", AlertType.ERROR);
                    }
                }
            } else {
                App.showAlert("Sin selección", "Seleccione una reserva para eliminar.", AlertType.WARNING);
            }
        } catch (Exception e) {
            App.showAlert("Error de Eliminación", "Ocurrió un error al intentar eliminar la reserva: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            App.showAlert("Error al Cambiar de Vista", "No se pudo regresar al menú de inicio: " + e.getMessage(), AlertType.ERROR);
        }
    }
}
