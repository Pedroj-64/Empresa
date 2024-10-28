package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class MenuRegistrarReservasController {

    private List<Reserva> listaReservas = new ArrayList<>();

    public List<Vehiculo> obtenerListaVehiculosDisponibles() {
        // TODO: Obtener la lista de vehículos disponibles para reserva desde la base de datos o el modelo
        System.out.println("Obteniendo lista de vehículos disponibles...");
        return new ArrayList<>(); // Este método debería retornar la lista real de vehículos disponibles
    }

    public void guardarReserva(Reserva reserva) {
        // TODO: Agregar la lógica para guardar una nueva reserva
        System.out.println("Guardando la reserva: " + reserva);
        listaReservas.add(reserva); // Agrega la reserva a la lista
    }

    public void limpiarReservas() {
        // TODO: Limpiar todas las reservas
        System.out.println("Limpiando todas las reservas.");
        listaReservas.clear(); // Limpia la lista de reservas
    }
}

