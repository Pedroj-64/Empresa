package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de lógica de negocio que maneja las operaciones relacionadas con reservas.
 * Este controlador interactúa con el modelo (clase Reserva) y provee los datos 
 * necesarios para que el ViewController los muestre en la interfaz gráfica.
 */
public class MenuVerReservarController {

    // Lista de reservas, que podría estar almacenada en una base de datos en un proyecto real.
    private List<Reserva> listaReservas;

    /**
     * Constructor que inicializa la lista de reservas. En un entorno real, aquí 
     * se podrían cargar los datos desde una base de datos o archivo.
     */
    public MenuVerReservarController() {
        this.listaReservas = new ArrayList<>();
        // Agregar algunas reservas de ejemplo para fines de prueba
        inicializarReservasEjemplo();
    }

    /**
     * Inicializa algunos datos de ejemplo. Esto es útil para verificar que la 
     * vista muestra datos correctamente al inicializar la aplicación.
     */
    private void inicializarReservasEjemplo() {
        listaReservas.add(new Reserva("Cliente1", 3, "2024-10-01", "Auto", 150.0));
        listaReservas.add(new Reserva("Cliente2", 5, "2024-10-03", "Camioneta", 250.0));
        listaReservas.add(new Reserva("Cliente3", 2, "2024-10-05", "Moto", 50.0));
    }

    /**
     * Retorna la lista de reservas como una ObservableList, que se utiliza para
     * conectar los datos con la interfaz.
     * @return Lista observable de reservas.
     */
    public ObservableList<Reserva> obtenerReservas() {
        return FXCollections.observableArrayList(listaReservas);
    }

    /**
     * Agrega una nueva reserva a la lista.
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

    /**
     * Elimina una reserva de la lista.
     * @param reserva La reserva a eliminar.
     */
    public void eliminarReserva(Reserva reserva) {
        listaReservas.remove(reserva);
    }

    /**
     * Modifica una reserva existente en la lista.
     * @param reservaOriginal La reserva original a modificar.
     * @param reservaActualizada La reserva con los datos actualizados.
     */
    public void modificarReserva(Reserva reservaOriginal, Reserva reservaActualizada) {
        int indice = listaReservas.indexOf(reservaOriginal);
        if (indice >= 0) {
            listaReservas.set(indice, reservaActualizada);
        }
    }
}
