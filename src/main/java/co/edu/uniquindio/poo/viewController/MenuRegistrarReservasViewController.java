package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'menuRegistrarReservas.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.layout.AnchorPane;
 
 public class MenuRegistrarReservasViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="Screen_03"
     private AnchorPane Screen_03; // Value injected by FXMLLoader
 
     @FXML // fx:id="btn_GuardarReservas"
     private Button btn_GuardarReservas; // Value injected by FXMLLoader
 
     @FXML // fx:id="btn_limpiarReservas"
     private Button btn_limpiarReservas; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca"
     private Label lbl_marca; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca1"
     private Label lbl_marca1; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca11"
     private Label lbl_marca11; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_tituloRegistroDeReservas"
     private Label lbl_tituloRegistroDeReservas; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_marca"
     private TableColumn<?, ?> tbc_marca; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_modelo"
     private TableColumn<?, ?> tbc_modelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_placa"
     private TableColumn<?, ?> tbc_placa; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbc_tipoDeVehiculo"
     private TableColumn<?, ?> tbc_tipoDeVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="tbl_listaVehiculos"
     private TableView<?> tbl_listaVehiculos; // Value injected by FXMLLoader
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert Screen_03 != null : "fx:id=\"Screen_03\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert btn_GuardarReservas != null : "fx:id=\"btn_GuardarReservas\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert btn_limpiarReservas != null : "fx:id=\"btn_limpiarReservas\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert lbl_marca != null : "fx:id=\"lbl_marca\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert lbl_marca1 != null : "fx:id=\"lbl_marca1\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert lbl_marca11 != null : "fx:id=\"lbl_marca11\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert lbl_tituloRegistroDeReservas != null : "fx:id=\"lbl_tituloRegistroDeReservas\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert tbc_marca != null : "fx:id=\"tbc_marca\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert tbc_modelo != null : "fx:id=\"tbc_modelo\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert tbc_placa != null : "fx:id=\"tbc_placa\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert tbc_tipoDeVehiculo != null : "fx:id=\"tbc_tipoDeVehiculo\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
         assert tbl_listaVehiculos != null : "fx:id=\"tbl_listaVehiculos\" was not injected: check your FXML file 'menuRegistrarReservas.fxml'.";
 
     }
 
 }
 