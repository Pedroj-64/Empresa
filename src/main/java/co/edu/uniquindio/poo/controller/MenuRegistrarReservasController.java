package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.util.Collection;

public class MenuRegistrarReservasController {

    public Empresa instancia() {
        return Empresa.getInstance("mi empresa");
    }

    public Collection<Vehiculo> obtenerListaVehiculosDisponibles() {
        System.out.println("Obteniendo lista de vehículos disponibles...");
        return instancia().getVehiculosDisponibles();
    }

    public Vehiculo buscarVehiculoPorPlacaYTipo(String placa, String tipoDeVehiculo) {
        Vehiculo  vehiculoBuscado = null;

        for (Vehiculo vehiculo : obtenerListaVehiculosDisponibles()) {
            if (vehiculo.getMatricula().equalsIgnoreCase(placa)
                    && vehiculo.getClass().getSimpleName().equalsIgnoreCase(tipoDeVehiculo)) {
                vehiculoBuscado=vehiculo;
            }
        }
        return vehiculoBuscado;
    }

    public void guardarReserva(Reserva reserva) {
        System.out.println("Guardando la reserva: " + reserva);
        instancia().getListaReservas().add(reserva);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return instancia().getClientes();
    }
}
