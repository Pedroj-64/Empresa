package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'menuRegistroDeClientes.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.AnchorPane;
 
 public class MenuRegistroDeClientresViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="Screen_05"
     private AnchorPane Screen_05; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_TituloRegistroCliente"
     private Label lbl_TituloRegistroCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_TituloRegistroVehicular1"
     private Label lbl_TituloRegistroVehicular1; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_apellido"
     private Label lbl_apellido; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_cedula"
     private Label lbl_cedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_edad"
     private Label lbl_edad; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_marca2311"
     private Label lbl_marca2311; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_nombre"
     private Label lbl_nombre; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_apellido"
     private TextField txt_apellido; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_cedula"
     private TextField txt_cedula; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_edad"
     private TextField txt_edad; // Value injected by FXMLLoader
 
     @FXML // fx:id="txt_nombre"
     private TextField txt_nombre; // Value injected by FXMLLoader
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert Screen_05 != null : "fx:id=\"Screen_05\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_TituloRegistroCliente != null : "fx:id=\"lbl_TituloRegistroCliente\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_TituloRegistroVehicular1 != null : "fx:id=\"lbl_TituloRegistroVehicular1\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_apellido != null : "fx:id=\"lbl_apellido\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_cedula != null : "fx:id=\"lbl_cedula\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_edad != null : "fx:id=\"lbl_edad\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_marca2311 != null : "fx:id=\"lbl_marca2311\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert lbl_nombre != null : "fx:id=\"lbl_nombre\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert txt_apellido != null : "fx:id=\"txt_apellido\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert txt_edad != null : "fx:id=\"txt_edad\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
         assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'menuRegistroDeClientes.fxml'.";
 
     }
 
 }
 