package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'menuVerReservas.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.scene.control.Label;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.layout.AnchorPane;
 
 public class MenuVerReservarViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="Screen_04"
     private AnchorPane Screen_04; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_tituloRegistroDeReservas"
     private Label lbl_tituloRegistroDeReservas; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_cliente"
     private TableColumn<?, ?> tbc_cliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_dias"
     private TableColumn<?, ?> tbc_dias; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_fechaDeInicio"
     private TableColumn<?, ?> tbc_fechaDeInicio; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_tipoDeVehiculo"
     private TableColumn<?, ?> tbc_tipoDeVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_totalCosto"
     private TableColumn<?, ?> tbc_totalCosto; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbl_verReservas"
     private TableView<?> tbl_verReservas; // Value injected by FXMLLoader
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert Screen_04 != null : "fx:id=\"Screen_04\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert lbl_tituloRegistroDeReservas != null : "fx:id=\"lbl_tituloRegistroDeReservas\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbc_cliente != null : "fx:id=\"tbc_cliente\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbc_dias != null : "fx:id=\"tbc_dias\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbc_fechaDeInicio != null : "fx:id=\"tbc_fechaDeInicio\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbc_tipoDeVehiculo != null : "fx:id=\"tbc_tipoDeVehiculo\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbc_totalCosto != null : "fx:id=\"tbc_totalCosto\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
         assert tbl_verReservas != null : "fx:id=\"tbl_verReservas\" was not injected: check your FXML file 'menuVerReservas.fxml'.";
 
     }
 
 }
 
 