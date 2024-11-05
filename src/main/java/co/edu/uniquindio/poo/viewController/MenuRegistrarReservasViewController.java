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

/**
 * Clase MenuRegistrarReservasViewController maneja la lógica de la interfaz de
 * registro de reservas.
 */
public class MenuRegistrarReservasViewController {
    /**
     * Por prácticas, se utiliza siempre una instancia del Controller de la clase
     * para llamar a los métodos necesarios.
     */
    private final MenuRegistrarReservasController registrarReservasController = new MenuRegistrarReservasController();

    /**
     * Aquí se definen los elementos que integran la interfaz visual.
     */

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
    // Se configura que va tipo de dato guarda la ComBox
    @FXML
    private ComboBox<Cliente> cmb_Clientes;
    // Se configura que la tabla va a mostrar datos de la clase Vehiculo.
    // Por ello, los valores obtenidos mediante .getValue() provienen de la clase
    // Vehiculo.
    @FXML
    private TableView<Vehiculo> tbl_listaVehiculos;
    // Se configura que tipo de dato muestra cada columna
    // <TipoDeDatoDetabla,TipoDeDatoAMostrar>
    @FXML
    private TableColumn<Vehiculo, String> tbc_marca;
    @FXML
    private TableColumn<Vehiculo, String> tbc_modelo;
    @FXML
    private TableColumn<Vehiculo, String> tbc_placa;
    @FXML
    private TableColumn<Vehiculo, String> tbc_tipoDeVehiculo;

    /**
     * Método que inicializa la interfaz y se ejecuta automáticamente después de
     * que se carga el archivo FXML.
     */
    @FXML
    void initialize() {
        configurarTabla(); // Configura las columnas de la tabla
        configurarAccionesBotones(); // Asigna acciones a los botones
        cargarDatos(); // Carga los datos iniciales de los vehículos y clientes
    }

    /**
     * Configura las columnas de la tabla para mostrar la información de los
     * vehículos.
     * ACLARACION= sobre como funciona la configuracion, vease asi:
     * 
     * 
     * Configura la columna 'tbc_nombreColumna' para que use el valor designado
     * de un objeto de la clase.
     * La expresión lambda (cellData -> new
     * SimpleObjectProperty<>(cellData.getValue().getPropiedad()))
     * toma cada celda de la columna y extrae el valor de la propiedad
     * correspondiente del objeto,
     * envolviéndolo en un SimpleObjectProperty para que la tabla pueda observar
     * cambios en ese valor.
     * 
     * A tener en cuenta:
     * cellData= expresion lambda que representa la celda como indivual su propio
     * nombre lo dice data de la celda
     * ->= forma de llamar metodo utilizando como argumetnto lo que antes de la
     * flecha
     * SimpleObjectProperty=Son clases que permiten rendir valores a las columnas de
     * las tablas de JavaFx
     * tienen sus valientes como SimpleStringProperty<> pero en este caso queremos
     * un tipo Object que es
     * el padre de todo objeto java asi evitamos posibles incompatibilidades
     * .getValue()=Utiliza el tipo de objeto que se expresion cuando se definieron
     * las columnas arriba y obtiene
     * un atributo de la clase definida.
     * .getSimpleName()=Forma simple de de tener nombres de la clase en la que se
     * esta un objeto
     * 
     */
    private void configurarTabla() {
        tbc_marca.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMarca()));
        tbc_modelo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getModelo()));
        tbc_placa.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMatricula()));
        tbc_tipoDeVehiculo.setCellValueFactory(
                cellData -> new SimpleObjectProperty<>(cellData.getValue().getClass().getSimpleName()));
    }

    /**
     * Carga los datos iniciales de los vehículos y clientes, y configura el
     * listener de la tabla.
     * 
     * 
     * DATO A TENER EN CUENTA: en la parte de abajo se definen objetos con conexion directa con App llamando empresa si bien
     * por practicas esto esta mal, se quiso hacer asi para ejemplificar a futuro que es posible utilizar como controller un viewController
     */
    private void cargarDatos() {
        cargarVehiculos(); // Carga la lista de vehículos disponibles
        cargarClientes(); // Carga la lista de clientes
        configurarListenerTabla(); // Configura el listener para la selección de la tabla
    }

    /**
     * Carga la lista de vehículos disponibles en la tabla, con colleciones
     * definidas para JavaFx.
     */
    private void cargarVehiculos() {
        ObservableList<Vehiculo> vehiculos = FXCollections
                .observableArrayList(App.getEmpresa().getVehiculosDisponibles());
        tbl_listaVehiculos.setItems(vehiculos);
    }

    /**
     * Carga la lista de clientes en el ComboBox.
     */
    private void cargarClientes() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(App.getEmpresa().getClientes());
        cmb_Clientes.setItems(clientes);
    }

    /**
     * Configura un listener en la tabla para manejar la selección de vehículos.
     * ACLARACION: sobre listener
     * Se añade un listener (oyente) a la propiedad selectedItemProperty de la
     * tabla tbl_listaVehiculos.
     * Este listener se activa cada vez que cambia el elemento seleccionado en la
     * tabla.
     * La expresión lambda (observable, oldValue, newValue) -> { ... } define lo
     * que ocurre cuando cambia la selección.
     * - observable: la propiedad observable (selectedItemProperty) que está
     * siendo observada.
     * - oldValue: el valor anterior de la selección (el elemento que estaba
     * seleccionado previamente).
     * - newValue: el nuevo valor de la selección (el nuevo elemento
     * seleccionado).
     */
    private void configurarListenerTabla() {
        tbl_listaVehiculos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txt_tipoDeVehiculo.setText(newValue.getClass().getSimpleName());
                txt_placa.setText(newValue.getMatricula());
            } else {
                limpiarCampos(); // Limpia los campos si no hay ningún vehículo seleccionado
            }
        });
    }

    /**
     * Asigna acciones a los botones mediante expresiones lambda.
     */
    private void configurarAccionesBotones() {
        btn_GuardarReservas.setOnAction(this::accionGuardarReserva);
        btn_limpiarReservas.setOnAction(event -> limpiarCampos());
        btn_regresarAlInicio.setOnAction(this::accionRegresarAlInicio);
    }

    /**
     * Maneja la acción de guardar una reserva.
     *
     * @param event Acción del botón
     */
    private void accionGuardarReserva(ActionEvent event) {
        try {
            validarCampos(); // Valida los campos de entrada
            int dias = Integer.parseInt(txt_dias.getText());
            Cliente cliente = cmb_Clientes.getSelectionModel().getSelectedItem();
            Vehiculo vehiculo = registrarReservasController.buscarVehiculoPorPlaca(txt_placa.getText());
            if (vehiculo != null) {
                Reserva reserva = new Reserva(dias, cliente, vehiculo);
                registrarReservasController.guardarReserva(reserva);
                App.showAlert("Éxito", "Reserva guardada exitosamente.", Alert.AlertType.INFORMATION);
                limpiarCampos(); // Limpia los campos después de guardar la reserva
            } else {
                App.showAlert("Error", "Vehículo no encontrado.", Alert.AlertType.ERROR);
                limpiarCampos(); // Limpia los campos si el vehículo no se encuentra
            }
        } catch (NumberFormatException e) {
            App.showAlert("Error", "Ingrese un valor numérico válido para los días.", Alert.AlertType.ERROR);
        } catch (IllegalArgumentException e) {
            App.showAlert("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            App.showAlert("Error inesperado", "Ha ocurrido un error inesperado. Detalle: " + e.getMessage(),
                    Alert.AlertType.ERROR);
            e.printStackTrace(); // Para más detalles en la consola
        }
    }

    /**
     * Valida los campos de entrada antes de guardar la reserva.
     *
     * @throws IllegalArgumentException si algún campo no es válido
     */
    private void validarCampos() throws IllegalArgumentException {
        if (txt_placa.getText().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }
        if (txt_dias.getText().isEmpty()) {
            throw new IllegalArgumentException("El campo de días no puede estar vacío.");
        }
        if (cmb_Clientes.getSelectionModel().getSelectedItem() == null) {
            throw new IllegalArgumentException("Debe seleccionar un cliente.");
        }
    }

    /**
     * Limpia los campos de entrada.
     */
    private void limpiarCampos() {
        txt_placa.clear();
        txt_dias.clear();
        cmb_Clientes.getSelectionModel().clearSelection();
    }

    /**
     * Maneja la acción de regresar al menú de inicio.
     *
     * @param event Acción del botón
     */
    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            App.showAlert("Error al Cargar Escena", "Ocurrió un error al regresar al menú de inicio.",
                    Alert.AlertType.ERROR);
        }
    }
}
