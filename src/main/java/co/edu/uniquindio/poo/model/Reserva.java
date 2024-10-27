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

    public Reserva(double costoTotal, int dias, Cliente cliente,Vehiculo vehiculo) {
        this.costoTotal = costoTotal;
        this.dias = dias;
        this.cliente = cliente;
        this.vehiculo=vehiculo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public LocalDate getFechaDeReserva() {
        return fechaDeReserva;
    }

    public void setFechaDeReserva(LocalDate fechaDeReserva) {
        this.fechaDeReserva = fechaDeReserva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Reserva [costoTotal=" + costoTotal + ", fechaDeReserva=" + fechaDeReserva + ", hora=" + hora + ", dias="
                + dias + ", cliente=" + cliente + "]";
    }

}
