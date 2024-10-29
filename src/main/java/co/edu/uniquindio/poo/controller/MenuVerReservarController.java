package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Controlador de lógica de negocio que maneja las operaciones relacionadas con reservas.
 * Este controlador interactúa con el modelo (clase Reserva) y provee los datos 
 * necesarios para que el ViewController los muestre en la interfaz gráfica.
 */
public class MenuVerReservarController {

    Empresa empresa;

    public  void instancia(){
        Empresa.getInstance("Mi empresa");
    }



    /**
     * Retorna la lista de reservas como una ObservableList, que se utiliza para
     * conectar los datos con la interfaz.
     * @return Lista observable de reservas.
     */
    public ObservableList<Reserva> obtenerReservas() {
        return FXCollections.observableArrayList(empresa.getListaReservas());
    }

    /**
     * Agrega una nueva reserva a la lista.
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        empresa.agregarReserva(reserva);
    }

    /**
     * Elimina una reserva de la lista.
     * @param reserva La reserva a eliminar.
     */
    public boolean eliminarReserva(Reserva reserva) {
        return empresa.eliminarReserva(reserva);
    }


}
