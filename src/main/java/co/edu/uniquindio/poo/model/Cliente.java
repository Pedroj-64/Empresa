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
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return super.getNombre();
    }

}
