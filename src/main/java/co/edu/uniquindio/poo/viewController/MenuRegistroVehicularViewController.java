package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'menuRegistroVehicular.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.scene.control.CheckBox;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.AnchorPane;
 
 public class MenuRegistroVehicularViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="Cmbox_tiposDeVehiculo"
     private ComboBox<?> Cmbox_tiposDeVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="Date_añoVehiculo"
     private DatePicker Date_añoVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="Screen_02"
     private AnchorPane Screen_02; // Value injected by FXMLLoader
 
     @FXML // fx:id="check_esCajaAutomatica"
     private CheckBox check_esCajaAutomatica; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_Año"
     private Label lbl_Año; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_TituloRegistroVehicular"
     private Label lbl_TituloRegistroVehicular; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_TituloRegistroVehicular1"
     private Label lbl_TituloRegistroVehicular1; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_aclaracionEnEntero"
     private Label lbl_aclaracionEnEntero; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_aclaracionEnEntero2"
     private Label lbl_aclaracionEnEntero2; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_capacidadDeCarga"
     private Label lbl_capacidadDeCarga; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_datosAdicionales"
     private Label lbl_datosAdicionales; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca"
     private Label lbl_marca; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca2311"
     private Label lbl_marca2311; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_matricula"
     private Label lbl_matricula; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_modelo"
     private Label lbl_modelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_numeroDePuertas"
     private Label lbl_numeroDePuertas; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_tipoDeVehiculo"
     private Label lbl_tipoDeVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_capacidadDeCarga"
     private TextField txt_capacidadDeCarga; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_marca"
     private TextField txt_marca; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_matricula"
     private TextField txt_matricula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_modelo"
     private TextField txt_modelo; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_numeroDePuertas"
     private TextField txt_numeroDePuertas; // Value injected by FXMLLoader
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert Cmbox_tiposDeVehiculo != null : "fx:id=\"Cmbox_tiposDeVehiculo\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert Date_añoVehiculo != null : "fx:id=\"Date_añoVehiculo\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert Screen_02 != null : "fx:id=\"Screen_02\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert check_esCajaAutomatica != null : "fx:id=\"check_esCajaAutomatica\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_Año != null : "fx:id=\"lbl_Año\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_TituloRegistroVehicular != null : "fx:id=\"lbl_TituloRegistroVehicular\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_TituloRegistroVehicular1 != null : "fx:id=\"lbl_TituloRegistroVehicular1\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_aclaracionEnEntero != null : "fx:id=\"lbl_aclaracionEnEntero\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_aclaracionEnEntero2 != null : "fx:id=\"lbl_aclaracionEnEntero2\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_capacidadDeCarga != null : "fx:id=\"lbl_capacidadDeCarga\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_datosAdicionales != null : "fx:id=\"lbl_datosAdicionales\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_marca != null : "fx:id=\"lbl_marca\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_marca2311 != null : "fx:id=\"lbl_marca2311\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_matricula != null : "fx:id=\"lbl_matricula\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_modelo != null : "fx:id=\"lbl_modelo\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_numeroDePuertas != null : "fx:id=\"lbl_numeroDePuertas\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert lbl_tipoDeVehiculo != null : "fx:id=\"lbl_tipoDeVehiculo\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert txt_capacidadDeCarga != null : "fx:id=\"txt_capacidadDeCarga\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert txt_marca != null : "fx:id=\"txt_marca\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert txt_matricula != null : "fx:id=\"txt_matricula\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert txt_modelo != null : "fx:id=\"txt_modelo\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
         assert txt_numeroDePuertas != null : "fx:id=\"txt_numeroDePuertas\" was not injected: check your FXML file 'menuRegistroVehicular.fxml'.";
 
     }
 
 }
 