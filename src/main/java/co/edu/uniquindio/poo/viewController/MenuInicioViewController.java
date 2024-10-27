package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'menuInicio.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.AnchorPane;
 
 public class MenuInicioViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="btn_registrarVehiculo"
     private Button btn_registrarVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="img_Carro"
     private AnchorPane img_Carro; // Value injected by FXMLLoader
 
     @FXML // fx:id="img_Persona"
     private ImageView img_Persona; // Value injected by FXMLLoader
 
     @FXML // fx:id="img_calendario"
     private ImageView img_calendario; // Value injected by FXMLLoader
 
     @FXML // fx:id="img_carro"
     private ImageView img_carro; // Value injected by FXMLLoader
 
     @FXML // fx:id="img_ojo"
     private ImageView img_ojo; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_crearCliente"
     private Button lbl_crearCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_realizarReserva"
     private Button lbl_realizarReserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_titulo"
     private Label lbl_titulo; // Value injected by FXMLLoader
 
     @FXML // fx:id="lbl_verReservas"
     private Button lbl_verReservas; // Value injected by FXMLLoader
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert btn_registrarVehiculo != null : "fx:id=\"btn_registrarVehiculo\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert img_Carro != null : "fx:id=\"img_Carro\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert img_Persona != null : "fx:id=\"img_Persona\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert img_calendario != null : "fx:id=\"img_calendario\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert img_carro != null : "fx:id=\"img_carro\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert img_ojo != null : "fx:id=\"img_ojo\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert lbl_crearCliente != null : "fx:id=\"lbl_crearCliente\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert lbl_realizarReserva != null : "fx:id=\"lbl_realizarReserva\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert lbl_titulo != null : "fx:id=\"lbl_titulo\" was not injected: check your FXML file 'menuInicio.fxml'.";
         assert lbl_verReservas != null : "fx:id=\"lbl_verReservas\" was not injected: check your FXML file 'menuInicio.fxml'.";
 
     }
 
 }
 