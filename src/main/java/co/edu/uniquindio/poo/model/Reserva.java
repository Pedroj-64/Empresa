package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

// Clase que representa una Reserva
public class Reserva {
    // Atributos de la clase Reserva
    private double costoTotal;
    private LocalDate fechaDeReserva = LocalDate.now(); // Fecha de la reserva, asignada a la fecha actual por defecto
    private LocalTime hora = LocalTime.now(); // Hora de la reserva, asignada a la hora actual por defecto
    private int dias; // Número de días de la reserva
    private Vehiculo vehiculo; // Vehículo asociado a la reserva
    private Cliente cliente; // Cliente que realiza la reserva

    // Constructor de la clase Reserva
    public Reserva(int dias, Cliente cliente, Vehiculo vehiculo) {
        setDias(dias); // Asigna el número de días utilizando el método setDias
        setCliente(cliente); // Asigna el cliente utilizando el método setCliente
        setVehiculo(vehiculo); // Asigna el vehículo utilizando el método setVehiculo
    }

    // Método para obtener el costo total
    public double getCostoTotal() {
        return costoTotal;
    }

    // Método para asignar el costo total con validación
    public void setCostoTotal(double costoTotal) {
        if (costoTotal < 0) { // Validación para que el costo total no sea negativo
            throw new IllegalArgumentException("El costo total no puede ser negativo.");
        }
        this.costoTotal = costoTotal;
    }

    // Método para obtener la fecha de la reserva
    public LocalDate getFechaDeReserva() {
        return fechaDeReserva;
    }

    // Método para asignar la fecha de la reserva con validación
    public void setFechaDeReserva(LocalDate fechaDeReserva) {
        if (fechaDeReserva == null) { // Validación para que la fecha de reserva no sea nula
            throw new IllegalArgumentException("La fecha de reserva no puede ser nula.");
        }
        this.fechaDeReserva = fechaDeReserva;
    }

    // Método para obtener la hora de la reserva
    public LocalTime getHora() {
        return hora;
    }

    // Método para asignar la hora de la reserva con validación
    public void setHora(LocalTime hora) {
        if (hora == null) { // Validación para que la hora no sea nula
            throw new IllegalArgumentException("La hora no puede ser nula.");
        }
        this.hora = hora;
    }

    // Método para obtener el número de días de la reserva
    public int getDias() {
        return dias;
    }

    // Método para asignar el número de días con validación
    public void setDias(int dias) {
        if (dias <= 0) { // Validación para que los días sean mayor que cero
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        this.dias = dias;
    }

    // Método para obtener el cliente asociado a la reserva
    public Cliente getCliente() {
        return cliente;
    }

    // Método para asignar el cliente con validación
    public void setCliente(Cliente cliente) {
        if (cliente == null) { // Validación para que el cliente no sea nulo
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        this.cliente = cliente;
    }

    // Método para obtener el vehículo asociado a la reserva
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Método para asignar el vehículo con validación
    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) { // Validación para que el vehículo no sea nulo
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        this.vehiculo = vehiculo;
    }

    // Método toString que devuelve una representación en cadena de la reserva
    @Override
    public String toString() {
        return "Reserva [costoTotal=" + costoTotal + ", fechaDeReserva=" + fechaDeReserva + ", hora=" + hora + ", dias="
                + dias + ", cliente=" + cliente + "]";
        // Devuelve una cadena con los atributos de la reserva
    }
}
