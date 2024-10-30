package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Cliente extends Persona {
    private Collection<Reserva> reservas;

    public Cliente(String nombre, String apellido, String cedula, int edad) {
        super(nombre, apellido, cedula, edad);
        reservas = new LinkedList<>();
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        if (reservas == null) {
            throw new IllegalArgumentException("La colección de reservas no puede ser nula.");
        }
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        if (!reservas.contains(reserva)) {
            throw new IllegalArgumentException("La reserva no existe en la colección.");
        }
        reservas.remove(reserva);
    }

    @Override
    public String toString() {
        return super.getNombre();
    }
}
