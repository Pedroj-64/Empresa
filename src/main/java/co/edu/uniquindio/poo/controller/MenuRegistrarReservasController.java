package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.util.Collection;
import java.util.NoSuchElementException;

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
        instancia().getListaReservas().add(reserva);
    }

    public void agregarReservasEjemplo() {

        // Crear un cliente
        Cliente cliente = new Cliente("Juan Pérez", "Ramires", "123456789", 8);
        instancia().agregarCliente(cliente);

        try {
            // Buscar vehículos por placa
            Vehiculo vehiculo1 = buscarVehiculoPorPlaca("ABC123");
            Reserva reserva1 = new Reserva(1, cliente, vehiculo1);
            guardarReserva(reserva1);
            
            Vehiculo vehiculo2 = buscarVehiculoPorPlaca("XYZ789");
            Reserva reserva2 = new Reserva(2, cliente, vehiculo2);
            guardarReserva(reserva2);
            
            Vehiculo vehiculo3 = buscarVehiculoPorPlaca("LMN456");
            Reserva reserva3 = new Reserva(3, cliente, vehiculo3);
            guardarReserva(reserva3);
            
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Cliente> obtenerListaClientes() {
        return instancia().getClientes();
    }
}