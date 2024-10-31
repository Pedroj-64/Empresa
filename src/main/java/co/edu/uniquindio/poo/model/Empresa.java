package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// La clase Empresa usa el patrón Singleton para asegurar que solo hay una instancia de la empresa
public class Empresa {

    // Atributos de la clase Empresa
    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Vehiculo> vehiculosDisponibles;
    private Collection<Vehiculo> vehiculosOcupados;
    private Collection<Cliente> clientes;
    private Collection<Reserva> listaReservas;
    private static Empresa instancia;

    // Constructor privado para Singleton
    private Empresa(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
        }
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
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
        }
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
        if (clientes == null) {
            throw new IllegalArgumentException("La colección de clientes no puede ser nula.");
        }
        this.clientes = clientes;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        if (listaReservas == null) {
            throw new IllegalArgumentException("La colección de reservas no puede ser nula.");
        }
        this.listaReservas = listaReservas;
    }

    // Método para verificar si la empresa tiene vehículos
    public boolean tieneVehiculos() {
        return !vehiculos.isEmpty();
    }

    // Método para crear una reserva de ejemplo
    public void crearReservaEjemplo() {
        // Crear un cliente con datos constantes
        Cliente cliente = new Cliente("Juan", "Pérez", "123456789", 30);
        agregarCliente(cliente); // Agregar el cliente a la empresa

        // Crear un vehículo (Camioneta) con datos constantes
        Camioneta camioneta = new Camioneta("ABC123", "Toyota", "Hilux", 2020, 100000, 10);
        agregarVehiculo(camioneta); // Agregar la camioneta a la empresa

        // Crear una reserva con datos constantes
        Reserva reserva = new Reserva(5, cliente, camioneta); // Reserva por 5 días
        this.calcularCostoReserva(reserva);
        agregarReserva(reserva); // Agregar la reserva a la empresa
    }

    // Métodos para manejar vehículos

    /**
     * Agrega un vehículo a la colección de la empresa.
     * 
     * @param vehiculo El vehículo a agregar.
     * @throws IllegalArgumentException si el vehículo es nulo o ya existe en la
     *                                  colección.
     */
    public void agregarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        if (vehiculo == null || vehiculos.contains(vehiculo)) {
            throw new IllegalArgumentException("El vehículo ya existe o es nulo.");
        }
        vehiculos.add(vehiculo);
        vehiculosDisponibles.add(vehiculo); // Agregar a disponibles al agregar vehiculo
    }

    /**
     * Busca un vehículo por su placa.
     * 
     * @param placa La placa del vehículo a buscar.
     * @return El vehículo encontrado.
     * @throws NoSuchElementException si no se encuentra un vehículo con la placa
     *                                especificada.
     */
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

    /**
     * Elimina un vehículo de la colección de la empresa.
     * 
     * @param vehiculo El vehículo a eliminar.
     * @throws NoSuchElementException si el vehículo no existe en la colección.
     */
    public void eliminarVehiculo(Vehiculo vehiculo) throws NoSuchElementException {
        if (vehiculo == null || !vehiculos.contains(vehiculo)) {
            throw new NoSuchElementException("El vehículo no existe o es nulo.");
        }
        vehiculos.remove(vehiculo);
        vehiculosDisponibles.remove(vehiculo); // Eliminar de disponibles si existe
        vehiculosOcupados.remove(vehiculo); // Eliminar de ocupados si existe
    }

    // Métodos para manejar clientes

    /**
     * Verifica si un cliente existe en la colección de la empresa.
     * 
     * @param cedula La cédula del cliente a verificar.
     * @return true si el cliente existe, false de lo contrario.
     */
    public boolean existeCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega un cliente a la colección de la empresa.
     * 
     * @param cliente El cliente a agregar.
     * @throws IllegalArgumentException si el cliente es nulo o ya existe en la
     *                                  colección.
     */
    public void agregarCliente(Cliente cliente) throws IllegalArgumentException {
        if (cliente == null || existeCliente(cliente.getCedula())) {
            throw new IllegalArgumentException("El cliente ya existe o es nulo.");
        }
        clientes.add(cliente);
    }

    /**
     * Elimina un cliente de la colección de la empresa.
     * 
     * @param cliente El cliente a eliminar.
     * @throws NoSuchElementException si el cliente no existe en la colección.
     */
    public void eliminarCliente(Cliente cliente) throws NoSuchElementException {
        if (cliente == null || !clientes.contains(cliente)) {
            throw new NoSuchElementException("El cliente no existe o es nulo.");
        }
        clientes.remove(cliente);
    }

    // Métodos para manejar reservas

    /**
     * Agrega una reserva a la colección de reservas de la empresa.
     * 
     * @param reserva La reserva a agregar.
     * @throws IllegalArgumentException si la reserva es nula o ya existe en la
     *                                  colección.
     */
    public void agregarReserva(Reserva reserva) throws IllegalArgumentException {
        if (reserva == null || listaReservas.contains(reserva)) {
            throw new IllegalArgumentException("La reserva ya existe o es nula.");
        }
        listaReservas.add(reserva);
        actualizarEstadoVehiculo(reserva.getVehiculo(), true);
    }

    /**
     * Elimina una reserva de la colección de reservas de la empresa.
     * 
     * @param reserva La reserva a eliminar.
     * @return true si la reserva fue eliminada, false de lo contrario.
     */
    public boolean eliminarReserva(Reserva reserva) {
        boolean banderilla = true;
        if (reserva == null || !listaReservas.contains(reserva)) {
            banderilla = false;
        }
        listaReservas.remove(reserva);
        actualizarEstadoVehiculo(reserva.getVehiculo(), false);
        return banderilla;
    }

    /**
     * Calcula el costo de una reserva.
     * 
     * @param reserva La reserva cuyo costo se va a calcular.
     */
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
