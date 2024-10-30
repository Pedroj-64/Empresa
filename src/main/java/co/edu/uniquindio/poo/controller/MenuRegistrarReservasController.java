package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import java.util.Collection;
import java.util.NoSuchElementException;
/**
 * Clase controller de MenuRegistrarReservas el cual maneja la logica de negocio de interfaz del mismo nombre
 */
public class MenuRegistrarReservasController {

    Empresa empresa = App.getEmpresa();
    /**
     * metodo utilizado para obtener la listaDeVehiculosDisponibles para poderla volverla una listaOber
     * @return
     */
    public Collection<Vehiculo> obtenerListaVehiculosDisponibles() {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no está inicializada.");
        }
        System.out.println("Obteniendo lista de vehículos disponibles...");
        return empresa.getVehiculosDisponibles();
    }

    public Vehiculo buscarVehiculoPorPlacaYTipo(String placa, String tipoDeVehiculo) {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        if (tipoDeVehiculo == null || tipoDeVehiculo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de vehículo no puede ser nulo o vacío.");
        }

        Vehiculo vehiculoBuscado = null;
        for (Vehiculo vehiculo : obtenerListaVehiculosDisponibles()) {
            if (vehiculo.getMatricula().equalsIgnoreCase(placa) &&
                vehiculo.getClass().getSimpleName().equalsIgnoreCase(tipoDeVehiculo)) {
                vehiculoBuscado = vehiculo;
                break;
            }
        }

        if (vehiculoBuscado == null) {
            throw new NoSuchElementException("No se encontró un vehículo con la placa y tipo especificados.");
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
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        System.out.println("Guardando la reserva: " + reserva);
        empresa.agregarReserva(reserva);
        empresa.calcularCostoReserva(reserva);
    }

    public Collection<Cliente> obtenerListaClientes() {
        if (empresa == null) {
            throw new IllegalStateException("La empresa no está inicializada.");
        }
        return empresa.getClientes();
    }
}
