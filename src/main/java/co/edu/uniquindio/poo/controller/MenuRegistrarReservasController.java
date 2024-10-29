package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.util.*;

public class MenuRegistrarReservasController {

    Empresa empresa;

    public void instancia() {
        Empresa.getInstance("mi empresa");
    }

    public Collection<Vehiculo> obtenerListaVehiculosDisponibles() {
        System.out.println("Obteniendo lista de vehículos disponibles...");
        return empresa.getVehiculosDisponibles();
    }

    public Vehiculo buscarVehiculoPorPlacaYTipo(String placa, String tipoDeVehiculo) {
        for (Vehiculo vehiculo : obtenerListaVehiculosDisponibles()) {
            if (vehiculo.getMatricula().equalsIgnoreCase(placa)
                    && vehiculo.getClass().getSimpleName().equalsIgnoreCase(tipoDeVehiculo)) {
                return vehiculo;
            }
        }
        return null; // No se encontró el vehículo
    }

    public void guardarReserva(Reserva reserva) {
        System.out.println("Guardando la reserva: " + reserva);
        empresa.getListaReservas().add(reserva); // Agrega la reserva a la lista
    }

    /**
     * 
     * metodo eliminado
     *     public Cliente buscarClientePorNombre(String nombre) {
        Cliente clienteEncontrado = null; // Variable temporal para almacenar el cliente encontrado
        if (nombre != null) {
            for (Cliente cliente : empresa.getClientes()) {
                if (nombre.equals(cliente.getNombre())) {
                    clienteEncontrado = cliente; // Asigna el cliente encontrado
                    break; // Sale del bucle una vez encontrado
                }
            }
        }
        return clienteEncontrado; // Retorna el cliente encontrado o null
    }
     * @return
     */

        public Collection<Cliente> obtenerListaClientes(){
        return empresa.getClientes();
    }

}
