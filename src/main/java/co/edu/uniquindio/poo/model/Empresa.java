package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Empresa {

    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Vehiculo> vehiculosDisponibles;
    private Collection<Vehiculo> vehiculosOcupados;
    private Collection<Cliente> clientes;
    private Collection<Reserva> listaReservas;
    private static Empresa instancia;

    // Constructor privado para Singleton
    private Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>();
        this.vehiculosDisponibles = new LinkedList<>();
        this.vehiculosOcupados = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.listaReservas = new LinkedList<>();
    }

    // Método para obtener la instancia Singleton
    public static Empresa getInstance(String nombre) {
        if (instancia == null) {
            instancia = new Empresa(nombre);
        }
        return instancia;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Collection<Vehiculo> getVehiculosDisponibles() {
        return vehiculosDisponibles;
    }

    public Collection<Vehiculo> getVehiculosOcupados() {
        return vehiculosOcupados;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public boolean tieneVehiculos() {
        return !vehiculos.isEmpty();
    }

    public void crearReservaEjemplo() {
        // Crear un cliente con datos constantes
        Cliente cliente = new Cliente("Juan", "Pérez", "123456789", 30);
        agregarCliente(cliente); // Agregar el cliente a la empresa
    
        // Crear un vehículo (Camioneta) con datos constantes
        Camioneta camioneta = new Camioneta("ABC123", "Toyota", "Hilux", 2020, 100000, 10);
        agregarVehiculo(camioneta); // Agregar la camioneta a la empresa

        Camioneta camioneta4 = new Camioneta("ABC123", "Toyota", "Hilux", 2020, 100000, 10);
        agregarVehiculo(camioneta4);
        
        // Crear una reserva con datos constantes
        Reserva reserva = new Reserva(5, cliente, camioneta); // Reserva por 5 días
        this.calcularCostoReserva(reserva);
        agregarReserva(reserva); // Agregar la reserva a la empresa
        
    }

    // Métodos para manejar vehículos
    public void agregarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        if (vehiculo == null || vehiculos.contains(vehiculo)) {
            throw new IllegalArgumentException("El vehículo ya existe o es nulo.");
        }
        vehiculos.add(vehiculo);
        vehiculosDisponibles.add(vehiculo); // Agregar a disponibles al agregar vehiculo
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) throws NoSuchElementException {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser nula o vacía.");
        }
        
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(placa)) {
                return vehiculo; // Retorna el vehículo encontrado
            }
        }
        
        throw new NoSuchElementException("No se encontró un vehículo con la placa: " + placa);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) throws NoSuchElementException {
        if (vehiculo == null || !vehiculos.contains(vehiculo)) {
            throw new NoSuchElementException("El vehículo no existe o es nulo.");
        }
        vehiculos.remove(vehiculo);
        vehiculosDisponibles.remove(vehiculo); // Eliminar de disponibles si existe
        vehiculosOcupados.remove(vehiculo); // Eliminar de ocupados si existe
    }

    // Métodos para manejar clientes
    public boolean existeCliente(String cedula){
        boolean banderilla=false;
        for(Cliente cliente: clientes){
            if(cliente.getCedula().equals(cedula)){
                banderilla=true;
            }
        }
        return banderilla;
    }

    public void agregarCliente(Cliente cliente) throws IllegalArgumentException {
        if (cliente == null || existeCliente(cliente.getCedula())) {
            throw new IllegalArgumentException("El cliente ya existe o es nulo.");
        }
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) throws NoSuchElementException {
        if (cliente == null || !clientes.contains(cliente)) {
            throw new NoSuchElementException("El cliente no existe o es nulo.");
        }
        clientes.remove(cliente);
    }

    // Métodos para manejar reservas
    public void agregarReserva(Reserva reserva) throws IllegalArgumentException {
        if (reserva == null || listaReservas.contains(reserva)) {
            throw new IllegalArgumentException("La reserva ya existe o es nula.");
        }
        listaReservas.add(reserva);
        actualizarEstadoVehiculo(reserva.getVehiculo(), true);
    }

    public boolean eliminarReserva(Reserva reserva) {
        if (reserva == null || !listaReservas.contains(reserva)) {
            return false;
        }
        listaReservas.remove(reserva);
        actualizarEstadoVehiculo(reserva.getVehiculo(), false);
        return true;
    }

    public void calcularCostoReserva(Reserva reserva) {
        double costo = reserva.getVehiculo().calcularCostoReserva(reserva.getDias());
        reserva.setCostoTotal(costo);
    }

    // Método auxiliar para actualizar el estado de un vehículo
    private void actualizarEstadoVehiculo(Vehiculo vehiculo, boolean ocupado) {
        if (ocupado) {
            vehiculosDisponibles.remove(vehiculo); // Remover de disponibles
            vehiculosOcupados.add(vehiculo); // Agregar a ocupados
        } else {
            vehiculosOcupados.remove(vehiculo); // Remover de ocupados
            vehiculosDisponibles.add(vehiculo); // Agregar a disponibles
        }
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }
}
