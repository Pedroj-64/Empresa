package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private double costoTotal;
    private LocalDate fechaDeReserva = LocalDate.now();
    private LocalTime hora = LocalTime.now();
    private int dias;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Reserva(int dias, Cliente cliente, Vehiculo vehiculo) {
        setDias(dias);
        setCliente(cliente);
        setVehiculo(vehiculo);
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        if (costoTotal < 0) {
            throw new IllegalArgumentException("El costo total no puede ser negativo.");
        }
        this.costoTotal = costoTotal;
    }

    public LocalDate getFechaDeReserva() {
        return fechaDeReserva;
    }

    public void setFechaDeReserva(LocalDate fechaDeReserva) {
        if (fechaDeReserva == null) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser nula.");
        }
        this.fechaDeReserva = fechaDeReserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException("La hora no puede ser nula.");
        }
        this.hora = hora;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Reserva [costoTotal=" + costoTotal + ", fechaDeReserva=" + fechaDeReserva + ", hora=" + hora + ", dias=" + dias + ", cliente=" + cliente + "]";
    }
}
