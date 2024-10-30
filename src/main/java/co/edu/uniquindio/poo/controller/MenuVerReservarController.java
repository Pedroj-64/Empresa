package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Controlador de lógica de negocio que maneja las operaciones relacionadas con
 * reservas.
 * Este controlador interactúa con el modelo (clase Reserva) y provee los datos
 * necesarios para que el ViewController los muestre en la interfaz gráfica.
 */
public class MenuVerReservarController {
    Empresa empresa;

    public void instancia() {
        empresa = App.getEmpresa();
        if (empresa == null) {
            throw new IllegalStateException("La empresa no puede ser nula.");
        }
    }

    /**
     * Retorna la lista de reservas como una ObservableList, que se utiliza para
     * conectar los datos con la interfaz.
     * 
     * @return Lista observable de reservas.
     */
    public ObservableList<Reserva> obtenerReservas() {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no está inicializada.");
        }
        return FXCollections.observableArrayList(empresa.getListaReservas());
    }

    /**
     * Agrega una nueva reserva a la lista.
     * 
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no está inicializada.");
        }
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        try {
            empresa.agregarReserva(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar la reserva: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina una reserva de la lista.
     * 
     * @param reserva La reserva a eliminar.
     * @return true si la reserva fue eliminada, false de lo contrario.
     */
    public boolean eliminarReserva(Reserva reserva) {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no está inicializada.");
        }
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        try {
            return empresa.eliminarReserva(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la reserva: " + e.getMessage(), e);
        }
    }
}
