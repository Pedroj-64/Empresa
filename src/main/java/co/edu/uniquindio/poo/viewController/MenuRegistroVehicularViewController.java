package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuRegistroVehicularController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MenuRegistroVehicularViewController {

    // Instancia del controlador que maneja la lógica de negocio.
    private final MenuRegistroVehicularController controladorVehicular = new MenuRegistroVehicularController();

    // Componentes de la interfaz de usuario.
    @FXML
    private ComboBox<String> cmb_TiposDeVehiculo;
    @FXML
    private DatePicker fechaAñoVehiculo;
    @FXML
    private AnchorPane pantallaRegistro;
    @FXML
    private Button btn_guardarVehiculo;
    @FXML
    private Button btn_regresarMenuInicio;
    @FXML
    private CheckBox checkEsCajaAutomatica;
    @FXML
    private TextField txt_CapacidadDeCarga, txt_Marca, txt_Matricula, txt_Modelo, txt_NumeroDePuertas, txt_TarifaBase;

    // Método inicializador que configura la vista y sus componentes.
    @FXML
    void initialize() {
        try {
            configuracionCombo(); // Configura las opciones del ComboBox.
            configureButtons(); // Configura los eventos de los botones.
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error.
            App.showAlert("Error de Inicialización", "Error al inicializar la vista: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    // Configura los elementos del ComboBox con los tipos de vehículos disponibles.
    private void configuracionCombo() {
        // Configura la combobox con una lista de String inicilizada por nosotros por
        // motivos de facilidad
        ObservableList<String> tiposVehiculos = FXCollections.observableArrayList("Auto", "Moto", "Camioneta");
        cmb_TiposDeVehiculo.setItems(tiposVehiculos);
        // Añade un listener para habilitar los campos específicos según el tipo de
        // vehículo seleccionado.
        cmb_TiposDeVehiculo.valueProperty().addListener((obs, oldVal, newVal) -> habilitarCamposEspecificos(newVal));
    }

    // Habilita o deshabilita campos específicos en función del tipo de vehículo
    // seleccionado.
    private void habilitarCamposEspecificos(String tipoVehiculo) {
        // El método .setDisable es booleano para la mayoría de los objetos de JavaFX.
        // Aquí, usamos el operador NOT (!) porque queremos desactivar el campo si el
        // tipo de vehículo no coincide.
        // Por ejemplo, "Moto".equals(tipoVehiculo) devolverá true si el tipo de
        // vehículo es "Moto".
        // Al aplicar el operador NOT, .setDisable(true) desactivará el campo.
        try {
            checkEsCajaAutomatica.setDisable(!"Moto".equals(tipoVehiculo));
            txt_NumeroDePuertas.setDisable(!"Auto".equals(tipoVehiculo));
            txt_CapacidadDeCarga.setDisable(!"Camioneta".equals(tipoVehiculo));
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error al configurar los campos.
            App.showAlert("Error al Configurar Campos",
                    "Error al habilitar campos específicos para el tipo de vehículo: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    // Configura los eventos de los botones.
    /**
     * ACLARACION: sobre la diferneica en los lambda de los botones
     * //
     * Diferencia entre 'this::metodo' y 'event -> metodo()':
     * 'this::metodo' es una referencia de método que se usa cuando queremos
     * pasar un método existente que ya se ajusta a la firma esperada (por ejemplo,
     * que toma un ActionEvent como parámetro). Es directo y limpio si no
     * necesitamos manipular el evento.
     * 
     * 'event -> metodo()' es una expresión lambda que se usa cuando queremos
     * definir una acción en línea. Aunque el método 'metodo()' no tome parámetros,
     * usamos una lambda para tener más flexibilidad. Las lambdas son útiles si
     * necesitamos agregar lógica adicional o manipular el evento antes de llamar al
     * método.
     * vease asi en resumen:
     * event -> es una expresión lambda que obliga a tener
     * un argumento (event) para el método. Esto permite que el método se ejecute
     * cuando ocurra el evento que se está definiendo, incluso si el método en sí no
     * recibe un ActionEvent como parámetro.
     * Por otro lado, this::metodo es una referencia directa a un método que ya
     * está definido para recibir un ActionEvent, por lo que no necesita la lambda.
     * 
     */
    private void configureButtons() {
        btn_guardarVehiculo.setOnAction(event -> registrarVehiculo());
        btn_regresarMenuInicio.setOnAction(this::accionRegresarAlInicio);
    }

    @FXML
    /**
     * Método que registra un vehículo si todos los campos son válidos.
     * El método registrarVehiculo podría recibir un ActionEvent como parámetro.
     * Sin embargo, en este caso no es necesario porque el método no utiliza ninguna
     * información específica del evento.
     * Esto se debe a que el método se encarga de registrar un vehículo
     * utilizando los datos de la interfaz de usuario, independientemente del evento
     * que lo haya desencadenado.
     * Incluir ActionEvent podría ser útil si se necesitara procesar información
     * adicional del evento.
     * NOTA= En este caso se hizo que no recibiera un ActionEvent para tener
     * ejemplificacion de todo
     * 
     */
    private void registrarVehiculo() {
        if (!validarCampos()) { // Verifica que todos los campos sean válidos.
            return;
        }
        try {
            // Obtiene los datos de los campos de texto y otros componentes.
            String matricula = txt_Matricula.getText();
            String marca = txt_Marca.getText();
            String modelo = txt_Modelo.getText();
            int año = fechaAñoVehiculo.getValue().getYear();
            boolean esAutomatica = checkEsCajaAutomatica.isSelected();
            double tarifaBase = Double.parseDouble(txt_TarifaBase.getText());
            Integer numeroDePuertas = obtenerValorCampo(txt_NumeroDePuertas);
            Integer capacidadDeCarga = obtenerValorCampo(txt_CapacidadDeCarga);
            String tipoVehiculo = cmb_TiposDeVehiculo.getValue();

            // Intenta registrar el vehículo usando el controlador.
            boolean registroExitoso = controladorVehicular.registrarVehiculo(matricula, marca, modelo, año,
                    esAutomatica, tipoVehiculo, tarifaBase, numeroDePuertas, capacidadDeCarga);

            // Muestra el resultado del registro.
            mostrarResultadoRegistro(registroExitoso);
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error durante el registro.
            App.showAlert("Error de Registro", "Error inesperado al registrar el vehículo: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    // Muestra un mensaje según el resultado del registro del vehículo.
    private void mostrarResultadoRegistro(boolean exito) {
        if (exito) {
            App.showAlert("Registro Exitoso", "El vehículo ha sido registrado exitosamente.",
                    Alert.AlertType.INFORMATION);
            limpiarCampos(); // Limpia los campos de texto después de un registro exitoso.
        } else {
            App.showAlert("Error de Registro", "No se pudo registrar el vehículo. Verifique los datos ingresados.",
                    Alert.AlertType.ERROR);
        }
    }

    // Acción para regresar al menú inicial.
    private void accionRegresarAlInicio(ActionEvent event) {
        try {
            App.loadScene("menuInicio", 800, 540);
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error al cargar la escena.
            App.showAlert("Error al Cargar Escena", "Ocurrió un error al regresar al menú de inicio: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    // Verifica que los campos requeridos no estén vacíos y que los datos numéricos
    // sean válidos.
    private boolean validarCampos() {
        try {
            if (esCampoVacio(txt_Matricula) || esCampoVacio(txt_Marca) || esCampoVacio(txt_Modelo) ||
                    fechaAñoVehiculo.getValue() == null || esCampoVacio(txt_TarifaBase) ||
                    (cmb_TiposDeVehiculo.getValue() == null || cmb_TiposDeVehiculo.getValue().isEmpty())) {
                // Muestra un mensaje de advertencia si hay campos vacíos.
                App.showAlert("Campos Vacíos", "Por favor, llene todos los campos obligatorios.",
                        Alert.AlertType.WARNING);
                return false;
            }
            return validarCamposNumericos();
        } catch (Exception e) {
            // Muestra un mensaje de alerta en caso de error durante la validación.
            App.showAlert("Error de Validación", "Error al validar campos: " + e.getMessage(), Alert.AlertType.ERROR);
            return false;
        }
    }

    // Verifica que los campos numéricos tengan valores válidos.
    private boolean validarCamposNumericos() {
        try {
            Double.parseDouble(txt_TarifaBase.getText());
            if (!txt_NumeroDePuertas.isDisabled() && !txt_NumeroDePuertas.getText().isEmpty()) {
                Integer.parseInt(txt_NumeroDePuertas.getText());
            }
            if (!txt_CapacidadDeCarga.isDisabled() && !txt_CapacidadDeCarga.getText().isEmpty()) {
                Integer.parseInt(txt_CapacidadDeCarga.getText());
            }
        } catch (NumberFormatException e) {
            // Muestra un mensaje de advertencia si los campos numéricos tienen valores
            // inválidos.
            App.showAlert("Error de Formato", "Verifique que los campos numéricos contienen valores válidos.",
                    Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    // Obtiene el valor de un campo de texto como Integer.
    private Integer obtenerValorCampo(TextField campo) {
        try {
            if (campo.isDisabled() || campo.getText().isEmpty()) {
                return 0;
            } else {
                return Integer.parseInt(campo.getText());
            }
        } catch (NumberFormatException e) {
            // Muestra un mensaje de advertencia en caso de error al obtener el valor del
            // campo.
            App.showAlert("Error de Formato", "Error al obtener valor del campo: " + e.getMessage(),
                    Alert.AlertType.WARNING);
            return 0;
        }
    }

    // Verifica si un campo de texto está vacío.
    private boolean esCampoVacio(TextField campo) {
        return campo.getText().isEmpty();
    }

    // Limpia todos los campos de texto y restablece los componentes a su estado
    // inicial.
    private void limpiarCampos() {
        txt_Matricula.clear();
        txt_Marca.clear();
        txt_Modelo.clear();
        fechaAñoVehiculo.setValue(null);
        txt_TarifaBase.clear();
        txt_NumeroDePuertas.clear();
        txt_CapacidadDeCarga.clear();
        checkEsCajaAutomatica.setSelected(false);
        cmb_TiposDeVehiculo.getSelectionModel().clearSelection();
    }
}
