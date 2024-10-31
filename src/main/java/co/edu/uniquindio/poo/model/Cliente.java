package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

// La clase Cliente hereda de Persona
public class Cliente extends Persona {

    // Colección de reservas asociadas al cliente
    private Collection<Reserva> reservas;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre   El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param cedula   La cédula del cliente.
     * @param edad     La edad del cliente.
     */
    public Cliente(String nombre, String apellido, String cedula, int edad) {
        // Llama al constructor de la clase base Persona
        super(nombre, apellido, cedula, edad);
        // Inicializa la colección de reservas como una LinkedList
        reservas = new LinkedList<>();
    }

    /**
     * Obtiene la colección de reservas del cliente.
     * 
     * @return La colección de reservas.
     */
    public Collection<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la colección de reservas del cliente.
     * Si la colección es nula, lanza una excepción.
     * 
     * @param reservas La colección de reservas a establecer.
     */
    public void setReservas(Collection<Reserva> reservas) {
        // Validación para asegurar que la colección no sea nula
        if (reservas == null) {
            throw new IllegalArgumentException("La colección de reservas no puede ser nula.");
        }
        this.reservas = reservas;
    }

    /**
     * Agrega una reserva a la colección de reservas del cliente.
     * Si la reserva es nula, lanza una excepción.
     * 
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        // Validación para asegurar que la reserva no sea nula
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        reservas.add(reserva);
    }

    /**
     * Elimina una reserva de la colección de reservas del cliente.
     * Si la reserva es nula o no existe en la colección, lanza una excepción.
     * 
     * @param reserva La reserva a eliminar.
     */
    public void eliminarReserva(Reserva reserva) {
        // Validación para asegurar que la reserva no sea nula
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        // Validación para asegurar que la reserva existe en la colección
        if (!reservas.contains(reserva)) {
            throw new IllegalArgumentException("La reserva no existe en la colección.");
        }
        reservas.remove(reserva);
    }

    /**
     * Devuelve una representación en cadena del objeto Cliente.
     * 
     * @return El nombre del cliente.
     */
    @Override
    public String toString() {
        return super.getNombre();
    }
}
