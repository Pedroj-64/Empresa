package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Vehiculo> vehiculosDisponibles;
    private Collection<Vehiculo> vehiculosOcupados;
    private Collection<Cliente> clientes;
    private Collection<Reserva> listaReservas;
    private static Empresa instancia;

    private Empresa(String nombre){
        this.nombre = nombre;
        vehiculos = new LinkedList<>();
        vehiculosDisponibles = new LinkedList<>();
        vehiculosOcupados = new LinkedList<>();
        clientes = new LinkedList<>();
        listaReservas = new LinkedList<>();
    }

    public static Empresa getInstance(String nombre) {
        if (instancia == null) {
            instancia = new Empresa(nombre);
        }
        return instancia;
    }

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

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
        vehiculosDisponibles.add(vehiculo); // Agregar a disponibles al agregar vehiculo
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
        vehiculosDisponibles.remove(vehiculo); // Eliminar de disponibles si existe
        vehiculosOcupados.remove(vehiculo); // Eliminar de ocupados si existe
    }

    public boolean existeCliente(String cedula){
        for(Cliente cliente: clientes){
            if(cliente.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }

    public void agregarCliente(Cliente cliente){
        if(!existeCliente(cliente.getCedula())){
            clientes.add(cliente);
        }
    }

    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void agregarReserva(Reserva reserva){
        listaReservas.add(reserva);
        Vehiculo vehiculo = reserva.getVehiculo();
        vehiculosDisponibles.remove(vehiculo); // Remover de disponibles
        vehiculosOcupados.add(vehiculo); // Agregar a ocupados
    }

    public void eliminarReserva(Reserva reserva){
        listaReservas.remove(reserva);
        Vehiculo vehiculo = reserva.getVehiculo();
        vehiculosOcupados.remove(vehiculo); // Remover de ocupados
        vehiculosDisponibles.add(vehiculo); // Agregar a disponibles
    }

    public void calcularCostoReserva(Reserva reserva) {
        double costo = reserva.getVehiculo().calcularCostoReserva(reserva.getDias());
        reserva.setCostoTotal(costo);
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }
}