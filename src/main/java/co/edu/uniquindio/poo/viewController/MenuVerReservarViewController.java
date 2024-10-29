package co.edu.uniquindio.poo.viewController;

/**
 * Controlador de vista para la interfaz de "Ver Reservas". 
 * Este controlador maneja la vista FXML 'menuVerReservas.fxml', donde se muestra 
 * una tabla con los datos de las reservas realizadas en el sistema.
 */

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MenuVerReservarViewController {

    private MenuVerReservarViewController reservaController = new MenuVerReservarViewController();


    @FXML // ResourceBundle que se inyecta automáticamente con el FXML
    private ResourceBundle resources;

    @FXML // URL de la ubicación del archivo FXML cargado
    private URL location;

    @FXML // Panel principal donde se muestra la interfaz "Ver Reservas"
    private AnchorPane Screen_04;

    @FXML // Etiqueta de título en la interfaz de "Registro de Reservas"
    private Label lbl_tituloRegistroDeReservas;

    @FXML // Columna de la tabla para mostrar el cliente asociado a la reserva
    private TableColumn<Reserva, Cliente> tbc_cliente;

    @FXML // Columna de la tabla para mostrar los días de la reserva
    private TableColumn<Reserva, ?> tbc_dias;

    @FXML // Columna de la tabla para mostrar la fecha de inicio de la reserva
    private TableColumn<Reserva, ?> tbc_fechaDeInicio;

    @FXML // Columna de la tabla para mostrar el tipo de vehículo de la reserva
    private TableColumn<Reserva, ?> tbc_tipoDeVehiculo;

    @FXML // Columna de la tabla para mostrar el costo total de la reserva
    private TableColumn<Reserva, ?> tbc_totalCosto;

    @FXML // Tabla principal donde se muestra el listado de reservas
    private TableView<?> tbl_verReservas;

    /**
     * Método de inicialización que se llama automáticamente al cargar la vista. 
     * Este método asegura que todos los componentes de la interfaz han sido inyectados 
     * correctamente y puede utilizarse para realizar configuraciones iniciales.
     */
    @FXML
    void initialize() {
        assert Screen_04 != null : "fx:id=\"Screen_04\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert lbl_tituloRegistroDeReservas != null : "fx:id=\"lbl_tituloRegistroDeReservas\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbc_cliente != null : "fx:id=\"tbc_cliente\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbc_dias != null : "fx:id=\"tbc_dias\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbc_fechaDeInicio != null : "fx:id=\"tbc_fechaDeInicio\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbc_tipoDeVehiculo != null : "fx:id=\"tbc_tipoDeVehiculo\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbc_totalCosto != null : "fx:id=\"tbc_totalCosto\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";
        assert tbl_verReservas != null : "fx:id=\"tbl_verReservas\" no fue inyectado: verifica el archivo FXML 'menuVerReservas.fxml'.";

        // Aquí puedes inicializar la tabla, configurando sus columnas y enlazándolas
        // con las propiedades correspondientes de la clase Reserva.
        configurarColumnas();
    }

    /**
     * Configura las columnas de la tabla 'tbl_verReservas' para que cada columna 
     * muestre el atributo adecuado de los objetos de reserva.
     */
    private void configurarColumnas() {
        // Configura cada columna de la tabla con el valor adecuado
        // Ejemplo: tbc_cliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        // Agrega la configuración específica para enlazar cada columna con las propiedades de la reserva
    }

    /**
     * Método para actualizar la tabla de reservas.
     * Se debe llamar cada vez que haya cambios en el listado de reservas 
     * para que la tabla refleje los datos actualizados.
     */
    public void actualizarTabla() {
        // Código para cargar y actualizar los datos en 'tbl_verReservas'
        // Ejemplo: tbl_verReservas.setItems(obtenerListaReservas());
    }

    /**
     * Obtiene una lista de todas las reservas disponibles en el sistema.
     * Este método podría conectarse al controlador de negocio para extraer los datos.
     * @return Lista observable de reservas para mostrar en la tabla
     */
    // private ObservableList<Reserva> obtenerListaReservas() {
    //     return FXCollections.observableArrayList(controladorNegocio.obtenerReservas());
    // }

}
