package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MenuRegistrarReservasController {

    Empresa empresa=App.getEmpresa();

    public Collection<Vehiculo> obtenerListaVehiculosDisponibles() {
        System.out.println("Obteniendo lista de vehículos disponibles...");
        return empresa.getVehiculosDisponibles();
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

    public Vehiculo buscarVehiculoPorPlaca(String placa) throws NoSuchElementException {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }

        for (Vehiculo vehiculo : obtenerListaVehiculosDisponibles()) {
            if (vehiculo.getMatricula().equals(placa)) {
                return vehiculo; // Retorna el vehículo encontrado
            }
        }

        throw new NoSuchElementException("No se encontró un vehículo con la placa: " + placa);
    }

    public void guardarReserva(Reserva reserva) {
        System.out.println("Guardando la reserva: " + reserva);
        empresa.agregarReserva(reserva);
    }



    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }
}